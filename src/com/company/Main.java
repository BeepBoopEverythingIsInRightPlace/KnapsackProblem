package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Item> itemsToTake = new ArrayList<>();

    public static void main(String[] args) {

        prepareItems();
        //pickBestItems()
    }

    public static void prepareItems() {
        itemsToTake.add(new Item(5, 10));
        itemsToTake.add(new Item(4, 40));
        itemsToTake.add(new Item(6, 30));
        itemsToTake.add(new Item(4, 50));
    }

    //Zastosuje alorytm aproksymacyjny
    public static List<Item> pickBestItems(List<Item> items) {
        sortItemsToTake();
        for (int i = 0; i < itemsToTake.size(); i++) {
            if (itemFitsInKnapSack(i)) {
                addToKnapsack(i);
                Knapsack.currentWeight += itemsToTake.get(i).weight;
            }
        }
        return Knapsack.sack;
    }

    private static boolean addToKnapsack(int i) {
        return Knapsack.sack.add(itemsToTake.get(i));
    }

    private static boolean itemFitsInKnapSack(int i) {
        return itemsToTake.get(i).weight + Knapsack.currentWeight <= Knapsack.KNAPSACK_MAX_WEIGHT;
    }

    public static void sortItemsToTake() {
        Collections.sort(itemsToTake);
    }
}
