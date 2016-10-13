import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Alustame pommitamisega");
        System.out.println("Autor Annely");

        int[][] lauaalgseis = new int[9][9];
        int[][] lauaseis = new int[9][9];

        // 0 - meri
        //1 - laev
        // 2 -pihta saanud laev

        /* While tsükli kirjutame ümber For tsükiks

        int count1 = 0;
        int count2 = 0;
        while (count1 < 9) {
            count2 = 0;
            while (count2 < 9) {
                lauaalgseis[count1][count2] = (int) (Math.random() * 1.3);
                count2++;
            }
            count1++;
        }
        count on for tsüklis asendatud i-ga ja j-ga
*/
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                lauaalgseis[i][j] = (int) (Math.random() * 1.3);
            }
        }

        /*int count3 = 0;
        while (count3 < 9){
            System.out.println(Arrays.toString(lauaalgseis[count3]));
            count3++; */

        prindiLaud(lauaseis);


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Kuhu tahad pommitada? Formaat: x-y");
            String input = sc.nextLine();
            String[] xy = input.split("-");
            int x = Integer.parseInt(xy[0]) - 1;
            int y = Integer.parseInt(xy[1]) - 1;
            System.out.println(x);
            System.out.println(y);

            int tabamus = lauaalgseis[y][x];
            //System.out.println(tabamus);
            if (tabamus == 1) {
                lauaalgseis[y][x] = 2;
                lauaseis[y][x] = 2;
                System.out.println("Pihtas!");
            } else if (tabamus == 0) {
                lauaseis[y][x] = 3;
                System.out.println("Mööda!");
            } else if (tabamus == 0) {
                System.out.println("Siia sa juba lasid.");
            } else {
                System.out.println("ERROR");
                break;
            }

            prindiLaud(lauaseis);

            boolean labi =kasonMangLabi(lauaalgseis);
            if (labi==true){
                break;
            }


        }
        System.out.println("Mäng on läbi");


    }

    private static boolean kasonMangLabi(int[][] laud) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (laud[j][i] ==1){
                    return false;
                }
            }
        }
        return true;

    }


    public static void prindiLaud(int[][] laud) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
    }
}


