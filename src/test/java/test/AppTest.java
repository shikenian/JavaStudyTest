package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testCharset(){
        char LF = '\r';
        char CR = '\n';
        System.out.println((int)LF);
        System.out.println((int)CR);
    }
}
