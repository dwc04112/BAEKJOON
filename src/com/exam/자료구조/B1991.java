package com.exam.자료구조;

import java.io.*;
import java.util.*;

public class B1991 {
    static char[][] tree;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new char[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tree[i][0] = st.nextToken().charAt(0);
            tree[i][1] = st.nextToken().charAt(0);
            tree[i][2] = st.nextToken().charAt(0);
        }

        preorder(tree[0][0]);
        sb.append('\n');
        inorder(tree[0][0]);
        sb.append('\n');
        postorder(tree[0][0]);
        System.out.println(sb);
    }


    public static void preorder(char root) {


        for(int i = 0; i < N; i++) {

            if(tree[i][0] == root) {

                sb.append(root);

                if(tree[i][1] != '.') preorder(tree[i][1]);

                if(tree[i][2] != '.') preorder(tree[i][2]);
                break;
            }
        }
    }


    public static void inorder(char root) {

        for(int i = 0; i < N; i++) {

            if(tree[i][0] == root) {

                if(tree[i][1] != '.') inorder(tree[i][1]);

                sb.append(root);

                if(tree[i][2] != '.') inorder(tree[i][2]);

                break;
            }
        }
    }


    public static void postorder(char root) {

        for(int i = 0; i < N; i++) {

            if(tree[i][0] == root) {

                if(tree[i][1] != '.') postorder(tree[i][1]);

                if(tree[i][2] != '.') postorder(tree[i][2]);

                sb.append(root);
                break;
            }
        }
    }
}