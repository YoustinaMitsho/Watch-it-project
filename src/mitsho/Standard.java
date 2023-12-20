package mitsho;

public class Standard extends Subscription{

    final int Price =200;
    protected int CalculatePriceOf3(){
        return (Price * PlanBCounter) ;
    }

}
