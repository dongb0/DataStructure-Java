package test;

import java.util.Date;
import java.util.Random;

public class TestUtils {

    static Random random = new Random();

    public static int[] getRandInts(int num){
        return getRandInts(num, Integer.MAX_VALUE);
    }

    public static int[] getRandInts(int num, int bound){
        int[] list = new int[num];
        random.setSeed(new Date().getTime());
        for(int i = 0; i < num; i++)
            list[i] = random.nextInt(bound);
        return list;
    }

}
