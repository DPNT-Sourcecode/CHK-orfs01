package befaster.solutions.CHK;

public class CheckoutSolution {

    private int[] itemToPayCount = new int[26];
    private int[] priceArray = {50,30,20,15,40,10,20,10,35,60,80,90,15,40,10,50,30,50,30,20,40,50,20,90,10,50};


    public Integer checkout(String skus) {

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

        //Buy X A Get Y A Free
        total -= applyFreeSameItemDiscount('F',3);


        //Bulk Discount Calculations
        //ProductA
        total -= applyGraduatedBulkDiscount('A',5,50,3,20);
        total -= applyGraduatedBulkDiscount('H',10,20,5,5);
        total -= applyGraduatedBulkDiscount('V',3,20,2,10);

        //ProductB
        total -= applySingleBulkDiscount('B',2,15);
        total -= applySingleBulkDiscount('K',2,10);
        total -= applySingleBulkDiscount('P',5,50);
        total -= applySingleBulkDiscount('Q',3,10);

        return total;
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
            itemToPayCount[1]-=free;
            return free*priceArray[freeItem-65];
        }
        else {
            int itemCount = itemToPayCount[freeItem-65];
            itemToPayCount[1] = 0;
            return itemCount*priceArray[freeItem-65];

        }
    }

}
