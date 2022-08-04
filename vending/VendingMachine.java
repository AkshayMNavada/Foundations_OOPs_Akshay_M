package vending;

import java.util.List;

public interface VendingMachine {
    void displayProducts();
    List<Product> selectProduct();
    String selectPaymentMode();
    void completeTransaction(String paymentMode, int amount);
}
