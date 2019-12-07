package com.thoughtworks.util;

/**
 * @program: galaxy
 * @description: 字符串处理工具类
 * @author: ffye
 * @create: 2019-12-05 19:25
 */
public class StringUtils {
    /**
     * 串接字符数组元素
     * @param delimiter
     * @param elements
     * @return
     */
    public static String join(String delimiter,String[] elements){
        StringBuffer sb = new StringBuffer();
        for (String elment: elements) {
            sb.append(elment);
            sb.append(delimiter);
        }
        return sb.substring(0,sb.length()-1);
    }
}
