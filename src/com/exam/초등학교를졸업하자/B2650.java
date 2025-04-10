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
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            if (x1 > x2) {
                addLine(new int[] {x2, y2, x1, y1, 0});
            } else {
                addLine(new int[] {x1, y1, x2, y2, 0});
            }
        }

        System.out.println(cross);
        int max = 0;
        for (int[] l : board) {
            max = Math.max(l[4], max);
        }
        System.out.println(max);
    }

    public static void addLine(int[] x) {
        for (int[] l: board) {
            int cnt = 0;
            if(x[0] == x[2]) {
                if (l[0] == x[0]) {
                    if ((l[3] > l[1] && l[1] > x[1]) || x[3] < l[1] && l[1] < x[1]) cnt++;
                }
                if (l[2] == x[0]) {
                    if ((x[3] > l[3] && l[3] > x[1]) || x[3] < l[3] && l[3] < x[1]) cnt++;
                }
            } else if((x[0]==3 && x[2]==4) || (x[2]==3 && x[0]==4) || (x[0]==1 && x[2]==2) || (x[2]==1 && x[0]==2)) {
                if(x[0]==l[0] && x[1]>l[1]) cnt++;
                if(x[0]==l[2] && x[1]>l[3]) cnt++;
                if(x[2]==l[0] && x[3]>l[1]) cnt++;
                if(x[2]==l[2] && x[3]>l[3]) cnt++;
                if(l[0]!=x[0] && l[0]!=x[2] && l[0]!=l[2]) cnt++;
            } else {
                if(x[0]==1 || x[2]==1) {
                    if(x[0]==l[0] && x[1]>l[1]) cnt++;
                    if(x[0]==l[2] && x[1]>l[3]) cnt++;
                    if(x[2]==l[0] && x[3]>l[1]) cnt++;
                    if(x[2]==l[2] && x[3]>l[3]) cnt++;
                }else {
                    if(x[0]==l[0] && x[1]<l[1]) cnt++;
                    if(x[0]==l[2] && x[1]<l[3]) cnt++;
                    if(x[2]==l[0] && x[3]<l[1]) cnt++;
                    if(x[2]==l[2] && x[3]<l[3]) cnt++;
                }
            }
            if(cnt == 1) {
                cross ++;
                l[4] ++;
                x[4] ++;
            }
        }
        board.add(x);
    }
}
