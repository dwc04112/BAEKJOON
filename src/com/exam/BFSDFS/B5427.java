package com.exam.BFSDFS;


import java.util.ArrayDeque;
import java.util.Scanner;

public class B5427 {

    static final int[][] D = {{0,-1},{0,1},{-1,0},{1,0}}; // 상 하 좌 우
    static int X, Y;
    static ArrayDeque<Fire> fires;
    static char[][] board;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            board = new char[Y][X];
            fires = new ArrayDeque<>();

            Node node = null;
            for (int j = 0; j < Y; j++) {
                char[] charArray = sc.next().toCharArray();

                for (int k = 0; k < charArray.length; k++) {
                    char x = charArray[k];
                    if(x == '@') {
                        node = new Node(k, j);
                        board[j][k] = '.';
                    }
                    else {
                        if(x == '*') fires.add(new Fire(k, j));
                        board[j][k] = x;
                    }
                }
            }

            int result = move(node);
            if (result > 0) {
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static int move(Node node){
        boolean[][] visited = new boolean[Y][X];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node.y][node.x] = true;

        int time = 0;

        while(!queue.isEmpty()) {

            // 불 이동
            int fireCount = fires.size();
            for (int x = 0; x < fireCount; x++) {
                Fire fire = fires.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fire.x + D[i][0];
                    int ny = fire.y + D[i][1];

                    if(nx < 0 || nx >= X || ny < 0 || ny >= Y) continue;
                    if(board[ny][nx]=='#' || board[ny][nx]=='*') continue;

                    board[ny][nx] = '*';
                    fires.add(new Fire(nx, ny));
                }
            }

            // node 이동
            int nodeCount = queue.size();
            for (int x = 0; x < nodeCount; x++) {
                Node nd = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = nd.x + D[i][0];
                    int ny = nd.y + D[i][1];

                    // 탈출 case
                    if(nx < 0 || nx >= X || ny < 0 || ny >= Y) {
                        return time + 1;
                    }

                    if(visited[ny][nx]) continue;
                    if(board[ny][nx]=='#' || board[ny][nx]=='*') continue;
                    visited[ny][nx] = true;

                    queue.add(new Node(nx, ny));
                }
            }

            time++;
        }

        return 0;
    }

    public static class Fire {
        int x, y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
