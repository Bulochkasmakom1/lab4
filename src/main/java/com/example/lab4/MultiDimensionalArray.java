package com.example.lab4;



public class MultiDimensionalArray {
    private final int[] dims;
    private final int[] strides;

    public final double[] data;

    public MultiDimensionalArray(int... dims) {
        this.dims = dims;
        this.strides = new int[dims.length];
        int stride = 1;
        for (int i = 0; i < dims.length; i++) {
            this.strides[i] = stride;
            stride *= dims[i];
        }
        this.data = new double[stride];
    }

    public double get(int... indices) {
        int index = calculateIndex(indices);
        return data[index];
    }

    public void set(double value, int... indices) {
        int index = calculateIndex(indices);
        data[index] = value;
    }

    public double getAiliff(int... indices) {
        int index = 0;
        for (int i = 0; i < indices.length; i++) {
            int dimIndex = indices[i] - dims[i] / 2;
            index += dimIndex * strides[i];
        }
        return data[index];
    }

    private int calculateIndex(int... indices) {
        int index = 0;
        for (int i = 0; i < indices.length; i++) {
            index += indices[i] * strides[i];
        }
        return index;
    }
    public int[] calculateVector(int... indices) {
        int[] vector = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            int dimIndex = index - dims[i] / 2;
            if (dimIndex >= 0) {
                vector[i] = dimIndex / strides[i];
            } else {
                vector[i] = (dimIndex - strides[i] + 1) / strides[i];
            }
        }
        return vector;
    }
}