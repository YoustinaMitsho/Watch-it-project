package mitsho;
/***
 * class Premium that inherit from Subscription parent class
 */
public class Premium extends Subscription{
    final int Price =300;

    /***
     * override from Subscription class
     * function that calculate the revenue of specific plan(Premium)
     * @return total revenue of specific plan(Premium)
     */
    @Override
    protected int CalculatePriceOf3()
    {
        return (Price * PlanCCounter) ;
    }
}
