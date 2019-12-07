package com.thoughtworks.parser;

import com.thoughtworks.exception.GalaxyException;
import com.thoughtworks.roman.Roman;
import com.thoughtworks.Context;

/**
 * @program: galaxy
 * @description: 罗马字母解析
 * @author: ffye
 * @create: 2019-12-05 18:03
 */
public class RomanParser extends Parser {
    public RomanParser(Context context) {
        super(context);
    }

    /**
     * 解析罗马字母和别名的映射
     * @param input
     * @return
     */
    @Override
    public boolean parse(String input) {
        String[] lexers = input.split(" is ");
        if (lexers.length != 2)
            return false;
        if (lexers[1].length() > 1)
            return false;
        Roman roman = Roman.findBySymbol(lexers[1]);
        if (roman == null)
        {
            throw new GalaxyException("syntex error.");
        }
        String aliasName = lexers[0].trim();
        this.context.getRomans().put(aliasName,roman);
        return true;
    }
}
