/**
 * 表格
 *
 * @author zmh
 * @create 2017-09-20 18:05
 **/
public class Form {
/*
    ###############################
    #  #  #  #  #  #  #  #  #  #  #
    ###############################
    #  #  #  #  #  #  #  #  #  #  #
    ###############################
    #  #  #  #  #  #  #  #  #  #  #
    ###############################
    #  #  #  #  #  #  #  #  #  #  #
    ###############################
    #  #  #  #  #  #  #  #  #  #  #
    ###############################
*/

    static void printForm(char[][] form) {
        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form[i].length; j++) {
                if (form[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(form[i][j]);
                }
            }
            System.out.println();
        }
    }

    static void drawHorizontal(char[][] form, int interval, int start, int end) {
        for (int i = 0; i < form.length; ) {
            for (int j = 0; j < end; j++) {
                form[i][j] = '#';
            }
            i += interval;
        }
    }
    static void drawVertical(char[][] form, int interval, int start, int end) {
        for (int i = start; i < form.length; ) {
            for (int j = 0; j < end;) {
                form[i][j] = '#';
                j += 2;
            }
            i += interval;
        }
    }

    public static void main(String[] args) {
        char[][] form = new char[11][31];
        drawHorizontal(form, 2, 0, 31);
        drawVertical(form, 2, 1, 31);

        printForm(form);
    }
}
