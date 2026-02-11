package com.exam.BFSDFS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B5427 {

    static int[][] D = {{0,-1},{0,1},{-1,0},{1,0}}; // 상 하 좌 우
    static int X,Y;
    static Queue<Fire> fires;
    static char[][] board;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            board = new char[Y][X];
            boolean[][] visited = new boolean[Y][X];
            fires = new LinkedList<>();

            Node node = null;
            for (int j = 0; j < Y; j++) {
                char[] charArray = sc.next().toCharArray();

                for (int k = 0; k < charArray.length; k++) {
                    char x = charArray[k];
                    if(x == '@') {
                        node = new Node(k,j,0, visited);
                        board[j][k] = '.';
                    }
                    else {
                        if(x == '*') fires.add(new Fire(k,j));
                        board[j][k] = x;
                    }
                }
            }

            move(node);
        }
    }

    public static void move(Node node){
        List<Integer> successList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            // 불 이동
            int fireCount = fires.size();
            for (int x = 0; x < fireCount; x++) {
                Fire fire = fires.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = fire.getX() + D[i][0];
                    int ny = fire.getY() + D[i][1];

                    if(nx < 0 || nx >= X || ny < 0 || ny >= Y) continue;
                    if(board[ny][nx]=='#' || board[ny][nx]=='*') continue;

                    board[ny][nx] = '*';
                    fires.add(new Fire(nx, ny));
                }
            }

            // node 이동
            int nodeCount = queue.size();
            for (int x = 0; x < nodeCount; x++) {
                Node nd = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = nd.getX() + D[i][0];
                    int ny = nd.getY() + D[i][1];
                    int nm = nd.getM() + 1;
                    boolean[][] visited = nd.getVisited();

                    // 탈출 case
                    if(nx < 0 || nx >= X || ny < 0 || ny >= Y) {
                        successList.add(nm);
                        continue;
                    }

                    if(visited[ny][nx]) continue;
                    if(board[ny][nx]=='#' || board[ny][nx]=='*') continue;
                    visited[ny][nx] = true;

                    queue.add(new Node(nx, ny, nm, visited));
                }
            }
        }

        if (successList.isEmpty()) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println( Collections.min(successList) );
    }

    public static class Fire {
        int x,y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class Node {
        int x,y,m;

        boolean[][] visited;

        public Node(int x, int y, int m, boolean[][] visited) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.visited = visited;
        }

        public boolean[][] getVisited() {
            return visited;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getM() {
            return m;
        }
    }
}
