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
}
