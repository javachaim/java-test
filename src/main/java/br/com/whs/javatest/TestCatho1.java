package br.com.whs.javatest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestCatho1 {

	public static void main(String[] args) {
		//System.out.println(readFile());
		process();
	}

	public static void process() {
		String s = readFile();
		String[] str = s.split("\n");
		int count = 0;
        for( int i = 0; i < str.length; i++ ){
        	if( !str[i].equals("\"\"\"") ) {
        		boolean criteria1 = false;
                boolean criteria2 = false;
                long fSizeLim = (long) Math.pow(2, 20);
                String strSize = str[i].substring(7,12);
                strSize = strSize.trim();
                long fSize = 0;
                if( strSize.indexOf("G") > -1 ) {
                	long elev = (long) Math.pow(2, 30);
                	fSize = (Long.parseLong(strSize.substring(0, strSize.length()-1))) * elev;
                }else if( strSize.indexOf("M") > -1 ) {
                	long elev = (long) Math.pow(2, 20);
                	fSize = (Long.parseLong(strSize.substring(0, strSize.length()-1))) * elev;
                }else if( strSize.indexOf("K") > -1 ) {
                	long elev = (long) Math.pow(2, 10);
                	fSize = (Long.parseLong(strSize.substring(0, strSize.length()-1))) * elev;
                }else {
                	fSize = Long.parseLong(strSize);
                }
                if( fSize <= fSizeLim )
                	criteria1 = true;
                String strDate = str[i].substring(13,24);
                strDate = strDate.trim();
                String[] splitDate = strDate.split(" ");
                Calendar c = Calendar.getInstance();
                c.set(2000, 1, 28, 00, 00, 00);
                Calendar fCal = Calendar.getInstance();
                fCal.set(Calendar.DATE, Integer.parseInt(splitDate[0]));
                fCal.set(Calendar.YEAR, Integer.parseInt(splitDate[2]));
                String[] strM = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Oct","Sep","Nov","Dec"};
                for( int j = 0; j < strM.length; j++ ) {
                	if( strM[j].equals(splitDate[1]) ) {
                		fCal.set(Calendar.MONTH, j);
                	}
                }
                if( fCal.before(c) )
                	criteria2 = true;
                if( criteria1 && criteria2 ) {
                	count++;
                	System.out.println(str[i]);
                }
        	}
        }
        System.out.println("count: "+count);
	}

	public static String readFile() {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(new File("file.txt"));
			br = new BufferedReader(fr);
			String line = null;
			while( (line=br.readLine()) != null ) {
				sb.append(line+"\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
	
	public static List<String> readFileAsList() {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> ret = new ArrayList<>();
		try {
			fr = new FileReader(new File("file.txt"));
			br = new BufferedReader(fr);
			String line = null;
			while( (line=br.readLine()) != null ) {
				ret.add(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
}
