package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 최대힙,최소힙
// https://www.acmicpc.net/problem/11279
// https://www.acmicpc.net/problem/1927

public class B11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        // 1927 최소힙 (우선순위큐)
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 11279 최대힙 (우선순위큐)
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(bf.readLine());
            if(n==0){
                if(!queue.isEmpty())
                    sb.append(queue.remove()).append('\n');
                else
                    sb.append(0).append('\n');
            }else{
                queue.add(n);
            }
        }
        System.out.println(sb);
    }
}
