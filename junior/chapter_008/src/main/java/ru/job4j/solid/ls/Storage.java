package ru.job4j.solid.ls;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 * Created by roman.pogorelov on 17.09.2019
 */
public abstract class Storage implements Store {
    private List<Food> storage = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.storage.add(food);
    }

    public List<Food> getStorage() {
        return storage;
    }

    public void setStorage(List<Food> storage) {
        this.storage = storage;
    }
}
