package com.exam.기타등등;

import java.util.Scanner;

public class B23971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();

        int hy = (int) Math.ceil((double) H / (1+y));
        int wx = (int) Math.ceil((double) W / (1+x));

        System.out.println(hy * wx);
    }
}
