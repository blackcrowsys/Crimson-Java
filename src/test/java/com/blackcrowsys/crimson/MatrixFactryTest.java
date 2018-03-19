package com.blackcrowsys.crimson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixFactryTest {

    private Matrix matrix1;
    @Test
    @DisplayName("Test creating a Matrix")
    void createNewMatrixWhenValid() {
        matrix1 = MatrixFactory.createMatrix(
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
                        matrix1 = MatrixFactory.createMatrix(
                                new Double[]{6.0, -1.0, 3.0},
                                new Double[]{5.0, -3.3, -5.6, 3.0}
                        )
        );
    }

    @Test
    @DisplayName("Creating an empty Matrix should throw an IllegalArgumentException")
    void whenCreatingEmptyMatrix_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> matrix1 = MatrixFactory.createMatrix());
    }

}
