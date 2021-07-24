package com.njustxz.Base;

public class WarpperClass {
    public static void main(String[] args) {
        Object ObjBool = true;
        Integer Objint = 5;
        int it = Objint;
        if(ObjBool instanceof Boolean){
            boolean b = (boolean) ObjBool;
            System.out.println(b);
        }
    }
}
