package com.slate.tests.data;


import java.util.Random;

public class DataProvider {

    public static final String TASK_NAME = "SlateTask-" + new Random().nextInt(1000) + 1;
    public static final String PROJECT_NAME = "SlateProject-" +  new Random().nextInt(1000) + 1;
}
