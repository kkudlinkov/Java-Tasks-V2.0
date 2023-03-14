package task3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SetLok<E> {
    public static final Lock lock = new ReentrantLock();
    public Set<String> sets = new HashSet<>();

     public void add(String num) {
        lock.lock();
        try {
            sets.add(num);
        } finally {
            lock.unlock();
        }
    }

    public void check() {
        System.out.println("Iterating over list:");
        Iterator<String> i = sets.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }

    @Override
    public String toString() {
        return sets.toString();
    }
}
