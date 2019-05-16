package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "students")
public class Student implements Serializable{
  @Id
  @GeneratedValue
  @Column(name = "id", unique = true)
  private int id;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "age", nullable = false)
  private int age;

  public Student() {
  }
  
  public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
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

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
  }
}
