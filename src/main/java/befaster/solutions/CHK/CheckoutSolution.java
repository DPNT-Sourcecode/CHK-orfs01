package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int total = 0;
        StringBuilder tempNum = new StringBuilder();
        int[] itemCount = new int[4];

        for(Character c: skus.toCharArray()){

            if(c.charValue() >= 48 && c.charValue() <= 58){
                tempNum.append(c);
            }
            else{

                int count = 1;
                if(tempNum.length() > 0) count = Integer.parseInt(tempNum.toString());

                if (c == 'A'){
                    itemCount[0]+=count;
                    total+=count*50;
                }
                else if (c == 'B'){
                    itemCount[1]+=count;
                    total+=count*30;
                }
                else if (c == 'C'){
                    itemCount[2]+=count;
                    total+=count*20;
                }
                else if (c == 'D'){
                    itemCount[3]+=count;
                    total+=count*15;
                }
                else
                    return -1;

                tempNum = new StringBuilder();
            }

        }

        //calc discounts
        //discount A
        int discountQuantityA = itemCount[0] / 3;
        total-=discountQuantityA*20;

        int discountQuantityB = itemCount[1] / 2;
        total-=discountQuantityB*15;

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
