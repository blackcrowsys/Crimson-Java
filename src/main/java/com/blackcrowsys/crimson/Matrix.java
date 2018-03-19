package com.blackcrowsys.crimson;

import lombok.Data;

@Data
class Matrix {

    private Double[][] matrixArray;

    Matrix(int row, int column) {
        matrixArray = new Double[row][column];
    }

    Matrix(Double[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    Double getValue(int row, int column) {
        return matrixArray[row - 1][column - 1];
    }

    Double[][] setValueByCoordinate(Matrix matrix, int row, int column, Double newValue) {
        Double[][] newMatrix = matrix.getMatrixArray().clone();
        newMatrix[row][column] = newValue;
        return newMatrix;
    }

    Matrix sum(final Matrix addMatrix) throws IllegalArgumentException {
        if (this.isEmpty() || addMatrix.isEmpty())
            throw new IllegalArgumentException(("One or both the matrices is empty"));
        if (this.matrixArray.length != addMatrix.getMatrixArray().length ||
                (addMatrix.getMatrixArray()[0].length != matrixArray[0].length))
            throw new IllegalArgumentException(("Matrices size is not equal"));

        final Double[][] addMatrixArray = addMatrix.getMatrixArray();
        final int numOfColumns = addMatrix.getMatrixArray()[0].length;
        final int numOfRows = addMatrix.getMatrixArray().length;

        Double[][] sumMatrix = new Double[numOfRows][numOfColumns];
        for (int row = 0; row < numOfRows; row++) {
            if (this.matrixArray[row].length > numOfColumns || addMatrixArray[row].length > numOfColumns)
                throw new IllegalArgumentException("Matrix size mismatch, columns not equal");
            for (int column = 0; column < numOfColumns; column++) {
                sumMatrix[row][column] = this.matrixArray[row][column] + addMatrixArray[row][column];
            }
        }
        return MatrixFactory.generateMatrix(sumMatrix);
    }

    public boolean isEmpty() {
        if (matrixArray == null || matrixArray.length == 0) return true;
        return false;
    }
}