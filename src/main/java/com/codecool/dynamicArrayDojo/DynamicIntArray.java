package com.codecool.dynamicArrayDojo;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.copyOf;

// put your code here!
public class DynamicIntArray {
    final int DEFAULT_SIZE = 10;
    Integer[] array;
    int ensuredSize;

    DynamicIntArray(int size) {
        this.ensuredSize = size;
        this.array = new Integer[size];
    }

    DynamicIntArray() {
        this.ensuredSize = DEFAULT_SIZE;
        this.array = new Integer[ensuredSize];
    }


    public Integer get(int index) {
        return array[index];
    }

    public void add(int value) {
        int length = size();

        if(length < ensuredSize) {
            array[length] = value;
        } else {
            ensureCapacity(++ensuredSize);
            array[length] = value;
        }
    }

    public void insert(int place, int value) {
        int length = size();
        if(length <= place) {
            add(value);
        } else {
            insert(place+1, array[place]);
            array[place] = value;
        }
    }

    public void remove(int index) {
        int length = size();
        if(index >= length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i<length-1; i++) {
            array[i] = array [i+1];
        }
        array[length-1] = null;

    }

    public int size() {
        int counter = 0;
        while(counter < array.length && array[counter] != null) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<array.length; i++) {
            if(array[i] != null) {
                result.append(" ");
                result.append(array[i]);
            }
        }
        return result.toString();
    }

    private void ensureCapacity(int size) {
       array = Arrays.copyOf(array, size);
    }



}
