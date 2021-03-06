package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by roman.pogorelov on 01.09.2019
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("low"));
    }
}