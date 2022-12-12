package study.redis.domain.order.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"productCode"})
public class CartProduct {
    private final String productCode;
    private String name;
    private Integer price;
    private Integer count;

    private CartProduct(String productCode) {
        this.productCode = productCode;
    }

    @Builder
    public CartProduct(String productCode, String name, Integer price, Integer count) {
        this(productCode);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public static CartProduct create(String productCode) {
        return new CartProduct(productCode);
    }

    public void plusCount(int count) {
        this.count += count;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                "}\n";
    }
}
