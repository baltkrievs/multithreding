package by.darashchonak.mentoring.multithreding;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncList {

    private List<Integer> list;
    private Lock lock = new ReentrantLock();

    public SyncList() {
        list = new ArrayList<>();
    }

    public void add(Integer value) {

        lock.lock();
        list.add(value);
        lock.unlock();
    }

    public List<Integer> getValues() {

        return new ArrayList(list);
    }
}
