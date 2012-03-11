#
LOCAL_PATH := $(call my-dir)
#
include $(CLEAR_VARS)
#
LOCAL_CFLAGS := -fexceptions
#LOCAL_C_INCLUDES += external/stlport/stlport
#LOCAL_SHARED_LIBRARIES += libstlport
#
LOCAL_MODULE    := digiburo-bridge
#LOCAL_C_INCLUDES	+= kernel/3rd/jpeg
LOCAL_SRC_FILES := NdkWrapper.cpp
#
LOCAL_LDLIBS    += -llog
#
include $(BUILD_SHARED_LIBRARY)
#
