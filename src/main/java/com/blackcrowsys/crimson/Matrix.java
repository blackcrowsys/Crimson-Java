package com.blackcrowsys.crimson;

import io.vavr.Tuple;
import io.vavr.Tuple2;
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

    private static Integer floor(double a) {
        return ((Double) Math.floor(a)).intValue();
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
        Function<Double, Double> multiply = (Double x) -> x * d;
        return apply(multiply);
    }

    public Matrix transpose() {
        final Integer arraySize = this.rows * this.columns;
        ArrayList<Double> results = new ArrayList<>(arraySize);
        for (int index = 0; index < arraySize; index++)
            results.add(index, getTransposeFromIndex(index));
        return MatrixFactory.create(results, this.rows);
    }

    private int getIndex(final int row, final int column) {
        return (row - 1) * this.columns + (column - 1);
    }

    private Double getTransposeFromIndex(final Integer index) {
        Tuple2<Integer, Integer> coords = getCoords(index, this.rows);
        return get(coords);
    }

    private Tuple2<Integer, Integer> getCoords(Integer index, int columns) {
        final Integer row = floor(index / columns) + 1;
        final Integer colIndex = (index + 1) % columns;
        final Integer col;
        if (colIndex == 0) col = columns;
        else col = colIndex;
        return Tuple.of(row, col);
    }

    private Double get(Tuple2<Integer, Integer> coords) {
        if (coords._2 > this.rows || coords._2 < 1)
            throw new IllegalArgumentException("Incorrect Column Index: " + coords._2);
        if (coords._1 > this.contents.size() / this.rows || coords._1 < 1)
            throw new IllegalArgumentException("Incorrect Row Index: " + coords._1);
        return contents.get(getIndex(coords._2, coords._1));
    }
}