package com.exam.초등학교를졸업하자;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B2660 {

    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();

        boolean[][] board = new boolean[N+1][N+1];

        boolean isFinish = false;
        while (!isFinish) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == -1 && b == -1) {
                isFinish = true;
            } else {
                board[a][b] = true;
                board[b][a] = true;
            }
        }

        // 하나씩 꺼내기
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            boolean[] visit = new boolean[N];

            Queue<Node> q = new LinkedList<>();

            for (int j = 1; j <= N; j++) {
                int l = frdNum(board[i]);
                if(board[i][j]) q.add(new Node(j,1,l));
            }

            int min = 99;
            while(!q.isEmpty()) {
                Node node = q.remove();
                int x = node.x;
                int m = node.m;
                int l = node.l;

                if(l==N-1) min = Math.min(min, m);
                if(visit[x-1]) continue;
                visit[x-1] = true;

                if(allVisit(visit)) min = Math.min(min, m);

                m++;
                for (int j = 1; j <= N; j++) {
                    if(board[x][j]) q.add(new Node(j,m,l));
                }
            }

            result.add(min);
        }


        // 출력
        int minValue = Collections.min(result);
        List<Integer> minList = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == minValue) {
                minList.add(i+1);
            }
        }
        System.out.println(minValue + " " + minList.size()+" ");
        for (int i = 0; i < minList.size(); i++) {
            if(i == minList.size()-1) {
                System.out.println(minList.get(i)+"");
            }else {
                System.out.print(minList.get(i)+" ");
            }
        }

    }


    public static boolean allVisit(boolean[] visit) {
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    public static int frdNum(boolean[] board) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(board[i]) cnt++;
        }
        return cnt;
    }


    public static class Node {
        int x,m,l;
        public Node(int x, int move, int line) {
            this.x = x;
            this.m = move;
            this.l = line;
        }
    }
}
