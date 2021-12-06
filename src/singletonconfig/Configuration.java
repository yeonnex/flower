package singletonconfig;

public class Configuration {
    private static Configuration instance;
    private int x;
    private int y;
    private int width;
    private int height;

    private Configuration(){

    }
    public static Configuration getInstance(){
        if (instance == null){
            instance = new Configuration();
        }
        return instance;
    }

    public static void setInstance(Configuration instance) {
        Configuration.instance = instance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void save(String filename){
        // 설정을 파일로 저장
    }
    public void load(String filename){
        // 파일로부터 설정 열기기
   }
}
