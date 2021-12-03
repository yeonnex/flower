package gardening;
public class FlowerSystem {
    public static void main(String[] args){
        WaterSpray waterSpray = new WaterSpray(100); // 용량 100ml 짜리 분무기 생성
        waterSpray.fillUp();

        FlowerPot pot = new FlowerPot(10); // 하루에 최소 10ml의 물을 받아야 살 수 있는 화분 생성

//        int water = waterSpray.getRemainingWaterInMl();
//        waterSpray.spray();
//        water -= waterSpray.getRemainingWaterInMl();
        for (int i=0; i<2;i++){
//            pot.addWater(water);
//            waterSpray.sprayTo(pot);
            pot.addWater(waterSpray);
        }
        pot.liveAnotherDay();
        System.out.println(pot.isAlive());
    }

}
