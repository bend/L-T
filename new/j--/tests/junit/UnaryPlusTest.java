
package junit;

import junit.framework.TestCase;
import pass.UnaryPlus;

public class UnaryPlusTest extends TestCase {
    private UnaryPlus plus;

    protected void setUp() throws Exception
    {
        super.setUp();
        plus = new UnaryPlus();
    }
    
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    public void testDivide()
    {
        this.assertEquals(plus.unaryPlus(+42), 42);
        this.assertEquals(plus.unaryPlus(+0), 0);
    }
}
