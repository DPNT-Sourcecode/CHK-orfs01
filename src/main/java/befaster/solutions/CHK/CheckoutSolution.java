package befaster.solutions.CHK;

public class CheckoutSolution {

    private int[] itemToPayCount = new int[26];
    private int[] priceArray = {50,30,20,15,40,10,20,10,35,60,70,90,15,40,10,50,30,50,20,20,40,50,20,17,20,21};


    public Integer checkout(String skus) {

        itemToPayCount = new int[26];

        int total = 0;

        for(Character c: skus.toCharArray()){

            if (c.charValue() >= 65 && c.charValue() <= 90) {
                itemToPayCount[c.charValue() - 65]++;
                total += priceArray[c.charValue() - 65];
            } else {

                return -1;
            }

        }

        total = applyDiscounts(total);

        return total;
    }

    private int applyDiscounts(int total) {

        // Free Item Calculations
        //Buy X A get Y B Free
        total -= applyFreeOtherItemDiscount('E',2,'B');
        total -= applyFreeOtherItemDiscount('N',3,'M');
        total -= applyFreeOtherItemDiscount('R',3,'Q');

        //Buy X A Get Y A Free
        total -= applyFreeSameItemDiscount('F',3);
        total -= applyFreeSameItemDiscount('U',4);


        //Bulk Discount Calculations
        //Graduated Discount
        total -= applyGraduatedBulkDiscount('A',5,50,3,20);
        total -= applyGraduatedBulkDiscount('H',10,20,5,5);
        total -= applyGraduatedBulkDiscount('V',3,20,2,10);

        //Single Discount
        total -= applySingleBulkDiscount('B',2,15);
        total -= applySingleBulkDiscount('K',2,20);
        total -= applySingleBulkDiscount('P',5,50);
        total -= applySingleBulkDiscount('Q',3,10);

        //Three of discount
        //order discount group from highest price to lowest price
        char[] discountGroup = {'Z','Y','T','S','X'};
        total-=calcGroupDiscount(discountGroup, 3);

        return total;
    }

    private int calcGroupDiscount(char[] discountGroup, int groupSize) {
        int discount = 0;
        int totalCount = 0;

        for(char c: discountGroup){
            totalCount+=itemToPayCount[c-65];
        }

        int discountSets = totalCount/groupSize;

        int currentProduct = 0;
        char c = discountGroup[currentProduct];
        int currentProductTempCount = itemToPayCount[c-65];

        for(int i = 0; i < discountSets; i++){
            for(int j = 0; j < groupSize; j++){
                 if(currentProductTempCount > 0){
                     discount+=priceArray[c-65];
                     currentProductTempCount--;
                 } else{
                     currentProduct++;
                     c = discountGroup[currentProduct];
                     currentProductTempCount = itemToPayCount[c-65];
                     j--;
                 }
            }
            discount-=45;
        }

        return discount;
    }

    private int applySingleBulkDiscount(int eligibleItem, int q, int d) {
        int discountQuantity = itemToPayCount[eligibleItem-65] / q;
        return discountQuantity*d;
    }

    private int applyGraduatedBulkDiscount(int eligibleItem, int primaryQuantity, int primaryDiscount, int secondaryQuantity, int secondaryDiscount) {
        int discountPrimaryQuantity = itemToPayCount[eligibleItem-65] / primaryQuantity;
        int itemsRemainderAfterPrimary = itemToPayCount[eligibleItem-65] % primaryQuantity;
        int discountSecondaryQuantity = itemsRemainderAfterPrimary / secondaryQuantity;

        return discountPrimaryQuantity*primaryDiscount + discountSecondaryQuantity*secondaryDiscount;

    }

    private int applyFreeSameItemDiscount(char eligibleItem, int requireForOneFree) {
        int free = itemToPayCount[eligibleItem-65]/requireForOneFree;
        return priceArray[eligibleItem-65]*free;
    }

    private int applyFreeOtherItemDiscount(char eligibleItem, int required, char freeItem) {
        int free = itemToPayCount[eligibleItem-65]/required;

        if(itemToPayCount[freeItem-65]-free >= 0){
            itemToPayCount[freeItem-65]-=free;
            return free*priceArray[freeItem-65];
        }
        else {
            int itemCount = itemToPayCount[freeItem-65];
            itemToPayCount[freeItem-65] = 0;
            return itemCount*priceArray[freeItem-65];

        }
    }

}
