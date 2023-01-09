package com.ird.portal.dao;

/**
 * 
 * @author jim
 * @since 19/04/2017 9:20 PM
 */
public enum SqlType {
    HQL("hql"),
    SQL("sql");

    private String type;

    SqlType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
