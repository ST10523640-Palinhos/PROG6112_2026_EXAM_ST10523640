
package com.mycompany.matresssales;

public class PrintProduct {

    // Uses the IProducts interface so any class that implements it can be printed
    private final IProducts products;

    public PrintProduct(IProducts products) {
        this.products = products;
    }

    public void PrintTotalProductsSold() {
        System.out.println("TOTAL PRODUCT SALES: " + products.GetTotalProductsSold());
    }

    // %.2f formats the average to 2 decimal places
    public void PrintAverageProductsSold() {
        System.out.printf("AVERAGE PRODUCT SALES: %.2f%n", products.GetAverageProductsSold());
    }

    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + products.GetMostPopularProduct());
    }

    // Prints the heading, then calls each print method in order
    public void PrintReport() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*******************************************");
        PrintTotalProductsSold();
        PrintAverageProductsSold();
        PrintMostPopularProduct();
    }
}
