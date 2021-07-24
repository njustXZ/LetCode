package com.njustxz.Base;

public class TestEnum {
    public static void main(String[] args) {
        SeasonEnum s1 = SeasonEnum.SPRING;
        SeasonEnum s2 = Enum.valueOf(SeasonEnum.class,"SUMMER");
        for(SeasonEnum s:SeasonEnum.values()){
            System.out.println(s1.compareTo(s));
            System.out.println(s);
        }

        System.out.println(s1.toString());
        new TestEnum().judge(s1);
    }

    private void judge(SeasonEnum seasonEnum) {
        switch (seasonEnum){
            case FALL:
                System.out.println("秋高气爽");
                break;
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case WINTER:
                System.out.println("冰天雪地");
                break;
        }
    }
}

enum  SeasonEnum{
    SPRING,SUMMER,FALL,WINTER
}

interface GenderDesc{
    void info();
}

enum Gender implements GenderDesc{
    MALE("男"){
        @Override
        public void info() {
            System.out.println("这个枚举类代表男性！");
        }
    },FEMALE("女"){
        @Override
        public void info() {
            System.out.println("这个枚举类代表女性！！");
        }
    };

    private final String name;
    Gender(String name) {
        this.name = name;
    }
}
