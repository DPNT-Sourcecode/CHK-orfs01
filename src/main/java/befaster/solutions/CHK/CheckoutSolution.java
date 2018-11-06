package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int total = 0;

        for(Character c: skus.toCharArray()){

            if(c.charValue() )

            if (c == 'A') total+=50;
            else if (c == 'B') total+=30;
            else if (c == 'C') total+=20;
            else if (c == 'D') total+=15;
            else
                return -1;
        }

        return total;
    }
//
//
//    public enum SKU{
//        A(50),B(30),C(20),D(15);
//
//        private final int value;
//
//        SKU(final int newValue){
//            value = newValue;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//    }
}
