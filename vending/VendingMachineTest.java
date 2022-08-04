package vending;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VendingMachineTest implements VendingMachine{

    @Override
    public void displayProducts() {
        System.out.println(" *********************************************");
        System.out.println("               VENDING MACHINE                ");
        System.out.println(" *********************************************");
        System.out.println();
        System.out.println("              Products available:             ");
        System.out.println("                                              ");

        int counter = 1;
        for(Product product: Product.values()){
            System.out.println("       "+ (counter++) +".   " + product.name() + " - Price: " + product.getPrice() + "   ");
        }
        System.out.println();
    }

    @Override
    public List<Product> selectProduct() {
        String addMore = "";
        int totalPrice = 0;
        List<Product> productList = new ArrayList<>();

        do {
            System.out.println("Current product list is : " + productList + "\n" +"Total cost : " + totalPrice);
            System.out.println("*************************************************************************************" + "\n");
            System.out.println("Enter the product ID to select : ");
            Scanner scanner = new Scanner(System.in);
            try {
                int id = scanner.nextInt();
                Product product;
                switch (id) {
                    case 1:
                        product = Product.valueOf("COKE");
                        productList.add(product);
                        totalPrice += product.getPrice();
                        break;
                    case 2:
                        product = Product.valueOf("PEPSI");
                        productList.add(product);
                        totalPrice += product.getPrice();
                        break;
                    case 3:
                        product = Product.valueOf("SODA");
                        productList.add(product);
                        totalPrice += product.getPrice();
                        break;
                    case 4:
                        product = Product.valueOf("LAYS");
                        productList.add(product);
                        totalPrice += product.getPrice();
                        break;
                    case 5:
                        product = Product.valueOf("DORITOS");
                        productList.add(product);
                        totalPrice += product.getPrice();
                        break;
                    default:
                        System.out.println("************************************* Please enter a valid product ID *****************************************");
                        break;
                }
                System.out.println("Do you want to add more products to cart? (y/n)");
                addMore = scanner.next();
            }catch (InputMismatchException e){
                System.out.println("************************************* Please enter a valid input *****************************************");
            }
        } while (addMore.equals("y"));

        System.out.println("Total product list is : " + productList + "\n" +"Total cost : " + totalPrice);
        return productList;
    }

    @Override
    public String selectPaymentMode() {
        System.out.println("**************** Payment mode ****************");
        System.out.println("Enter either 1 (for cash) or 2 (for card)");
        System.out.println("Amount to be paid is doubled if you select card");
        System.out.println("**********************************************");
        System.out.println("                  1 - Cash                    ");
        System.out.println("                  2 - Card                    ");
        System.out.println("**********************************************");

        int paymentMode = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            try{
                paymentMode = scanner.nextInt();
                if (paymentMode == 1)
                    return "Cash";
                if (paymentMode == 2)
                    return "Card";
                else{
                    System.out.println("Please select a valid option \n");
                    break;
                }

            }catch (InputMismatchException exception){
                System.out.println("Please enter a valid input \n");
                break;
            }
        }while (paymentMode != 1 && paymentMode != 2);

        return "";
    }

    @Override
    public void completeTransaction(String paymentMode, int amount) {
        int cash = 0;
        System.out.println("**********************************************");
        if (paymentMode.equals("Cash")){
            System.out.println("Total amount to be paid is : "+ amount);
            System.out.println("Pay the amount by cash ");
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    cash = scanner.nextInt();
                    if (cash - amount == 0)
                        System.out.println("************ Thank you !! *************");
                    else if (cash - amount < 0)
                        System.out.println("Please pay the correct amount");
                    else
                        System.out.println("Please take the change " + (cash - amount));
                }catch (InputMismatchException exception){
                    System.out.println("Please enter a valid input \n");
                    break;
                }
            }while (cash < amount);
        }else if (paymentMode.equals("Card")){
            System.out.println("Total amount to be paid is : "+ 2*amount);
            System.out.println("Insert your card and pay the amount");
            System.out.println("************ Thank you !! *************");
        }
    }
}
