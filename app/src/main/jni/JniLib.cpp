//
// Created by 周童 on 2019-11-15.
//

#include "com_example_myapplication_JniLib.h"

JNIEXPORT jstring JNICALL Java_com_example_myapplication_JniLib_callToCpp
  (JNIEnv *env, jclass){
    return (*env).NewStringUTF("从cpp返回的文本。");
  };