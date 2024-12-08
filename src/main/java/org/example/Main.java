package org.example;

import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student studentA=new Student("Quynh");
        studentA.info();
        List<Student> students= List.of(
               new Student("Nhung"),
                new Student("Thuy"),
                new Student("Thuy Quynh"),
                new Student("Toan"),
                new Student("Trinh"),
                new Student("Long")

        );
        for(Student student: students){
            student.info();
            System.out.println("\n=============");
        }
        //todo: get student has max math point
        Student maxMathPointStudent=students.stream().max(Comparator.comparing(Student::getMath)).get();
        System.out.println("max Math point student====");
        maxMathPointStudent.info();
        //get list of math point
        List<Integer> mathPoints=students.stream().map(Student::getMath).toList();
        for(int p:mathPoints){
            System.out.println(p);
        }
        //sort by name
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(student ->System.out.println(student.getName()));
        //filter students having math physic >5
        List<Student> subStudent=students.stream().filter(student->student.getPhysic()>=5).toList();
        for(Student student:students){
            student.info();
            System.out.println("\n==============");
        }
        subStudent.forEach(Student::info);
    }
}