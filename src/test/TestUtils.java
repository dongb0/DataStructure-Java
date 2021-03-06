package test;

import main.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestUtils {

    static Random random = new Random();

    public static int[] getRandInts(int num){
        return getRandInts(num, Integer.MAX_VALUE);
    }
    public static List<Integer> getRandIntegers(int num) {
        return getRandIntegers(num, Integer.MAX_VALUE);
    }

    public static int[] getRandInts(int num, int bound){
        int[] list = new int[num];
        random.setSeed(new Date().getTime());
        for(int i = 0; i < num; i++)
            list[i] = random.nextInt(bound);
        return list;
    }

    public static List<Integer> getRandIntegers(int num, int bound){
        List<Integer> list = new ArrayList<>(num);
        random.setSeed(new Date().getTime());
        for(int i = 0; i < num; i++)
            list.add(random.nextInt(bound));
        return list;
    }

    public static List<Double> getRandDoubles(int num){
        List<Double> list = new ArrayList<>(num);
        random.setSeed(new Date().getTime());
        for(int i = 0; i < num; i++)
            list.add(random.nextDouble());
        return list;
    }

    //TODO: isAscend() accepts generic type
    //how to provide static function?
//    public static boolean isAscend(List<Node<Integer>> l1){
//        for(int i = 1, sz = l1.size(); i < sz; i++)
//            if(l1.get(i - 1).getValue().compareTo(l1.get(i).getValue()) > 0)
//                return false;
//        return true;
//    }

    public static <T extends Comparable<T>> boolean isAscend(List<Node<T>> l1){
        for(int i = 1, sz = l1.size(); i < sz; i++)
            if(l1.get(i - 1).getValue().compareTo(l1.get(i).getValue()) > 0)
                return false;
        return true;
    }

}
