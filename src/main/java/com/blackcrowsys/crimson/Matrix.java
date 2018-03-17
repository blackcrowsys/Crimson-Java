package com.blackcrowsys.crimson;

import lombok.Data;

import java.util.Arrays;

@Data
public class Matrix {

    private Double[][] matrix;

    private int numOfRows;

    public Matrix(int row, int column) {
        matrix = new Double[row][column];
    }

    public Matrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public Double getValue(int row, int column) {
        return matrix[row-1][column-1];
    }

    public Double[][] setValueByCoordinate(Matrix matrix, int row, int column, Double newValue) {
        Double newMatrix[][] = matrix.getMatrix().clone();
        newMatrix[row][column] = newValue;
        return newMatrix;
    }
}