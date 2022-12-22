package com.example.vo;

public class Dept {
    private  Integer ID;
    private  String Name;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Dept() {
    }

    public Dept(Integer ID, String name) {
        this.ID = ID;
        Name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
