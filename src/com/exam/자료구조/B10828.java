package com.exam.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//스택
//https://www.acmicpc.net/problem/10828

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            String str = st.nextToken();

            if(Objects.equals(str, "push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }else if(Objects.equals(str, "pop")){
                if(stack.size()<1)  sb.append(-1).append('\n');
                else {
                    sb.append(stack.pop()).append('\n');
                }
            }else if(Objects.equals(str, "size")){
                sb.append(stack.size()).append('\n');
            }else if(Objects.equals(str, "empty")){
                if(stack.empty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }else if(Objects.equals(str, "top")){
                if(stack.size()<1) sb.append(-1).append('\n');
                else sb.append(stack.peek()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
