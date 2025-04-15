package com.exam.초등학교를졸업하자;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2642 {
    static int[][] D = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    static int match = 0;
    static int peek = 0;
    static int[][] board = new int[6][6];
    static boolean[][] isMatch = new boolean[6][6];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(board[i][j] != 0) move(new Node(i,j,null, 0));
            }
        }

        System.out.println(match==3 ? peek : 0);
    }

    public static void move(Node node) {
        int y = node.y;
        int x = node.x;
        if(isMatch[y][x]) return;
        q.add(node);

        boolean[][] visited = new boolean[6][6];
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node nd = q.remove();
            for (int i = 0; i < 4; i++) {
                int ny = nd.y + D[i][0];
                int nx = nd.x + D[i][1];
                int nm = nd.m;

                if(nx<0 || ny<0 || nx>5 || ny>5) continue;
                if(visited[ny][nx]) continue;
                if(board[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                if(nd.d == null) {
                    // 초기 방향과 이동 수 SET
                    q.add(new Node(ny, nx, D[i], nm + 1));
                }else {
                    if(nd.d == D[i]) nm += 1;
                    if(nm == 2 && !isMatch[ny][nx]) {
                        // 이미 마주보는 면이 있으면 건너뛰기
                        isMatch[y][x] = true;
                        isMatch[ny][nx] = true;
                        if(board[ny][nx] == 1) peek = board[y][x];
                        if(board[y][x] == 1) peek = board[ny][nx];
                        match++;
                        q.clear();
                        break;
                    }

                    q.add(new Node(ny, nx, nd.d, nm));
                }
            }
        }
    }


    public static class Node{
        int x,y,m;
        int[] d;
        public Node(int y, int x, int[] d, int m) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.m = m;
        }
    }
}
