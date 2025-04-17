package com.exam.기타등등;

import java.util.Objects;
import java.util.Scanner;

public class B2816 {
    private static int[] ARR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ARR = new int[n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            str = str.trim();
            if(Objects.equals(str, "KBS1")) {
                ARR[i] = 0;
            } else if(Objects.equals(str, "KBS2")) {
                ARR[i] = 1;
            } else {
                ARR[i] = n;
            }
        }

        compare(0);
        compare(1);
        System.out.println();
    }

    private static void compare(int target) {
        int idx = 0;

        while(true) {
            if(ARR[target] == target) return;
            if(ARR[idx] == target) {
                System.out.print('4');
                swap(idx, --idx);
            }else {
                System.out.print('1');
                idx++;
            }
        }
    }

    private static void swap(int i, int j) {
        int temp;
        temp = ARR[i];
        ARR[i] = ARR[j];
        ARR[j] = temp;
    }
}
