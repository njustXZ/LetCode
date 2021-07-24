package com.njustxz.Base;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSynchronizedCollections {
    public static void main(String[] args) {
        SortedSet<Student> s1 = Collections.synchronizedSortedSet(new TreeSet<>((o1, o2) -> o2.id-o1.id));
        s1.add(new Student(12,"jack"));
        s1.add(new Student(13,"john"));
        s1.add(new Student(14,"mark"));
        s1.add(new Student(15,"lily"));
        s1.add(new Student(15,"lucy"));

        s1.forEach(student -> System.out.println(student.id+"->"+student.name));

    }
}
class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(! (obj instanceof Student)) return false;
        Student s1 =(Student) obj;
        return s1.id == this.id;
    }
}
