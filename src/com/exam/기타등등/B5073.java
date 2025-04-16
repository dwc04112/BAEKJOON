package com.exam.기타등등;

import java.util.Arrays;
import java.util.Scanner;

public class B5073 {

    static int[] num = new int[3];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            num = new int[] {
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt()
            };
            if(num[0]==0 && num[1]==0 && num[2]==0) break;

            num = Arrays.stream(num).sorted().toArray();

            print();
        }
    }

    private static void print() {
        if(num[2] >= num[0] + num[1]) {
            System.out.println("Invalid");
            return;
        }
        if(num[0] == num[1] && num[0] == num[2]) {
            System.out.println("Equilateral");
        }else if(num[0] == num[1] || num[0] == num[2] || num[1] == num[2]) {
            System.out.println("Isosceles");
        }else {
            System.out.println("Scalene");
        }
    }
}
