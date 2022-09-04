package com.exam.자료구조;

// 덱
// https://www.acmicpc.net/problem/10866

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10866 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(),"_| ");
            String str = st.nextToken();

            // 입력이 들어올때
            if(Objects.equals(str, "push")){
                String sbStr = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(Objects.equals(sbStr, "front")){
                    // 덱의 첫번째에 삽입
                    deque.addFirst(num);
                }else{
                    // 마지막에 삽입
                    deque.addLast(num);
                }
            // 그 외에 문자가 들어올 때
            }else {
                // "_"으로 자른 첫 문자열이 pop일때
                // 뒤에 문자와 합쳐준다
                if (Objects.equals(str, "pop")) {
                    String sbStr = st.nextToken();
                    str += sbStr;
                }

                // switch case 를 통해 입력과 동시에
                switch (str) {
                    // 바로 위 if 문에서 합친 문자열 popfront
                    case "popfront": {
                        if (deque.isEmpty()) {
                            //System.out.println(-1);
                            sb.append(-1).append("\n");
                            continue;
                        }
                        sb.append(deque.removeFirst()).append("\n");
                        break;
                    }
                    case "popback": {
                        if (deque.isEmpty()) {
                            sb.append(-1).append("\n");
                            continue;
                        }
                        sb.append(deque.removeLast()).append("\n");
                        break;
                    }
                    case "size": {
                        sb.append(deque.size()).append("\n");
                        break;
                    }
                    case "empty": {
                        if (deque.isEmpty()) {
                            sb.append(1).append("\n");
                        } else {
                            sb.append(0).append("\n");
                        }
                        break;
                    }
                    case "front": {
                        if (deque.isEmpty()) {
                            sb.append(-1).append("\n");
                            continue;
                        }
                        sb.append(deque.peekFirst()).append("\n");
                        break;
                    }
                    case "back": {
                        if (deque.isEmpty()) {
                            sb.append(-1).append("\n");
                            continue;
                        }
                        sb.append(deque.peekLast()).append("\n");
                        break;
                    }

                }
            }
        }

        System.out.println(sb);
    }
}
