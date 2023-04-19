package ru.ntr.library.iterator;

public class Link {
    public String name;
    public int age;

    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Name: "+this.name+", age: "+this.age;
    }
}
