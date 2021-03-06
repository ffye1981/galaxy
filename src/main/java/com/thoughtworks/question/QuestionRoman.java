package com.thoughtworks.question;

import com.thoughtworks.exception.GalaxyException;
import com.thoughtworks.roman.RomanGroup;
import com.thoughtworks.Context;

/**
 * @program: galaxy
 * @description: 商品数量问题
 * @author: ffye
 * @create: 2019-12-05 22:30
 */
public class QuestionRoman extends AbstractQuestion {
    public QuestionRoman(Context context, String question) {
        super(context, question);
        this.qulifier = "how much is";
    }

    /**
     * 计算商品数量
     * @return
     */
    @Override
    public String process() {
        String body = this.question.substring(this.qulifier.length()+1,this.question.length()-1).trim();
        try {
            RomanGroup roman = RomanGroup.Parse(body, this.context.getRomans());
            int calculated = roman.Calculate();
            StringBuffer answer = new StringBuffer(body + " is " + calculated);
            System.out.println(answer.toString());
            return answer.toString();
        }catch(GalaxyException e){
            StringBuffer answer = new StringBuffer(e.getMessage());
            System.out.println(answer.toString());
            return answer.toString();
        }catch(Exception e){
            StringBuffer answer = new StringBuffer("I have no idea what you are talking about");
            System.out.println(answer.toString());
            return answer.toString();
        }

    }
}
