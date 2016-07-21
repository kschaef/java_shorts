package shorts;

import javax.swing.*;

public class fibonacci {

    public static void main(String[] args) {
        String stopString;
        Integer stop;
        Integer inc = 3;
        Integer[] lastThree = {0, 1, 1};

        stopString = JOptionPane.showInputDialog("How many terms from the Fibonacci sequence would you like to print?");
        stop = new Integer(stopString);

        System.out.printf("%d ", lastThree[0]);
        if (stop > 1) {
            System.out.printf("%d ", lastThree[1]);
        }
        if (stop > 2) {
            System.out.printf("%d ", lastThree[2]);
        }
        if (stop > 3) {
            while (inc < stop) {
                lastThree[0] = lastThree[1];
                lastThree[1] = lastThree[2];
                lastThree[2] = lastThree[0] + lastThree[1];
                System.out.printf("%d ", lastThree[2]);
                inc++;
            }
        }
    }
}
