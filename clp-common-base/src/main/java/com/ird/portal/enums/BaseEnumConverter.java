/**
 * @Project Name: dls-common-api
 * @File Name: BaseEnumConverter.java
 * @Date: 17/05/2018 13:58:19
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.enums;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * 系統枚舉轉換基類.
 * 
 * JPA中的Entity的枚舉需以注解方式轉換類進行枚舉與DB值的轉換.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/05/2018 13:58:19<br/>
 * @author raysely
 * @version 1.0
 * 
 * @param <X> the type of the entity attribute
 * @param <Y> the type of the database column
 */
public abstract  class BaseEnumConverter<X extends BaseEnum<Y>, Y> implements AttributeConverter<BaseEnum<Y>, Y> {
    
    /**
     * xclazz.
     */
    private Class<X> xclazz;
    
    /**
     * valuesMethod.
     */
    private Method valuesMethod;

    /**
     * 構造函數.
     */
    @SuppressWarnings("unchecked")
    public BaseEnumConverter() {
        this.xclazz = (Class<X>) (((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments())[0];
        try {
            valuesMethod = xclazz.getMethod("values");
        } catch (Exception e) {
            throw new RuntimeException("can't get values method from " + xclazz);
        }
    }

    @Override
    public Y convertToDatabaseColumn(BaseEnum<Y> attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public X convertToEntityAttribute(Y dbData) {
        try {
            X[] values = (X[]) valuesMethod.invoke(null);
            for (X x : values) {
                if (x.getCode().equals(dbData)) {
                    return x;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("can't convertToEntityAttribute" + e.getMessage());
        }
        throw new RuntimeException("unknown dbData " + dbData);
    }

}
