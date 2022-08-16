package com.exam.BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12100 {
    static int N;
    static int maxInt=0;
    static int[][] firstBoard;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우


    static class Board{
        int[][] Board;
        int move;
        Board(int[][] board, int m){
            Board = board;
            move = m;
        }
        public int[][] getBoard(){
            return Board;
        }
    }

    private static int[][] move21(int[][] board, int r, int c,  int i, boolean[][] isAdd) {
        if(board[r][c] == 0) return board;
        int nr = r+D[i][0];
        int nc = c+D[i][1];

        if(nr<0 || nr>=N || nc<0 || nc>=N){
            return board;
        }

        if(!isAdd[nr][nc] && board[nr][nc] == board[r][c]){
            //합치고 원래있던 자리는 비우기
            isAdd[nr][nc] = true;
            board[nr][nc] *=2;
            board[r][c] = 0;

            if(board[nr][nc]>maxInt){
                maxInt = board[nr][nc];
            }
            return board;
        }

        if(board[nr][nc]>0 ) return board;

        if(board[nr][nc]==0){
            board[nr][nc] = board[r][c];
            board[r][c] = 0;
            return move21(board, nr, nc, i, isAdd);
        }

        return null;
    }

    private static void move() {
        Queue<Board> q = new LinkedList<>();
        q.add(new Board(firstBoard,0));

        while(!q.isEmpty()){
            Board temp = q.remove();
            if(temp.move >= 5) continue;

            //최대 5번 이동
                for (int i = 0; i < 4; i++) {
                    // 0 : 상측이동
                    // 1 : 하측이동
                    // 2 : 좌측이동
                    // 3 : 우측이동
                    boolean[][] isAdd = new boolean[N][N];
                    boolean isMove = false;
                    int[][] newBoard = new int[N][N];

                    for(int v=0; v<N; v++) {
                        for(int w=0; w<N; w++) {
                            newBoard[v][w] =temp.getBoard()[v][w];
                        }
                    }

                    if (i == 0 || i == 2) {
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < N; c++) {
                                if(newBoard[r][c]==0) continue;
                                int[][] num = move21(newBoard,r,c,i, isAdd);
                                if(num == null) {
                                    continue;
                                }
                                newBoard = num;
                                isMove = true;
                            }
                        }
                    //     System.out.println(Arrays.deepToString(newBoard));
                    //        System.out.println("test : " + i + " move : "+(temp.move+1));
                        if(isMove) q.add(new Board(newBoard, temp.move+1));
                    }

                    if (i == 1 || i == 3) {
                        for (int r = (N-1); r >= 0; r--) {
                            for (int c = (N-1); c >= 0; c--) {
                                if(newBoard[r][c]==0) continue;
                                int[][] num  = move21(newBoard,r,c,i,isAdd);
                                if(num == null) {
                                    continue;
                                }
                                newBoard = num;
                                isMove = true;
                            }
                        }
                        //    System.out.println(Arrays.deepToString(newBoard));
                        //    System.out.println("test : " + i + " move : "+(temp.move+1));
                        if(isMove) q.add(new Board(newBoard, temp.move+1));
                    }
                }
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        firstBoard = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                firstBoard[i][j] = sc.nextInt();
                //최대값 지정
                if(firstBoard[i][j]>maxInt) maxInt = firstBoard[i][j];
            }
        }
        move();
        System.out.println(maxInt);
    }
}
