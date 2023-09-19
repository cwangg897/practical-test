package sample.cafekiosk.unit;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.beverage.Americano;
import sample.cafekiosk.order.Order;


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
    public void addSeveralBeverage_happy() throws Exception {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        int count = 2;
        // when
        cafeKiosk.add(americano, count);
        // then
        Assertions.assertEquals(cafeKiosk.getBeverages().size(), 2);
    }

    @Test
    public void addSeveralBeverage_exception() throws Exception {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        int count = 2;
        // when
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> cafeKiosk.add(americano, count))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("음료는 0이하는 불가능합니다");
    }

    @Test
    void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);
        cafeKiosk.remove(americano);
        Assertions.assertEquals(cafeKiosk.getBeverages().size(), 0);
    }

    @Test
    void clear() {

    }

    @Test
    void calculateTotalPrice() {

    }

    @Test
    void createOrder() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        Order order = cafeKiosk.createOrder(LocalDateTime.of(2023,1,17,14,0));
        // 사이즈 체크
        // 뭐 들어있는지
        Assertions.assertEquals(order.getBeverages().size(), 1);
        Assertions.assertEquals(order.getBeverages().get(0).getName(), "아메리카노");
    }

    @Test
    void createOrder_exception() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> cafeKiosk.createOrder(LocalDateTime.of(2023,1,17,9,0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("영업시간이 아닙니다");
    }
}