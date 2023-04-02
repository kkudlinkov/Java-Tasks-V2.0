package task8.State;

public interface State {
    void doAction(Context context); // Определяет поведение объекта в данном состоянии
    String toString(); // возвращает название состояния
}