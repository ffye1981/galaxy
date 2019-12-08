package com.thoughtworks.roman;

import com.thoughtworks.util.FileUtil;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class RomanGroupTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkRoman()
    {
        RomanGroup.checkRoman("MDCLXVI");
        RomanGroup.checkRoman("MDCLXVIA");
        RomanGroup.checkRoman("MMMDD");
    }
}
