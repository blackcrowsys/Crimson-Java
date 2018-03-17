package com.blackcrowsys.crimson;

public class MatrixFactory {

    public static Matrix generateMatrix(final Double[]... rows) {
        final int numOfColumns = rows[0].length;
        Double[][] matrix = new Double[rows.length][numOfColumns];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i];
            if (rows[i].length > numOfColumns) throw new IllegalArgumentException("Matrix size mismatch");
        }
        return new Matrix(matrix);
    }
}
