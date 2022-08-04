package vending;

public enum Product {

    COKE(1,"Coke", 40),
    PEPSI(2,"Pepsi", 35),
    SODA(3,"Soda", 30),
    LAYS(4,"Lays", 20),
    DORITOS(5,"Doritos",50);

    private final int id;
    private final String name;
    private final int price;

    Product(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public long getPrice(){
        return price;
    }
}
