package com.exam.자료구조;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> cmd = new ArrayList<>();
            ArrayList<Long> numArr = new ArrayList<>();
            while (true) {
                st = new StringTokenizer(bf.readLine(), " ");
                String str = st.nextToken();
                if(Objects.equals(str, "QUIT")) {
                    return;
                }
                if (Objects.equals(str, "END")) break;
                if (Objects.equals(str, "NUM")) {
                    long n = Long.parseLong(st.nextToken());
                    cmd.add(str);
                    numArr.add(n);
                } else {
                    cmd.add(str);
                }
            }

            int N = Integer.parseInt(bf.readLine());
            for (int i = 0; i < N; i++) {
                start(cmd, numArr,  Long.parseLong(bf.readLine()), sb);
            }
            cmd.clear();
            numArr.clear();
            System.out.println(sb);
            String str = bf.readLine();
        }
    }


    private static void start(ArrayList<String> cmd, ArrayList<Long> numArr, long i, StringBuilder sb) {
        ArrayList<Long> intArr = new ArrayList<>();
        intArr.add(i);
        int count = 0;
        for(String s : cmd){
            switch (s){
                case "NUM" : {
                    intArr.add(numArr.get(count));
                    count++;
                    break;
                }
                case "POP" : {
                    if(intArr.size()<1){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    intArr.remove(intArr.size()-1);
                    break;
                }
                case "INV" : {
                    if(intArr.size()<1){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    if(intArr.get(intArr.size()-1)==0){
                        intArr.set(intArr.size()-1, (long) 0);
                    }else {
                        long num = intArr.get(intArr.size() - 1);
                        intArr.set(intArr.size() - 1, num * -1);
                    }
                    break;
                }
                case "DUP" : {
                    if(intArr.size()<1){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    intArr.add(intArr.get(intArr.size()-1));
                    break;
                }
                case "SWP" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    long temp = (intArr.get(intArr.size()-1));
                    intArr.set(intArr.size()-1,intArr.get(intArr.size()-2));
                    intArr.set(intArr.size()-2,temp);
                    break;
                }
                case "ADD" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }

                    long num = intArr.get(intArr.size()-2) + intArr.get(intArr.size()-1);
                    if(Math.abs(num)>1000000000) {
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    intArr.remove(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.add(num);
                    break;
                }
                case "SUB" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    long num = intArr.get(intArr.size()-2) - intArr.get(intArr.size()-1);
                    if(Math.abs(num)>1000000000) {
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    intArr.remove(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.add(num);
                    break;
                }
                case "MUL" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    long num = intArr.get(intArr.size()-2) * intArr.get(intArr.size()-1);
                    if(Math.abs(num)>1000000000) {
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    intArr.remove(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.add(num);
                    break;
                }
                case "DIV" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    if(intArr.get(intArr.size()-1)==0){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    long num = intArr.get(intArr.size()-2) / intArr.get(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.add(num);
                    break;
                }
                case "MOD" : {
                    if(intArr.size()<2){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    if(intArr.get(intArr.size()-1)==0 ){
                        sb.append("ERROR").append('\n');
                        return;
                    }
                    long num =  intArr.get(intArr.size()-2) % intArr.get(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.remove(intArr.size()-1);
                    intArr.add(num);
                    break;
                }
            }
        }



        if(intArr.size()!=1) sb.append("ERROR").append('\n');
        else sb.append(intArr.get(0)).append('\n');
    }
}
