package com.thoughtworks.util;

import com.thoughtworks.util.FileUtil;
import com.thoughtworks.util.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class StringUtilsTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void join()
    {
        String[] elements = new String[]{
                "a",
                "b",
                "c",
                "d"
        };
        System.out.println(StringUtils.join(" ",elements));
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void repeat()
    {
        String str = "wwwaacbbdwww";
        String s="";
        Matcher m=Pattern.compile("(\\w)\\1*").matcher(str);
        while(m.find()){
            s+=m.group().length()+m.group().subSequence(0, 1).toString();
            System.out.println(m.group().subSequence(0, 1).toString() + "=" + m.group().length());
        }
    }

    @Test
    public void check()
    {
        String pattern = "[MDCLXVI]*";
        System.out.println("M".matches(pattern));
        System.out.println("D".matches(pattern));
        System.out.println("MD".matches(pattern));
        System.out.println("MMD".matches(pattern));
        System.out.println("MMDD".matches(pattern));
        System.out.println("MMDDAa".matches(pattern));
    }

}
