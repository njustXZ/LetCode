package com.njustxz.UtilsTest;

import java.util.Scanner;

public class testScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("\n");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}
