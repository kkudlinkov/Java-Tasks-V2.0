package task7.Proxy;

public class StandartDB implements Database{
    String db;

    public StandartDB(String db) {
        this.db = db;
        load();
    }

    private void load() {
        System.out.println("Receiving data from " + db);
    }

    @Override
    public void showUp() {
        System.out.println("Output from " + db);
    }
}