LOCAL_PATH := $(call my-dir)
#include $(LOCAL_PATH)/yunxinglib/$(TARGET_ARCH_ABI)/Android.mk

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

# 该方法便于引用第三方静态库
include $(CLEAR_VARS)
LOCAL_STATIC_LIBRARIES := \
    ssl \
    crypto
LOCAL_C_INCLUDES += $(LOCAL_PATH)/openssl/$(TARGET_ARCH_ABI)/include
LOCAL_MODULE := md5
LOCAL_SRC_FILES := md5.c
include $(BUILD_EXECUTABLE)

# 以下第三方动态库引入失败
include $(CLEAR_VARS)
LOCAL_MODULE    := yunxingningmeng
LOCAL_SRC_FILES := $(LOCAL_PATH)/$(TARGET_ARCH_ABI)/libyunxingningmeng.so
#LOCAL_SRC_FILES := libyunxingningmeng.so
include $(PREBUILT_SHARED_LIBRARY)

#include $(CLEAR_VARS)
#LOCAL_PREBUILT_LIBS := libyunxingningmeng:../../libs/$(TARGET_ARCH_ABI)/libyunxingningmeng.so
#include $(BUILD_MULTI_PREBUILT)

# include $(CLEAR_VARS)
# LOCAL_MODULE := yunxingningmeng
# LOCAL_SRC_FILES := libyunxingningmeng.so
# LOCAL_MODULE_TAGS := optional
# LOCAL_MODULE_CLASS := SHARED_LIBRARIES
# LOCAL_MODULE_PATH := $(TARGET_OUT)/lib/
# include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
#LOCAL_PREBUILT_LIBS := libyunxingningmeng.so
LOCAL_C_INCLUDES := $(LOCAL_PATH)/$(TARGET_ARCH_ABI)
LOCAL_SHARED_LIBRARIES := libyunxingningmeng
#LOCAL_JNI_SHARED_LIBRARIES := libyunxingningmeng
LOCAL_LDLIBS := -llog
LOCAL_MODULE := yunxing
LOCAL_SRC_FILES := yunxing.c
include $(BUILD_SHARED_LIBRARY)

#include $(LOCAL_PATH)/yunxinglib/Android.mk

#PRODUCT_COPY_FILES += \
#    ../../libs/$(TARGET_ARCH_ABI)/libyunxingningmeng.so:system/lib/libyunxingningmeng.so

#   device/com/example/myapplication/src/main/libs/$(TARGET_ARCH_ABI)/libyunxingningmeng.so:system/lib/libyunxingningmeng.so

# LOCAL_LDLIBS += -pthread
#LOCAL_CFLAGS := -mfloat-abi=hard -D_NDK_MATH_NO_SOFTFP=1
#LOCAL_CPPFLAGS := -s -mfloat-abi=hard -mfpu=neon -D_NDK_MATH_NO_SOFTFP=1