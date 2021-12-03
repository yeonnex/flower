package gardening;

// 한 번 spray 할 때마다 5ml 씩 분사됨
public class WaterSpray {
    private int capacity;
    private int remainingWaterInMl;

    public WaterSpray(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getRemainingWaterInMl() {
        return remainingWaterInMl;
    }
    public void addWater(int amountInMl){
        this.remainingWaterInMl += amountInMl;
        this.remainingWaterInMl = Math.min(this.remainingWaterInMl,capacity);
    }
    public void spray(){
        this.remainingWaterInMl -= Math.min(this.remainingWaterInMl, 5);
    }
    public void sprayTo(FlowerPot pot){
        int amountToSpray = Math.min(this.remainingWaterInMl, 5);
//        pot.addWater(amountToSpray);

        this.remainingWaterInMl -= amountToSpray;
    }
    public void fillUp(){ // 최대 용량까지 채우기
        this.remainingWaterInMl = capacity;
    }
}
