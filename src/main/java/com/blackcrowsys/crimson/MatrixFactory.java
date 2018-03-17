package com.blackcrowsys.crimson;

public class MatrixFactory {

    public static Matrix generateMatrix(int numOfRows, Double[]... rows) {
        Double[][] matrix = new Double[numOfRows][rows[0].length];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i];
        }
        return new Matrix(matrix);
    }
}
