package com.thoughtworks.selenium.webdriven;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class WebDriverStringHelper {
	public static String removeWhiteSpace(String s) {
		StringTokenizer st = new StringTokenizer(s);
		int index = st.countTokens();

		StringBuffer str = new StringBuffer();

		for (int i = 0; i < index; ++i) {
			str.append(st.nextToken().trim());
		}

		return str.toString();
	}

	public static String[] stringToStringArray(String s) {
		return stringToStringArray(s, " ");
	}

	public static String[] stringToStringArray(String s, String sDelim) {
		String[] lines = s.split(sDelim);
		return lines;
	}

	public static String stripWSChar(String s) {
		StringBuffer sb = new StringBuffer();

		for (int x = 0; x < s.length(); ++x) {
			char c = s.charAt(x);
			int i = c;

			if (i == 160)
				continue;
			sb.append(c);
		}

		return sb.toString();
	}

	public static String[] sortIgnoreCase(String[] s, boolean bAscOrDesc) {
		for (int i = 0; i < s.length; ++i) {
			int cnt = 0;
			for (int j = 0; j < s.length - i - 1; ++j) {
				if (bAscOrDesc) {
					if (s[j].compareToIgnoreCase(s[(j + 1)]) <= 0)
						continue;
					String temp = s[j];
					s[j] = s[(j + 1)];
					s[(j + 1)] = temp;
					++cnt;
				} else {
					if (s[j].compareToIgnoreCase(s[(j + 1)]) > 0)
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

	public static String[] sort(String[] s, boolean bAscOrDesc) {
		for (int i = 0; i < s.length; ++i) {
			int cnt = 0;
			for (int j = 0; j < s.length - i - 1; ++j) {
				if (bAscOrDesc) {
					if (s[j].compareTo(s[(j + 1)]) <= 0)
						continue;
					String temp = s[j];
					s[j] = s[(j + 1)];
					s[(j + 1)] = temp;
					++cnt;
				} else {
					if (s[j].compareTo(s[(j + 1)]) > 0)
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

	public static String replace(String s, String sub, String with) {
		if ((s == null) || (sub == null) || (with == null)) {
			return s;
		}
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1) {
			return s;
		}
		StringBuffer buf = new StringBuffer(s.length() + with.length());
		do {
			buf.append(s.substring(c, i));
			buf.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < s.length()) {
			buf.append(s.substring(c, s.length()));
		}
		return buf.toString();
	}

	public static String replace(String s, char sub, char with) {
		if (s == null) {
			return s;
		}
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; ++i) {
			if (str[i] == sub) {
				str[i] = with;
			}
		}
		return new String(str);
	}

	public static String replaceFirst(String s, String sub, String with) {
		if ((s == null) || (sub == null) || (with == null)) {
			return s;
		}
		int i = s.indexOf(sub);
		if (i == -1) {
			return s;
		}
		return s.substring(0, i) + with + s.substring(i + sub.length());
	}

	public static String replaceFirst(String s, char sub, char with) {
		if (s == null) {
			return s;
		}
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; ++i) {
			if (str[i] == sub) {
				str[i] = with;
				break;
			}
		}
		return new String(str);
	}

	public static String replaceLast(String s, String sub, String with) {
		if ((s == null) || (sub == null) || (with == null)) {
			return s;
		}
		int i = s.lastIndexOf(sub);
		if (i == -1) {
			return s;
		}
		return s.substring(0, i) + with + s.substring(i + sub.length());
	}

	public static String replaceLast(String s, char sub, char with) {
		if (s == null) {
			return s;
		}
		char[] str = s.toCharArray();
		for (int i = str.length - 1; i >= 0; --i) {
			if (str[i] == sub) {
				str[i] = with;
				break;
			}
		}
		return new String(str);
	}

	public static boolean isEmpty(String s) {
		if (s != null) {
			return (s.length() == 0);
		}
		return true;
	}

	public static String setMaxLength(String s, int len) {
		if (s == null) {
			return s;
		}
		if (s.length() > len) {
			s = s.substring(0, len);
		}
		return s;
	}

	public static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}

	public static String toNotNullString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	public static String[] split(String src, String delimeter) {
		if (src == null) {
			return null;
		}
		if (delimeter == null) {
			return new String[]{src};
		}
		int maxparts = src.length() / delimeter.length() + 2;
		int[] positions = new int[maxparts];
		int dellen = delimeter.length();

		int i = 0;
		int j = 0;
		int count = 0;
		positions[0] = (-dellen);
		while ((i = src.indexOf(delimeter, j)) != -1) {
			++count;
			positions[count] = i;
			j = i + dellen;
		}
		++count;
		positions[count] = src.length();

		String[] result = new String[count];

		for (i = 0; i < count; ++i) {
			result[i] = src
					.substring(positions[i] + dellen, positions[(i + 1)]);
		}
		return result;
	}

	public static int indexOfIgnoreCase(String src, String subS) {
		return indexOfIgnoreCase(src, subS, 0);
	}

	public static int indexOfIgnoreCase(String src, String subS, int startIndex) {
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		int total = src.length() - sublen + 1;
		for (int i = startIndex; i < total; ++i) {
			int j = 0;
			while (j < sublen) {
				char source = Character.toLowerCase(src.charAt(i + j));
				if (sub.charAt(j) != source) {
					break;
				}
				++j;
			}
			if (j == sublen) {
				return i;
			}
		}
		return -1;
	}

	public static int lastIndexOfIgnoreCase(String s, String subS) {
		return lastIndexOfIgnoreCase(s, subS, 0);
	}

	public static int lastIndexOfIgnoreCase(String src, String subS,
			int startIndex) {
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		int total = src.length() - sublen;
		for (int i = total; i >= startIndex; --i) {
			int j = 0;
			while (j < sublen) {
				char source = Character.toLowerCase(src.charAt(i + j));
				if (sub.charAt(j) != source) {
					break;
				}
				++j;
			}
			if (j == sublen) {
				return i;
			}
		}
		return -1;
	}

	public static boolean startsWithIgnoreCase(String src, String subS) {
		return startsWithIgnoreCase(src, subS, 0);
	}

	public static boolean startsWithIgnoreCase(String src, String subS,
			int startIndex) {
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		if (startIndex + sublen > src.length()) {
			return false;
		}
		int j = 0;
		int i = startIndex;
		while (j < sublen) {
			char source = Character.toLowerCase(src.charAt(i));
			if (sub.charAt(j) != source) {
				return false;
			}
			++j;
			++i;
		}
		return true;
	}

	public static boolean endsWithIgnoreCase(String src, String subS) {
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		int j = 0;
		int i = src.length() - sublen;
		if (i < 0)
			return false;
		do {
			char source = Character.toLowerCase(src.charAt(i));
			if (sub.charAt(j) != source) {
				return false;
			}
			++j;
			++i;
		} while (j < sublen);

		return true;
	}

	public static int count(String source, String sub) {
		int count = 0;
		int i = 0;
		int j = 0;
		while (true) {
			i = source.indexOf(sub, j);
			if (i == -1) {
				break;
			}
			++count;
			j = i + sub.length();
		}
		return count;
	}

	public static String repeat(String s, int iRepeat) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < iRepeat; ++i) {
			buf.append(s);
		}
		return buf.toString();
	}

	public static String toProperCase(String s) {
		String sInitChar = s.substring(0, 1);
		String sCapitalizedChar = sInitChar.toUpperCase();
		String sOutStr = replaceFirst(s, sInitChar, sCapitalizedChar);
		return sOutStr;
	}

	public static boolean doStringsMatch(String firstString, String secondString) {
		return firstString.equals(secondString);
	}

	public static boolean isSubstring(String searchString, String substring) {
		Pattern p = Pattern.compile(substring);
		return p.matcher(searchString).matches();
	}

	public static String fixString(String s) {
		String t = "";
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == 160) {
				t = t + ' ';
			} else {
				t = t + s.charAt(i);
			}
		}
		return t;
	}

	public static void printCharVals(String s1, String s2) {
		for (int i = 0; i < s1.length(); ++i) {
			System.out
					.print("'" + s1.charAt(i) + "' == '" + s1.charAt(i) + "'");
			System.out.print(":");
			System.out.println("'" + s2.charAt(i) + "' == '" + s2.charAt(i)
					+ "'");
		}
	}

	public static boolean findPattern(String pattern, String[] screenContents) {
		boolean found = false;

		Pattern p = Pattern.compile(pattern);

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (p.matcher(screenContents[i]).matches())) {
				return true;
			}
		}
		return found;
	}

	public static boolean findPattern(String pattern, String screenContents) {
		if ((pattern == null) || (screenContents == null))
			return false;
		Pattern p = Pattern.compile(pattern);
		return p.matcher(screenContents).matches();
	}

	public static int findPatternRow(String pattern, String[] screenContents) {
		int row = -1;
		Pattern p = Pattern.compile(pattern);

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (p.matcher(screenContents[i]).matches())) {
				return i;
			}
		}
		return row;
	}

	public static int findPatternRow(String pattern, int fromIndex,
			String[] screenContents) {
		int row = -1;

		Pattern p = Pattern.compile(pattern);

		for (int i = fromIndex; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (p.matcher(screenContents[i]).matches())) {
				return i;
			}
		}
		return row;
	}

	public static int[] findPatternRows(String pattern, String[] screenContents) {
		Vector v = new Vector();

		Pattern p = Pattern.compile(pattern);

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] == null)
					|| (!(p.matcher(screenContents[i]).matches())))
				continue;
			v.add(new Integer(i));
		}

		Object[] objs = v.toArray();
		int[] rows = new int[objs.length];
		for (int i = 0; i < objs.length; ++i)
			rows[i] = ((Integer) objs[i]).intValue();
		return rows;
	}

	public static boolean findString(String string, String[] screenContents) {
		boolean found = false;

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (screenContents[i].indexOf(string) != -1)) {
				return true;
			}
		}
		return found;
	}

	public static boolean findString(String string, String screenContents) {
		if ((string == null) || (screenContents == null)) {
			return false;
		}

		return (screenContents.indexOf(string) != -1);
	}

	public static int findStringRow(String string, String[] screenContents) {
		int row = -1;

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (screenContents[i].indexOf(string) != -1)) {
				return i;
			}
		}
		return row;
	}

	public static int findStringRow(String string, int fromIndex,
			String[] screenContents) {
		int row = -1;

		for (int i = fromIndex; i < screenContents.length; ++i) {
			if ((screenContents[i] != null)
					&& (screenContents[i].indexOf(string) != -1)) {
				return i;
			}
		}
		return row;
	}

	public static int[] findStringRows(String string, String[] screenContents) {
		Vector v = new Vector();

		for (int i = 0; i < screenContents.length; ++i) {
			if ((screenContents[i] == null)
					|| (screenContents[i].indexOf(string) == -1))
				continue;
			v.add(new Integer(i));
		}

		Object[] objs = v.toArray();
		int[] rows = new int[objs.length];
		for (int i = 0; i < objs.length; ++i) {
			rows[i] = ((Integer) objs[i]).intValue();
		}
		return rows;
	}

	public static int findStringRowBeginning(String[] asText, String sText) {
		String sFromList = "";

		int iLength = sText.length();

		for (int iTmp = 0; iTmp < asText.length; ++iTmp) {
			if (asText[iTmp].length() >= iLength) {
				sFromList = asText[iTmp].substring(0, iLength);
				if (sFromList.equalsIgnoreCase(sText))
					return iTmp;
			}
		}
		return -1;
	}

	public static int findStringRowBeginningStartAt(String[] asText,
			String sText, int iStartAt) {
		String sFromList = "";

		int iLength = sText.length();

		for (int iTmp = iStartAt; iTmp < asText.length; ++iTmp) {
			if (asText[iTmp].length() >= iLength) {
				sFromList = asText[iTmp].substring(0, iLength);
				if (sFromList.equalsIgnoreCase(sText))
					return iTmp;
			}
		}
		return -1;
	}

	public static String replace(Hashtable ht, String s) {
		Enumeration enumr = ht.keys();
		String newstring = s;

		while (enumr.hasMoreElements()) {
			String from = (String) enumr.nextElement();
			String to = (String) ht.get(from);
			newstring = replace(newstring, from, to);
		}

		return newstring;
	}

	public static String[] replaceAll(Hashtable ht, String[] s) {
		String[] newstring = s;

		for (int i = 0; i < s.length; ++i) {
			newstring[i] = replace(ht, s[i]);
		}

		return newstring;
	}

	public static String arrayToString(String[] s) {
		StringBuffer sOut = new StringBuffer();
		if (s.length > 0) {
			sOut.append(s[0]);
			for (int i = 1; i < s.length; ++i) {
				sOut.append(System.getProperty("line.separator"));
				sOut.append(s[i]);
			}
		}
		return sOut.toString();
	}

	public static boolean isNumber(String s) {
		if ((s == null) || (s.trim().length() == 0)) {
			return false;
		}
		int pointCount = 0;
		int eCount = 0;
		int index = 0;
		for (int length = s.length(); index < length; ++index) {
			char c = s.charAt(index);

			if ((c == '-') && (index != 0)) {
				return false;
			}

			if ((c == '0') && (index == 0) && (s.length() > 1)) {
				return false;
			}

			if (c == '.') {
				if (pointCount == 0) {
					++pointCount;
					continue;
				}
				return false;
			}

			if ((c == 'E') || (c == 'e')) {
				int idx1 = s.indexOf(46);
				int idx2 = s.indexOf(c);
				if (idx2 < idx1) {
					return false;
				}

				if ((index == 0) || (index == length - 1))
					return false;
				if (eCount == 0) {
					++eCount;
					continue;
				}
				return false;
			}

			if ((c == 'F') || (c == 'f') || (c == 'D') || (c == 'd')) {
				return (index == length - 1);
			}
			if ((c == 'L') || (c == 'l')) {
				return ((index == length - 1) && (pointCount == 0));
			}
			if (!(isNumberChar(c))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isNumberChar(char c) {
		return ((c >= '0') && (c <= '9'));
	}

	public static boolean contains(String sTarget, String sSub) {
		sTarget = replaceWhiteSpace(sTarget);
		sSub = replaceWhiteSpace(sSub);

		return sTarget.contains(sSub);
	}

	public static String replaceWhiteSpace(String s) {
		StringBuffer sb = new StringBuffer();

		for (int x = 0; x < s.length(); ++x) {
			char c = s.charAt(x);
			int i = c;

			if (i != 160) {
				sb.append(c);
			} else
				sb.append(' ');

		}

		return sb.toString();
	}

	public static String firstCharacterToUpperCase(String stringToModify) {
		if (stringToModify.equals("")) {
			return stringToModify;
		}
		try {
			String myFirstLetter = stringToModify.substring(0, 1);
			String myRemainingLetters = stringToModify.replaceFirst(
					myFirstLetter, "");
			return myFirstLetter.toUpperCase() + myRemainingLetters;
		} catch (Exception e) {
		}
		return stringToModify;
	}

	public static String toCamelCase(String delimiter, String stringToModify) {
		String myNewString = stringToModify;

		if (!(stringToModify.contains(delimiter))) {
			return stringToModify;
		}
		try {
			String[] myLocatorWords = myNewString.split(delimiter);
			myNewString = "";
			for (int i = 0; i < myLocatorWords.length; ++i) {
				myNewString = myNewString
						+ firstCharacterToUpperCase(myLocatorWords[i]);
			}

		} catch (Exception localException) {
		}

		return myNewString;
	}
}
