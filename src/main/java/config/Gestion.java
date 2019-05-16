package config;

import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Gestion {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = 
    Persistence.createEntityManagerFactory("MySQLDemo");
  
  public int createStudent(String name, int age){
    EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    int rpta = 0;
    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();
      // Create a new Student object
      Student n = new Student();
      n.setName(name);
      n.setAge(age);
      // Save the student object
      manager.persist(n);
      // Commit the transaction
      transaction.commit();
      rpta = n.getId();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      // Print the Exception
      ex.printStackTrace();
    } finally {
      // Close the EntityManager
      manager.close();
    }
    return rpta;
  }
  
  public List<Student> listStudents(){
    List students = null;
    // Create an EntityManager
    EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();
      // Get a List of Students
      students = manager.createQuery("SELECT s FROM Student s",
        Student.class).getResultList();
      // Commit the transaction
      transaction.commit();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      // Print the Exception
      ex.printStackTrace();
    } finally {
      // Close the EntityManager
      manager.close();
    }
    return students;
  }
}
