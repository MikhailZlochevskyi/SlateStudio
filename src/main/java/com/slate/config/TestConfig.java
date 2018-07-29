package com.slate.config;

import static org.aeonbits.owner.ConfigFactory.create;

public class TestConfig {

    public static String getUserLogin() {
        User testUser = create(User.class);
        return testUser.userLogin();
    }

    public static String getUserPass() {
        User testUser = create(User.class);
        return testUser.userPass();
    }

    public static String getUserToken() {
        User testUser = create(User.class);
        return testUser.userToken();
    }
}
