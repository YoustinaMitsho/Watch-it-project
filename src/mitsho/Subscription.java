package mitsho;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * the class of Subscription plan
 */
public class Subscription {
    public static int PlanACounter = 0;//basic
    public static int PlanBCounter = 0;//standerd
    public static int PlanCCounter = 0;//premium

    /***
     * collect the total revenue of the 3 plans we have
     * @return total revenue
     */
public static int CalcRevenu() {
        Subscription s = new Basic();
        Basic a = (Basic) s;

        Subscription hh = new Standard();
        Standard w = (Standard) hh;

        Subscription gg = new Premium();
        Premium l = (Premium) gg;

        int res = a.CalculatePriceOf3() + w.CalculatePriceOf3() + l.CalculatePriceOf3();
        return res;
    }

    /**
     * calculate revenue for each plan
     * @return revenue for each plan
     */
public static int ReturnRevenu(String subscrebtion_type ) {

        int  res=0;
        if (subscrebtion_type.equals("Basic")) {
            Basic a = new Basic();
            res= a.Price;


        } else if (subscrebtion_type.equals("Standard")) {
            Standard s = new Standard();
            res= s.Price;

        } else if (subscrebtion_type.equals("Premium")) {

            Premium p = new Premium();
            res= p.Price;
        }


        return res;
    }
}
