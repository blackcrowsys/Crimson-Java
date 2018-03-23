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
        matrix1 = MatrixFactory.create(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);

        matrix2 = MatrixFactory.create(Stream.of(6.0, -2.0,  13.2, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);
    }

    @Test
    public void testAddingTwoMatricesOfSameSize() {
        resultMatrix = matrix1.add(matrix2);
        assertEquals(9.0, resultMatrix.get(1, 1), 0.1);
    }

    @Test
    public void testGettingValuesByRowColumn() {
        assertEquals(3.00, matrix1.get(1, 1), 0.001);
        assertEquals(2.00, matrix1.get(1, 2), 0.001);
        assertEquals(3.142, matrix1.get(2, 1), 0.001);
        assertEquals(-0.2, matrix1.get(2, 2), 0.001);
    }
}