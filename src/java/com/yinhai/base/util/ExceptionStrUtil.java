package com.yinhai.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 针对中心报错信息处理
 *
 */
public class ExceptionStrUtil {
	
	public static String regex_zh = "([\u4e00-\u9fa5]+)";
	public static String regex1 = "&#xd;";
	public static String regex2 = "\r";
	public static String regex3 = "\n";
	public static String regex4 = "[a-zA-Z]{0,}Exception";
	
	/**
	 * 获取有效错误信息
	 * @param errmsg
	 * @return
	 */
	public static String getErrMsg(String errmsg){
		if(errmsg == null){
			return "";
			
		}else if(errmsg.indexOf(".AppException")>-1){
			return getAppExceptionErrMsg(errmsg);
			
		}else if(errmsg.indexOf(".NullPointerException")>-1){
			return getNullPointerExceptionErrMsg(errmsg);
			
		}else if(errmsg.indexOf("Exception")>-1){
			return getOtherExceptionErrMsg(errmsg);
			
		}else{
			return getOtherNoExceptionErrMsg(errmsg);
		}
	}
	
	/**
	 * 解析AppException
	 * @param errmsg
	 * @return
	 */
	private static String getAppExceptionErrMsg(String errmsg){
		String newstr;
		Matcher matcher = Pattern.compile(regex_zh).matcher(errmsg);
		Matcher matcher2;
		while(matcher.find()){
			newstr = errmsg.substring(matcher.start(), errmsg.length());
			matcher2 = Pattern.compile(regex1).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex2).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex3).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
		}
		return getOtherNoExceptionErrMsg(errmsg);
	}
	
	/**
	 * 解析空指针异常
	 * @param errmsg
	 * @return
	 */
	private static String getNullPointerExceptionErrMsg(String errmsg){
		String newstr;
		Matcher matcher = Pattern.compile("at").matcher(errmsg);
		Matcher matcher2;
		while(matcher.find()){
			newstr = errmsg.substring(matcher.start(), errmsg.length());
			matcher2 = Pattern.compile(regex1).matcher(newstr);
			while(matcher2.find()){
				return "Null "+newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex2).matcher(newstr);
			while(matcher2.find()){
				return "Null "+newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex3).matcher(newstr);
			while(matcher2.find()){
				return "Null "+newstr.substring(0, matcher2.start());
			}
		}
		return getOtherNoExceptionErrMsg(errmsg);
	}
	
	private static String getOtherExceptionErrMsg(String errmsg){
		String newstr;
		Matcher matcher = Pattern.compile(regex_zh).matcher(errmsg);
		Matcher matcher2;
		boolean zh = false;
		while(matcher.find()){
			newstr = errmsg.substring(matcher.start(), errmsg.length());
			matcher2 = Pattern.compile(regex1).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex2).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
			matcher2 = Pattern.compile(regex3).matcher(newstr);
			while(matcher2.find()){
				return newstr.substring(0, matcher2.start());
			}
			zh = true;
		}
		if(!zh){
			matcher = Pattern.compile(regex4).matcher(errmsg);
			while(matcher.find()){
				newstr = errmsg.substring(matcher.start(), errmsg.length());
				matcher2 = Pattern.compile(regex1).matcher(newstr);
				while(matcher2.find()){
					return newstr.substring(0, matcher2.start());
				}
				matcher2 = Pattern.compile(regex2).matcher(newstr);
				while(matcher2.find()){
					return newstr.substring(0, matcher2.start());
				}
				matcher2 = Pattern.compile(regex3).matcher(newstr);
				while(matcher2.find()){
					return newstr.substring(0, matcher2.start());
				}
			}	
		}
		return getOtherNoExceptionErrMsg(errmsg);
	}
	
	private static String getOtherNoExceptionErrMsg(String errmsg){
		return errmsg.replace("<", "").replace("]]>", "").replaceAll("!\\[CDATA\\[", "");
	}
}
