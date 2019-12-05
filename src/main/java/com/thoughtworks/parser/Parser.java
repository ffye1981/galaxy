package com.thoughtworks.parser;

import com.thoughtworks.Context;

/**
 * @program: galaxy
 * @description: 字符解析父类
 * @author: ffye
 * @create: 2019-12-05 14:22
 */
public abstract class Parser {
    protected Context context;

    public Parser(Context context){
        this.context = context;
    }
    public abstract boolean parse(String input);
}
