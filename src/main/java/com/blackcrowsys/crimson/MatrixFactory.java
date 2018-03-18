package com.blackcrowsys.crimson;

import org.jetbrains.annotations.NotNull;

class MatrixFactory {

    private MatrixFactory() {
        throw new IllegalStateException("Utility Class");
    }

    @NotNull
    static Matrix generateMatrix(final Double[]... rows) {
        if (rows.length == 0)
            throw new IllegalArgumentException("Matrix is empty");
        final int numOfColumns = rows[0].length;
        final int numOfRows = rows.length;
        Double[][] matrix = new Double[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            if (rows[i].length > numOfColumns)
                throw new IllegalArgumentException("Matrix size mismatch, too many columns");
            matrix[i] = rows[i];
        }
        return new Matrix(matrix);
    }

    @NotNull
    static Matrix generateMatrixFromArray(final Double[][] matrixArray) {
        return new Matrix(matrixArray);
    }
}
