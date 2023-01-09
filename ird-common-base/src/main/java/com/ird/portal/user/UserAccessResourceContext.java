package com.ird.portal.user;


public class UserAccessResourceContext {
    
    private static final ThreadLocal<String> authorizeExpressions = new ThreadLocal<>();
    
    public static void set(String expression) {
        authorizeExpressions.set(expression);
    }
    
    public static void remove() {
        authorizeExpressions.remove();
    }
    
    public static String get() {
        return authorizeExpressions.get();
    }
    
}
