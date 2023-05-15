//https://leetcode.com/problems/fibonacci-number/
//
import java.util.*;
class Fibonacci {

   // Map for memoization in dynamic programming
   static Map<Integer, Integer> fibonacciCache = new HashMap<Integer, Integer>();
    public int fib(int n) {
        Integer fibN1, fibN2;
        if( n == 0 ) return 0;
        
        if(n == 1) return 1;

        
            fibN1 = fibonacciCache.get(n-1);
            if( fibN1 == null) {
                fibN1 = fib(n-1);
               fibonacciCache.put(n-1, fibN1);
          }
           fibN2 = fibonacciCache.get(n-2);
           if(fibN2 == null) {
               fibN2 = fib(n-2);
              fibonacciCache.put(n-2, fib(n-2));
          }
          return fibN1 + fibN2;

    }
}

