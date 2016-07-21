package shorts;

import javax.swing.*;
import java.util.ArrayList;

public class prime {
    private Integer n;
    private Integer maxPrime;
    private ArrayList<Integer> candidates;
    private ArrayList<Integer> composites;

    public Integer getN() {
        return n;
    }

    public ArrayList<Integer> getComposites() {
        return composites;
    }

    public void newComposites() {
        this.composites = new ArrayList<Integer>(this.n);
    }

    public void setN(Integer n) {
        this.n = n;
        this.newComposites();
    }

    public prime(Integer num) {
        this.n = num;
        this.newComposites();
    }

    public ArrayList<Integer> listPrimes() {
        Integer maxPrime;
        Integer j;
        ArrayList<Integer> candidates;

        candidates = new ArrayList<Integer>(this.n);

        candidates.add(2);
        maxPrime = (int) Math.sqrt(this.n);
        // can skip even numbers
        for (Integer i=3; i<=this.n; i+=2) {
            // remove the multiples of all primes less than or equal to the square root of n
            if (i <= maxPrime){
                j = 2;
                while(i * j < this.n){
                    this.composites.add(i * j);
                    j++;
                }
            }
            if(!this.composites.contains(i)){
                candidates.add(i);
            }
        }
        return candidates;
    }

    public static void main(String[] args) {
        String nString;
        Integer n;

        nString = JOptionPane.showInputDialog("Print primes up to what number?");
        n = new Integer(nString);
        prime primeList;

        primeList = new prime(n);
        System.out.println(primeList.listPrimes());
    }
}
