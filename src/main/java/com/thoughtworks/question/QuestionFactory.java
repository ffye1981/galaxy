package com.thoughtworks.question;

import com.thoughtworks.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: galaxy
 * @description: 问题工厂
 * @author: ffye
 * @create: 2019-12-05 22:00
 */
public class QuestionFactory {
    /**
     * 创建问题
     * @param input
     * @param context
     * @return
     */
    public static AbstractQuestion createQuestion(String input, Context context){
        AbstractQuestion question = null;
        if(input.startsWith("how much")) {
            question = new QuestionRoman(context,input);
        }else if(input.startsWith("how many")) {
            question = new QuestionPrice(context,input);
        }
        return question;
    }

    /**
     * 创建问题集合
     * @param inputs
     * @param context
     * @return
     */
    public static List<AbstractQuestion> createQuestions(List<String> inputs,Context context){
        List<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
        for (String input: inputs) {
            AbstractQuestion question = createQuestion(input,context);
            if(question!=null) {
                questions.add(question);
            }
        }
        return questions;
    }
}
