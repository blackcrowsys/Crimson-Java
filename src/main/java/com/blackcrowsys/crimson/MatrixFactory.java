package com.blackcrowsys.crimson;

import io.vavr.collection.List;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MatrixFactory {

    private MatrixFactory() {
        throw new IllegalStateException("Utility Class");
    }

    @NotNull
    public static Matrix create(final ArrayList<Double> contents, final int numOfColumns) {
        if ((numOfColumns < 1) || (contents.size() % numOfColumns != 0)) {
            throw new IllegalArgumentException("Contents mismatch");
        }
        List matrixContents = List.ofAll(contents);
        return new Matrix(matrixContents, numOfColumns);
    }

}