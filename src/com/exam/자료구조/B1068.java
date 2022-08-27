package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 트리
// https://www.acmicpc.net/problem/1068
public class B1068 {
    static int N;
    static int Leaf,Root = 0;
    static int[] Node;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        Node = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            Node[i] =  Integer.parseInt(st.nextToken());
            if( Node[i] == -1 ){
                //시작점(-1)은 여러개일수도 있다
                q.add(i);
                visited[i] = true;
            }
        }
        int D = Integer.parseInt(br.readLine());

        deleteNode(D);
        searchLeaf();
        System.out.println(Leaf);
    }

    private static void deleteNode(int d) {
        Node[d] = -2;
        for(int i=0; i<N; i++){
            //해당 부모노드를 가리키는 자식노드들을 전부 -2로 바꿔준다
            if(Node[i]==d) deleteNode(i);
        }
    }

    private static void searchLeaf() {
        while(!q.isEmpty()){
            int temp = q.remove();
            boolean isLeaf = true;
            if(Node[temp] == -2) continue;
            for(int i=0; i<N; i++){
                if( !visited[i] && Node[i]==temp ){
                    visited[i] = true;
                    q.add(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) Leaf++;
        }
    }
}
