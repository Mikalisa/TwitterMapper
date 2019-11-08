package filters.test;

import filters.*;
import org.junit.Test;


import static org.junit.Assert.assertTrue;


/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        System.out.println("#########"+ x.toString());
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }

    @Test
    public void testOrExp() throws SyntaxError {
        Filter x = new Parser("trump or evil or blue or red or green or purple").parse();
        System.out.println("#########"+ x.toString());
        assertTrue(x.toString().equals("(((((trump or evil) or blue) or red) or green) or purple)"));
    }

    @Test
    public void testAndExp() throws SyntaxError {
        Filter x = new Parser("evil and blue and red and green and purple").parse();
        System.out.println("#########"+ x.toString());
        assertTrue(x.toString().equals("((((evil and blue) and red) and green) and purple)"));
    }


}
