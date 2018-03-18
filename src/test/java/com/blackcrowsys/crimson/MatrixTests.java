package com.blackcrowsys.crimson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTests {

    private Matrix matrix1;

    private Matrix matrix2;

    @BeforeEach
    void setUp() {
        matrix1 = new Matrix(2, 3);
    }

    @Test
    @DisplayName("Test if matrix1 will return the correct value given the row and collum")
    void returnValueByCoordinate() {
        matrix1.setValueByCoordinate(matrix1, 1, 1, 6.0);
        assertEquals(6.00, 6.00, 0.001);
    }

    @Test
    @DisplayName("Test creating a Matrix")
    void createNewMatrixWhenValid() {
        matrix1 = MatrixFactory.generateMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        assertEquals(-5.6, matrix1.getValue(2, 3), 0.1);
    }

    @Test
    @DisplayName("Creating an invalid Matrix should throw an IllegalArgumentException")
    void createNewMatrixWhenInvalid_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () ->
                        matrix1 = MatrixFactory.generateMatrix(
                                new Double[]{6.0, -1.0, 3.0},
                                new Double[]{5.0, -3.3, -5.6, 3.0}
                        )
        );
    }

    @Test
    @DisplayName("Creating an empty Matrix should throw an IllegalArgumentException")
    void whenCreatingEmptyMatrix_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> matrix1 = MatrixFactory.generateMatrix());
    }

    @Test
    @DisplayName("Sum two Matrices together")
    void whenSummingTwoMatricesTogether_ThenReturnNewMatrix() {
        matrix1 = MatrixFactory.generateMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        matrix2 = MatrixFactory.generateMatrix(
                new Double[]{3.0, 1.0, -4.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        Matrix sumMatrix = matrix1.sum(matrix2);

        assertEquals(12.5, sumMatrix.getValue(2, 1), 0.1);
    }

    @Test
    @DisplayName("Sum two Matrices with different sizes")
    void whenSummingInvalidMatricesTogether_ThenThrowInvalidArgumentException() {
        matrix1 = MatrixFactory.generateMatrix(
                new Double[]{6.0, -1.0, 3.0},
                new Double[]{5.0, -3.3, -5.6}
        );

        matrix2 = MatrixFactory.generateMatrix(
                new Double[]{3.0, 1.0, -4.0, 5.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        assertThrows(IllegalArgumentException.class,
                () -> matrix1.sum(matrix2));
    }

    @Test
    @DisplayName("Sum two Matrices together where one is empty")
    void whenSummingMatricesWhereOneIsNull_ThenThrowInvalidArgumentException() {
        matrix1 = MatrixFactory.generateMatrix(
                new Double[]{3.3, 1.0, -4.0}
        );

        matrix2 = MatrixFactory.generateMatrix(
                new Double[]{3.0, 1.0, -4.0},
                new Double[]{7.5, -5.3, 4.0}
        );

        assertThrows(IllegalArgumentException.class,
                () -> matrix1.sum(matrix2));
    }
}
