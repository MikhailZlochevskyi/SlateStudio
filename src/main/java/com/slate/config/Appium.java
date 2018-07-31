package com.slate.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/driver.properties"})
public interface Appium extends Config {

        @Key("appium.server")
        String appiumServer();
}
