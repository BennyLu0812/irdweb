package com.ird.portal.common.user.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 駕駛資格
 *
 * @author Tim
 */
public enum LicCatTypeEnum implements BaseEnum<String> {

    A1_A("A1_A"),
    A1_M("A1_M"),
    A2_A("A2_A"),
    A2_M("A2_M"),
    B_A("B_A"),
    B_M("B_M"),
    D1_A("D1_A"),
    D1_M("D1_M"),
    D2_A("D2_A"),
    D2_M("D2_M"),
    C("C"),
    EC("EC"),
    EB("EB"),
    CICL("CICL"),


    licCatEc("EC"),
    licCatD2("D2"),
    licCatD1("D1"),
    licCatC("C"),
    licCatB("B"),
    licCatA2("A2"),
    licCatA1("A1"),
    licCatCicl("CICL");

    private String code;
    private String text;

    LicCatTypeEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getText(Locale locale) {
        return EnumUtil.getText(this, locale);
    }



    public static String[]  getLicCats(String key){
        Map<String, String[]> licCats = new HashMap<>();

        String[] C_A = new String[]{
                LicCatTypeEnum.CICL.getCode(),
                LicCatTypeEnum.A1_A.getCode(),
                LicCatTypeEnum.A1_M.getCode(),
                LicCatTypeEnum.A2_A.getCode(),
                LicCatTypeEnum.A2_M.getCode()};

        String[] C_M = new String[]{
                LicCatTypeEnum.CICL.getCode(),
                LicCatTypeEnum.A1_M.getCode(),
                LicCatTypeEnum.A2_M.getCode()};

        String[] M_A = new String[]{
                LicCatTypeEnum.A1_A.getCode(),
                LicCatTypeEnum.A1_M.getCode(),
                LicCatTypeEnum.A2_A.getCode(),
                LicCatTypeEnum.A2_M.getCode()};

        String[] M_M = new String[]{
                LicCatTypeEnum.A1_M.getCode(),
                LicCatTypeEnum.A2_M.getCode()};

        String[] M_VOL = new String[]{
                LicCatTypeEnum.A2_A.getCode(),
                LicCatTypeEnum.A2_M.getCode()};

        String[] L_A = new String[]{
                LicCatTypeEnum.B_A.getCode(),
                LicCatTypeEnum.B_M.getCode(),
                LicCatTypeEnum.C.getCode(),
                LicCatTypeEnum.D1_A.getCode(),
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_A.getCode(),
                LicCatTypeEnum.D2_M.getCode(),
                LicCatTypeEnum.EB.getCode(),
                LicCatTypeEnum.EC.getCode()};

        String[] L_M = new String[]{
                LicCatTypeEnum.B_M.getCode(),
                LicCatTypeEnum.C.getCode(),
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_M.getCode(),
                LicCatTypeEnum.EB.getCode(),
                LicCatTypeEnum.EC.getCode()};

        String[] P_A = new String[]{
                LicCatTypeEnum.C.getCode(),
                LicCatTypeEnum.D1_A.getCode(),
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_A.getCode(),
                LicCatTypeEnum.D2_M.getCode(),
                LicCatTypeEnum.EC.getCode()};

        String[] P_M = new String[]{
                LicCatTypeEnum.C.getCode(),
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_M.getCode(),
                LicCatTypeEnum.EC.getCode()};

        String[] P_A_9 = new String[]{LicCatTypeEnum.C.getCode()};
        String[] P_M_9 = new String[]{LicCatTypeEnum.C.getCode()};

        String[] P_A_9_25 = new String[]{
                LicCatTypeEnum.D1_A.getCode(),
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_A.getCode(),
                LicCatTypeEnum.D2_M.getCode()};

        String[] P_M_9_25 = new String[]{
                LicCatTypeEnum.D1_M.getCode(),
                LicCatTypeEnum.D2_M.getCode()};

        String[] P_A_25 = new String[]{
                LicCatTypeEnum.D2_A.getCode(),
                LicCatTypeEnum.D2_M.getCode()};

        String[] P_M_25 = new String[]{
                LicCatTypeEnum.D2_M.getCode()};

        String[] S = new String[]{LicCatTypeEnum.EC.getCode()};

        String[] I_9 = new String[]{LicCatTypeEnum.D2_M.getCode()};
        String[] I_9_LESS = new String[]{LicCatTypeEnum.C.getCode()};

        licCats.put("C_A", C_A);
        licCats.put("C_M", C_M);

        licCats.put("M_A", M_A);
        licCats.put("M_M", M_M);
        licCats.put("M_VOL", M_VOL);

        licCats.put("L_A", L_A);
        licCats.put("L_M", L_M);

        licCats.put("P_A", P_A);
        licCats.put("P_M", P_M);
        licCats.put("P_A_9_25", P_A_9_25);
        licCats.put("P_M_9_25", P_M_9_25);
        licCats.put("P_A_25", P_A_25);
        licCats.put("P_M_25", P_M_25);
        licCats.put("P_A_9", P_A_9);
        licCats.put("P_M_9", P_M_9);

        licCats.put("S", S);
        licCats.put("I_9", I_9);
        licCats.put("I_9_LESS", I_9_LESS);

        return licCats.get(key);
    }

    @Override
    public String getText() {
        return text;
    }

}

