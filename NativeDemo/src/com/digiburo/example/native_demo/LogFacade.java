package com.digiburo.example.native_demo;

import android.util.Log;

/**
 * Wrapper for Android Logger.
 *
 * @author gsc
 */
public class LogFacade {

  /**
   * log entry into a method
   * 
   * @param logTag log tag
   * @param name method name
   */
  public static void entry(String logTag, String name) {
    if (Constants.DEBUG_APPLICATION_MODE) {
      String message = "--entry:" + name;
      Log.d(logTag, message);
    }
  }
  
  /**
   * 
   * @param logTag
   * @param name
   */
  public static void exit(String logTag, String name) {
    if (Constants.DEBUG_APPLICATION_MODE) {     
      String message = "--exit:" + name;
      Log.d(logTag, message);
    }
  } 
  
  /**
   * 
   * @param logTag
   * @param message
   */
  public static void debug(String logTag, String message) {
    if (Constants.DEBUG_APPLICATION_MODE) {
      Log.d(logTag, message);
    }
  }
  
  /**
   * 
   * @param logTag
   * @param message
   */
  public static void info(String logTag, String message) {
    Log.i(logTag, message);
  }

  /**
   * 
   * @param logTag
   * @param message
   */
  public static void error(String logTag, String message) {
    Log.e(logTag, message);
  }

  /**
   * 
   * @param logTag
   * @param exception
   */
  public static void error(String logTag, Exception exception) {
    String message = "null exception message";
    
    if ((exception == null) || (exception.getMessage() == null)) {
      exception.printStackTrace();
    } else {
      message = exception.getMessage();
    }
    
    error(logTag, message);
  }
}

/*
 * Copyright 2010 Digital Burro, INC
 * Created on Nov 17, 2010 by gsc
 */