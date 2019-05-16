package config;

public class App {
  public static void main(String[] args) {
    Gestion g = new Gestion();
    int id = g.createStudent("Pepe", 30);
    System.out.println("Id generado : " + id);
  }
}
