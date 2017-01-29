package com.thoughtworks.selenium.webdriven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WebDriverFileHelper {
	public static boolean fileExists(String sFileName) {
		File fileToCheck = new File(sFileName);
		return fileToCheck.exists();
	}
	
	public static String getFileContents(String filename) {
		if (!(fileExists(filename))) {
			return "";
		}
		try {
			File file = new File(filename);
			FileReader in = new FileReader(file);
			char[] c = new char[(int) file.length()];
			in.read(c);
			String fileContentsString = new String(c);
			in.close();
			return fileContentsString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void writeFileContents(String filename, String sContents) {
		try {
			FileWriter out = new FileWriter(filename);
			out.write(sContents);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void appendStringToFile(String filename, String sContents) {
		try {
			String original = "";
			try {
				original = getFileContents(filename);
			} catch (Exception localException1) {
			}
			String newContents = original + sContents;
			writeFileContents(filename, newContents);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String filename) {
		try {
			File f = new File(filename);

			if (!(f.exists())) {
				return;
			}

			if (!(f.canWrite())) {
				f.canWrite();
		//		f.setWritable(true);
			}

			if (f.isDirectory()) {
				String[] files = f.list();

				if (files.length > 0) {
					for (int x = 0; x < files.length; ++x) {
						deleteFile(f.getAbsolutePath() + File.separator
								+ files[x]);
					}

				}

			}

			boolean success = f.delete();

			if (success) {
				return;
			}
			return;
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return;
		}
	}
	
	public static String[] getFileContentsAsList(String filename) {
		int z = 0;
		int n = getNumberOfLinesInFile(filename);
		String[] lsLines = new String[n];
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = in.readLine()) != null) {
				if (z >= n) {
					break;
				}
				lsLines[z] = line;
				++z;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsLines;
	}
	
	public static int getNumberOfLinesInFile(String filename) {
		int i = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while (in.readLine() != null)
				++i;
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
}
