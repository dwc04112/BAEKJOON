package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class B2331 {
    static int A,P;
    static ArrayList<Integer> sumArr = new ArrayList<>();
    static boolean finish;

    static void dfs(int a){
        sumArr.add(a);
        int sumA = 0;
        String[] str = String.valueOf(a).split("");
        for (String s : str) {
            sumA += Math.pow(Integer.parseInt(s), P);
        }
        if(sumArr.size()>1) {
            for (int i = 0; i < sumArr.size()-1; i++) {
                if (sumArr.get(i) == a && sumArr.get(i + 1) == sumA) {
                    sumArr.subList(i,sumArr.size()).clear();
                    System.out.println(sumArr.size());
                    finish = true;
                }
            }
        }
        if(!finish) dfs(sumA);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        P = sc.nextInt();
        dfs(A);
    }
}
