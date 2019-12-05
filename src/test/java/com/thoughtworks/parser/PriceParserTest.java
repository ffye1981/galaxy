package com.thoughtworks.parser;

import com.thoughtworks.Context;
import org.junit.Test;

import java.util.Iterator;

/**
 * Unit test for simple App.
 */
public class PriceParserTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void  parse()
    {
        Context context = new Context();
        RomanParser romanParser = new RomanParser(context);
        PriceParser priceParserParser = new PriceParser(context);
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
                System.out.println("error:" + input);
            }
        }
        for (String input : inputs) {
            try {
                priceParserParser.parse(input);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("goods-price：");
        Iterator<String> iterator = context.getPrices().keySet().iterator();
        while(iterator.hasNext()) {
            String good = iterator.next();
            System.out.println("\t" + good + " = " + context.getPrices().get(good));
        }
    }
}
