package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int total = 0;
        StringBuilder tempNum = new StringBuilder();

        for(Character c: skus.toCharArray()){

            if(c.charValue() >= 48 && c.charValue() <= 58){
                tempNum.append(c);
            }
            else{

                int count = Integer.parseInt(tempNum.toString());

                if (c == 'A') total+=count*50;
                else if (c == 'B') total+=count*30;
                else if (c == 'C') total+=count*20;
                else if (c == 'D') total+=count*15;
                else
                    return -1;

                tempNum = new StringBuilder();
            }


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
