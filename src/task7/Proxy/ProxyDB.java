package task7.Proxy;

public class ProxyDB implements Database {
    String db;
    StandartDB stdDB;

    public ProxyDB(String db) {
        this.db = db;
    }

    @Override
    public void showUp() {
        if (stdDB == null) {
            System.out.println("Creating empty data base!");
            stdDB = new StandartDB(db);
        }
        stdDB.showUp();
    }
}