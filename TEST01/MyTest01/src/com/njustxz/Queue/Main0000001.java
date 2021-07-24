package com.njustxz.Queue;
import java.util.*;
public class Main0000001{
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int total = Integer.parseInt(sca.nextLine());
            int[][] touz= new int[total][6];
            for(int i = 0;i<total;i++){
                for(int j = 0;j<6;j++){
                    touz[i][j] = sca.nextInt();
                }
            }
            Map<Integer,Integer> numMap = new HashMap<>();
            for(int i = 0;i<total;i++){
                int fir = Math.min(touz[i][0],touz[i][1])*10+ Math.max(touz[i][0],touz[i][1]);
                int sec = Math.min(touz[i][2],touz[i][3])*10+ Math.max(touz[i][2],touz[i][3]);
                int thi = Math.min(touz[i][4],touz[i][5])*10+ Math.max(touz[i][4],touz[i][5]);
                int tmp = Math.min(fir,sec);
                int tmp2 = fir + sec -tmp;
                int tmp3 = tmp;
                tmp = Math.min(tmp,thi);
                tmp3 = tmp3+thi-tmp;
                tmp2 = Math.min(tmp2,tmp3);
                tmp = tmp*100 + tmp2;
                if(numMap.containsKey(tmp)){
                    tmp2 =numMap.get(tmp) +1;
                    numMap.put(tmp,tmp2);
                }else{
                    numMap.put(tmp,1);
                }
            }
            List<Integer> ans = new LinkedList<>();
            ans.addAll(numMap.values());
            Collections.sort(ans);
            Stack<Integer> stack = new Stack<>();
            stack.addAll(ans);
            System.out.println(stack.size());
            while(!stack.empty()){
                System.out.print(stack.pop()+" ");
            }
            System.out.println();
        }
    }
}