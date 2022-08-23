package com.exam.자료구조;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B5430 {
    static ArrayList<Integer> intArr = new ArrayList<>();
    static ArrayList<String> resArr = new ArrayList<>();
    static boolean reverse;
    static char[] charArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            reverse = false;
            charArr = sc.next().toCharArray();
            int n = sc.nextInt();
            // 문자열 입력받고 숫자만 int변환후 int배열에 저장
            String[] str = sc.next().replaceAll("\\[","").replaceAll("]","").split(",");
            if(n>0){
                for (String s : str) {
                    intArr.add(Integer.parseInt(s));
                }
            }
            calc();
            intArr.clear();
        }

        for(String s : resArr){
            System.out.println(s);
        }
    }

    private static void calc() {
        boolean error = false;
        for(char c : charArr){
            if(c=='R'){
                // 실제로 뒤집으면 시간초과 따라서 reverse를 지정해두고
                // 마지막 reverse가 true면 뒤집어서 출력하고
                // 아니면 그냥 출력
                reverse = !reverse;
            } else if(c=='D'){
                if(intArr.size()<=0){
                    error = true;
                    break;
                }else{
                    //만약 reverse 상태면 제일 뒷쪽의 숫자를 제거해줘야한다
                    if(reverse) intArr.remove(intArr.size()-1);
                    if(!reverse) intArr.remove(0);
                }
            }
        }

        if(error){
            resArr.add("error");
        }else{
            if (reverse) {
                Collections.reverse(intArr);
            }
            resArr.add(intArr.toString().replace(" ",""));
        }
    }
}
