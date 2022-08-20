package com.exam.초등학교를졸업하자;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class B2658 {
    // x,y좌표를 받아줄 클래스 생성
    static class position{
        int x;
        int y;
        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[][] map;

    public static void main(String[] args) throws IOException {
        map = new int[10][10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        position pos;
        position row_pos = new position(0,0);
        position col_pos = new position(0,0);

        int row_max = 0;
        int col_max = 0;

        //입력을 받아 맵을 구현한다.
        for(int i=0; i<10; ++i) {
            String s = br.readLine();
            for(int j=0; j<10; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 가로세로길이의 차이
        for(int i=0; i<10; ++i) {
            for(int j=0; j<10; ++j) {
                if(map[i][j]==1) {
                    pos = new position(i,j);
                    int row_len = 1;
                    int col_len = 1;
                    for(int j2 = j+1; j2<10; ++j2) {
                        if(map[i][j2] == 1) {
                            row_len++;
                        }
                        if(row_len > row_max) {
                            row_max= row_len;
                            row_pos = pos;
                        }
                    }

                    for(int i2 = i+1; i2<10; ++i2) {
                        if(map[i2][j] == 1) {
                            col_len++;
                        }
                        if(col_len > col_max) {
                            col_max = col_len;
                            col_pos = pos;
                        }
                    }
                }
            }
        }


        position non = new position(-1,-1);
        if(row_max == 0 || col_max == 0) {
            System.out.print(0);
        }else {
            // 각 정점의 위치와 그 정점을 기준으로 한 최대 길이를 넘겨준다.
            position[] answers= check(row_pos,col_pos,row_max,col_max);
            for(position pos1 : answers) {
                if(pos1.x == -1 ) {
                    System.out.print(0);
                    break;
                }
                System.out.printf("%d %d\n" ,pos1.x + 1, pos1.y + 1);
            }
        }

    }

    static public position[] check(position row_pos, position col_pos, int row_max, int col_max) {
        position non = new position(-1,-1);
        position first;
        position second;
        position third;
//		  position[] answer= new position[3];
        //만약 가로세로 길이가 같다면
        if(row_max == col_max) {


            if(row_pos.x == col_pos.x && row_pos.y == col_pos.y) {
                for(int i=0; i<col_max; ++i) {
                    for(int j =0; j<row_max -i; ++j) {
                        if (map[row_pos.x + i][row_pos.y + j] != 1) {
                            position[] answer = {non};
                            return answer;
                        }
                    }
                }
                first = new position(row_pos.x,row_pos.y);
                second = new position(row_pos.x,row_pos.y + row_max-1);
                third = new position(row_pos.x + col_max -1, row_pos.y);
                position[] answer = {first,second,third};
                return answer;
            }


            if((row_pos.y + row_max -1) == col_pos.y && row_pos.x == col_pos.x) {
                for(int i =0; i< col_max; ++i) {
                    for(int j=i; j<row_max; ++j) {
                        if(map[row_pos.x +i][row_pos.y +j] != 1) {
                            position[] answer = {non};
                            return answer;
                        }
                    }
                }
                first = new position(row_pos.x,row_pos.y);
                second = new position(row_pos.x,row_pos.y + row_max-1);
                third = new position(row_pos.x + col_max -1, row_pos.y + row_max -1);
                position[] answer = {first,second,third};
                return answer;
            }


            if(row_pos.y == col_pos.y && row_pos.x == (col_pos.x + col_max -1)) {
                for(int i =0; i< col_max; ++i) {
                    for(int j=0; j<i+1; ++j) {
                        if(map[col_pos.x + i][col_pos.y +j] != 1) {
                            position[] answer = {non};
                            return answer;
                        }
                    }
                }
                first = new position(col_pos.x,col_pos.y);
                second = new position(col_pos.x + col_max -1 , col_pos.y);
                third = new position(col_pos.x + col_max -1, col_pos.y + row_max -1);
                position[] answer = {first,second,third};
                return answer;

            }


            if((row_pos.y + row_max -1) == col_pos.y && row_pos.x == (col_pos.x + col_max -1)) {
                for(int i =0; i<col_max; ++i) {
                    for(int j = row_max -i -1; j<row_max; ++j) {
                        if(map[col_pos.x + i][row_pos.y + j] != 1) {
                            position[] answer = {non};
                            return answer;
                        }
                    }
                }
                first = new position(col_pos.x,col_pos.y);
                second = new position(row_pos.x , row_pos.y);
                third = new position(col_pos.x + col_max -1, col_pos.y);
                position[] answer = {first,second,third};
                return answer;
            }

            //가로 세로 길이가 다를때
        }else{

            if(row_max %2 ==1 && row_max /2 +1 == col_max) {


                if((row_pos.y + row_max /2) == col_pos.y && row_pos.x == col_pos.x) {
                    for(int i=0 ; i<col_max; ++i) {
                        for(int j = -col_max +i +1; j< col_max -i; ++j) {
                            if(map[col_pos.x +i][col_pos.y + j] != 1) {
                                position[] answer = {non};
                                return answer;
                            }
                        }
                    }
                    first = new position(row_pos.x,row_pos.y);
                    second = new position(row_pos.x , row_pos.y + row_max -1);
                    third = new position(col_pos.x + col_max -1, col_pos.y);
                    position[] answer = {first,second,third};
                    return answer;

                }

                if((row_pos.y + row_max /2) ==col_pos.y && row_pos.x ==(col_pos.x + col_max -1)) {
                    for(int i =0 ; i< col_max; ++i) {
                        for(int j= -i; j<i+1; ++j) {
                            if(map[col_pos.x + i][col_pos.y + j] != 1) {
                                position[] answer = {non};
                                return answer;
                            }
                        }
                    }
                    first = new position(col_pos.x,col_pos.y);
                    second = new position(row_pos.x , row_pos.y);
                    third = new position(row_pos.x , row_pos.y + row_max -1);
                    position[] answer = {first,second,third};
                    return answer;
                }

            }

            if(col_max %2 ==1 && row_max == col_max/2 +1) {

                if((col_pos.x +col_max /2) == row_pos.x && col_pos.y == row_pos.y) {
                    for(int j =0; j<row_max; ++j) {
                        for(int i =-row_max +j +1; i<row_max -j; ++i) {
                            if(map[row_pos.x +i][row_pos.y +j] != 1) {
                                position[] answer = {non};
                                return answer;
                            }
                        }
                    }
                    first = new position(col_pos.x,col_pos.y);
                    second = new position(row_pos.x , row_pos.y+row_max -1);
                    third = new position(col_pos.x + col_max -1 , col_pos.y);
                    position[] answer = {first,second,third};
                    return answer;

                }


                if((col_pos.x + col_max/2) == row_pos.x && col_pos.y == (row_pos.y + row_max -1)) {
                    for(int j =0; j<row_max; ++j) {
                        for(int i =-j ; i<j+1; ++i) {
                            if(map[row_pos.x + i][row_pos.y +j] != 1) {
                                position[] answer = {non};
                                return answer;
                            }
                        }
                    }
                    first = new position(col_pos.x,col_pos.y);
                    second = new position(row_pos.x , row_pos.y);
                    third = new position(col_pos.x + col_max -1 , col_pos.y);
                    position[] answer = {first,second,third};
                    return answer;
                }
            }

        }
        position[] answer = {non};
        return answer;
    }
}
