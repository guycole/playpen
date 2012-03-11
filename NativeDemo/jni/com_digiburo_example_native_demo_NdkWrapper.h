/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_digiburo_example_native_demo_NdkWrapper */

#ifndef _Included_com_digiburo_example_native_demo_NdkWrapper
#define _Included_com_digiburo_example_native_demo_NdkWrapper
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeSetup
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeSetup
  (JNIEnv *, jobject);

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeVectorDemo
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeVectorDemo
  (JNIEnv *, jobject);

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeString
  (JNIEnv *, jobject);

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    nativeAdder
 * Signature: (ID)I
 */
JNIEXPORT jint JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_nativeAdder
  (JNIEnv *, jobject, jint, jdouble);

/*
 * Class:     com_digiburo_example_native_demo_NdkWrapper
 * Method:    exceptionDemo
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_digiburo_example_native_1demo_NdkWrapper_exceptionDemo
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif