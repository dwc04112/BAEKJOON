package com.exam.자료구조;

import java.util.*;

public class B3190 {
    static int N,A,T;   //NxN, Apple , Turn
    static int count =0;
    static int dir =1;
    static int[][] Board;
    static Map<Integer,String> turn = new HashMap<>();

    static int[][] D = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌 시계방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        Board = new int[N][N];
        int[][] apple = new int[A][2];
        for(int i=0; i<A; i++){
            apple[i][0] = sc.nextInt();
            apple[i][1] = sc.nextInt();
        }
        T = sc.nextInt();
        for(int i=0; i<T; i++){
            turn.put(sc.nextInt(), sc.next());
        }
        for (int[] ints : apple) {
            Board[ints[0]-1][ints[1]-1] = 1;
        }
        move();
        System.out.println(count);
    }

    private static void move() {
        Node node = new Node(0,0);
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0,0});

        Loop1:
        while(true){
            if(turn.get(count)!=null){
                if(Objects.equals(turn.get(count), "D")){
                    if(dir==3){
                        dir =0;
                    }else{
                        dir +=1;
                    }
                }else{
                    if(dir==0){
                        dir =3;
                    }else{
                        dir -=1;
                    }
                }
            }
            count += 1;
            int nr = node.row+D[dir][0];
            int nc = node.col+D[dir][1];
            if(nr<0||nr>=N||nc<0||nc>=N) break;

            for (int[] ints : snake) {
                if(nr==ints[0] && nc==ints[1]) break Loop1;
            }

            if(Board[nr][nc]==1){
                snake.add(new int[]{nr,nc});
                Board[nr][nc]=0;
            }else{
                snake.add(new int[]{nr,nc});
                snake.remove();
            }
            node.row = nr;
            node.col = nc;

            /*
            System.out.println("======= c: "+count+"=======");
            for (int[] ints : snake) {
                System.out.println(Arrays.toString(ints));
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(Board[i][j]+" ");
                }
                System.out.println("");
            }

             */

        }
    }

    private static class Node {
        int row,col;
        Node(int r, int c){
            row = r;
            col = c;
        }
    }
}
