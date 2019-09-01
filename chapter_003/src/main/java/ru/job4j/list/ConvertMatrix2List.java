package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.pogorelov on 01.09.2019
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
