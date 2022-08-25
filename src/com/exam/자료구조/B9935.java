package com.exam.자료구조;

import java.util.*;

// 문자열 폭발
// https://www.acmicpc.net/problem/9935
public class B9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] chArr = sc.next().toCharArray();
        char[] Bomb =  sc.next().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : chArr) {
            stack.push(c);
            if (stack.size() >= Bomb.length) {
                boolean explosion = true;
                for (int j = 0; j < Bomb.length; j++) {
                    if (stack.get(stack.size() - Bomb.length + j) != Bomb[j]) {
                        explosion = false;
                        break;
                    }
                }
                if (explosion) {
                    for (int j = 0; j < Bomb.length; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        if(sb.toString().length()==0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}
