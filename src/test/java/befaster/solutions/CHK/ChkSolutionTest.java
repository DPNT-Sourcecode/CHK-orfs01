package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChkSolutionTest {

    private CheckoutSolution chk;

    @Before
    public void setup(){
        chk = new CheckoutSolution();
    }

    @Test
    public void testCalculationOneItemEach(){
        String basket = "ABCD";

        Integer expectedTotal = 115;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testCalculationOneItem(){
        String basket = "A";

        Integer expectedTotal = 50;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

}
