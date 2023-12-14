package mitsho;

import java.time.LocalDate;
import java.util.Scanner;

public class Subscription {


    protected int UserId;
    //private int PlanPrice;
   // protected LocalDate StartDate;
    //protected LocalDate EndDate = StartDate.plusDays(30);

    protected boolean is_paied;
    public static int PlanACounter = 0;
    public static int PlanBCounter = 0;
    public static int PlanCCounter = 0;
    public int Movienum;


    protected int defaultnum;

    private void MovieDecreaser() {
        if (Movie.is_watched && Movienum > 0) {
            Movienum--;
        } else {
            System.out.println("Max Number of Movies is Reached");
        }
    }

    // need adjustments
    /*private void SubscriptionResetter() {
        LocalDate today = LocalDate.now();
        if (today.isEqual(EndDate)) {
            Movienum = 0;
        }
    }

    //ygded el subscription
    protected void Subscriptionrenew() {
        LocalDate today = LocalDate.now();
        if (is_paied && today.isEqual(EndDate)) {
            Movienum = defaultnum;
        }
    }*/

    //revenue
    public void chooseplan(String plantype) {
        System.out.println("choose your plan");
        Scanner input = new Scanner(System.in);
        if (plantype.equals("basic")) {
            PlanACounter++;

        } else if (plantype.equals("standard")) {
            PlanBCounter++;

        } else if (plantype.equals("premium")) {
            PlanCCounter++;

        }
    }

    //most subscriped plan done

    public int CalcRevenu() {
        Subscription s = new Basic();
        Basic a = (Basic) s;

        Subscription hh = new Standard();
        Standard w = (Standard) hh;

        Subscription gg = new Premium();
        Premium l = (Premium) s;

        int res = a.CalculatePriceOf1() + w.CalculatePriceOf2() + l.CalculatePriceOf3();
        return res;
    }
}
