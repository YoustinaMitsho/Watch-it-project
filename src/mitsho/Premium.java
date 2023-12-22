package mitsho;
/***
 * class Premium that inherit from Subscription parent class
 */
public class Premium extends Subscription implements CalcRevenue{
    final int Price =300;
    /***
     * override from Subscription class
     * function that calculate the revenue of specific plan(Premium)
     * @return total revenue of specific plan(Premium)
     */
    @Override
    public int CalculatePriceOf3()
    {
        return (Price * PlanCCounter) ;
    }
}
