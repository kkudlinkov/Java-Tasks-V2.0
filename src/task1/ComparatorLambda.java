package task1;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorLambda {

    public static class Student{
        int grade;

        public int getGrade() {
            return grade;
        }
    }


    public static void main(String[] args) {
        Student student1 = new Student();
        student1.grade = 20;
        Student student2 = new Student();
        student2.grade = 10;

        Comparator<Student> function = (s1, s2) -> {
            return s1.getGrade() - s2.getGrade();
       };

        System.out.println(function.compare(student1, student2));
        System.out.println(function.compare(student2, student1));
    }
}

