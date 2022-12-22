package com.example.vo;

public class Employee {
    private  Integer ID;
    private  Integer DeptID;
    private  String Name;
    private  String birthday;

    public Employee(Integer deptID, String name, String birthday) {
        DeptID = deptID;
        Name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", DeptID=" + DeptID +
                ", Name='" + Name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(Integer ID, Integer deptID, String name, String birthday) {
        this.ID = ID;
        DeptID = deptID;
        Name = name;
        this.birthday = birthday;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
