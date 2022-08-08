package com.exam.BFSDFS;

import java.util.*;

public class B16234Failed {

    static int[][] intArr;
    static int n, firstNum , secondNum;
    static int result;
    static  Map<String,Map<String, Integer>> numMap;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        firstNum = sc.nextInt();
        secondNum = sc.nextInt();
        intArr = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                intArr[y][x] = sc.nextInt();
            }
        }
        System.out.println(move());
    }

    public static int move(){
        numMap = new HashMap<>();
        do {
            numMap.clear();
            // i=y & j=x
            for(int i=0; i<n; i++){
                for(int j=0; j<n-1; j++){
                    int colMinus = Math.abs(intArr[i][j]-intArr[i][j+1]);
                    int rowMinus = Math.abs(intArr[j][i]-intArr[j+1][i]);

                    if(colMinus>=firstNum && colMinus<=secondNum) {
                        boolean match = false;
                        for (String key : numMap.keySet()) {
                            if (numMap.get(key).get(String.valueOf(i) + j) != null) {
                                if(numMap.get(key).get(String.valueOf(i) + (j + 1)) == null ){
                                    numMap.get(key).put(String.valueOf(i) + (j + 1), intArr[i][j + 1]);
                                }
                                match = true;
                            } else if (numMap.get(key).get(String.valueOf(i) + (j + 1)) != null) {
                                if(numMap.get(key).get(String.valueOf(i) + j) == null ){
                                    numMap.get(key).put(String.valueOf(i) + j, intArr[i][j]);
                                }
                                match = true;
                            }
                        }
                        if (!match) {
                            Map<String, Integer> valueMap = new HashMap<>();
                            numMap.put(String.valueOf(i) + j, valueMap);
                            valueMap.put(String.valueOf(i) + j, intArr[i][j]);
                            valueMap.put(String.valueOf(i) + (j+1), intArr[i][j+1]);
                        }
                    }
                    if(rowMinus>=firstNum && rowMinus<=secondNum) {
                        boolean match = false;
                        for (String key : numMap.keySet()) {
                            if (numMap.get(key).get(String.valueOf(j) + i) != null) {
                                if(numMap.get(key).get(String.valueOf(j + 1) + i) == null ){
                                    numMap.get(key).put(String.valueOf(j + 1) + i, intArr[j + 1][i]);
                                }
                                match = true;
                            } else if (numMap.get(key).get(String.valueOf(j + 1) + i) != null) {
                                if(numMap.get(key).get(String.valueOf(j) + i) == null ){
                                    numMap.get(key).put(String.valueOf(j) + i, intArr[j][i]);
                                }
                                match = true;
                            }
                        }
                        if (!match) {
                            Map<String, Integer> valueMap = new HashMap<>();
                            numMap.put(String.valueOf(j) + i, valueMap);
                            valueMap.put(String.valueOf(j) + i, intArr[j][i]);
                            valueMap.put(String.valueOf(j + 1) + i, intArr[j + 1][i]);
                        }
                    }
                }
            }
            System.out.println(result+1+" 번째 실행");
            System.out.println("===numMap===");
            System.out.println(numMap);
            setAvg();
            System.out.println("===AvgSet===");
            System.out.println(Arrays.deepToString(intArr));
            if(!numMap.isEmpty()){
                result++;
            }
        }
        while(!numMap.isEmpty());
        return result;
    }
    public static void setAvg(){
        for(String key : numMap.keySet()){
            int sum = 0;
            int count = 0;
            int avg;
            for(String subKey : numMap.get(key).keySet() ){
                sum += numMap.get(key).get(subKey);
                count++;
            }
            avg = sum/count;
            for(String subKey : numMap.get(key).keySet() ){
                int a =  Character.getNumericValue(subKey.toCharArray()[0]);
                int b =  Character.getNumericValue(subKey.toCharArray()[1]);
                intArr[a][b] = avg;
            }
        }
    }
}
