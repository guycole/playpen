package com.digiburo.shorttimer;

import java.util.Calendar;

/**
 * julian date math
 *
 * @author gsc
 */
public class DateMath {

  /**
   * convert from gregorian to julian
   * 
   * @param day
   * @param month (January = 0)
   * @param year
   * @return
   */
  public int gregorianToJulian(int day, int month, int year) {
    if (year == 0) {
      throw new IllegalArgumentException("no year zero");
    }
	
    int iyyy = year;
    int mm = month+1;
    int id = day;

    int jy = 0;
    int jm = 0;

    if (iyyy < 0) iyyy += 1;
    if (mm > 2) {
      jy = iyyy;
      jm = mm+1;
    } else {
      jy = iyyy-1;
      jm = mm+13;
    }

    int result = (int)(365.25*jy) + (int)(30.6001*jm) + id + 1720995;

    int threshold = 15+31*(10+12*1582);

    if (id+31*(mm+12*iyyy) >= threshold) {
      int ja = (int) (0.01*jy);
      result = result+2-ja+(int)(0.25*ja);
    }

    return(result);
  }
  
  /**
   * convert from gregorian to julian
   * 
   * @param calendar
   * @return
   */
  public int gregorianToJulian(Calendar calendar) {
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH);
    int year = calendar.get(Calendar.YEAR);

    return(gregorianToJulian(day, month, year));
  }

  /**
   * convert from gregorian to julian
   * 
   * @param milliseconds
   * @return
   */
  public int gregorianToJulian(long milliseconds) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(milliseconds);

    return(gregorianToJulian(calendar));
  }

  /**
   * convert from julian to gregorian
   *  
   * @param julian
   * @return
   */
  public Calendar julianToGregorian(int julian) {
    int ja = 0;
    int jalpha = 0;

    if (julian >= 2299161) {
      jalpha = (int) (((julian-1867216.0)-0.25)/36524.25);
      ja = julian+1+jalpha - (int)(0.25*jalpha);
    } else {
      ja = julian;
    }

    int jb = ja+1524;
    int jc = (int) (6680.0 + ((jb-2439870-122.1)/365.25));
    int jd = 365*jc + (int)(0.25*jc);
    int je = (int) ((jb-jd)/30.6001);

    int id = jb-jd - (int) (30.6001*je);
    int mm = je-1;
    if (mm > 12) mm -= 12;
    int iyyy = jc-4715;
    if (mm > 2) iyyy-=1;
    if (iyyy <= 0) iyyy-=1;

    Calendar calendar = Calendar.getInstance();
    calendar.set(iyyy, mm-1, id);

    return(calendar);
  }
}

/*
 * Created on Mar 12, 2010 by gsc
 */
