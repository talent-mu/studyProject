/**
 * 快速排序
 *
 * @author zmh
 * @create 2017-07-10 9:54
 **/
public class QuickSort {


    private static int[] sort(int[] array, int L, int R) {
        int i = L;
        int j = R;
        int pivot = array[(L + R) / 2];
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (i > L) {
            sort(array, L, j);
        }
        if (j < R) {
            sort(array, i, R);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 7, 6, 8, 1, 2, 4, 5, 5, 9, 4, 1, 4, 6, 2, 0, 3, 2, 1, 8, 2, 1};
        array = sort(array, 0, array.length - 1);
        for (int anArray : array) {
            System.out.println(anArray);
        }
    }
}
