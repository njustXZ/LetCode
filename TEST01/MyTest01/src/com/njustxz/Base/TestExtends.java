package com.njustxz.Base;

public class TestExtends {
    public static void main(String[] args) {
        Animal a1 = new Animal(20);
        Bird bird = new Bird(a1);
        bird.breath();
        bird.fly();
        Wolf wolf = new Wolf(a1);
        System.out.println(bird.toString());
        System.out.println(wolf.toString());
    }
}
class Animal{
    int weight;
    public void breath(){
        System.out.println("动物都会呼吸！");
    }
    private void beat(){
        System.out.println("动物没了心跳，就无了");
    }

    public Animal(int weight) {
        this.weight = weight;
        System.out.println("Animal 有参构造器被调用了！");
    }
}
class Bird extends Animal{
    private Animal a;
    public Bird(Animal a) {
        super(a.weight);
        this.a = a;
    }

    public Bird(int weight) {
        super(weight);
    }

    public void breath(){
        a.breath();
    }
    public void fly(){
        System.out.println("鸟儿可以飞翔！！");
    }
}
class Wolf extends Animal{
    private Animal a;

    public Wolf(Animal a) {
        super(a.weight);
        this.a = a;
    }

    public void breath() {
        a.breath();
    }
    public void run(){
        System.out.println("狼狩猎时跑的很快！！");
    }
}