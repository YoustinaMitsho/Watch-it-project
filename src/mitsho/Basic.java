package mitsho;

public class Basic extends Subscription{
    final int Price =100;

    /*public static int PlanACounter() {
        return Subscription.PlanACounter;
    }*/


    protected int CalculatePriceOf3(){
        return (Price * PlanACounter) ;
    }
}
