package com.blackcrowsys.crimson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class MatrixFactory {

    private MatrixFactory() {
        throw new IllegalStateException("Utility Class");
    }

    @NotNull
    static Matrix generateMatrix(final ArrayList<Double> contents, int numOfColumns) {
        if ((contents.size() % numOfColumns != 0) || (numOfColumns < 1)) {
            throw new IllegalArgumentException("Contents mismatch");
        }
        return new Matrix(contents, numOfColumns);
    }

}
