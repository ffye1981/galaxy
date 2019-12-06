package com.thoughtworks.question;

import com.thoughtworks.Context;
import com.thoughtworks.parser.Parser;
import com.thoughtworks.parser.PriceParser;
import com.thoughtworks.parser.RomanParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class QuestionRomanTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void  process()
    {
        Context context = new Context();
        Parser[] parsers = new Parser[]{
                new RomanParser(context),
                new PriceParser(context)
        };
        List<String> lines = new ArrayList<String>();
        lines.add("glob is I");
        lines.add("prok is V");
        lines.add("pish is X");
        lines.add("tegj is L");
        lines.add("glob glob Silver is 34 Credits");
        lines.add("glob prok Gold is 57800 Credits");
        lines.add("pish pish Iron is 3910 Credits");
        lines.add("how much is pish tegj glob glob ?");
        lines.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        for (Parser _p: parsers) {
            for (String input : lines) {
                try {
                    _p.parse(input);
                }catch(Exception e){
                    System.out.println("error:" + input);
                }
            }
        }

        List<AbstractQuestion> questions = QuestionFactory.createQuestions(lines,context);
        for (AbstractQuestion question: questions) {
            question.process();
        }

    }
}
