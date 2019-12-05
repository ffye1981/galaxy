package com.thoughtworks.question;

import com.thoughtworks.Context;

/**
 * @program: galaxy
 * @description: 类
 * @author: ffye
 * @create: 2019-12-05 22:01
 */
public abstract class AbstractQuestion {
    protected Context context;
    protected String question;
    protected double value;
    protected String qulifier;
    protected String body;

    public AbstractQuestion(Context context,String question) {
        this.context = context;
        this.question = question;
    }

    public abstract String process();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getQulifier() {
        return qulifier;
    }

    public void setQulifier(String qulifier) {
        this.qulifier = qulifier;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
