package study.redis.domain.order.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"productCode"})
public class CartProduct {
    private String productCode;
    private String name;
    private Integer price;
    private Integer count;

    @Builder
    public CartProduct(String productCode, String name, Integer price, Integer count) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void plusCount(int count) {
        this.count += count;
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
