package task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MapSemaphore<K, V> {
    private final Semaphore semaphore = new Semaphore(1);
    private Map<K, V> map = new HashMap<>();

    public MapSemaphore() {
    }

    public void put(K key, V elem) {
        try {
            semaphore.acquire(); // Получение раз
            map.put(key, elem);
            semaphore.release(); // Освобождаем разрешение
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public V get(K key) {
        V elem = null;
        try {
            semaphore.acquire();
            elem = map.get(key);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return elem;
    }
}
