
package com.mycompany.matresssales;

import java.util.Scanner;

public class MatressSales {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {"Cozy Nights Monarch mattress",
                          "Restonic Barbados mattress",
                          "Sealy Phuket mattress"};
        // Rows = products, columns = 3 months of sales
        int[][] sales = new int[names.length][3];

        // Outer loop goes through each product, inner loop through each month
        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + ": ");
                sales[p][m] = input.nextInt();
            }
            System.out.println();
        }

        // Pass the captured data to Product, then print the report
        Product product = new Product(names, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.PrintReport();
        input.close();
    }
}