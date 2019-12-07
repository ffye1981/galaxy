package com.thoughtworks.question;

import com.thoughtworks.exception.GalaxyException;
import com.thoughtworks.roman.RomanGroup;
import com.thoughtworks.Context;
import com.thoughtworks.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program: galaxy
 * @description: 包含单价问题
 * @author: ffye
 * @create: 2019-12-05 22:30
 */
public class QuestionPrice extends AbstractQuestion {
    public QuestionPrice(Context context, String question) {
        super(context, question);
        this.qulifier = String.format("how many %s is", context.getUnit());;
    }

    @Override
    public String process() {
        String body = this.question.substring(this.qulifier.length()+1,this.question.length()-1).trim();
        String[] lexers = body.split(" ");
        String unit = lexers[lexers.length-1];
        double price = this.context.getPrices().get(unit);

        //计算商品单价
        List<String> list = Arrays.asList(lexers);
        String[] _lexers = new String[list.size()-1];
        for (int i=0;i< list.size()-1;i++) {
            _lexers[i] = list.get(i);
        }

        try {
            RomanGroup roman = RomanGroup.Parse(StringUtils.join(" ",_lexers), this.context.getRomans());
            int calculated = roman.Calculate();
            StringBuffer answer = new StringBuffer(body + " is ");
            answer.append(calculated * price + " " + this.context.getUnit());
            System.out.println(answer.toString());
            return answer.toString();
        }catch(GalaxyException e){
            StringBuffer answer = new StringBuffer(e.getMessage());
            System.out.println(answer.toString());
            return answer.toString();
        } catch(Exception e){
            StringBuffer answer = new StringBuffer("I have no idea what you are talking about");
            System.out.println(answer.toString());
            return answer.toString();
        }
    }
}
