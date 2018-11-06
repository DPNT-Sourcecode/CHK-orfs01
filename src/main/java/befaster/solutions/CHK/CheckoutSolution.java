package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int total = 0;
        StringBuilder tempNum = new StringBuilder();
        int[] itemToPayCount = new int[6];

        for(Character c: skus.toCharArray()){

            if(c.charValue() >= 48 && c.charValue() <= 58){
                tempNum.append(c);
            }
            else{

                int count = 1;
                if(tempNum.length() > 0) count = Integer.parseInt(tempNum.toString());

                if (c == 'A'){
                    itemToPayCount[0]+=count;
                    total+=count*50;
                }
                else if (c == 'B'){
                    itemToPayCount[1]+=count;
                    total+=count*30;
                }
                else if (c == 'C'){
                    itemToPayCount[2]+=count;
                    total+=count*20;
                }
                else if (c == 'D'){
                    itemToPayCount[3]+=count;
                    total+=count*15;
                }
                else if (c == 'E'){
                    itemToPayCount[4]+=count;
                    total+=count*40;
                }
                else if (c == 'F'){
                    itemToPayCount[5]+=count;
                    total+=count*10;
                }
                else
                    return -1;

                tempNum = new StringBuilder();
            }

        }

        //Discount For Product E
        int freeB = itemToPayCount[4]/2;
        if(itemToPayCount[1]-freeB >= 0){
            itemToPayCount[1]-=freeB;
            total-=freeB*30;
        }
        else {
            total-=itemToPayCount[1]*30;
            itemToPayCount[1] = 0;
        }

        //calc discounts
        //discount A
        int discountQuantityA50 = itemToPayCount[0] / 5;
        int remainingA = itemToPayCount[0] % 5;
        int discountQuantityA20 = remainingA / 3;

        total-=discountQuantityA50*50;
        total-=discountQuantityA20*20;

        int discountQuantityB = itemToPayCount[1] / 2;
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
