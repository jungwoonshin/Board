package com.shin.board.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 문자열 공백 여부 체크하기
	 * 
	 * @param checkString
	 *            : 검사 문자열
	 * @return
	 */
	public Boolean blankCheck(String checkString) {
		
		checkString = checkString.trim();
		if (checkString == null) return false;
		if (checkString.length() == 0) return false;
		
		return true;
	}
	
	/**
	 * 문자열 공백 여부 체크 및 길이 체크
	 * 
	 * @param checkString
	 *            : 검사 문자열
	 * @param min
	 *            : 최소 길이(-1인 경우 체크 안함)
	 * @param max
	 *            : 최대 길이(-1인 경우 체크 안함)
	 * @return
	 */
	public Boolean lengthCheck(String checkString, int min, int max) {
		
		checkString = checkString.trim();
		if (!blankCheck(checkString)) return false;
		if (min != -1 && checkString.length() < min) return false;
		if (max != -1 && checkString.length() > max) return false;
		
		return true;
	}
	
	/**
	 * 문자열 패턴 체크하기
	 * 
	 * @param chekString
	 *            : 검사 문자열
	 * @param pattern
	 *            : 최소 길이(-1인 경우 체크 안함)
	 * @return
	 */
	public Boolean patterCheck(String chekString, String patternString) {
		
		Boolean patternCheck = false;
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(chekString);
		
		patternCheck = matcher.matches();
		
		return patternCheck;
	}
	
	/**
	 * 객체 문자열로 변환하기
	 */
	public String objectCheck(Object object) {
		
		String checkString = null;
		
		if (object == null) checkString = "Null";
		else checkString = object.toString();
		
		return checkString;
	}
	
	/**
	 * @param 문자열
	 *            날짜 : yyyy/MM/dd hh:mm
	 * @return Timestamp 문자열 날짜( 형식 : yyyy/MM/dd hh:mm )를 Timestamp 형으로 변환하기
	 * @throws ParseException
	 */
	public Timestamp stringToTimestamp(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date parseDate = dateFormat.parse(date);
		Timestamp timeStamp = new Timestamp(parseDate.getTime());
		return timeStamp;
	}
	
	public static boolean isEmpty(String fileName) {
		return false;
	}
}
