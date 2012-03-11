package com.digiburo.example.native_demo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onResume()
   */
  @Override
  protected void onResume() {
    super.onResume();
    
    LogFacade.entry(LOG_TAG, "onResume");
    LogFacade.info(LOG_TAG, "nativeAdder:" + _ndkWrapper.nativeAdder(234, 4.56));
    LogFacade.info(LOG_TAG, "nativeString:" + _ndkWrapper.nativeString());
    
    _ndkWrapper.vectorDemo();
  }
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (Constants.DEBUG_APPLICATION_MODE) {
      LogFacade.info(LOG_TAG, "----start w/debug mode true----");
    } else {
      LogFacade.info(LOG_TAG, "----start w/debug mode false----");
    }
    
    setContentView(R.layout.main);
  }
  
  //
  private NdkWrapper _ndkWrapper = new NdkWrapper();

  //
  private final String LOG_TAG = getClass().getSimpleName();
}