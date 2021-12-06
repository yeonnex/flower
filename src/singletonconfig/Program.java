package singletonconfig;

public class Program {
    public static void main(String args[]){
        // 프로그램 실행 후 파일로부터 설정을 읽어옴
        Configuration config = Configuration.getInstance();
        config.load("settings.csv");

        int windowX = 100;
        int windowY = 200;

        // 창 위치 바뀔 때, x와 y를 설정함
        config.setX(windowX);
        config.setY(windowY);

        // 프로그램 종료 시, save()를 이용해서 변경사항을 파일에 저장장



   }
}
