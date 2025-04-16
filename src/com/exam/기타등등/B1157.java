package com.exam.기타등등;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class B1157 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        // JAVA 11 .toList() -> .collect(Collectors.toList());
        List<Integer> list = map.values().stream()
            .sorted(Comparator.reverseOrder())
            .toList();

        if(list.size()>1 && Objects.equals(list.get(0), list.get(1))) {
            System.out.println("?");
        }else {
            for(Character c : map.keySet()) {
                if(Objects.equals(map.get(c), list.get(0))) {
                    System.out.println(c);
                }
            }
        }
    }

}
