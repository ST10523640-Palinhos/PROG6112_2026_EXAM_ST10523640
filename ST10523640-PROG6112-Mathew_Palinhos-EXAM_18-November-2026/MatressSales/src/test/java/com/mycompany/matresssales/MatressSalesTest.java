
package com.mycompany.matresssales;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MatressSalesTest {
  
    private Product createProduct() {
        String[] names = {"Cozy Nights Monarch mattress",
                          "Restonic Barbados mattress",
                          "Sealy Phuket mattress"};
        int[][] sales = {
                {25, 10, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        return new Product(names, sales);
    }

    // Unit Test 1
    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        assertEquals(145, createProduct().GetTotalProductsSold());
    }

    // Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(145.0 / 9, createProduct().GetAverageProductsSold(), 0.001);
    }
}


