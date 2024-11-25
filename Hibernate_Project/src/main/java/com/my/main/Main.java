package com.my.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hibernate.dao.HibernateDaoImp;
import com.my.Entity.Projects;
import com.my.Entity.Student;
import com.my.Entity.StudentDetails;
import com.my.Entity.Subjects;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HibernateDaoImp hdi = new HibernateDaoImp();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Student");
            System.out.println("2. Fetch All Students");
            System.out.println("3. Fetch Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Update Student Email by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    scan.nextLine(); 
                    String name = scan.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = scan.nextLine();
                    System.out.print("Enter Student Address: ");
                    String address = scan.nextLine();
                    System.out.print("Enter Student Pincode: ");
                    int pincode = scan.nextInt();
                    System.out.print("Enter Student Department: ");
                    scan.nextLine(); 
                    String department = scan.nextLine();
                    System.out.print("Enter Student Year: ");
                    int year = scan.nextInt();
                    System.out.print("Enter Student Contact: ");
                    long contact = scan.nextLong();

                    Student student = new Student(name, email, address, pincode);
                    StudentDetails sd = new StudentDetails(department, year, contact);
                    Subjects s1 = new Subjects("SQl");
                    Subjects s2 = new Subjects("HIbernate");
                    
                    Projects p1 = new Projects("Food App", 8);
                    Projects p2 = new Projects("Drives Portal", 10);
                    Projects p3 = new Projects("Banking App", 40);
                    
                    List<Subjects> Subjectslist = new ArrayList<Subjects>();
                    Subjectslist.add(s1);
                    Subjectslist.add(s2);
                    s1.setStudent(student);
                    s2.setStudent(student);
                    
                    List<Projects> ProjectList = new ArrayList<Projects>();
                    ProjectList.add(p1);
                    ProjectList.add(p2);
                    ProjectList.add(p3);
                    
                    
                    sd.setStudent(student);
                    student.setSd(sd);
                    student.setSubjects(Subjectslist);
                    student.setProjects(ProjectList);
                    
                    hdi.insert(student);
                    System.out.println("Student inserted successfully.");
                    break;

                case 2:
                    // Fetch All Students
                    ArrayList<Student> list = hdi.fetchAll();
                    System.out.println("Student Records:");
                    for (Student a : list) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    // Fetch Student by ID
                    System.out.print("Enter Student ID to fetch: ");
                    int fetchId = scan.nextInt();
                    Student s = hdi.fetchOne(fetchId);
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Student Data : ");
                    System.out.println(s.getStudent_id() + "   " + s.getStudent_name() + "   " + s.getEmail()+"   " +
                    s.getEmail() + "   " + s.getAddress() + "   " + s.getPincode());
                    
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Student Details: ");
                    System.out.println(s.getSd());
                    
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Enrolled Subjects: ");
                    for(Subjects subs : s.getSubjects()) {
                    	System.out.println(subs);
                    }
                    
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Projects Experience: ");
                    for(Projects projs : s.getProjects()) {
                    	System.out.println(projs);
                    }
                    
                    break;

                case 4:
                    // Delete Student by ID
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scan.nextInt();
                    if (hdi.fetchOne(deleteId) != null) {
                        hdi.delete(deleteId);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found with ID: " + deleteId);
                    }
                    break;

                case 5:
                    // Update Student Email by ID
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scan.nextInt();
                    System.out.print("Enter new email: ");
                    scan.nextLine(); // Consume newline
                    String newEmail = scan.nextLine();
                    if (hdi.fetchOne(updateId) != null) {
                        hdi.update(updateId, newEmail);
                        System.out.println("Student email updated successfully.");
                    } else {
                        System.out.println("Student not found with ID: " + updateId);
                    }
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scan.close();
    }
}
