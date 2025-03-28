package com.exam.초등학교를졸업하자;

import java.io.IOException;
import java.util.Scanner;


public class B2659 {
    static int[] peek = new int[4];
    static int count = 1;

    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        int peekNum;
        for (int i = 0; i < 4; i++) {
            peek[i] = sc.nextInt();
        }
        peekNum = calcMin(peek);
        breakLoop(peekNum);
        System.out.println(count);
    }

    public static void breakLoop(int peekNum){
        boolean[] visit = new boolean[10001];
        for (int i = 1; i < 10; i++) {
            peek[0]=i;
            for (int j = 1; j < 10; j++) {
                peek[1]=j;
                for (int k = 1; k < 10; k++) {
                    peek[2]=k;
                    for (int l = 1; l < 10; l++) {
                        peek[3]=l;
                        int temp = calcMin(peek);
                        if(peekNum <= temp) {
                            return;
                        }
                        if(!visit[temp]) {
                            visit[temp] = true;
                            count++;
                        }
                    }
                }
            }
        }
    }
    public static int calcMin(int[] peek) {
        int[] ints = peek.clone();
        int tmp;
        int min = 9999;
        // 시계숫자
        for (int i = 0; i < 4; i++) {
            tmp = ints[i]*1000
                + ints[(i == 3) ? 0 : i+1]*100
                + ints[(i >= 2) ? i-2 : i+2]*10
                + ints[(i >= 1) ? i-1 : i+3];
            min = Math.min(min, tmp);
        }
        return min;
    }
}
