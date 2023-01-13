package com.ird.portal.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * 
 * JxlsUtils -- 模板式製作excel文件.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/06/2019 13:45:04<br/>
 * @author Keith.Chen
 * @version 1.0
 */
public class JxlsUtils {
    public static void exportExcel(InputStream is, OutputStream os, Map<String, Object> model) throws IOException{
//        Context context = PoiTransformer.createInitialContext();
//        if (model != null) {
//            for (String key : model.keySet()) {
//                context.putVar(key, model.get(key));
//            }
//        }
//        JxlsHelper jxlsHelper = JxlsHelper.getInstance();
//        Transformer transformer  = jxlsHelper.createTransformer(is, os);
//        //获得配置
//        JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator)transformer.getTransformationConfig().getExpressionEvaluator();
//        //设置静默模式，不报警告
//        //evaluator.getJexlEngine().setSilent(true);
//        //函数强制，自定义功能
//        Map<String, Object> funcs = new HashMap<String, Object>();
//        funcs.put("utils", new JxlsUtils());    //添加自定义功能
//        evaluator.getJexlEngine().setFunctions(funcs);
//        //必须要这个，否者表格函数统计会错乱
//        jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);
    }

}
