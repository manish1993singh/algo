package java_basics;

class Data_type {

public static void main(String[] args){
    int intigerVariable = 10;
    double doubleVAriable = 10.5;
    char charVariable = 'A';
    boolean booleanVariable = true;
    String stringVariable = "Hello, World!";
    float floatVariable = 5.5f;
    long longVariable = 100000L;
    short shortVariable = 1000;
    byte byteVariable = 127;
    System.out.println("Integer: " + intigerVariable);
    System.out.println("Double: " + doubleVAriable);
    System.out.println("Character: " + charVariable);
    System.out.println("Boolean: " + booleanVariable);
    System.out.println("String: " + stringVariable);
    System.out.println("Float: " + floatVariable);
    System.out.println("Long: " + longVariable);
    System.out.println("Short: " + shortVariable);
    System.out.println("Byte: " + byteVariable);

    System.out.println("3 == 3: "+(new String("3") == new String("3")));
    System.out.println("3 == 3: "+(new String("3").equals(new String("3"))));
    System.out.println("3 == 3: "+("3" == "3")); 
    System.out.println("3 == 3: "+("3".equals("3"))); 
    System.out.println("3 == 3: "+(3 == 3));  
    
    int[] intArray = new int[5];
    for(int i:intArray){
        System.out.println(i);
    }

    Student student = new Student();
    System.out.println("Not assigned int variable: %s".formatted(student.getAge())); // This will cause a compile-time error
    Animal animal = new GermanShepherd();
    animal.sound(); // Calls the overridden method in GermanShepherd class
}
}

class Student {
    private String name;
    private int age;    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

abstract class Animal {
    public  void sound(){System.out.println("Animal makes a sound");}
}

abstract class Dog extends Animal {
    @Override
    public void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}

class GermanShepherd extends Dog {
    @Override
    public void sound() {
        super.sound();
        System.out.println("German Shepherd barks loudly");
    }
}