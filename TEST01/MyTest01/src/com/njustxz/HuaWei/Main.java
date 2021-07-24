package com.njustxz.HuaWei;

import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        while (sca.hasNext()) {
            int num = sca.nextInt();
            if (num == 0) break;
            System.out.println(count(num));
        }
    }

    public static int count(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        return n / 3 + count(n / 3 + n % 3);
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        while (sca.hasNext()) {
            int n = sca.nextInt();
            List<Integer> nums = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int tmp = sca.nextInt();
                insert(tmp, nums);
            }
            for (int num : nums) {
                System.out.println(num);
            }
        }
    }

    public static void insert(int n, List<Integer> nums) {
        int len = nums.size();
        if (len == 0) {
            nums.add(n);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (n == nums.get(i)) return;
            if (n < nums.get(i)) {
                nums.add(i, n);
                return;
            }
        }
        nums.add(n);
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String tmp = in.nextLine();
            char[] c1 = tmp.toCharArray();
            int n = c1.length, ret = 0,basic = 16;
            for (int i = 2; i < n; i++) {
                ret = basic*ret;
                ret +=getNum(c1[i]);
            }
            System.out.println(ret);
        }
    }

    public static int getNum(char c) {
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if (c >= '0' && c <= '9') {
            return c-'0';
        }
        return -1;
    }
}
class Main4{
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String tmp = sca.nextLine();
        int n =Integer.parseInt(tmp);
        Set<String> names = new HashSet<>();
        Map<String,String> wants = new HashMap<>();
        for(int i = 0;i<n;i++){
            tmp = sca.nextLine();
            String[] get = tmp.split(" ");
            names.add(get[0]);
            wants.put(get[0],get[1]);
        }
        int ret = 0;
        int count = 0;
        Set<String> named = new HashSet<>();
        Iterator<String> iterator;
        while (!names.isEmpty()){
            
        }
    }
}