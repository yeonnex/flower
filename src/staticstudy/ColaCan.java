package staticstudy;

public class ColaCan {
    private int remainingInMl;
    private static int numCreated = 0;
    public ColaCan(int initialInMl){
        this.remainingInMl = initialInMl;
        ++numCreated;
    }
    public static int printStats(){
        return numCreated;
    }
}
