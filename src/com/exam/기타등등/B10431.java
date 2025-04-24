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
            int num = Integer.parseInt(st.nextToken());
            int tot = 0;
            board.add(new ArrayList<>());

            for (int j = 0; j < 20; j++) {
                board.get(i).add(Integer.parseInt(st.nextToken()));

                int idx = 0;
                while(true) {
                    if(idx == j) break;
                    if(board.get(i).get(idx) > board.get(i).get(j)) {
                        tot += j-idx;
                        int addNum = board.get(i).get(j);
                        board.get(i).remove(j);
                        board.get(i).add(idx, addNum);
                        break;
                    }
                    idx ++;
                }
            }

            System.out.println(num + " " + tot);
        }
    }
}
