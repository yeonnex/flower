package singleton;

public class Program {
    public static void main(String[] args){
        Singleton singleton0 = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println("same object? " + (singleton0 == singleton1));

//        int absValue = Math.abs(-2); // 컴파일 에러
        Math math = Math.getInstance();
        int absValue_1 = Math.getInstance().abs(-2);
        int absValue_2 = math.abs(-4);
        System.out.print(absValue_1);
        System.out.print(absValue_2);

    }
}
