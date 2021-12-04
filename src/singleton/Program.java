package singleton;

public class Program {
    public static void main(String[] args){
        Singleton singleton0 = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println("same object? " + (singleton0 == singleton1));

    }
}
