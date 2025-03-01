
class Singleton {

    private static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {

            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(data);
                    System.out.println("Creating new Instance");
                }
            }
        }

        System.out.println("Instance Data: " + result.data );

        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance("data");
        obj = Singleton.getInstance("value");

    }
}
