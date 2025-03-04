import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        
        Product product = new Product(id, name, price);
        
        product.displayDetails();
        System.out.println("\n\nprogram by PUSHKAR [22BCS17250]");
        
        scanner.close();
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    // Method to display product details
    public void displayDetails() {
        System.out.println("\nProduct Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}
