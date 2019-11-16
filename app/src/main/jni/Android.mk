LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := JniLib
LOCAL_SRC_FILES := JniLib.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := hello
LOCAL_SRC_FILES := hello.c
include $(BUILD_EXECUTABLE)

include $(CLEAR_VARS)
LOCAL_MODULE    := ssl
LOCAL_SRC_FILES := $(LOCAL_PATH)/openssl/$(TARGET_ARCH_ABI)/lib/libssl.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := crypto
LOCAL_SRC_FILES := $(LOCAL_PATH)/openssl/$(TARGET_ARCH_ABI)/lib/libcrypto.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_SHARED_LIBRARIES := \
    ssl \
    crypto
LOCAL_C_INCLUDES += $(LOCAL_PATH)/openssl/$(TARGET_ARCH_ABI)/include
LOCAL_MODULE := md5
LOCAL_SRC_FILES := md5.c
include $(BUILD_EXECUTABLE)




