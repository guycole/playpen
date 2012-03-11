/*
** Java to C bridge.  
** This file exposes all methods/functions that Java was promised.
**
** support@digiburo.com
*/

#include <jni.h>
#include <string.h>
#include <android/log.h>

#include "com_digiburo_example_native_demo_NdkWrapper.h"

#define LOG_TAG "NdkWrapperC"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

static JavaVM *cachedJavaVm;
static jobject thisClass;
static jclass callbackClass;
static jmethodID callBackMethodId;
static jfieldID bufferId;
static jintArray nativeBuffer;

/*
 * error reporting
 */
void envDump(JNIEnv *env) {
  if (env->ExceptionCheck()) {
    env->ExceptionDescribe();
    env->ExceptionClear();
  }
}

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeSetup
 * Signature: ()V
 *
 * perform initialization, cache pointers
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeSetup(JNIEnv *env, jobject thiz) {
  LOGI("setup entry");

  thisClass = thiz;

  jclass tempClass = env->GetObjectClass(thiz);
  if (!tempClass) {
    LOGE("setup//failed to discover NdkWrapper");
    envDump(env);
    return;
  }

  callbackClass = (jclass) env->NewGlobalRef(tempClass);
  env->DeleteLocalRef(tempClass);

  callBackMethodId = env->GetMethodID(callbackClass, "callBack", "()V");
  if (!callBackMethodId) {
    LOGE("setup//callBack method find failure");
    envDump(env);
    return;
  }

  bufferId = env->GetFieldID(callbackClass, "_nativeBuffer", "[I");
  if (!bufferId) {
    LOGE("setup//nativeBuffer find failure");
    envDump(env);
    return;
  }

  LOGI("setup exit");
}

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeVectorDemo
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeVectorDemo(JNIEnv *env, jobject thiz) {
  LOGI("vector demo");

  nativeBuffer = (jintArray) env->GetObjectField(thiz, bufferId);

  jint limit = env->GetArrayLength(nativeBuffer);
  jint *body = env->GetIntArrayElements(nativeBuffer, 0);
  for (int ii = 0; ii < limit; ii++) {
    body[ii] = ii*2;
  }

  env->ReleaseIntArrayElements(nativeBuffer, body, 0);
  env->CallVoidMethod(thiz, callBackMethodId);
  env->DeleteLocalRef(nativeBuffer);
}

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeString
 * Signature: ()Ljava/lang/String;
 *
 * return a C string
 */
JNIEXPORT jstring JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeString(JNIEnv *env, jobject thiz) {
  char buffer[127];

  // allergic to sprintf
  strcpy(buffer, "compiled on ");
  strcat(buffer, __DATE__);
  strcat(buffer, " at ");
  strcat(buffer, __TIME__);

  LOGI(buffer);

  return(env->NewStringUTF(buffer));
}

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeAdder
 * Signature: (ID)I
 *
 * demonstrate argument retrieval and return a value
 */
JNIEXPORT jint JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeAdder(JNIEnv *env, jobject thiz, jint arg1, jdouble arg2) {
  int result = (int) arg1 + arg2;
  return(result);
}

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    exceptionDemo
 * Signature: ()V
 *
 * demonstrate exception propagation
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_exceptionDemo(JNIEnv *env, jobject thiz) {
  LOGI("throw exception");
  //throw("demonstration exception");
  jthrowable throwable = env->ExceptionOccurred();
  jclass iae = env->FindClass("java/lang/IllegalArgumentException");
  env->ThrowNew(iae, "throw from C");
}

/*
 * initialization 
 */
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
  JNIEnv *env;
  jclass cls;

  LOGI("---------------------");
  LOGI("greetings from onload");
  LOGI("---------------------");

  if (jvm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
    LOGE("onload//bad version");
    cachedJavaVm = NULL;
    return(JNI_ERR);
  }

  cachedJavaVm = jvm;

  return JNI_VERSION_1_6;
}

/*
 * cleanup
 */
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *jvm, void *reserved) { 
  LOGI("OnUnload Noted");
}
