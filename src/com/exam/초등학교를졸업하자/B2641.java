package com.exam.초등학교를졸업하자;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class B2641 {
    static boolean[][] board;
    static int N;
    static int cnt;
    static Queue<Integer> q;
    static List<Queue<Integer>> qList;

    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        q = new LinkedList<>();
        qList = new ArrayList<>();

        board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
            // board 만들기
        }
        qList.add(q);

        cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < N; j++) {
                q.add(sc.nextInt());
            }
            qList.add(q);
        }
    }

    public static boolean[][] createBoard(Queue<Integer> q) {

        while (!q.isEmpty()) {
            q.peek();
            int x = N;
            int y = N;

            switch (q.peek()) {
                //case 1 : board[]
            }
        }


        return board;
    }
}
