package com.njustxz;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Student zhangsan = new Student();
        zhangsan.name = "zahngsan";
        Student.classNo = 3;
        //System.out.println("name = "+zhangsan.name+",class = "+zhangsan.classNo);
        /*float [] nums = new float[5];
        boolean [] bs = new boolean[3];*/
        /*for(float i : nums){
            System.out.println(i);
        }*/
        /*for(boolean b : bs){
            System.out.println(b);
        }*/
        //testMultiParam(2, "hello!","don't you know?","he is the super star");

        Person p1 = new Student();
        System.out.println("----------------");
        Person p2 = new Student("liming");
        System.out.println("++++++++++++++++++++++++");
        Person p3 = new Student(13,"zhangsan","niubi");
    }

    public  static void testMultiParam(int n,String... params){
        int m = params.length;
        for(String param:params){
            System.out.println(param);
        }
        System.out.println("m="+m);
        System.out.println("n="+n);
    }

}

class Student extends Person{
    public String cname;
    public static int classNo;

    public Student(int age, String name, String namec) {
        super(age, name);//注意这里！！
        this.name = cname;
    }

    public Student(String cname) {
        this.cname = cname;
    }

    public Student() {
    }
}
class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("Person 有参构造器！！");
    }


    static void breath(){
        System.out.println("生而为人，必能呼吸！");
    }
    public Person() {
        System.out.println("Person 无参构造器！");
    }

    @Override
    public String toString() {
        return "My name is:"+this.name+
                " ,and  I am "+ this.age+" years old";
    }
}
