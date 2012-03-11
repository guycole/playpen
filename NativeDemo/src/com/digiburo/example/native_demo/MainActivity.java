package com.digiburo.example.native_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * NativeDemo driver
 * 
 * @author gsc
 */
public class MainActivity extends Activity {

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onResume()
   */
  @Override
  protected void onResume() {
    super.onResume();
    Log.i(LOG_TAG, "onResume");

    // demonstrate reading a C string
    Log.i(LOG_TAG, _ndkWrapper.nativeString());
    
    // demonstrate method w/arguments and return value
    int result = _ndkWrapper.nativeAdder(11, 22);
    Log.i(LOG_TAG, "native adder result:" + result);
    
    // demonstrate exception handling
    try {
      _ndkWrapper.exceptionDemo();
    } catch(IllegalArgumentException iae) {
      Log.i(LOG_TAG, "exception noted");
    }
  
    // demonstrate update of a shared variable and callback
    _ndkWrapper.vectorDemo();
  }
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(LOG_TAG, "onCreate");
    setContentView(R.layout.main);
  }
  
  //
  private NdkWrapper _ndkWrapper = new NdkWrapper();

  //
  private final String LOG_TAG = getClass().getSimpleName();
}

/*
 * Copyright 2012 Digital Burro, INC
 * Created on Jan 16, 2012 by gsc
 */
