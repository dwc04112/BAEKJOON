package com.exam.BFSDFS;

import java.util.Scanner;

public class B7682 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String str = sc.next();
            if(str.equals("end")) return;
            if (verification(str.toCharArray())) {
                System.out.println("valid");
            }else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean verification(char[] chars) {

        int oCnt = 0, xCnt = 0, dCnt = 0;
        for (char c : chars) {
            if(c == 'O') oCnt++;
            if(c == 'X') xCnt++;
            if(c == '.') dCnt++;
        }

        if(oCnt > xCnt || xCnt > oCnt + 1) return false;
        if(isBingo(chars, 'O')) return oCnt == xCnt;
        if(isBingo(chars, 'X')) return xCnt == oCnt + 1;

        return dCnt == 0;
    }

    private static boolean isBingo(char[] chars, char c) {
        for (int i = 0; i < 3; i++) {
            if(chars[i*3] == c && chars[i*3+1] == c && chars[i*3+2] == c) return true;
            if(chars[i] == c && chars[i+3] == c && chars[i+6] == c) return true;
        }
        if(chars[0] == c && chars[4] == c && chars[8] == c) return true;
        if(chars[2] == c && chars[4] == c && chars[6] == c) return true;
        return false;
    }
}
