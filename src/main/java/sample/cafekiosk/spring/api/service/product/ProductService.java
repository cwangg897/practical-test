package sample.cafekiosk.spring.api.service.product;


import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;
import sample.cafekiosk.spring.domain.Product;
import sample.cafekiosk.spring.domain.ProductRepository;
import sample.cafekiosk.spring.domain.ProductSellingStatus;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductResponse> getSellingProducts(){
        List<Product> productList = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return productList.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
