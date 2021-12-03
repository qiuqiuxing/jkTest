package com.yinhai.base.util;

import com.yinhai.base.exception.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"rawtypes", "unchecked"})
/**
 * 常用工具类
 */
public class CommUtil {
    /**
    *
    * 功能描述: 根据key值获取配置文件value（只能读取根目录下文件）
    *
    * @param propertiesName 配置文件名
     * @param key key值
    */
    public static String getConfig(String propertiesName,String key){
        Properties properties=new Properties();
        InputStream inStream=null;
        try{
            inStream=CommUtil.class.getClassLoader().getResourceAsStream(propertiesName +".properties");
            properties.load(inStream);
        }catch (IOException e){
            e.printStackTrace();
            properties = null;
        }finally{
            try {
                if(inStream!=null){
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(properties == null){
            return "";
        }
        return properties.getProperty(key);
    }
    /**
     * 移除重复数据
     *
     * @param list
     * @param terms 判断重复的条件
     * @return @
     */
    public static List<Map> removeDuplicates(List<Map> list, String[] terms) {
        boolean bz = true;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                for (String s : terms) {
                    try {
                        if (list.get(j).get(s).equals(list.get(i).get(s))) {
                            bz = true;
                        } else {
                            bz = false;
                            break;
                        }
                    } catch (Exception e) {
                        bz = true;
                    }
                }
                if (bz) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    /**
     * 验证座机号码
     */
    public static boolean isFixdPhone(String mobilePhone) {
        String regx = "([0-9]{3,4}-)?[0-9]{7,8}";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(mobilePhone);

        return m.matches();
    }

    /**
     * 验证手机号码
     */
    public static boolean isTelePhone(String telePhone) {
//        String regx = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
        String regx = "^1[0-9]\\d{9}$";//zhangc 07/23修改
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(telePhone);
        return m.matches();
    }


    /**
     * 根据身份证计算年龄(精确到月)
     *
     * @param aac147
     * @return
     */
    public static int getAgeFromIDcard(String aac147) {
        int age;
        int selectYear;
        int selectMonth;
        if (aac147.length() == 18) {
            String birthTime = aac147.substring(6, 14);
            // 先截取到字符串中的年、月、日
            selectYear = Integer.parseInt(birthTime.substring(0, 4));
            selectMonth = Integer.parseInt(birthTime.substring(4, 6));

        } else {
            selectYear = Integer.parseInt("19" + aac147.substring(6, 8));
            selectMonth = Integer.parseInt(aac147.substring(8, 10));
        }
        // 得到当前时间的年、月、日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowTime = sdf.format(new Date());

        int yearNow = Integer.parseInt(nowTime.substring(0, 4));
        int monthNow = Integer.parseInt(nowTime.substring(4, 6));

        // 用当前年月减去生日年月
        int yearMinus = yearNow - selectYear;
        int monthMinus = monthNow - selectMonth;

        age = yearMinus;// 先大致赋值
        if (age <= 0) {
            return 0;
        }
        if (age == 16 || age == 60 || age == 55) {
            if (monthMinus < 0) {
                age -= 1;
            }
        }
        return age;
    }

    /**
     * 根据出生日期计算年龄(精确到月)
     *
     * @return
     */
    public static int getAgeFromAac006(String birthTime) {
        birthTime = birthTime.replace("-", "");
        // 先截取到字符串中的年、月、日
        int selectYear = Integer.parseInt(birthTime.substring(0, 4));
        int selectMonth = Integer.parseInt(birthTime.substring(4, 6));
        // 得到当前时间的年、月、日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowTime = sdf.format(new Date());

        int yearNow = Integer.parseInt(nowTime.substring(0, 4));
        int monthNow = Integer.parseInt(nowTime.substring(4, 6));

        // 用当前年月减去生日年月
        int yearMinus = yearNow - selectYear;
        int monthMinus = monthNow - selectMonth;

        int age = yearMinus;// 先大致赋值
        if (age <= 0) {
            return 0;
        }
        if (age == 16 || age == 60 || age == 55) {
            if (monthMinus < 0) {
                age -= 1;
            }
        }
        return age;
    }


    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return boolean
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);

        return isNum.matches();
    }

    /**
     * 功能： 判断字符串是否由数字、字母、小括号和中横线组成
     *
     * @param str : 需要验证的字符串
     * @return boolean
     */

    public static boolean isLikeIdCard(String str) {
        String regx = "^[0-9a-zA-Z-(][0-9a-zA-Z-()]*$";
        Pattern pattern = Pattern.compile(regx);
        Matcher idCard = pattern.matcher(str);

        return idCard.matches();
    }

    /**
     * 根据银行账号获取对应银行ID
     *
     * @param aae010
     * @return
     */
    public static String getAaz065(String aae010) {
        String aaz065 = "";
        if (ValidateUtil.isNotEmpty(aae010)) {
            aaz065 = "1001";
        }
        return aaz065;
    }


    public static String ClobToString(Clob clob) throws SQLException, IOException {
        String reString = "";
        java.io.Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }

    /**
     * 获得该月最后一天(yyyy-MM-dd)
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 功能描述: Map转换为Object对象
     *
     * @param beanClass
     * @param: map
     * @return: java.lang.Object
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    /**
     * 功能描述: Object装换为Map
     *
     * @param: obj
     * @return: java.util.Map<?       ,       ?>
     */
    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null)
            return null;
        return new org.apache.commons.beanutils.BeanMap(obj);
    }

    /**
     * 功能描述: 将Map参数去空格
     *
     * @param: param
     * @return: void
     */
    public static void paramTrim(Map param) {
        Set keySet = param.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Object o = param.get(key);
            if (o instanceof String) {
                param.put(key, ((String) o).trim());
            }
        }
    }

    /**
     * 功能描述: 将日期字符串转换为期号字符串
     *
     * @param: date 日期字符串 如"2020-07-23"
     * @return: java.lang.String
     * @date: 2020/7/23 15:40
     */
    public static String date2Issue(String date) {
        if (ValidateUtil.isEmpty(date)) throw new AppException("日期为空");
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        return year + month;
    }

    /**
     * 功能描述: 比较两个日期
     *
     * @param date2 日期1
     * @param: date1 日期1
     * @return: boolean  第一个日期大于第二个日期
     */
    public static boolean compareDateStr(String date1, String date2) {
        if (ValidateUtil.isEmpty(date1) || ValidateUtil.isEmpty(date2)) throw new AppException("日期为空");
        String tmdate1 = date1.substring(0, 4) + date1.substring(5, 7) + date1.substring(8);
        String tmdate2 = date2.substring(0, 4) + date2.substring(5, 7) + date2.substring(8);
        return Integer.valueOf(tmdate1) > Integer.valueOf(tmdate2);
    }


    /***
     * 计算当前年龄
     *
     * @param birthDayStr
     *            出生日期
     * @return
     * @throws Exception
     */
    public static int getAge(String birthDayStr) {
        if (birthDayStr == null) {
            throw new AppException("出生日期不能为null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date birthDay = null;
        try {
            birthDay = sdf.parse(birthDayStr);
        } catch (ParseException e) {
            throw new AppException("出生日期格式错误");
        }
        int age = 0;

        Date now = new Date();

        SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new SimpleDateFormat("MM");

        String birth_year = format_y.format(birthDay);
        String this_year = format_y.format(now);

        String birth_month = format_M.format(birthDay);
        String this_month = format_M.format(now);

        // 初步，估算
        age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);

        // 如果未到出生月份，则age - 1
        if (this_month.compareTo(birth_month) < 0) {
            age -= 1;
        }
        if (age < 0) { // age小于0，未满一岁
            age = 0;
        }

        return age;
    }

    public static void main(String[] args) {
////        System.out.println(date2Issue("2020-07-23"));
//        int a = getAgeFromIDcard("130503671201001");
////        int a = getAgeFromIDcard("511623199312265569");
//        System.out.println(a);
    }
}
