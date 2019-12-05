package com.thoughtworks;

import com.thoughtworks.parser.Parser;
import com.thoughtworks.parser.PriceParser;
import com.thoughtworks.parser.RomanParser;
import com.thoughtworks.question.AbstractQuestion;
import com.thoughtworks.question.QuestionFactory;
import com.thoughtworks.util.FileUtil;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 程序入口函数
     * @param args
     */
    public static void main( String[] args )
    {
        List<String> inputs = FileUtil.readInputs("src/main/resources/inputs.txt");
        Context context = new Context();
        Parser[] parsers = new Parser[]{
                new RomanParser(context),
                new PriceParser(context)
        };
        for (Parser _p: parsers) {
            for (String input : inputs) {
                try {
                    _p.parse(input);
                }catch(Exception e){
                    System.out.println("error:" + input);
                }
            }
        }
        List<AbstractQuestion> questions = QuestionFactory.createQuestions(inputs,context);
        for (AbstractQuestion question: questions) {
            question.process();
        }
    }
}
