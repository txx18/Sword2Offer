package zhelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shane Tang
 * @create 2019-09-28 11:03
 */
public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr1 = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        System.out.println("list是");
        myPrintArrayList(list);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }

    public static void myPrintArrayList(List list) {
        StringBuilder sb = new StringBuilder("[");
        if (list == null || list.size() < 1) {
            sb.append("]");
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                sb.append(list.get(i)).append("]");
                break;
            }
            sb.append(list.get(i)).append(", ");
        }
        System.out.println(sb.toString());
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                System.out.print(arr[i]);
                System.out.println();
                return;
            }
            System.out.print(arr[i] + ", ");
        }
    }
}
