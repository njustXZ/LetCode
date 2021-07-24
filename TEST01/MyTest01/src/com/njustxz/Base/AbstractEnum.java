package com.njustxz.Base;

import java.time.Year;

public  enum AbstractEnum {
    PLUS{
        @Override
        public double eval(double x, double y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x-y;
        }
    },
    TIMES{
        @Override
        public double eval(double x, double y) {
            return x*y;
        }
    },
    DEVIDE{
        @Override
        public double eval(double x, double y) {
            return x/ y;
        }
    };
    public abstract double eval(double x,double y);

    public static void main(String[] args) {
        double x = 10.0;
        double y = 5.0;
        System.out.println(AbstractEnum.PLUS.eval(x,y));
        System.out.println(AbstractEnum.TIMES.eval(x,y));
        System.out.println(AbstractEnum.MINUS.eval(x,y));
        System.out.println(AbstractEnum.DEVIDE.eval(x,y));
    }
}
