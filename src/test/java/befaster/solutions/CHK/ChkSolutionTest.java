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
        String basket = "AABCCD";

        Integer expectedTotal = 185;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testCalculationMultiItemLargeNumbers(){
        String basket = "ABCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDD";

        Integer expectedTotal = 50+30+13*20+18*15;

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
        String basket = "AAABBCD";

        Integer expectedTotal = 210;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testMultiBuyDiscountAndNonContiguousItems(){
        String basket = "AAABBCDBDADDDBBBBBB";

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
        String basket = "ABCDEE";

        Integer expectedTotal = 50+30+20+15+2*40-30;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNewADiscount(){
        String basket = "AAAAAAAA";

        Integer expectedTotal = 200+130;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNewADiscountWithBDiscount(){
        String basket = "AAAAAAAAABBBCDEEEE";

        Integer expectedTotal = 9*50+3*30+20+15+4*40-2*30-1*50-1*20;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testBFreeAndBDiscount(){
        String basket = "ABBBBBEEEE";

        Integer expectedTotal = 50+5*30+4*40-2*30-15;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testBFreeAndBDiscountDoesNotEqualNegativeBSpendTotal(){
        String basket = "BBBBEEEEEEEEEE";

        Integer expectedTotal = 4*30+10*40-4*30;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testFinBasket(){
        String basket = "FF";

        Integer expectedTotal = 2*10;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testFinBasketWithDiscount(){
        String basket = "FFFFFFF";

        Integer expectedTotal = 7*10-2*10;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testFinBasketWithDiscountAndOtherItems(){
        String basket = "AAAAABBCDDDFFFFFFF";

        Integer expectedTotal = 5*50+2*30+20+3*15+7*10-50-15-2*10;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNewPriceArray(){
        String basket = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Integer expectedTotal = 50+30+20+15+40+10+20+10+35+60+80+90+15+40+10+50+30+50+30+20+40+50+20+90+10+50;

        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testHDiscount(){
        String basket = "ABCHHHHHHHHHHHHHHHH";

        Integer expectedTotal = 50+30+20+16*10-20-5;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testVDiscount(){
        String basket = "ABCVVVVV";

        Integer expectedTotal = 50+30+20+5*50-20-10;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testKDiscount(){
        String basket = "ABCKKK";

        Integer expectedTotal = 50+30+20+3*80-10;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testNDiscount(){
        String basket = "ABCNNNNMM";

        Integer expectedTotal = 50+30+20+2*15+4*40-15;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testPDiscount(){
        String basket = "ABCPPPPP";

        Integer expectedTotal = 50+30+20+5*50-50;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testQDiscount(){
        String basket = "ABCQQQQ";

        Integer expectedTotal = 50+30+20+4*30-10;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testRDiscount(){
        String basket = "ABCRRRQQQQ";

        Integer expectedTotal = 50+30+20+3*50+4*30-30-10;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testUDiscount(){
        String basket = "ABCRRRUUUUU";

        Integer expectedTotal = 50+30+20+3*50+5*40-40;
        assertEquals(expectedTotal, chk.checkout(basket));
    }

    @Test
    public void testRQDiscount(){
        String basket = "RRRRRRQQ";

        Integer expectedTotal = 2*30+6*50-2*30;
        assertEquals(expectedTotal, chk.checkout(basket));
    }
}
