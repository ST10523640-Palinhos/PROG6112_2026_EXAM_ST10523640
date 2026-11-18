
package com.mycompany.matressgui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatressGUITest {
    
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    }
}