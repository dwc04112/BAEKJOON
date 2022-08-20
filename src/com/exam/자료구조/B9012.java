package com.exam.자료구조;


import java.util.Scanner;

public class B9012 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] Board = new char[N][51];
        int[][] intArr = new int[N][51];
        for(int i=0; i<N; i++){
            String str = sc.next();
            Board[i] = str.toCharArray();
            for(int j=0; j<Board[i].length; j++){
                if(Board[i][j]=='(') intArr[i][j] =1;
                if(Board[i][j]==')') intArr[i][j] =-1;
            }
        }

        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++){
            int sum=0;
            for(int j=0; j<50; j++){
                sum +=intArr[i][j];
                if(sum<0){
                    check[i] = false;
                    break;
                }
            }
            if(check[i] || sum==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
