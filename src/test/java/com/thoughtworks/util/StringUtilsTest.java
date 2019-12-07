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
    @Test
    public void check()
    {
        String regex = "[IVXLCDM]*";  //只能由IVXLCDM组成

        System.out.println("I:"+"I".matches(regex));
        System.out.println("V:"+"V".matches(regex));
        System.out.println("X:"+"X".matches(regex));
        System.out.println("L:"+"L".matches(regex));
        System.out.println("C:"+"C".matches(regex));
        System.out.println("D:"+"D".matches(regex));
        System.out.println("M:"+"M".matches(regex));
        System.out.println("MM:"+"MM".matches(regex));
        System.out.println("MD:"+"MD".matches(regex));
        System.out.println("MDA:"+"MDA".matches(regex));
        System.out.println("IVX:"+"IVX".matches(regex));
        regex = "[M]{0,3}";
        System.out.println("M:"+"M".matches(regex));
        System.out.println("MM:"+"MM".matches(regex));
        System.out.println("MMM:"+"MMM".matches(regex));
        System.out.println("MMMM:"+"MMMM".matches(regex));
    }
}
