package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//큐
//https://www.acmicpc.net/problem/10845

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        int[] queue = new int[10001];
        int start = 0;
        int last = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine(), " ");


            switch (st.nextToken()){
                case "push":{
                    queue[last] = Integer.parseInt(st.nextToken());
                    last++;
                    break;
                }
                case "pop":{
                    if(last-start==0) sb.append(-1).append('\n');
                    else {
                        sb.append(queue[start]).append('\n');
                        start++;
                    }
                    break;
                }
                case "size":{
                    sb.append(last-start).append('\n');
                    break;
                }
                case "empty":{
                    if(last-start == 0) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "front":{
                    if(last-start == 0) sb.append(-1).append('\n');
                    else sb.append(queue[start]).append('\n');
                    break;
                }
                case "back":{
                    if(last-start == 0) sb.append(-1).append('\n');
                    else sb.append(queue[last-1]).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
