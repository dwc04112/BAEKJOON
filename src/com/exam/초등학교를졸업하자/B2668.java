package com.exam.초등학교를졸업하자;

import java.util.*;

public class B2668 {
    static int N;
    static int[] board;
    static boolean[] visited;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean[] bfs(int first, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[first] = true;
        queue.add(first);
        boolean isCycle = false;
        ArrayList<Integer> subArr = new ArrayList<>();

        while(!queue.isEmpty()){
            int temp = queue.remove();
            if(board[temp]==first){
                subArr.add(board[temp]);
                isCycle = true;
                break;
            }
            if(visited[board[temp]]) continue;
            visited[board[temp]] = true;
            subArr.add(board[temp]);
            queue.add(board[temp]);
        }

        if(isCycle) {
            arr.addAll(subArr);
            return visited;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i <N+1; i++){
            board[i] = sc.nextInt();
        }

        for(int i=1; i <N+1; i++){
           boolean[] after = bfs(i, visited.clone());
           if(after!=null){
               visited = after;
           }
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i : arr){
            System.out.println(i);
        }
    }
}
