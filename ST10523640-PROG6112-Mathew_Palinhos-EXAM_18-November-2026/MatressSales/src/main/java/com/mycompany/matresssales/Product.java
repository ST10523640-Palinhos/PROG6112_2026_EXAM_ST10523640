
package com.mycompany.matresssales;

public class Product implements IProducts {

    private final String[] productNames;   // single-dimensional array
    private final int[][] monthlySales;    // two-dimensional array [product][month]

    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    // Total sales of one product across all months
    private int getProductTotal(int productIndex) {
        int total = 0;
        for (int month = 0; month < monthlySales[productIndex].length; month++) {
            total += monthlySales[productIndex][month];
        }
        return total;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < productNames.length; p++) {
            total += getProductTotal(p);
        }
        return total;
    }

    @Override
    public double GetAverageProductsSold() {
        int entries = 0;
        for (int p = 0; p < productNames.length; p++) {
            entries += monthlySales[p].length;
        }
        return entries == 0 ? 0 : (double) GetTotalProductsSold() / entries;
    }

    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        for (int p = 1; p < productNames.length; p++) {
            if (getProductTotal(p) > getProductTotal(bestIndex)) {
                bestIndex = p;
            }
        }
        return productNames[bestIndex] + " (" + getProductTotal(bestIndex) + ")";
    }
}