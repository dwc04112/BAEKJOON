package com.exam.기타등등;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class B11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());


        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> all = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "add" : {
                    set.add(Integer.parseInt(cmd[1]));
                    break;
                }
                case "remove" : {
                    set.remove(Integer.parseInt(cmd[1]));
                    break;
                }
                case "check" : {
                    if (set.contains(Integer.parseInt(cmd[1]))) {
                        sb.append(1).append('\n');
                    }else {
                        sb.append(0).append('\n');
                    }
                    break;
                }
                case "toggle" : {
                    int a = Integer.parseInt(cmd[1]);
                    if(!set.remove(a)) set.add(a);
                    break;
                }
                case "all" : {
                    set = new HashSet<>(all);
                    break;
                }
                case "empty" : {
                    set = new HashSet<>();
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
