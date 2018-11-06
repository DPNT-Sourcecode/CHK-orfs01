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

        //Buy X A Get Y A Free
        total -= applyFreeSameItemDiscount('F',3);


        //Bulk Discount Calculations
        //ProductA
        total -=applyGraduatedBulkDiscount('A',5,50,3,20);

        //ProductB
        int discountQuantityB = itemToPayCount[1] / 2;
        total-=discountQuantityB*15;
        return total;
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
        int free = itemToPayCount[eligibleItem-65]/2;

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
