package com.exam.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {
    static int N,K;
    static int res= 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        bfs();
        System.out.println(res);
    }
    static class Node{
        int p,m;
        Node(int position, int move){
            p = position;
            m = move;
        }
    }

    private static void bfs() {
       Queue<Node> queue = new LinkedList<>();
       visited[N] = true;
       queue.add(new Node(N,0));
       while(!queue.isEmpty()){
           Node temp = queue.remove();
           if(temp.p==K) {
               if(res==0) res= temp.m;
               if(res>temp.p) res = temp.m;
               break;
           }
           if((temp.p+1)<100001 && !visited[temp.p+1]){
               visited[temp.p+1] = true;
               queue.add(new Node((temp.p+1), temp.m+1));
           }
           if((temp.p-1)>=0&&!visited[temp.p-1]){
               visited[temp.p-1] = true;
               queue.add(new Node((temp.p-1), temp.m+1));
           }
           if((temp.p*2)<100001 && !visited[temp.p*2]){
               visited[temp.p*2] = true;
               queue.add(new Node((temp.p*2), temp.m+1));
           }
       }
    }
}
















