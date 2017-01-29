package com.thoughtworks.selenium.webdriven;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebDriverDateHelper {
	public static long glCalOffset = 18000000L;

	public static long glStartTime = 0L;

	public static long setStartTime() {
		long lTime = System.currentTimeMillis();
		return lTime;
	}

	public static long getElapsedTimeLong(long startTime) {
		long endTime = System.currentTimeMillis();

		long time = endTime - startTime;

		return time;
	}

	public static String getElapsedTime(long startTime) {
		long endTime = System.currentTimeMillis();

		long time = endTime - startTime;

		String s = getFormattedDateTime(time, "HH:mm:ss:SSS");

		return s;
	}

	public static String getElapsedTime(long startTime, String sFormat) {
		long endTime = System.currentTimeMillis();

		long time = endTime - startTime;

		String s = getFormattedDateTime(time, sFormat);

		return s;
	}

	public static String getFormattedDateTime(long dDateTime,
			String sDateTimeFormat) {
		SimpleDateFormat tmformat = new SimpleDateFormat(sDateTimeFormat);

		Date tm = new Date(glCalOffset + dDateTime);

		String s = tmformat.format(tm);

		return s;
	}

	public static long getLongFromFormattedDateTime(String sDate, String sFormat) {
		Date dDate = stringToDate(sDate, sFormat);

		return dDate.getTime();
	}

	public static String getCurrentDate() {
		long currentDate = System.currentTimeMillis() - glCalOffset;

		String sDay = getFormattedDateTime(currentDate, "dd");
		String sCurrentDate;
		if (Integer.parseInt(sDay) <= 9)
			sCurrentDate = getFormattedDateTime(currentDate, "MMMM d, yyyy");
		else {
			sCurrentDate = getFormattedDateTime(currentDate, "MMMM dd, yyyy");
		}

		return sCurrentDate;
	}

	public static String getCurrentDate(String sFormat) {
		long currentDate = System.currentTimeMillis() - glCalOffset;

		String sDay = getFormattedDateTime(currentDate, "dd");
		String sCurrentDate;
		if (Integer.parseInt(sDay) <= 9)
			sCurrentDate = getFormattedDateTime(currentDate, sFormat);
		else {
			sCurrentDate = getFormattedDateTime(currentDate, sFormat);
		}

		return sCurrentDate;
	}

	public static String getCurrentDatePlusOne(String sFormat) {
		long glOneDay = 86400000L;
		long currentDate = System.currentTimeMillis() - glCalOffset + glOneDay;

		String sDay = getFormattedDateTime(currentDate, "dd");
		String sCurrentDate;
		if (Integer.parseInt(sDay) <= 9)
			sCurrentDate = getFormattedDateTime(currentDate, sFormat);
		else {
			sCurrentDate = getFormattedDateTime(currentDate, sFormat);
		}

		return sCurrentDate;
	}

	public static String getCurrentDateAndTime() {
		DateFormat dtformat = DateFormat.getDateInstance();
		DateFormat tmformat = DateFormat.getTimeInstance();
		return dtformat.format(new Date()) + " " + tmformat.format(new Date());
	}

	public static String getDateTimeStamp() {
		Date d = new Date();

		SimpleDateFormat tmformat = new SimpleDateFormat("yyyyMMdd.HHmmss");

		String s = tmformat.format(d);

		return s;
	}

	public static String genDateBasedRandVal() {
		Date d = new Date();

		SimpleDateFormat tmformat = new SimpleDateFormat("MMddHHmmssSSSS");

		String s = tmformat.format(d);

		return s;
	}

	public static String genDateBasedRandVal(int i) {
		Date d = new Date();

		SimpleDateFormat tmformat = new SimpleDateFormat("MMddHHmmss");

		String s = tmformat.format(d);

		int ilen = s.length();

		return s.substring(ilen - i);
	}

	public static String[] sortDate(String[] s, boolean bAscOrDeAsc) {
		String sFormat = "M/d/yy H:mm";
		for (int i = 0; i < s.length; ++i) {
			int cnt = 0;
			for (int j = 0; j < s.length - i - 1; ++j) {
				if (bAscOrDeAsc) {
					if (!(stringToDate(parseDate(s[j]), sFormat)
							.after(stringToDate(parseDate(s[(j + 1)]), sFormat))))
						continue;
					String temp = s[j];
					s[j] = s[(j + 1)];
					s[(j + 1)] = temp;
					++cnt;
				} else {
					if (!(stringToDate(parseDate(s[j]), sFormat)
							.before(stringToDate(parseDate(s[(j + 1)]), sFormat))))
						continue;
					String temp = s[j];
					s[j] = s[(j + 1)];
					s[(j + 1)] = temp;
					++cnt;
				}
			}

			if (cnt != 0)
				continue;
		}
		return s;
	}

	public static String parseFormat(String sText) {
		String patten = "";
		String sDate = "";
		String sTime = "";

		int x = 0;
		if (x < sText.length()) {
			sDate = sText.substring(0, sText.indexOf(" ")).trim();
		}

		sText = sText.substring(sText.indexOf(" ")).trim();

		if (x < sText.length()) {
			sTime = sText.substring(0, sText.indexOf(" ")).trim();
		}


		if (x < sDate.length()) {
			String sMonth = sDate.substring(0, sDate.indexOf("/")).trim();
			if (!(sMonth.startsWith("0"))) {
				patten = patten + "M/";
			}
		}
		sDate = sDate.substring(sDate.indexOf("/") + 1).trim();

		if (x < sDate.length()) {
			String sDay = sDate.substring(0, sDate.indexOf("/")).trim();
			if (!(sDay.startsWith("0"))) {
				patten = patten + "d/";
			}
		}
		String sYear = sDate.substring(sDate.indexOf("/") + 1).trim();
		if (sYear.length() == 2)
			patten = patten + "yy ";

		if (x < sTime.length()) {
			String sHour = sTime.substring(0, sTime.indexOf(":")).trim();
			if (!(sHour.startsWith("0"))) {
				patten = patten + "H:mm ";
			}

		}

		String sZone = sText.substring(sText.indexOf(" ")).trim();
		if ((sZone.equalsIgnoreCase("AM")) || (sZone.equalsIgnoreCase("PM")))
			patten = patten + "a";
		return patten;
	}

	public static String parseDate(String sText) {
		String s = sText;

		String sZone = s.substring(s.length() - 3, s.length()).trim();
		String sDate = s.substring(0, s.indexOf(" ")).trim();
		s = s.substring(s.indexOf(" ")).trim();
		String sTime = s.substring(0, s.indexOf(" ")).trim();
		String sHour = sTime.substring(0, sTime.indexOf(":")).trim();
		String sMinute = sTime.substring(sTime.indexOf(":") + 1).trim();
		if (s.endsWith("PM"))
			sHour = String.valueOf(Integer.parseInt(sHour) + 12);
		s = sDate + " " + sHour + ":" + sMinute + " " + sZone;
		return s;
	}

	public static Date stringToDate(String sDate, String sFormat)
  {
    Date dDate = null;
    try
    {
      ParsePosition pos = new ParsePosition(0);
      SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
      if (sDate.endsWith("PM"))
      {
        dDate = sdf.parse(sDate, pos); 
      }

      dDate = sdf.parse(sDate, pos);
    }
    catch (Exception e)
    {
      return dDate;
    }
    return dDate;
  }
	public static String formatDateString(String sDate, String sFormatIn,
			String sFormatOut) {
		long lDate = getLongFromFormattedDateTime(sDate, sFormatIn);

		return getFormattedDateTime(lDate, sFormatOut);
	}

	public static String getTodaysDate() {
		Date today = new Date();

		DateFormat dateFormatter = DateFormat.getDateInstance(3);

		String dateOut = dateFormatter.format(today);

		return dateOut;
	}

	public static String todayPlus(int iDays, int iMonths, int iYears)
  {
    String sDate = getTodaysDate();

    Calendar cal = Calendar.getInstance();
    String sNewDate = "";
    try
    {
      boolean twoDigitYr = false;
      int chA = sDate.trim().indexOf("/");
      int iMth = Integer.parseInt(sDate.substring(0, chA));
      int chB = sDate.trim().indexOf("/", chA + 1);
      int intDy = Integer.parseInt(sDate.substring(chA + 1, chB));
      int iYr = Integer.parseInt(sDate.substring(chB + 1, sDate.length()));

      if (iYr < 100) {
        twoDigitYr = true;
        iYr += 2000;
      }

      cal.set(2, iMth - 1);
      cal.set(1, iYr);
      cal.set(5, intDy);

      cal.add(1, iYears);
      cal.add(2, iMonths);
      cal.add(5, iDays);

      if (twoDigitYr) {
        String str = Integer.toString(cal.get(1));

        sNewDate = (cal.get(2) + 1) + "/" + cal.get(5) + "/" + str;
      }

      sNewDate = (cal.get(2) + 1) + "/" + cal.get(5) + "/" + cal.get(1);
    }
    catch (Exception localException)
    {
    }

   return sNewDate;
  }
	public static String sGetCurrentTimePlusX(int iMinsToAdd) {
		Date dToday = new Date();
		String sToday = dToday.toString();

		String sTime = sToday.substring(sToday.indexOf(":") - 2);

		sTime = sTime.substring(0, sTime.indexOf(" "));

		String sHour = sTime.substring(0, sTime.indexOf(":"));
		String sMins = sTime.substring(sTime.indexOf(":") + 1,
				sTime.lastIndexOf(":"));

		int iMins = Integer.parseInt(sMins);
		int iHours = Integer.parseInt(sHour);
		String sNewHour;
		String sNewMins;

		if (iMins + iMinsToAdd > 59) {
			sNewMins = String.valueOf(iMins + iMinsToAdd - 60);
			sNewHour = String.valueOf(iHours + 1);
		} else {
			sNewMins = String.valueOf(iMins + iMinsToAdd);
			sNewHour = sHour;
		}
		if (sNewMins.length() == 1) {
			sNewMins = "0" + sNewMins;
		}
		return sNewHour + ":" + sNewMins;
	}

	public static String sGetCurrentTimePlusX12(int iMinsToAdd) {
		Date dToday = new Date();
		String sToday = dToday.toString();

		String sTime = sToday.substring(sToday.indexOf(":") - 2);

		sTime = sTime.substring(0, sTime.indexOf(" "));

		String sHour = sTime.substring(0, sTime.indexOf(":"));
		String sMins = sTime.substring(sTime.indexOf(":") + 1,
				sTime.lastIndexOf(":"));

		int iMins = Integer.parseInt(sMins);
		int iHours = Integer.parseInt(sHour);
		String sNewMins;
		if (iMins + iMinsToAdd > 59) {
			sNewMins = String.valueOf(iMins + iMinsToAdd - 60);
			++iHours;
		} else {
			sNewMins = String.valueOf(iMins + iMinsToAdd);
		}

		if (sNewMins.length() == 1) {
			sNewMins = "0" + sNewMins;
		}
		if (iHours > 12)
			iHours -= 12;
		String sNewHour = String.valueOf(iHours);
		return sNewHour + ":" + sNewMins;
	}
}
