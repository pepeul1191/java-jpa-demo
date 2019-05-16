package config;

import entity.Student;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Gestion g = new Gestion();
    // int id = g.createStudent("Pepe", 30);
    // System.out.println("Id generado : " + id);
    ArrayList<Student> students = (ArrayList) g.listStudents();
    System.out.println("Lista de alumnos");
    System.out.println(students.size());
    for(Student s : students){
      System.out.println(s.toString());
    }
  }
}
