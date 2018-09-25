package main.java.ocp.nested;

/**
 * Created by christianneuls on 23.08.18.
 */
public class AnonInner {
    public int basePrice = 1000;

    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice){
        SaleTodayOnly sale = new SaleTodayOnly(){
            @Override
            public int dollarsOff() {
                return basePrice + 3;
            }
        };
        return basePrice - sale.dollarsOff();

    }
}
