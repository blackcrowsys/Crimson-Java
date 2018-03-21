package com.blackcrowsys.crimson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixFactoryTest {

    private Matrix matrix1;

    @BeforeEach
    void setUp() {
        matrix1 = MatrixFactory.generateMatrix(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 2);
    }

    @Test
    @DisplayName("Create Matrix tests")
    void generateMatrix_ArrayListAndNumberOfColumnsGiven_ShouldIfInvalid() {
        assertThrows(IllegalArgumentException.class, () ->  MatrixFactory.generateMatrix(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 3));
        assertThrows(IllegalArgumentException.class, () ->  MatrixFactory.generateMatrix(Stream.of(3.0, 2.0,  3.142, -0.2)
                .collect(Collectors.toCollection(ArrayList::new)), 0));
        assertThrows(IllegalArgumentException.class, () ->  MatrixFactory.generateMatrix(Stream.of(2.0)
                .collect(Collectors.toCollection(ArrayList::new)), 0));
    }

}