package com.thoughtworks.parser;

import com.thoughtworks.Context;
import com.thoughtworks.parser.RomanParser;
import org.junit.Test;

import java.util.Iterator;

/**
 * Unit test for simple App.
 */
public class RomanParserTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void  parse()
    {
        Context context = new Context();
        RomanParser romanParser = new RomanParser(context);
        String[] inputs = new String[]{
                "glob is I",
                "prok is V",
                "pish is X",
                "tegj is L",
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits",
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?",
                "how many Credits is glob prok Gold ?",
                "how many Credits is glob prok Iron ?",
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?",
        };
        for (String input : inputs) {
            try {
                romanParser.parse(input);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("roman-ailias:");
        Iterator<String> iterator = context.getRomans().keySet().iterator();
        while(iterator.hasNext()) {
            String good = iterator.next();
            System.out.println("\t" + good + " = " + context.getRomans().get(good));
        }
    }
}
