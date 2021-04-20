package test;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestUtils {

    Random random = new Random();

    int[] getRandInts(int num){
        return getRandInts(num, Integer.MAX_VALUE);
    }

    int[] getRandInts(int num, int bound){
        int[] list = new int[num];
        random.setSeed(new Date().getTime());
        for(int i = 0; i < num; i++)
            list[i] = random.nextInt(bound);
        return list;
    }

}
