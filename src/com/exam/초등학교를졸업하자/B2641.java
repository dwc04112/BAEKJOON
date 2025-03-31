package com.exam.초등학교를졸업하자;



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class B2641 {
    static int N;
    static int initXY;
    static int[][] D = {{0,1},{-1,0},{0,-1},{1,0}};//1:우 2:상 3:좌 4:하

    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        initXY = (N/2)-1;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }
        String compare = reverse(getBoard(q));

        // 표본 수
        int cnt = sc.nextInt();
        int suc = 0;
        int num;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            String str = "";
            for (int j = 0; j < N; j++) {
                num = sc.nextInt();
                q.add(num);
                str = str.concat(String.valueOf(num)).concat(" ");
            }
            if(compare.equals(reverse(getBoard(q)))){
                suc++;
                result.add(str);
            }
        }

        // 출력부분 다른방법 확인해봐야할듯
        System.out.println(suc);
        for (int i = 0; i < suc; i++) {
            if(i == suc-1) {
                System.out.println(result.get(i).trim());
            } else {
                System.out.println(result.get(i));
            }
        }
    }

    public static boolean[][] getBoard(Queue<Integer> q) {
        boolean[][] board = new boolean[N][N];
        // 시작점
        int x = initXY;
        int y = initXY;

        while (!q.isEmpty()) {
            int move = q.remove();
            // 1:우 2:상 3:좌 4:하
            switch (move) {
                case 1 : {
                    x++;
                    break;
                }
                case 2 : {
                    y--;
                    break;
                }
                case 3 : {
                    x--;
                    break;
                }
                case 4 : {
                    y++;
                    break;
                }
            }
            if(board[y][x]) continue;
            board[y][x] = true;
        }
        return board;
    }

    public static String reverse(boolean[][] board) {
        Node init = findFirstNode(board);
        Queue<Node> q = new LinkedList<>();
        String str = "";
        q.add(init);

        while(!q.isEmpty()) {
            Node node = q.remove();

            for(int i=0; i<4; i++){
                int x = node.x + D[i][0];
                int y = node.y + D[i][1];

                if(!board[x][y]) continue;

                q.add(new Node(x,y));
                str = str.concat(i+1+"");
                board[x][y] = false;
            }
        }
        return str;
    }

    public static Node findFirstNode(boolean[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!board[i][j]) continue;
                return new Node(i,j);
            }
        }
        return null;
    }

    public static class Node {
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
