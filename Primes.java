import java.lang.System;
import java.lang.Integer;

public class Primes {
    private int[] sieve;
    private int max;

    public Primes(int max) 
    {
        this.sieve = new int[max+1];
        int i = 2;
        while (max + 1 > i)
        {
            this.sieve[i] = 1;
            i+=1;
        }
        this.max = max;
    }

    public void erastosthene() {
        int i = 2;
        int j;

        while (this.max+1 > i*i)
        {
            if (this.sieve[i] == 1)
            {
                j = i+i;
                while (this.max +1 > j)
                {
                    this.sieve[j] = 0;
                    j+=i;
                }
            }
            i+=1;
        }

        i = 2;
        while (this.max + 1 > i)
        {   
            if (this.sieve[i] == 1)
                System.out.print(i + " ");
            i+=1;
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing argument");
            return;
        }
        int i = Integer.parseInt(args[0]);
        Primes primes = new Primes(i);
        primes.erastosthene(); 
    }


}
