package org.example;

import java.util.Random;

public class Student {
    private String name;
    private String id;
    private int math;
    private int physic;
    private int chemistry;

    public Student(String name) {
        this.name = name;
        Random random=new Random();
        this.id="TVN"+random.nextInt(1000);
        this.math=random.nextInt(10);
        this.physic=random.nextInt(10);
        this.chemistry=random.nextInt(10);
    }
    public void info(){
        System.out.println("Student name is"+this.name);
        System.out.println("Student id is"+this.id);
        System.out.println("Math is"+this.math);
        System.out.println("Physical is"+this.physic);
        System.out.println("Chemistry is"+this.chemistry);


    }
    public int getMath(){
        return math;
    }
    public int getPhysic(){
        return physic;
    }
    public int getChemistry(){
        return chemistry;
    }
    public String getName(){
        return name;
    }

}
