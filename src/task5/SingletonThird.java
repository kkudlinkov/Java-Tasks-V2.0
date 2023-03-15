package task5;

/*
 * https://habr.com/ru/post/129494/
 *
 * + Простая и прозрачная реализаци
 * + Потокобезопасность
 * - Не ленивая инициализация
 */

public class SingletonThird {
    public static final SingletonThird INSTANCE = new SingletonThird();
}