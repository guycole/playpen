package com.digiburo.example.native_demo;

/**
 * @author guycole
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
   * invoked from C to dump updated nativeBuffer
   */
  private void callBack() {
    LogFacade.info(LOG_TAG, "callBack runs");
    
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      LogFacade.info(LOG_TAG, ii + ":" + _nativeBuffer[ii]);
    }
  }

  //
  private int[] _nativeBuffer = new int[10];
  
  /**
   * ctor
   */
  public NdkWrapper() {
    LogFacade.info(LOG_TAG, "ctor");
    LogFacade.info(LOG_TAG, "classpath:" + System.getProperty("java.class.path"));
    LogFacade.info(LOG_TAG, "libpath:" + System.getProperty("java.library.path"));
    
    nativeSetup();
  }
  
  /**
   * demonstrate updating a variable and a Java method from C
   */
  public void vectorDemo() {
    LogFacade.entry(LOG_TAG, "vectorDemo");
    
    LogFacade.info(LOG_TAG, "---prior to c---");
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      LogFacade.info(LOG_TAG, ii + "//" + _nativeBuffer[ii]);
    }
    
    nativeVectorDemo();
    
    /*
    LogFacade.info(LOG_TAG, "---back from c---");
    for (int ii = 0; ii < _nativeBuffer.length; ii++) {
      LogFacade.info(LOG_TAG, ii + "//" + _nativeBuffer[ii]);
    }
    */
    
    LogFacade.exit(LOG_TAG, "vectorDemo");
  }

  //
  private final String LOG_TAG = getClass().getSimpleName();
}
