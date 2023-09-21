package sample.cafekiosk.spring.domain.product;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTypeTest {


    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다")
    @Test
    public void containsStockType1() throws Exception {
        // given
        ProductType productType = ProductType.HANDMADE;
        // when
        boolean result = ProductType.containsStockType(productType);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다")
    @Test
    public void containsStockType2() throws Exception {
        // given
        ProductType productType = ProductType.BOTTLE;
        // when
        boolean result = ProductType.containsStockType(productType);
        // then
        assertThat(result).isFalse();
    }
}