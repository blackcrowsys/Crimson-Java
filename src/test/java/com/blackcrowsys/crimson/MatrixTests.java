package com.blackcrowsys.crimson;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTests {

    private Matrix matrix;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(2, 3);
    }

    @Test
    @DisplayName("Test if matrix will return the correct value given the row and collum")
    public void returnValueByCoordinate() {
        matrix.setValueByCoordinate(matrix, 1, 1, 6.0);
        Double value = matrix.getValue(1, 1);
        assertEquals(6.00, 6.00, 0.001);
    }

    @Test
    @DisplayName("Test creating a Matrix")
    public void createNewMatrix() {
        matrix = MatrixFactory.generateMatrix(1,
                new Double[]{6.0, -1.0, 3.0}
        );
        assertEquals(6.0, matrix.getValue(1, 1), 0.1);
    }

}
