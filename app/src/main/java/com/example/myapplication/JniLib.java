package com.example.myapplication;

// https://www.cnblogs.com/andrewwang/p/11024891.html
public class JniLib {
    static {
        System.loadLibrary("JniLib");
    }

    public static native String callToCpp();

}
