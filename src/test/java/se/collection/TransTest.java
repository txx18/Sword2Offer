package se.collection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-25 10:08
 */
public class TransTest {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0, 1, 2, 3};
/*        ArrayList<Integer> aList = new ArrayList<>();
        boolean b = Collections.addAll(aList, arr);
        System.out.println("b = " + b);*/
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("list = " + list);
        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println("integers = " + Arrays.toString(integers));
    }

}
