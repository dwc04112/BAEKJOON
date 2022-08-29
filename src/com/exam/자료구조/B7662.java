package com.exam.자료구조;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine()," ");
                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(Objects.equals(s, "I")){
                    minQ.add(n);
                    maxQ.add(n);
                    // Map을 사용하여 저장하는 값을 key 값으로 두고
                    // 해당 값이 없으면 default 값인 0에 1을더하여 1을 저장한다
                    // 만약 있으면 해당 갯수에 +1
                    map.put(n, map.getOrDefault(n,0) +1 );
                }else{
                    if(map.size()==0) continue;
                    if(n==-1){
                        delete(minQ,map);
                    }else{
                        delete(maxQ,map);
                    }
                }
            }


            if(map.size()==0){
                sb.append("EMPTY").append('\n');
            }else{
                // 최대값 최소값 출력
                // 최소 최대값이 같으면 (최대값 poll후 size가 0이면) 최대값을 두번 출력한다
                int res = delete(maxQ, map);
                sb.append(res).append(" ");
                if(map.size()>0) res = delete(minQ, map);
                sb.append(res).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int delete(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int num;
        while(true){
            num = queue.poll();
            // maxQ나 minQ에서 꺼낸 값이 map에 있는지 확인하고
            // 없으면 계속 반복한다
            int cnt = map.getOrDefault(num,0);
            if(cnt == 0) continue;
            // 해당 값이 1이면 제거 (해당값이 하나만 있으면)
            if(cnt == 1)
                map.remove(num);
            else
                //해당 값이 여러개면 한개 줄여서 저장
                map.put(num, cnt-1);
            break;
        }
        return num;
    }
}
