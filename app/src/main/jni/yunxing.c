//
// Created by 周童 on 2019-11-17.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <jni.h>
#include "com_example_myapplication_YunxingLib.h"
#include "libyunxingningmeng.h"


#include <android/log.h>

#define LOG_TAG "lzd"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)



//int main(int argc, char **argv){
////    printhello();
//    printf("%s", "wohenaini");
//    return 0;
//}

JNIEXPORT jstring JNICALL Java_com_example_myapplication_YunxingLib_runYunxingFromJNI
(JNIEnv *env,jobject j){
    printhello();
    LOGI("sayHello zht");
    return (*env)->NewStringUTF(env, "成功调用linux下的So");
}