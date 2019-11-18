package com.example.myapplication;


public class JniLib {
    static {

        System.loadLibrary("yunxingningmeng");
        System.loadLibrary("JniLib");
    }

    public static native String callToCpp();

}
