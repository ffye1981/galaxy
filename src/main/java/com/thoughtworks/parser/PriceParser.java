package com.thoughtworks.parser;

import com.thoughtworks.roman.RomanGroup;
import com.thoughtworks.Context;
import com.thoughtworks.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program: galaxy
 * @description: 商品单价解析
 * @author: ffye
 * @create: 2019-12-05 18:04
 */
public class PriceParser extends Parser {
    public PriceParser(Context context) {
        super(context);
    }

    @Override
    public boolean parse(String input) {
        String[] lexers = input.split(" is ");
        if (lexers.length != 2)
            return false;

        if(input.endsWith("?")) {
            return false;
        }

        String[] left = lexers[0].split(" ");
        if (left.length < 2)
            return false;

        //计算商品单位
        String[] right = lexers[1].split(" ");
        int rValue = Integer.parseInt(right[0]);
        String rUnit = right[1];
        this.context.setUnit(rUnit);

        //计算商品单价
        List<String> list = Arrays.asList(left);
        String[] _left = new String[list.size()-1];
        for (int i=0;i< list.size()-1;i++) {
            _left[i] = list.get(i);
        }
        RomanGroup roman = RomanGroup.Parse(StringUtils.join(" ",_left), this.context.getRomans());
        int calculated = roman.Calculate();
        String goods = left[left.length-1];
        double price = (double)rValue / (double)calculated;
        this.context.getPrices().put(goods,price);
        return true;
    }
}
