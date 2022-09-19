package com.exam.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13460 {
    static int N,M;
    static char[][] Board;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
    static Queue<Node> queue = new LinkedList<>();
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Board  = new char[N+1][M+1];
        for (int i = 0; i < N; i++) {
            Board[i] = br.readLine().toCharArray();
        }
        int rRow=0,rCol=0,bRow=0,bCol=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(Board[i][j] == 'R') {
                    Board[i][j] = '.';
                    rRow = i;
                    rCol = j;
                }
                if(Board[i][j] == 'B') {
                    Board[i][j] = '.';
                    bRow = i;
                    bCol = j;
                }
            }
        }
        queue.add(new Node(rRow,rCol,bRow,bCol,0));
        play();
    }

    private static void play() {
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp.count==10) continue;

            for (int i = 0; i < 4; i++) {
                // i 순서대로 상 하 좌 우
                // {{-1,0},{1,0},{0,-1},{0,1}};
                Node data;
                if(temp.redR==-1) continue;
                if(temp.blueR==-1) continue;

                if(i==0){
                    // 순서정하기
                    if(temp.redR < temp.blueR) {
                        data = redMove(temp , i);
                        data = blueMove(data , i);
                    }else{
                        data = blueMove(temp , i);
                        data = redMove(data , i);
                    }
                }else if(i==1){
                    if(temp.redR < temp.blueR) {
                        data = blueMove(temp , i);
                        data = redMove(data , i);
                    }else{
                        data = redMove(temp , i);
                        data = blueMove(data , i);
                    }

                }else if(i==2){

                    if(temp.redC < temp.blueC) {
                        data = redMove(temp , i);
                        data = blueMove(data , i);
                    }else{
                        data = blueMove(temp , i);
                        data = redMove(data , i);
                    }

                }else {

                    if(temp.redC < temp.blueC) {
                        data = blueMove(temp , i);
                        data = redMove(data , i);
                    }else{
                        data = redMove(temp , i);
                        data = blueMove(data , i);
                    }

                }
                if(data.redR==-1 && data.blueR!=-1){
                    if(res==-1) res = temp.count+1;
                    else if(res > (temp.count+1)) res = temp.count+1;
                }

                queue.add(new Node(data.redR, data.redC, data.blueR, data.blueC, temp.count + 1));

            }
        }
        System.out.println(res);
    }

    private static Node redMove(Node node , int i) {
        int nr = node.redR + D[i][0];
        int nc = node.redC + D[i][1];
        if(Board[nr][nc] == '#') return node;
        if(Board[nr][nc] == 'O') {
            return new Node(-1,-1,node.blueR,node.blueC, node.count);
        }
        if(nr == node.blueR && nc == node.blueC) return node;
        return redMove(new Node(nr,nc,node.blueR,node.blueC, node.count),i);
    }

    private static Node blueMove(Node node , int i) {
        int nr = node.blueR + D[i][0];
        int nc = node.blueC + D[i][1];
        if(Board[nr][nc] == '#') return node;
        if(Board[nr][nc] == 'O') {
            return new Node(node.redR, node.redC, -1,-1, node.count);
        }
        if(nr == node.redR && nc == node.redC) return node;
        return blueMove(new Node(node.redR, node.redC, nr,nc, node.count),i);
    }

    static class Node{
        int redR,redC;
        int blueR, blueC;
        int count;
        Node(int rr, int rc, int br, int bc, int c){
            redR = rr;
            redC = rc;
            blueR = br;
            blueC = bc;
            count = c;
        }
    }
}
