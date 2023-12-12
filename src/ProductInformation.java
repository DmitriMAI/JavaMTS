import java.math.BigDecimal;

/*
* Класс содержит информацию для подсчета
* общей цены всего товара, а также текущую скидку на товар
* */
public class ProductInformation {
    // Количество единиц товара
    private int amountOfProduct;
    // Цена одного товара
    private BigDecimal priceOfProduct;
    // Текущая скидка на товар
    private double discountPercent;

    public int getAmountOfProduct() {
        return amountOfProduct;
    }
    public void setAmountOfProduct(int amountOfProduct) {
        if (amountOfProduct < 0){
            throw new IllegalArgumentException("Not valid amount of product");
        }
        this.amountOfProduct = amountOfProduct;
    }
    public BigDecimal getPriceOfProduct() {
        return priceOfProduct;
    }
    public void setPriceOfProduct(double priceOfProduct) {
        if (priceOfProduct < 0){
            throw new IllegalArgumentException("Not valid price of product");
        }
        this.priceOfProduct = BigDecimal.valueOf(priceOfProduct);
    }
    public double getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(double discountPercent) {
        if (discountPercent <= 0){
            throw new IllegalArgumentException("That's not how discount work, use value zero or more");
        }
        this.discountPercent = discountPercent / 100;
    }
    ProductInformation(int amountOfProduct, double priceOfProduct, double discount){
        argumentValidation(amountOfProduct, priceOfProduct, discount);
        this.amountOfProduct = amountOfProduct;
        this.priceOfProduct = BigDecimal.valueOf(priceOfProduct);
        this.discountPercent = discount / 100;
    }
    private void argumentValidation(int amountOfProduct, double priceOfProduct, double discount){
        if (amountOfProduct < 0){
            throw new IllegalArgumentException("Not valid amount of product");
        }
        if (priceOfProduct < 0){
            throw new IllegalArgumentException("Not valid price of product");
        }
        if (discount <= 0){
            throw new IllegalArgumentException("That's not how discount work, use value zero or more");
        }
    }
}
