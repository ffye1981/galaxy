package com.thoughtworks.roman;

import com.thoughtworks.exception.GalaxyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: galaxy
 * @description: 罗马数字集合类
 * @author: ffye
 * @create: 2019-12-05 14:51
 */
public class RomanGroup {

    private List<Roman> romanList;

    public RomanGroup() {
        this.romanList = new ArrayList<Roman>();
    }

    private int _valueCache = 0;
    private boolean _dirty = true;
    public int Calculate() {
        if (_dirty) {
            _valueCache = 0;
            int result = 0;
            int length = this.romanList.size();
            for (int i = 0; i < length; i++) {
                Roman current = this.romanList.get(i);
                result += current.getValue();

                if (i == length - 1)
                    return result;

                Roman next = this.romanList.get(i + 1);
                if (current.getValue() < next.getValue()) {
                    result = next.getValue() - result;
                    i++;
                } else if (current.getValue() == next.getValue()) {
                    if (!current.isRepeat()) {
                        throw new GalaxyException(String.format("%s can't be repeated", current.getSymbol()));
                    }
                    int count = 2;
                    for (int j = i + 2; j < length; j++) {
                        if (this.romanList.get(j).getSymbol() != current.getSymbol())
                            break;
                        count++;
                        result += current.getValue();
                        i++;
                        if (count > 3) {
                            throw new GalaxyException(String.format("%s can't be repeated more than 3 times", current.getSymbol()));
                        }
                    }
                }
            }
            _valueCache = result;
        }

        return _valueCache;
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
