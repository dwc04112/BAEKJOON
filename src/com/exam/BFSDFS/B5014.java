package com.exam.BFSDFS;

import java.util.*;

public class B5014 {
    static int F,S,G,U,D;
    static ArrayList<Integer> res = new ArrayList<>();
    static boolean[] visited;

    static class Node{
        int n,c;
        Node(int now, int click){
            n=now;
            c=click;
        }
    }
    static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(new Node(S,0));

        while(!queue.isEmpty()){
            Node temp = queue.remove();

            if(temp.n==G){
                res.add(temp.c);
                break;
            }
            if((temp.n-D)>0 && !visited[temp.n-D]){
                int down = temp.n-D;
                visited[down] = true;
                queue.add(new Node(down,temp.c+1));
            }
            if((temp.n+U)<=F && !visited[temp.n+U]){
                int up = temp.n +U;
                visited[up] = true;
                queue.add(new Node(up,temp.c+1));
            }
        }

        if(!visited[G]) {
            System.out.println("use the stairs");
        }
        else{
            Collections.sort(res);
            System.out.println(res.get(0));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();   //시작위치
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        visited = new boolean[F+1];
        bfs();
    }
}
