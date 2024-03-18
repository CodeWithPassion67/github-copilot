package com.github.copilot;

public class PrimeNumber {
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    // Implement a method to find first n prime numbers
    public static int[] findFirstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        int number = 2;
        
        while (count < n) {
            if (isPrime(number)) {
                primes[count] = number;
                count++;
            }
            number++;
        }
        
        return primes;
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int number = 7; // Replace with the number you want to test
        
        // if (isPrime(number)) {
        //     System.out.println(number + " is a prime number.");
        // } else {
        //     System.out.println(number + " is not a prime number.");
        // }

        System.out.println(factorial(number));
    }
}