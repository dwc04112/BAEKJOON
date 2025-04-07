package com.exam.초등학교를졸업하자;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B2650 {

    static int N;
    static List<int[]> board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new LinkedList<>();

        for (int i = 0; i < N/2; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            addLine(x1, y1, x2, y2);
        }
    }

    public static void addLine(int x1, int y1, int x2, int y2) {


        if(!board.isEmpty()) {

            for (int[] ints: board) {
                int dx1 = ints[0];
                int dy1 = ints[1];
                int dx2 = ints[2];
                int dy2 = ints[3];

                // 같은 변에 점이 하나라도 있는 경우
                if (x2==dx2 || x1==dx2 || x2==dx1 || x1==dx1) {

                }
            }

        }

        board.add(new int[] {x1, y1, x2, y2});
    }
}
