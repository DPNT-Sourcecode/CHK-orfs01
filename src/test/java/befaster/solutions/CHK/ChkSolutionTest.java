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

    @Test
    public void testCalculationMultiItem(){
        String basket = "3A2BCD";

        Integer expectedTotal = 245;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testCalculationMultiItemLargeNumbers(){
        String basket = "A2BC42D";

        Integer expectedTotal = 760;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testInvalidCharacters(){
        String basket = "A2XBC42D";

        Integer expectedTotal = -1;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testInvalidCharacters2(){
        String basket = "A2XBC4#D";

        Integer expectedTotal = -1;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testMultiBuyDiscount(){
        String basket = "3A2BCD";

        Integer expectedTotal = 210;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testMultiBuyDiscountAndNonContiguousItems(){
        String basket = "3A2BCDBD5A3D6B";

        Integer expectedTotal = 665;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

}
