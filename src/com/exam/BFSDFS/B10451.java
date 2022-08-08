package com.exam.BFSDFS;

import java.util.Scanner;

public class B10451 {
    static int[] intArr;
    static boolean[] visited;


    static int dfs(int j){
        if(j ==  intArr[j] || visited[j]) return 1;
        visited[j] = true;
        return dfs(intArr[j]);
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N  = sc.nextInt();

        for(int i=0; i<N; i++){
            int M = sc.nextInt();
            intArr = new int[M+1];
            visited = new boolean[M+1];
            int count = 0;

            for(int j=1; j<M+1; j++){
               intArr[j] = sc.nextInt();
            }
            for(int j=1; j<M+1; j++){
                if(!visited[j]) count += dfs(j);
            }
            System.out.println(count);
        }
    }
}
