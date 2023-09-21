package sample.cafekiosk.spring.domain.order;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static sample.cafekiosk.spring.domain.product.ProductType.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductType;

class OrderTest {



    @DisplayName("주문 생성시 주문 등록 시간을 기록한다")
    @Test
    public void registeredDateTime() throws Exception {
        // given
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );

        LocalDateTime registeredDateTime = LocalDateTime.now();
        // when
        Order order = Order.create(products, LocalDateTime.now());
        // then
        assertThat(order.getRegisteredDateTime()).isEqualTo(registeredDateTime);
    }
    
    @DisplayName("주문 생성시 주문 상태는 INIT이다")
    @Test
    public void init() throws Exception {
        // given
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );
        // when
        Order order = Order.create(products, LocalDateTime.now());
        // then
        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT); // ENUM값 자체 비교할때 사용하는거
    }


    @DisplayName("주문 생성시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    public void calculateTotalPrice() throws Exception {
        // given
        List<Product> products = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000)
        );
        // when
        Order order = Order.create(products, LocalDateTime.now());
        // then
        assertThat(order.getTotalPrice()).isEqualTo(3000);
    }


    private Product createProduct(String productNumber, int price){
        return Product.builder()
                .type(HANDMADE)
                .productNumber(productNumber)
                .price(price)
                .sellingStatus(SELLING)
                .name("메뉴 이름")
                .build();
    }

}