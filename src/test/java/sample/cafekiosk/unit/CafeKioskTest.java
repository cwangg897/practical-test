package sample.cafekiosk.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.beverage.Americano;


// 수동화된 테스트 문제점 눈으로 확인하는거, 다른사람이 이 코드를 봤을때 어떤것을 봐야하는지 모름
// 자동화된 테스트 장점
class CafeKioskTest {

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        Assertions.assertEquals(cafeKiosk.getBeverages().size(), 1);
    }

    @Test
    void remove() {

    }

    @Test
    void clear() {

    }

    @Test
    void calculateTotalPrice() {

    }

    @Test
    void createOrder() {
    }
}