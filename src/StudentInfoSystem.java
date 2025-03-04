import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Displayable {
    void displayDetails();
}

abstract class Person implements Displayable {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    private int rollNumber;
    
    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

public class StudentInfoSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student Information System by pushkar[22bcs17250]");
        
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Add Teacher");
                System.out.println("3. Display All Students");
                System.out.println("4. Display All Teachers");
                System.out.println("5. Search Student by Roll Number");
                System.out.println("6. Search Teacher by Name");
                System.out.println("7. Update Student Details");
                System.out.println("8. Update Teacher Details");
                System.out.println("9. Remove Student");
                System.out.println("10. Remove Teacher");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        addTeacher(scanner);
                        break;
                    case 3:
                        displayAllStudents();
                        break;
                    case 4:
                        displayAllTeachers();
                        break;
                    case 5:
                        searchStudent(scanner);
                        break;
                    case 6:
                        searchTeacher(scanner);
                        break;
                    case 7:
                        updateStudent(scanner);
                        break;
                    case 8:
                        updateTeacher(scanner);
                        break;
                    case 9:
                        removeStudent(scanner);
                        break;
                    case 10:
                        removeTeacher(scanner);
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please try again.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            System.out.print("Enter Student Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            Student student = new Student(name, age, rollNumber);
            students.add(student);
            System.out.println("Student added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Student not added.");
            scanner.nextLine();
        }
    }

    private static void addTeacher(Scanner scanner) {
        try {
            System.out.print("Enter Teacher Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Teacher Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Teacher Subject: ");
            String subject = scanner.nextLine();
            Teacher teacher = new Teacher(name, age, subject);
            teachers.add(teacher);
            System.out.println("Teacher added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Teacher not added.");
            scanner.nextLine(); 
        }
    }
    
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                student.displayDetails();
                System.out.println("---------------------------");
            }
        }
    }
    
    private static void displayAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
        } else {
            System.out.println("All Teachers:");
            for (Teacher teacher : teachers) {
                teacher.displayDetails();
                System.out.println("---------------------------");
            }
        }
    }
    
    private static void searchStudent(Scanner scanner) {
        try {
            System.out.print("Enter Roll Number to search: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 
            boolean found = false;
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    student.displayDetails();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with Roll Number " + rollNumber + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
            scanner.nextLine(); 
        }
    }
    
    private static void searchTeacher(Scanner scanner) {
        System.out.print("Enter Teacher Name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.name.equalsIgnoreCase(name)) {
                teacher.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Teacher with name " + name + " not found.");
        }
    }
    
    private static void updateStudent(Scanner scanner) {
        try {
            System.out.print("Enter Roll Number of the student to update: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 
            boolean found = false;
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); 
                    student.setName(newName);
                    student.setAge(newAge);
                    System.out.println("Student details updated.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with Roll Number " + rollNumber + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Update aborted.");
            scanner.nextLine(); 
        }
    }
    
    private static void updateTeacher(Scanner scanner) {
        System.out.print("Enter Teacher Name to update: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter new Subject: ");
                String newSubject = scanner.nextLine();
                teacher.setName(newName);
                teacher.setAge(newAge);
                teacher.setSubject(newSubject);
                System.out.println("Teacher details updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Teacher with name " + name + " not found.");
        }
    }
    
    private static void removeStudent(Scanner scanner) {
        try {
            System.out.print("Enter Roll Number of the student to remove: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 
            boolean removed = students.removeIf(student -> student.getRollNumber() == rollNumber);
            if (removed) {
                System.out.println("Student removed successfully.");
            } else {
                System.out.println("Student with Roll Number " + rollNumber + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Removal aborted.");
            scanner.nextLine(); 
        }
    }
    
    private static void removeTeacher(Scanner scanner) {
        System.out.print("Enter Teacher Name to remove: ");
        String name = scanner.nextLine();
        boolean removed = teachers.removeIf(teacher -> teacher.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Teacher removed successfully.");
        } else {
            System.out.println("Teacher with name " + name + " not found.");
        }
    }
}
