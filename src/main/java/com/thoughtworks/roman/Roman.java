package com.thoughtworks.roman;

import com.thoughtworks.exception.GalaxyException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: galaxy
 * @description: 罗马字母类
 * @author: ffye
 * @create: 2019-12-05 09:16
 */
public class Roman {
    //符号
    private String symbol;
    //值
    private int value;
    //是否可重复
    private boolean isRepeat;
    //是否可被减
    private boolean isSubtract;
    //顺序
    private int index;

    private static List<Roman> romans;

    static {
        romans = new ArrayList<Roman>();
        romans.add(new Roman("I",1,true,true, 1));
        romans.add(new Roman("V",5,false,false,2));
        romans.add(new Roman("X",10,true,true, 3));
        romans.add(new Roman("L",50,false,false,4));
        romans.add(new Roman("C",100,true,true,5));
        romans.add(new Roman("D",500,false,false,6));
        romans.add(new Roman("M",1000,true,false,7));
    }

    public Roman() {
    }

    public Roman(String symbol, int value, boolean isRepeat, boolean isSubtract, int index) {
        this.symbol = symbol;
        this.value = value;
        this.isRepeat = isRepeat;
        this.isSubtract = isSubtract;
    }

    public static Roman findBySymbol(String symbol){
        Roman r = null;
        Iterator<Roman> it = romans.iterator();
        while (it.hasNext()){
            if((r = it.next()).getSymbol().equals(symbol)) {
                break;
            }
        }
        return r;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isSubtract() {
        return isSubtract;
    }

    public void setSubtract(boolean subtract) {
        isSubtract = subtract;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    @Override
    public String toString() {
        return "Roman{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                ", isRepeat=" + isRepeat +
                ", isSubtract=" + isSubtract +
                '}';
    }
}
