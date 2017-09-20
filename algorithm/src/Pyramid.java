/**
 * 金字塔
 *
 * @author zmh
 * @create 2017-09-20 14:34
 **/
public class Pyramid {
    static void print(int level) {
        for (int i = 0; i < level; i++) {
            for (int j = level-i-1; j > 0; j--) {
                System.out.print(" ");
            }
            char middle = 'A';
            for (int j = 0; j <= i; j++) {
                middle = (char) ('A' + j);
                System.out.print(middle);
            }
            for (int j = 1; j <= i; j++) {
                System.out.print((char) (middle - j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(10);
    }
}
