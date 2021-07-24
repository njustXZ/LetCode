package com.njustxz.Base;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestV {
    public static void main(String[] args) {
        Apple<String> a1 = new Apple<>("delicious");
        Apple<Integer> a2= new Apple<>(1);
        Set<Apple> appleSet =  Collections.synchronizedSet(new HashSet<>());
        appleSet.add(a1);
        appleSet.add(a2);
        appleSet.forEach(apple-> System.out.println(apple.getInfo()));
    }
}
class Apple<V>{
    private V info;

    public Apple(V info) {
        this.info = info;
    }

    public Apple() {
    }

    public V getInfo() {
        return info;
    }

    public void setInfo(V info) {
        this.info = info;
    }
}