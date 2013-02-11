import java.lang.System;

public class Primes {
    private int[] sieve;
    private int max;

    public Primes(int max) {
        this.sieve = new int[max+1];
        for (int i = 2; i < max+1; ++i){
            this.sieve[i] = 1;
        }
        this.max = max;
    }

    public void erastosthene() {
        int i;
        int j;

        for (i = 2; i* i < this.max + 1; ++i)
        {
            if (this.sieve[i] == 1)
            {
                for (j = i + i; j < this.max +1; j += i)
                {
                    this.sieve[j] = 0;
                }
            }
        }
        
        for (i = 2; i< this.max + 1; ++i)
        {   
            if (this.sieve[i] == 1)
                System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Primes primes = new Primes(Integer.parseInt(args[0]));
        primes.erastosthene();
    }
}
