package ru.job4j.tracker;

/**
 * Created by roman.pogorelov on 31.08.2019
 */
public class FindItemById extends BaseAction {

    public FindItemById(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------------- Search request by id -----------------");
        Item item = tracker.findById(input.ask("Введите id заявки :"));
        String result = item == null ? "Request isn't found" : String.format("Request is found - %s %s %s.", item.getId(), item.getName(), item.getDescription());
        System.out.println(result);
        System.out.println("---------------------------------");
    }
}
