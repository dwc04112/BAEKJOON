package com.exam.자료구조;

import java.util.*;

public class B1717ER {
    static int N,M,p,a,b;
    static ArrayList<ArrayList<Integer>> Board;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Board = new ArrayList<>();

        for(int i=1; i<=N; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            Board.add(list);
        }
        for(int i=0; i<M; i++){

            p = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            calc(p,a,b);
            /*
            System.out.println("====");
            for(ArrayList<Integer> j : Board){
                System.out.println(j);
            }
            System.out.println("====");
             */
        }
    }

    private static void calc(int p, int a, int b) {
        boolean isMatch = false;
        if(p == 0){
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            int indexA = 0;
            int indexB = 0;
            for(int i = 0; i<Board.size(); i++){
                for(int j : Board.get(i)){
                    if(j==a){
                        A =Board.get(i);
                        indexA = i;
                    }
                    if(j==b){
                        B =Board.get(i);
                        indexB = i;
                    }
                }
            }
            Board.remove(A);
            if (indexA != indexB) {
                Board.remove(B);
                A.addAll(B);
            }
            Board.add(A);
        }
        else if(p==1){
            for(ArrayList<Integer> board : Board){
                for(int i : board){
                    if(i==a){
                        for(int j : board){
                            if (j == b) {
                                isMatch = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(isMatch) System.out.println("YES");
            if(!isMatch) System.out.println("NO");
        }
    }
}
