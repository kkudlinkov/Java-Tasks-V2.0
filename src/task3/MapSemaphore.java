package task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MapSemaphore<K, V>{
    private final Semaphore semaphore = new Semaphore(1);
    private Map<K, V> msp =
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }
}
