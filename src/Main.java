import java.math.BigDecimal;
import java.math.RoundingMode;


public class Main {
    public static void main(String[] args) {
        ProductInformation productsInformation = new ProductInformation(10,3.49, 0.1);
        printCalculatedSumWithAndWithoutDiscount(productsInformation);
        productsInformation.setAmountOfProduct(30);
        productsInformation.setPriceOfProduct(5.99);
        productsInformation.setDiscountPercent(20);
        printCalculatedSumWithAndWithoutDiscount(productsInformation);
        productsInformation.setAmountOfProduct(5);
        productsInformation.setPriceOfProduct(10.32);
        productsInformation.setDiscountPercent(5.23);
        printCalculatedSumWithAndWithoutDiscount(productsInformation);
    }
    public static void printCalculatedSumWithAndWithoutDiscount(ProductInformation productsInformation){
        BigDecimal priceOfProduct = productsInformation.getPriceOfProduct();
        BigDecimal sum = BigDecimal.valueOf(productsInformation.getAmountOfProduct())
                .multiply(priceOfProduct).setScale(2, RoundingMode.HALF_UP);
        double discount = productsInformation.getDiscountPercent();
        BigDecimal sumDiscounted = sum.multiply(BigDecimal.valueOf((1 - discount)))
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("Sum without discount: " + sum + " | Sum with discount: " + sumDiscounted);
    }
}