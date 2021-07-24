package com.njustxz.Games;

public class MiGong {
    public static void main(String[] args) {
        //表示迷宫的二维数组
        int[][] map = new int[8][7];
        //1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        map[1][2]=1;
        map[2][2]=1;
        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,5,6,2);
        System.out.println("迷宫走法地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //使用递归回溯来给小球找路
    //map表示地图，i，j表示从哪里出发，从1，1，触发到6，5
    //0表示走过，1表示墙，2表示通路可走，3表示该点已经走过，但是不通
    //走路时先定义个策略。按上右下左的方式找路，假如该点不通，再回溯
    public static boolean setWay(int[][] map,int i,int j,int l1,int l2){
        if(map[l1][l2]==2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j] = 2;
                if(setWay(map,i+1,j,l1,l2)){
                    return true;
                }else if(setWay(map,i,j-1,l1,l2)){
                    return true;
                }else if(setWay(map,i-1,j,l1,l2)){
                    return true;
                }else if(setWay(map,i,j+1,l1,l2)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
