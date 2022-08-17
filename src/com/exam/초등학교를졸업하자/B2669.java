package com.exam.초등학교를졸업하자;

import java.util.Scanner;

public class B2669 {
    static int[][] data = new int[4][4];
    static int[][] Board = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            int sCol=sc.nextInt();
            int sRow=sc.nextInt();
            int fCol=sc.nextInt();
            int fRow=sc.nextInt();

            for(int r=sRow; r<fRow; r++){
                for(int c=sCol; c<fCol; c++){
                    Board[r][c] = 1;
                }
            }
        }
        for(int i=10; i>=0; i--){
            for(int j=0; j<10; j++){
                System.out.print(Board[i][j] +" ");
            }
            System.out.println("");
        }

        int res=0;
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(Board[i][j]==1) res+=1;
            }
        }
        System.out.println(res);
    }
}
