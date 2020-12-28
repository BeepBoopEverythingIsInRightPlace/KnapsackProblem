package com.company;

public class Item implements Comparable{
    public int weight;
    public int value;
    public double valueToWeightRatio;

    public Item(int weight, int value) {
        if (weight <= 0)
            throw new IllegalArgumentException("Negative Value of Item Weight");
        if (value <= 0)
            throw new IllegalArgumentException("Negative Value of Item Value");

        this.weight = weight;
        this.value = value;
        this.valueToWeightRatio = value / weight;
    }

    @Override
    public int compareTo(Object compareItem) {
        double itemValueToWeightRatio = ((Item)compareItem).valueToWeightRatio;
        return (int)(itemValueToWeightRatio - this.valueToWeightRatio);
    }

    @Override
    public String toString() {
        return "value: " + this.value + ", weight: " + this.weight;
    }
}
