package com.njustxz.Base;

import java.util.Objects;
import java.util.TreeSet;

public class TestTreeSet implements Comparable{
    int count;

    public TestTreeSet(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTreeSet that = (TestTreeSet) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public int compareTo(Object o) {
        TestTreeSet t1 =(TestTreeSet)o;
        return this.count-t1.count;
    }

    public static void main(String[] args) {
        TreeSet<TestTreeSet> treeSets = new TreeSet<>();
        treeSets.add(new TestTreeSet(3));
        treeSets.add(new TestTreeSet(1));
        treeSets.add(new TestTreeSet(5));
        treeSets.add(new TestTreeSet(37));
        treeSets.add(new TestTreeSet(33));
        treeSets.add(new TestTreeSet(7));
        for(TestTreeSet tts:treeSets){
            System.out.println(tts.count);
        }
    }
}

class Able{
    int id;
    String name;
    String Address;

    public Able(int id, String name, String address) {
        this.id = id;
        this.name = name;
        Address = address;
    }

    public Able() {}

    @Override
    public String toString() {
        return "id:"+this.id+
                ",name:"+this.name+
                ",address:"+this.Address;
    }

    public static void main(String[] args) {
        TreeSet<Able> aTest = new TreeSet<>((o1,o2)->{
            Able a1 = o1;
            Able a2 = o2;
            return a1.id-a2.id;
        });
        aTest.add(new Able(1,"jack","shanghai1"));
        aTest.add(new Able(2,"john","shanghai"));
        aTest.add(new Able(3,"lily","beijing"));
        aTest.forEach(System.out::println);

    }
}
