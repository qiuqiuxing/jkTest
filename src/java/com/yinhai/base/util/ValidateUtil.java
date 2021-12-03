package com.yinhai.base.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description
 * @ClassName ValidateUtil.java
 * @createTime 2021年02月26日 13:57:00
 */
public class ValidateUtil {

    public static boolean areEqual(Object obj, Object obj2) {
    if (obj == null) {
        return obj2 == null;
    } else {
        return obj.equals(obj2);
    }
}

    public static boolean areEqualIgnoreCase(String obj, String obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equalsIgnoreCase(obj2);
        }
    }

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else {
            if (value instanceof String) {
                if (((String)value).length() == 0) {
                    return true;
                }
            } else if (value instanceof Collection) {
                if (((Collection)value).size() == 0) {
                    return true;
                }
            } else if (value instanceof Map) {
                if (((Map)value).size() == 0) {
                    return true;
                }
            } else if (value instanceof String[] && ((String[])((String[])value)).length == 0) {
                return true;
            }

            return false;
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isEmpty(Collection c) {
        return c == null || c.size() == 0;
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    public static boolean isNotEmpty(Collection c) {
        return c != null && c.size() > 0;
    }

    public static boolean isEmail(String s) {
        if (isEmpty(s)) {
            return true;
        } else if (isWhitespace(s)) {
            return false;
        } else {
            int i = 1;

            int sLength;
            for(sLength = s.length(); i < sLength && s.charAt(i) != '@'; ++i) {
                ;
            }

            return i < sLength - 1 && s.charAt(i) == '@';
        }
    }

    public static boolean isWhitespace(String s) {
        if (isEmpty(s)) {
            return true;
        } else {
            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (" \t\n\r".indexOf(c) == -1) {
                    return false;
                }
            }

            return true;
        }
    }
}
