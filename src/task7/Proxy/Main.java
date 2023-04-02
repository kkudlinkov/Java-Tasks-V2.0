package task7.Proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Receiving and showing up data: ");
        Database stdDB = new StandartDB("someDataBase.db");
        stdDB.showUp();

        System.out.println("\nReceiving null data: ");
        Database stdDB2 = new StandartDB(null);

        System.out.println("Receiving and showing up data from: ");
        Database proxyDB = new ProxyDB("someOtherDataBase.db");
        proxyDB.showUp();
        Database proxyDb2 = new ProxyDB(null);
        proxyDb2.showUp();
    }
}
