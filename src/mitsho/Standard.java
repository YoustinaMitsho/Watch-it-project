package mitsho;
/***
 * class Standard that inherit from Subscription parent class
 */
public class Standard extends Subscription{

    final int Price =200;

    /***
     * override from Subscription class
     * function that calculate the revenue of specific plan(Standard)
     * @return total revenue of specific plan(Standard)
     */
    @Override
    protected int CalculatePriceOf3(){
        return (Price * PlanBCounter) ;
    }

}
