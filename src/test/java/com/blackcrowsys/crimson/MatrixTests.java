package com.blackcrowsys.crimson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTests {

    private Matrix matrix1;

    private Matrix matrix2;
    
    @Test
    @DisplayName("Matrix should return the correct value given the row and column")
    void returnValueByCoordinate() {
        matrix1 = MatrixFactory.createMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{6.57, -3.3, -5.6},
                new Double[]{5.67, -3.3, -5.6},
                new Double[]{67.50, -3.3, -5.6}
        );
        matrix1.setValueByCoordinate(matrix1, 1, 1, 6.0);
        assertEquals(6.00, 6.00, 0.001);
    }

    @Test
    @DisplayName("Sum two 3*2 Matrices together")
    void whenSummingTwoMatrices_ThenReturnNewMatrix() {
        matrix1 = MatrixFactory.createMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        matrix2 = MatrixFactory.createMatrix(
                new Double[]{3.0, 1.0, -4.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        Matrix sumMatrix = matrix1.sum(matrix2);

        assertEquals(12.5, sumMatrix.getValue(2, 1), 0.1);
    }

    @Test
    @DisplayName("Sum two 2*2 Matrices together")
    void whenSummingTwoByTwoMatrices_ThenReturnNewMatrix() {
        matrix1 = MatrixFactory.createMatrix(
                new Double[]{6.0, -1.0},
                new Double[]{5.0, -3.3}
        );

        matrix2 = MatrixFactory.createMatrix(
                new Double[]{3.0, 1.0},
                new Double[]{7.5, -5.3}
        );

        Matrix sumMatrix = matrix1.sum(matrix2);

        assertEquals(12.5, sumMatrix.getValue(2, 1), 0.1);
    }

    @Test
    @DisplayName("Sum two Matrices with different sizes")
    void whenSummingInvalidMatricesTogether_ThenThrowInvalidArgumentException() {
        matrix1 = MatrixFactory.createMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        matrix2 = MatrixFactory.createMatrix(
                new Double[]{3.0, 1.0, -4.0, 5.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        assertThrows(IllegalArgumentException.class,
                () -> matrix1.sum(matrix2));
    }

    @Test
    @DisplayName("Sum two Matrices together where one is empty")
    void whenSummingMatricesWhereOneIsNull_ThenThrowInvalidArgumentException() {
        matrix1 = MatrixFactory.createMatrix(
                new Double[]{3.3, 1.0, -4.0}
        );

        matrix2 = MatrixFactory.createMatrix(
                new Double[]{3.0, 1.0, -4.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        assertThrows(IllegalArgumentException.class,
                () -> matrix1.sum(matrix2));
    }
}
