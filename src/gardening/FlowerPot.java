package gardening;

public class FlowerPot {
    private boolean alive = true;
    private int minDailyWaterInMl;
    private int dailyWaterReceived = 0;
    public void addWater(WaterSpray spray){
        int water = spray.getRemainingWaterInMl();
        spray.spray();
        water -= spray.getRemainingWaterInMl();

        dailyWaterReceived += water;
    }
    public void liveAnotherDay(){ // 하루가 지나면 이 함수를 호출해주자!
        if (dailyWaterReceived < minDailyWaterInMl){
            alive = false;
        }
        dailyWaterReceived = 0;
    }

    public FlowerPot(int minDailyWaterInMl){
        this.minDailyWaterInMl = minDailyWaterInMl;
    }
    public boolean isAlive(){
        return this.alive;
    }
    public int getMinDailyWaterInMl(){
        return this.minDailyWaterInMl;
    }

}
