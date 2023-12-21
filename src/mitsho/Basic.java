package mitsho;

/***
 * class basic that inherit from Subscription parent class
 */
public class Basic extends Subscription{
    final int Price =100;

    /*public static int PlanACounter() {
        return Subscription.PlanACounter;
    }*/

     /***
     * override from Subscription class
     * function that calculate the revenue of specific plan(basic)
     * @return total revenue of specific plan(basic)
     */
    @Override
    protected int CalculatePriceOf3(){
        return (Price * PlanACounter) ;
    }
}
