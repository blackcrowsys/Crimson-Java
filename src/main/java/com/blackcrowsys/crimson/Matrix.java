package com.blackcrowsys.crimson;

import io.vavr.collection.List;
import lombok.Data;

import java.util.ArrayList;

@Data
class Matrix {

    private List<Double> contents;

    private int numOfColumns;

    private int numOfRows;

    Matrix(List contents, int numOfColumns) {
        this.setContents(contents);
        this.setNumOfColumns(numOfColumns);
        this.numOfRows = contents.size() / this.numOfColumns;
    }


    Double get(int row, int column) {
        if (column > this. numOfColumns  || column < 1) {
            throw new IllegalArgumentException(("Incorrect Column Index: " + column));
        }
        if (row > contents.size() / this.numOfColumns || row < 1) {
            throw new IllegalArgumentException("Incorrect Row Index: " + row);
        }
        return contents.get(getIndex(row, column));
    }

    Matrix sum(final Matrix thatMatrix) {
        if ((this.getNumOfRows() != thatMatrix.getNumOfRows()) && (this.getNumOfColumns() != thatMatrix.getNumOfColumns()))
            throw new IllegalArgumentException("Matrix size mismatch");
        ArrayList<Double> sum = new ArrayList<>();
        for (int i = 0; i < this.contents.size(); i++)
            sum.add(this.contents.get(i) + thatMatrix.getContents().get(i));
        return MatrixFactory.generateMatrix(sum, this.numOfColumns);
    }

    private int getIndex(final int row, final int column) {
        return (row - 1) * this.numOfColumns + (column - 1);
    }
}