package mitsho;

/***
 * class basic that inherit from Subscription parent class
 */
public class Basic extends Subscription implements CalcRevenue{
    final int Price =100;
    /***
     * override from Subscription class
     * function that calculate the revenue of specific plan(basic)
     * @return total revenue of specific plan(basic)
     */
    @Override
    public int CalculatePriceOf3() {
        return (Price * PlanACounter) ;
    }

   /* @Override
    protected int CalculatePriceOf3(){
        return (Price * PlanACounter) ;
    }*/
}
