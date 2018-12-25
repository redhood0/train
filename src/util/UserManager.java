package util;

import javabean.User;

public class UserManager {
    private static User user;

    public static void setUser(User user4Set){
        user = user4Set;
    }

    public static User getUser(){
        return user;
    }
}
