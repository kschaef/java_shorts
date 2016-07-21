package shorts;

import javax.swing.*;
import java.util.ArrayList;

public class pascal {
    public static void printNice(ArrayList<Integer> list){
        for (Integer k : list){
            System.out.printf("%d\t", k);
        }
        System.out.println();
    }

    public static ArrayList<Integer> pascal(ArrayList<Integer> row){
        Integer rowSize = row.size();
        ArrayList<Integer> newRow;

        newRow = new ArrayList<Integer>(rowSize + 1);

        newRow.add(1);
        for (Integer i=1; i < rowSize; i++){
            newRow.add(row.get(i-1) + row.get(i));
        }
        newRow.add(1);
        printNice(newRow);

        return newRow;
    }
    public static void main(String[] args){
        String stopString;
        Integer stop;

        stopString = JOptionPane.showInputDialog("How many rows of Pascal's triangle would you like to print?");
        stop = new Integer(stopString);
        ArrayList<Integer> startingRow = new ArrayList<Integer>();
        startingRow.add(1);
        startingRow.add(1);

        System.out.println(1);
        if (stop > 1) {
            printNice(startingRow);
            if (stop > 2) {
                for (Integer j = 0; j < stop - 2; j++) {
                    startingRow = pascal(startingRow);
                }
            }
        }
    }
}