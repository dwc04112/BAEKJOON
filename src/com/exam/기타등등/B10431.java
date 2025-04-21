package com.exam.기타등등;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

public class B10431 {

    static int N;
    static List<List<Integer>> board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        board = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            Integer.parseInt(st.nextToken());
            board.add(new ArrayList<>());
            for (int j = 0; j < 20; j++) {
                board.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N; i++) {

            if(i==N-1) {
                System.out.println(i+1+" "+calc(i));
            }else {
                System.out.println(i+1+" "+calc(i)+" ");
            }
        }
    }


    static private int calc(int n) {
        int total = 0;
        for (int i = 19; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(board.get(n).get(i) < board.get(n).get(j)) {
                    total += i-j;
                    int addNum = board.get(n).get(i);
                    board.get(n).remove(i);
                    board.get(n).add(j, addNum);
                }
            }
        }
        return total;
    }
}
