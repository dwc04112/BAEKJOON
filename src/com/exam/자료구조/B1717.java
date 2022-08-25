package com.exam.자료구조;
// 집합의 표현 Union - find
import java.util.Scanner;
public class B1717 {
    static int N,M;
    static int[] parent = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // 0~n+1의 수
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            int m,a,b;
            m = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            if(m==1) isSameParent(a,b);
            if(m==0) union(a,b);
        }
    }

    private static void isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static int find(int x){
        if(x==parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b){
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
}
