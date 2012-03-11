package com.digiburo.example.native_demo;

import android.util.Log;

/**
 * NDK wrapper
 * 
 * @author gsc
 */
public class NdkWrapper {

  static {
    System.loadLibrary("digiburo-bridge");
  }
  
  /**
   * initialization
   */
  private native void nativeSetup();
  
  /**
   * manipulate nativeBuffer and invoke callBack
   */
  private native void nativeVectorDemo();
  
  /**
   * Return a native string
   * @return native string
   */
  public native String nativeString();
  
  /**
   * add two numbers in C
   * 
   * @param arg1
   * @param arg2
   * @return sum
   */
  public native int nativeAdder(int arg1, double arg2);
  
  /**
   * demonstrate exception handling
   */
  public native void exceptionDemo();
  
  /**
   * invoked from C to dump updated nativeBuffer
   */
  private void callBack() {
    Log.i(LOG_TAG, "callBack runs");
    
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      Log.i(LOG_TAG, ii + ":" + _nativeBuffer[ii]);
    }
  }

  // shared between C and Java
  private int[] _nativeBuffer = new int[10];
  
  /**
   * ctor
   */
  public NdkWrapper() {
    Log.i(LOG_TAG, "ctor");
    Log.i(LOG_TAG, "classpath:" + System.getProperty("java.class.path"));
    Log.i(LOG_TAG, "libpath:" + System.getProperty("java.library.path"));
    
    nativeSetup();
  }
  
  /**
   * demonstrate updating a variable and a Java method from C
   */
  public void vectorDemo() {
    Log.i(LOG_TAG, "vectorDemo entry");
    
    Log.i(LOG_TAG, "---prior to c---");
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      Log.i(LOG_TAG, ii + "//" + _nativeBuffer[ii]);
    }
    
    nativeVectorDemo();

    Log.i(LOG_TAG, "---back from c---");
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      Log.i(LOG_TAG, ii + "//" + _nativeBuffer[ii]);
    }
    
    Log.i(LOG_TAG, "vectorDemo exit");
  }

  //
  private final String LOG_TAG = getClass().getSimpleName();
}

/*
 * Copyright 2012 Digital Burro, INC
 * Created on Jan 16, 2012 by gsc
 */
