/**
 * 冒泡排序
 *
 * @author zmh
 * @create 2017-09-26 9:07
 **/
public class BubbleSort {

    static void sortAsc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
            }
        }
    }

    static void sortDesc(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void haha(int[] array) {
        int count = 0;
        boolean swaped;
        int n = array.length;
        do {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swaped = true;
                    count++;
                }
            }
            n--;
        } while (swaped);
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1, 55, 11, 566, 32, 121, 656, 1232, 121, 1, 2, 5, 7, 22, 112,};
        haha(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
