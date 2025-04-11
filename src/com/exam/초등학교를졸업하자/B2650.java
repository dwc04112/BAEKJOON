package com.exam.초등학교를졸업하자;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B2650 {

    static int N;
    static List<int[]> board;
    static int cross = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new LinkedList<>();

        for (int i = 0; i < N/2; i++) {
            int p1 = getPnt(sc.nextInt(), sc.nextInt());
            int p2 = getPnt(sc.nextInt(), sc.nextInt());

            if (p1 > p2) {
                addLine(new int[] {p2, p1, 0});
            } else {
                addLine(new int[] {p1, p2, 0});
            }
        }

        System.out.println(cross);
        int max = 0;
        for (int[] l : board) {
            max = Math.max(l[2], max);
        }
        System.out.println(max);
    }

    public static void addLine(int[] x) {
        for (int[] l : board) {
            if((l[0] > x[0] && l[0] < x[1] && l[1] > x[1]) || (x[0] > l[0] && x[0] < l[1] && x[1] > l[1])) {
                cross++;
                l[2] ++;
                x[2] ++;
            }
        }
        board.add(x);
    }

    // 시계방향으로 수 구하기
    public static int getPnt(int x, int y) {
        if (x == 1) return y;
        else if (x == 2) return 51 * 2 + 51 - y;
        else if (x == 3) return 51 * 3 + 51 - y;
        else return 51 + y;
    }
}
