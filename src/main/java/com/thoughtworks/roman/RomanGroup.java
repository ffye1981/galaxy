package com.thoughtworks.roman;

import com.thoughtworks.exception.GalaxyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: galaxy
 * @description: 罗马字母集合类
 * @author: ffye
 * @create: 2019-12-05 14:51
 */
public class RomanGroup {

    private List<Roman> romanList;

    public RomanGroup() {
        this.romanList = new ArrayList<Roman>();
    }

    /**
     * 罗马字母转换为阿拉伯数字
     * @return
     */
    public int roman2Number() {
        check(this.romanList);
        int result = 0;
        int length = this.romanList.size();
        if(length == 1) {
            result = this.romanList.get(0).getValue();
        }else {
            for (int i = 0; i < length; i++) {
                Roman current = this.romanList.get(i);
                if(i == length -1) {
                    result += current.getValue();
                    break;
                }
                Roman next = this.romanList.get(i + 1);

                if(current.getValue() > next.getValue()) {
                    //当前元素大于下一个元素，累加
                    result += current.getValue();
                }else if (current.getValue() < next.getValue()) {
                    //当前元素小于下一个元素，做减法
                    if(!current.isSubtract()) {
                        throw new GalaxyException(String.format("%s can never be subtracted", current.getSymbol()));
                    }
                    if((next.getIndex() - current.getIndex()) > 2) {
                        throw new GalaxyException(String.format("%s can never be subtracted from %s", current.getSymbol(),next.getSymbol()));
                    }
                    result += (next.getValue() - current.getValue());
                    i++;
                } else if (current.getValue() == next.getValue()) {
                    //当前元素等于下一个元素，累加
                    result += current.getValue();
                    for (int j = i + 2; j < length; j++) {
                        if (this.romanList.get(j).getSymbol() != current.getSymbol())
                        {
                            i = j - 2;
                            break;
                        }else {
                            i = j - 1;
                        }
                        result += current.getValue();
                    }
                }
            }
        }
        return result;
    }

    public static RomanGroup Parse(String line, Map<String, Roman> map)
    {
        String[] left = line.split(" ");
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < left.length; i++)
        {
            number.append(map.get(left[i]).getSymbol());
        }
        RomanGroup roman = RomanGroup.Parse(number.toString());
        return roman;
    }

    public static RomanGroup Parse(String line)
    {
        RomanGroup roman = new RomanGroup();
        for (int i = 0; i < line.length(); i++)
        {
            roman.getRomanList().add(Roman.findBySymbol(line.charAt(i)+""));
        }
        return roman;
    }

    /**
     *  罗马字母校验
     * @param romans
     */
    public static void check(List<Roman> romans){

        StringBuilder romanSequence = new StringBuilder();
        for (Roman roman: romans) {
            romanSequence.append(roman.getSymbol());
        }
        checkRoman(romanSequence.toString());
    }

    /**
     * 非法字符校验
     * @param romanSequence
     */
    public static void checkRoman(String romanSequence) {
        String pattern = "[MDCLXVI]*";
        if(!romanSequence.toString().matches(pattern)){
            throw new GalaxyException(String.format("Illegal symbol"));
        }
        checkRepeat(romanSequence);
    }

    /**
     * 重复次数校验
     * @param romanSequence
     */
    public static void checkRepeat(String romanSequence){
        Matcher m= Pattern.compile("(\\w)\\1*").matcher(romanSequence);
        while(m.find()){
            String _symbol = m.group().subSequence(0, 1).toString();
            //实际重复次数
            int _repeatTimes = m.group().length();
            //允许重复次数
            int allowedTimes = Roman.getRepeatTimesBySymbol(_symbol);

            if(_repeatTimes > allowedTimes){
                if(allowedTimes > 1) {
                    throw new GalaxyException(String.format("%s can't be repeated more than %s times", _symbol,allowedTimes));
                }else {
                    throw new GalaxyException(String.format("%s can't be repeated", _symbol));
                }
            }
        }
    }

    public List<Roman> getRomanList() {
        return romanList;
    }

    public void setRomanList(List<Roman> romanList) {
        this.romanList = romanList;
    }

}
