package com.exam.알고리즘.플로이드워셜;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1389 {

    static int M;
    static int N;
    static int IFN = 500001;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int[][] nd = new int[M+1][M+1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= M; j++){
                if(i==j) {
                    nd[i][j] = 0;
                    continue;
                }
                nd[i][j] = IFN;
            }
        }

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            nd[n][m] = nd[m][n] = 1;
        }

        for (int n = 1; n <= M; n++) {
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= M; j++) {
                    if(nd[i][j] > nd[i][n] + nd[n][j]) {
                        nd[i][j] = nd[i][n] + nd[n][j];
                    }
                }
            }
        }

        // 모든 노드는 연결되어 있으므로 최댓값 고려 X
        List<Integer> score =  new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            score.add(Arrays.stream(nd[i]).sum());
        }

        int min =  Collections.min(score);
        for (int i = 0; i < M; i++) {
            if (score.get(i) == min) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
