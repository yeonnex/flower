package singleton;
// 싱글턴 Math 클래스
public class Math{
    private static Math instance;
    private Math(){

    }
    public static Math getInstance(){
        if (instance == null){
            instance = new Math();
        }
        return instance;
    }
    public int abs(int n){
        return n<0? -n:n;
    }
}