package com.example.tut02.entity;

public class Friend {
    //declare attributes
    private int id;
    private String name;
    private int age;
    private String sex;
    private String city;

    //generate code for constructor, getter and setter

    public Friend(int id, String name, int age, String sex, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
    }

    public Friend(String name, int age, String sex, String city) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
    }

    public Friend(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
