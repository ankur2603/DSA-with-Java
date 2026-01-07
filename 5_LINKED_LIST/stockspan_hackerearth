Link : https://www.hackerearth.com/problem/algorithm/stock-span-4-a0d4600b-b5c6efe0/

import java.util.*;
class stockspan{

    public static void function(int stocks[], int span[]){

        Stack<Integer> s =new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1 ; i<stocks.length ; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stocks[] = new int[n];
        for (int i = 0; i < n; i++) {
            stocks[i] = sc.nextInt();
        }
        int span[] = new int[n];
        function(stocks, span);

        for (int i = 0; i < n; i++) {
            System.out.print(span[i]+" ");
        }
    }
}
