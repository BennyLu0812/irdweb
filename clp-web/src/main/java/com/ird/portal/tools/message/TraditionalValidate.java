package com.ird.portal.tools.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

/**
 * 
 * 繁體字驗證工具.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 11/02/2019 16:13:43<br/>
 * @author Keith.Chen
 * @version 1.0
 */
public class TraditionalValidate {
    
    private static Logger log = LoggerFactory.getLogger(TraditionalValidate.class);

    private static String I18N_DIRECTORY = "/i18n";
    private static String MESSAGE_SOURCE_DIRECTORY = I18N_DIRECTORY + "/{0}/messages_zh_TW.properties";
    
    /**
     * 運行檢測本項目的國際化(中文繁體)中存在的繁體字.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String[] folderNames = getFolderNames();
        for (String scanFolder : folderNames) {
            Properties properties = new Properties();
            InputStream resourceAsStream = TraditionalValidate.class.getResourceAsStream(MessageFormat.format(MESSAGE_SOURCE_DIRECTORY, scanFolder));
            properties.load(resourceAsStream);
            Set<Object> keySet = properties.keySet();
            for (Object key : keySet){
                String origText = (String)properties.get(key);
                String convertText = ZHConverter.convert(origText, ZHConverter.TRADITIONAL);
                if (!origText.equalsIgnoreCase(convertText)){
                    log.error("Please confirm key[{}] = value[{}], System Prompt Value is [{}]", key, origText, convertText);
                }
            }
        }
    }
    
    /**
     * 獲取文件夾下文件集合.
     * @return
     */
    public static String[] getFolderNames() {
        File file = new File(TraditionalValidate.class.getResource(I18N_DIRECTORY).getFile());
        return file.list();
    }
    
    /**
     * 內部繁體字驗證.
     *
     * <br/>
     * <br/>
     * <b>Date:</b> 11/02/2019 16:12:58<br/>
     * @author Keith.Chen
     * @version 1.0
     */
    static class ZHConverter {
        private Properties charMap = new Properties();
        private Set conflictingSets  = new HashSet();

        public static final int TRADITIONAL = 0;
        public static final int SIMPLIFIED = 1;
        private static final int NUM_OF_CONVERTERS = 2;
        private static final ZHConverter[] converters = new ZHConverter[NUM_OF_CONVERTERS];
        private static final String[]  propertyFiles = new String[2];

        static {
            propertyFiles[TRADITIONAL] = "/convert/zh2Hant.properties";
            propertyFiles[SIMPLIFIED] = "/convert/zh2Hans.properties";
        }

        /**
         *
         * @param converterType 0 for traditional and 1 for simplified
         * @return
         */
        public static ZHConverter getInstance(int converterType) {

            if (converterType >= 0 && converterType < NUM_OF_CONVERTERS) {

                if (converters[converterType] == null) {
                    synchronized(ZHConverter.class) {
                        if (converters[converterType] == null) {
                            converters[converterType] = new ZHConverter(propertyFiles[converterType]);
                        }
                    }
                }
                return converters[converterType];

            } else {
                return null;
            }
        }

        public static String convert(String text, int converterType) {
            ZHConverter instance = getInstance(converterType);
            if(instance != null){
                return instance.convert(text);
            }
            log.error("ZHConverter is null");
            return null;
        }


        private ZHConverter(String propertyFile) {

            InputStream is = null;


            is = getClass().getResourceAsStream(propertyFile);

            if (is != null) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(is));
                    charMap.load(reader);
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    log.error("IOException " + e.getMessage(), e);
                } finally {
                    try {
                        if (reader != null)
                            reader.close();
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                        log.error("IOException " + e.getMessage(), e);
                    }
                }
            }
            initializeHelper();
        }

        private void initializeHelper() {
            Map stringPossibilities = new HashMap();
            Iterator iter = charMap.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                if (key.length() >= 1) {

                    for (int i = 0; i < (key.length()); i++) {
                        String keySubstring = key.substring(0, i + 1);
                        if (stringPossibilities.containsKey(keySubstring)) {
                            Integer integer = (Integer)(stringPossibilities.get(keySubstring));
                            stringPossibilities.put(keySubstring, new Integer(
                                    integer.intValue() + 1));

                        } else {
                            stringPossibilities.put(keySubstring, new Integer(1));
                        }

                    }
                }
            }

            iter = stringPossibilities.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                if (((Integer)(stringPossibilities.get(key))).intValue() > 1) {
                    conflictingSets.add(key);
                }
            }
        }

        public String convert(String in) {
            StringBuilder outString = new StringBuilder();
            StringBuilder stackString = new StringBuilder();
            for (int i = 0; i < in.length(); i++) {

                char c = in.charAt(i);
                String key = "" + c;
                stackString.append(key);

                if (conflictingSets.contains(stackString.toString())) {
                } else if (charMap.containsKey(stackString.toString())) {
                    outString.append(charMap.get(stackString.toString()));
                    stackString.setLength(0);
                } else {
                    CharSequence sequence = stackString.subSequence(0, stackString.length()-1);
                    stackString.delete(0, stackString.length()-1);
                    flushStack(outString, new StringBuilder(sequence));
                }
            }

            flushStack(outString, stackString);

            return outString.toString();
        }


        private void flushStack(StringBuilder outString, StringBuilder stackString) {
            while (stackString.length() > 0){
                if (charMap.containsKey(stackString.toString())) {
                    outString.append(charMap.get(stackString.toString()));
                    stackString.setLength(0);

                } else {
                    outString.append("" + stackString.charAt(0));
                    stackString.delete(0, 1);
                }

            }
        }


        String parseOneChar(String c) {

            if (charMap.containsKey(c)) {
                return (String) charMap.get(c);

            }
            return c;
        }
    }
}
