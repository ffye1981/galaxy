package com.thoughtworks.util;

import com.thoughtworks.util.FileUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class FileUtilTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void readInputs()
    {
        List<String> lines = FileUtil.readInputs("src/main/resources/inputs.txt");
        for (String line: lines) {
            System.out.println(line);
        }

    }
}
