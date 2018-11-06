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
        String basket = "2A1B2CD";

        Integer expectedTotal = 185;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testCalculationMultiItemLargeNumbers(){
        String basket = "AB13C42D";

        Integer expectedTotal = 970;

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
        String basket = "3A2BCDBDA3D6B";

        Integer expectedTotal = 4*50+9*30+20+5*15-20-4*15;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testAddItemE(){
        String basket = "ABCDE";

        Integer expectedTotal = 50+30+20+15+40;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testItemEDiscount(){
        String basket = "ABCD2E";

        Integer expectedTotal = 50+30+20+15+2*40-30;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNewADiscount(){
        String basket = "8A";

        Integer expectedTotal = 200+130;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNewADiscountWithBDiscount(){
        String basket = "9A3BCD4E";

        Integer expectedTotal = 9*50+3*30+20+15+4*40-2*30-1*50-1*20;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testBFreeAndBDiscount(){
        String basket = "A5B4E";

        Integer expectedTotal = 50+5*30+4*40-2*30-15;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testBFreeAndBDiscountDoesNotEqualNegativeBSpendTotal(){
        String basket = "4B10E";

        Integer expectedTotal = 4*30+10*40-4*30;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

}
