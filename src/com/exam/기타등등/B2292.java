package com.exam.기타등등;

import java.util.Scanner;


public class B2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 1;
        int i = 1;
        while(true) {
            num += (i-1)*6;
            if(N <= num) break;
            i++;
        }

        System.out.println(i);
    }
}
