package com.exam.자료구조;

// 스택 수열
// https://www.acmicpc.net/problem/1874

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] intArr = new int[N];

        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(bf.readLine());
        }

        // index 는 수열 배열의 (intArr[index]) 현재 위치를 나타낸다 (삭제해야하는 숫자 위치)
        int index=0;
        // for 문으로 스택에 숫자를 추가하였다
        // 다음 저장할 위치를 i로 기억
        for (int i = 1; i < N+1; i++) {
            stack.push(i);
            sb.append("+").append("\n");

            while(true) {
                // index 가 출력해야하는 수열목록 보다 커지거나
                // stack 의 크기가 0이되면 while 문 빠져나오기
                if(index>N-1) break;
                if(stack.size()==0) break;
                // peek 으로 제일 위 스택 꺼내보기
                int temp = stack.peek();
                if (intArr[index] == temp) {
                    // 만약 꺼낸 숫자가 삭제해야하는 숫자면
                    // 삭제 후 수열 index ++ 해주어 다음순서
                    stack.pop();
                    index++;
                    sb.append("-").append("\n");
                    continue;
                }
                break;
            }
        }
        if(stack.size()==0){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
