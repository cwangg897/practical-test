package sample.cafekiosk.unit;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import sample.cafekiosk.beverage.Beverage;
import sample.cafekiosk.order.Order;

@Getter
public class CafeKiosk {

    private static final LocalTime SHOP_OPEN = LocalTime.of(10, 0);
    private static final LocalTime SHOP_END = LocalTime.of(10, 22);


    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
    }


    public void add(Beverage beverage, int count){
        if(count <= 0){
            throw new IllegalArgumentException("음료는 0이하는 불가능합니다");
        }

        for(int i=0; i<count; i++){
            beverages.add(beverage);
        }

    }

    public void remove(Beverage beverage){
        beverages.remove(beverage);
    }

    public void clear(){
        beverages.clear();
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for(Beverage beverage : beverages){
            totalPrice += beverage.getPrice();
        }
        return totalPrice;
    }

    public Order createOrder(){
        LocalTime current = LocalDateTime.now().toLocalTime();

        if(current.isAfter(SHOP_END) || current.isBefore(SHOP_OPEN)){
            throw new IllegalArgumentException("영업시간이 아닙니다");
        }
        return new Order(LocalDateTime.now(), beverages);
    }

    public Order createOrder(LocalDateTime currentDateTime){
        LocalTime current = currentDateTime.toLocalTime();

        if(current.isAfter(SHOP_END) || current.isBefore(SHOP_OPEN)){
            throw new IllegalArgumentException("영업시간이 아닙니다");
        }
        return new Order(LocalDateTime.now(), beverages);
    }
}
