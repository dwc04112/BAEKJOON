package com.exam.자료구조;
// 회전하는 큐
// https://www.acmicpc.net/problem/1021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1021 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =  new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] index = new int[M];
        st =  new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            d.add(i);
        }

        int count =0;
        int move = 0;
        while(true){
            if(count>=M) {
                break;
            }else if(d.getFirst() == index[count]) {
                d.removeFirst();
                count++;
            }else{
                int idx = d.indexOf(index[count]);
                int size = d.size()/2;
                if(idx>size) {
                    while(true){
                        if(d.getFirst() == index[count]) break;
                        else {
                            int temp = d.getLast();
                            d.removeLast();
                            d.addFirst(temp);
                            move++;
                        }
                    }
                }else{
                    while(true) {
                        if(d.getFirst() == index[count]) break;
                        else {
                            int temp = d.getFirst();
                            d.removeFirst();
                            d.addLast(temp);
                            move++;
                        }
                    }
                }
            }
        }
        System.out.println(move);
    }

}
