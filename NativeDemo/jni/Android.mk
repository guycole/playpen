#
LOCAL_PATH := $(call my-dir)
#
include $(CLEAR_VARS)
#
LOCAL_CFLAGS := -fexceptions
#
LOCAL_MODULE    := digiburo-bridge
#
LOCAL_SRC_FILES := NdkWrapper.cpp
#
LOCAL_LDLIBS    += -llog
#
include $(BUILD_SHARED_LIBRARY)
#
