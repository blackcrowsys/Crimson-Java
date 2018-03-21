package com.blackcrowsys.crimson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixFactoryTest {
    private Matrix matrix1;

    private Matrix matrix2;

    @BeforeEach
    void setUp() {
        matrix1 = MatrixFactory.generateMatrix(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);
    }

    @Test
    @DisplayName("Create new Matrix")
    void get_IndexGiven_ShouldReturnMatrixValue() {
        assertEquals(3.00, matrix1.get(1, 1), 0.001);
        assertEquals(2.00, matrix1.get(1, 2), 0.001);
        assertEquals(3.142, matrix1.get(2, 1), 0.001);
        assertEquals(-0.2, matrix1.get(2, 2), 0.001);
    }

}
