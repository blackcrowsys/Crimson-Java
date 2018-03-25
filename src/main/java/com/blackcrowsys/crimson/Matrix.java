package com.blackcrowsys.crimson;

import io.vavr.collection.List;
import lombok.Data;

import java.util.ArrayList;
import java.util.function.Function;

@Data
public class Matrix {

    private final List<Double> contents;

    private final int columns;

    private int rows;

    public Matrix(final List<Double> contents, final int columns) {
        this.contents = contents;
        this.columns = columns;
        this.rows = this.contents.size() / this.columns;
    }

    private static Double mulitplyDoubles(Double a, Double b) {
        return a * b;
    }

    public Double get(final int row, final int column) {
        if (column > this.columns || column < 1) {
            throw new IllegalArgumentException(("Incorrect Column Index: " + column));
        }
        if (row > contents.size() / this.columns || row < 1) {
            throw new IllegalArgumentException("Incorrect Row Index: " + row);
        }
        return contents.get(getIndex(row, column));
    }

    public Matrix add(final Matrix that) {
        if ((this.getRows() != that.getRows()) && (this.getColumns() != that.getColumns()))
            throw new IllegalArgumentException("Matrix size mismatch");
        ArrayList<Double> sum = new ArrayList<>();
        for (int i = 0; i < this.contents.size(); i++)
            sum.add(this.contents.get(i) + that.getContents().get(i));
        return MatrixFactory.create(sum, this.columns);
    }

    public Matrix apply(final Function<Double, Double> f) {
        ArrayList<Double> newContents = new ArrayList<>();
        contents.forEach(value -> newContents.add(f.apply(value)));
        return MatrixFactory.create(newContents, this.columns);
    }

    public Matrix multiplyByScaler(final Double d) {
        Function<Double, Double> multiply = (Double x) -> mulitplyDoubles(x, d);
        return apply(multiply);
    }

    private int getIndex(final int row, final int column) {
        return (row - 1) * this.columns + (column - 1);
    }
}