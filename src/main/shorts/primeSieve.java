package shorts;

import java.util.ArrayList;

public class primeSieve {
    public static void main(String[] args) {
        // using the Sieve of Eratosthenes:
        // Make a list of all the integers less than or equal to n (greater than one)
        Integer n = 10;
        Integer j = 0;
        Integer maxPrime;
        ArrayList<Integer> candidates;
        ArrayList<Integer> composites;

        candidates = new ArrayList<Integer>(n);
        composites = new ArrayList<Integer>(n);

        candidates.add(2);
        maxPrime = (int) Math.sqrt(n);
        // can skip even numbers
        for (Integer i=3; i<=n; i+=2) {
            // remove the multiples of all primes less than or equal to the square root of n
            if (i <= maxPrime){
                j = 2;
                while(i * j < n){
                    composites.add(i * j);
                    j++;
                }
            }
            if(!composites.contains(i)){
                candidates.add(i);
            }
        }
        System.out.println(candidates);
    }
}
