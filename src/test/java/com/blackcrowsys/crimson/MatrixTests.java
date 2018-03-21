package com.blackcrowsys.crimson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTests {

    private Matrix matrix1;

    private Matrix matrix2;

    private Matrix resultMatrix;

    @BeforeEach
    void setUp() {
        matrix1 = MatrixFactory.generateMatrix(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);

        matrix2 = MatrixFactory.generateMatrix(Stream.of(6.0, -2.0,  13.2, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);
    }

    @Test
    @DisplayName("Sum two Matrices")
    void sum() {
        resultMatrix = matrix1.sum(matrix2);
        assertEquals(9.0, resultMatrix.get(1, 1), 0.1);
    }

}
