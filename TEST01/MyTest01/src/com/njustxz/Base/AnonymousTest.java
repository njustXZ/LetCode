package com.njustxz.Base;

interface Product{
    double getPrice();
    String getName();
}

public class AnonymousTest {
    public void showProduct(Product p){
        System.out.println("商品名称是"+p.getName()+"，其价格是："+p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest a = new AnonymousTest();
        a.showProduct(new Product() {
            @Override
            public double getPrice() {
                return 800.0;
            }

            @Override
            public String getName() {
                return "“滑板鞋”";
            }
        });

        a.showProduct(new Device("keyboard") {
            @Override
            public double getPrice() {
                return 60.0;
            }
        });
        Device d = new Device() {
            {
                System.out.println("内部类的初始化模块！！");
            }
            @Override
            public double getPrice() {
                return 30.0;
            }

        };
        d.setName("mouse");
        a.showProduct(d);
    }
}
abstract class Device implements Product{
    private String name;
    public abstract double getPrice();

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
