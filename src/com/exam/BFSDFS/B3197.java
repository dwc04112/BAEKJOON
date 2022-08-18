package com.exam.BFSDFS;

import java.util.*;

public class B3197 {
    static int R,C;
    static ArrayList<Integer> swan = new ArrayList<>();
    static char[][] Board;
    static boolean[][] visited;
    static Queue<Node> swanQ = new LinkedList<>();
    static Queue<Node> meltQ = new LinkedList<>();
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우

    static class Node{
        int row,col;
        Node(int r, int c){
            row = r;
            col = c;
        }
    }

    private static boolean move() {
        Queue<Node> nextQ = new LinkedList<>();

        while(!swanQ.isEmpty()){
            Node temp = swanQ.remove();
            if( (temp.row == swan.get(2)) && (temp.col == swan.get(3))){
                return true;
            }

            for(int i=0; i<4; i++){
                int nr = temp.row+D[i][0];
                int nc = temp.col+D[i][1];

                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc]=true;
                if(Board[nr][nc]!='X'){
                    swanQ.add(new Node(nr,nc));
                }else if (Board[nr][nc] == 'X') {
                    nextQ.add(new Node(nr,nc));
                }
            }
        }
        swanQ = nextQ;
        return false;
    }

    private static void melt() {
        int size = meltQ.size();
        for(int f=0; f<size; f++) {
            Node temp = meltQ.remove();

            for(int i=0; i<4; i++){
                int nr = temp.row+D[i][0];
                int nc = temp.col+D[i][1];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;

                if(Board[nr][nc] == 'X') {
                    Board[nr][nc] = '.';
                    meltQ.add(new Node(nr,nc));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        Board = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String str = sc.next();
            Board[i] = str.toCharArray();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(Board[i][j]=='L'){
                    swan.add(i);
                    swan.add(j);
                    //백조가 있는곳도 물이기 때문에
                    meltQ.add(new Node(i,j));
                }

                if(Board[i][j]=='.'){
                    meltQ.add(new Node(i,j));
                }
            }
        }
        visited[swan.get(0)][swan.get(1)] = true;
        swanQ.add(new Node(swan.get(0),swan.get(1)));

        int day = 0;
        while (!move()) {
            melt();
            //녹는 상황 보려면
            /*
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    System.out.print(Board[i][j]);
                }
                System.out.println("");
            }

            System.out.println(" ");
            System.out.println(" ");

             */
            day++;
        }
        System.out.println(day);
    }
}
