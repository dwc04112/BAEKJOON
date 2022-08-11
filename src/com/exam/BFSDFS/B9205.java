package com.exam.BFSDFS;

import java.util.Arrays;
import java.util.Scanner;

public class B9205 {
    static int t;
    static int[][] Board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        Board = new int[t][104];

        for (int i=0; i<t; i++){
            int n = sc.nextInt();
            Board[i][0] = n+2;
            for(int j=1; j<(n+2)*2+1; j++){
                Board[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<t; i++){
            System.out.println(bfs(i));
        }
    }


    private static String bfs(int i) {

        for(int n=1; n<Board[i][0]; n++){
            int x= Math.abs(Board[i][2*n+1]-Board[i][2*n-1]);
            int y= Math.abs(Board[i][2*n+2]-Board[i][2*n]);
            if((x+y)>1000) {
                return "sad";
            }
        }
        return "happy";

    }
}
