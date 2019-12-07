package com.thoughtworks.roman;

import com.thoughtworks.exception.GalaxyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public int Calculate() {
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
                //当前小于下一个值，做减法
                if(current.getValue() > next.getValue()) {
                    result += current.getValue();
                }else if (current.getValue() < next.getValue()) {
                    if(!current.isSubtract()) {
                        throw new GalaxyException(String.format("%s can never be subtracted", current.getSymbol()));
                    }
                    if((next.getIndex() - current.getIndex()) > 2) {
                        throw new GalaxyException(String.format("%s can never be subtracted from %s", current.getSymbol(),next.getSymbol()));
                    }
                    result += (next.getValue() - current.getValue());
                    i++;
                } else if (current.getValue() == next.getValue()) {
                    if (!current.isRepeat()) {
                        throw new GalaxyException(String.format("%s can't be repeated", current.getSymbol()));
                    }
                    result += current.getValue();
                    int count = 2;
                    int j = i + 2;
                    for (; j < length; j++) {
                        if (this.romanList.get(j).getSymbol() != current.getSymbol())
                        {
                            i = j - 2;
                            break;
                        }else {
                            i = j - 1;
                        }
                        result += current.getValue();
                        count++;
                        if (count > 3) {
                            throw new GalaxyException(String.format("%s can't be repeated more than 3 times", current.getSymbol()));
                        }
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

    public List<Roman> getRomanList() {
        return romanList;
    }

    public void setRomanList(List<Roman> romanList) {
        this.romanList = romanList;
    }

}
