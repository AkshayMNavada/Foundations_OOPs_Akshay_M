package vending;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int totalAmount = 0;
        String paymentMode = "";

        VendingMachine vendingMachine = new VendingMachineTest();
        vendingMachine.displayProducts();

        List<Product> products = vendingMachine.selectProduct();
        if (products.size() == 0){
            System.out.println("********************* Please add 1 or more products to cart *********************");
            return;
        }

        for (Product product : products) {
            totalAmount += product.getPrice();
        }

        while (paymentMode.length() == 0) {
            paymentMode = vendingMachine.selectPaymentMode();
        }
        System.out.println("Selected payment mode is " + paymentMode);

        vendingMachine.completeTransaction(paymentMode, totalAmount);
    }
}
