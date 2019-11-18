package com.example.myapplication;

public class YunxingLib {

    static public native String runYunxingFromJNI();
    static {
        System.loadLibrary("yunxingningmeng");
        System.loadLibrary("yunxing");
    }
}
