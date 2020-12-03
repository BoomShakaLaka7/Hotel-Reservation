package com.company.model;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

    private static Map<String, User> user_map = new HashMap<String, User>();

    public static Map<String, User> getUser_map() {
        return user_map;
    }
}
