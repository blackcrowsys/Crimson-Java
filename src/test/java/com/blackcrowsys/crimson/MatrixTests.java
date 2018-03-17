package com.blackcrowsys.crimson;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void createNewMatrixWhenValid() {
        matrix = MatrixFactory.generateMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        assertEquals(-5.6, matrix.getValue(2, 3), 0.1);
    }

    @Test
    @DisplayName("Creating an invalid Matrix should throw an IllegalArgumentException")
    public void createNewMatrixWhenInvalid_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    matrix = MatrixFactory.generateMatrix(
                            new Double[]{6.0, -1.0, 3.0},
                            new Double[]{5.0, -3.3, -5.6, 3.0}
                    );
                }
        );
    }
}
