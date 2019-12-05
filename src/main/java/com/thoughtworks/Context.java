package com.thoughtworks;

import com.thoughtworks.roman.Roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: galaxy
 * @description: 上下文类
 * @author: ffye
 * @create: 2019-12-05 17:54
 */
public class Context {
    //单位
    private String unit;
    //罗马字母集合
    private Map<String, Roman> romans;
    //金属单价
    private Map<String,Double> prices;
    //问题集合
    private List<String> questions;

    public Context() {
        this.romans = new HashMap<String, Roman>();
        this.prices = new HashMap<String, Double>();
        this.questions = new ArrayList<String>();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Map<String, Roman> getRomans() {
        return romans;
    }

    public void setRomans(Map<String, Roman> romans) {
        this.romans = romans;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
