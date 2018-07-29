package com.slate.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:user.properties"})
public interface User extends Config {

    @Key("user.login")
    String userLogin();

    @Key("user.pass")
    String userPass();

    @Key("user.token")
    String userToken();

}
