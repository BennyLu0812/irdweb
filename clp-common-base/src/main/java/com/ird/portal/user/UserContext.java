package com.ird.portal.user;

import java.util.Locale;

/**
 * Provide static method for accessing Thread local variable User
 *
 * @author SPISTEV
 */
public class UserContext {

    public static final String USER_SESSION = "USER_SESSION";

    private static final ThreadLocal<User> userContext = new ThreadLocal<User>();



    public static void setUser(User user) {
        userContext.set(user);
    }

    public static void removeUser() {
        userContext.remove();
    }

    public static User getUser() {
        return userContext.get();
    }

    public static Locale getUserLocale() {
        User user = getUser();
        return user != null ? user.getLocale() : null;
    }



}
