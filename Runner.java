
import Entity.*;

import java.util.Scanner;
import java.sql.*;
import static Entity.Students.*;

public class Runner {

    public static void main(String[] args) {


        Scanner keyboard =new Scanner(System.in);
        String option;
        String choice;
        String adminUserName;
        String adminPassword = "";
        String enteredPassword="";
        String enteredUsername="";



        String url="jdbc:mysql://localhost:3306/onlinemanagementsystem";
        String username="root";
        String password="";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);

            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM administrator");

            while (resultSet.next()) {
                enteredPassword = resultSet.getString(2);
                enteredUsername =resultSet.getString(1);
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("--------------------------LOGIN---------------------------");
            System.out.println("----------------------------------------------------------");

            System.out.print("Enter username to login   :");
            adminUserName=keyboard.nextLine();
            System.out.print("Enter password to login   :");
            adminPassword=keyboard.nextLine();
            System.out.println("----------------------------------------------------------");



            if(enteredUsername.equals(adminUserName) && enteredPassword.equals(adminPassword))
            {
                System.out.println("1. For Student :");
                System.out.println("2. For Teacher :");
                System.out.println("3. For Class   :");
                System.out.println("4. For Subject :");
                System.out.println("5. Assign classes for subjects from the master list :");
                System.out.println("6. Assign teachers to a class for a subject         :");
                System.out.println("7. All the subjects for all the classes             :");
                System.out.println("Enter 1234 to Termitare program                     :");

                System.out.println("-----------------------------------------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("Enter option your want to perform :");
                option=keyboard.nextLine();


                while (option!="1234")
                {
                    switch (option)
                    {
                        case "1":
                            System.out.println("1. Enter Student to database :");
                            System.out.println("2. List of students          :");
                            System.out.println("------------------------------");
                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();

                            Students students=new Students();

                            if (choice.equals("1"))
                            {System.out.println("-----------------------------------------------------------------");
                                students.addStudent();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                students.listStudents();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }

                            break;
                        case "2":
                            System.out.println("1. Enter Teacher to database :");
                            System.out.println("2. List all the teachers     :");
                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();

                            Teacher teacher = new Teacher();

                            if (choice.equals("1"))
                            {System.out.println("-----------------------------------------------------------------");
                                teacher.addTeacher();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                               teacher.listTeacher();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }

                            break;

                        case "3":
                            System.out.println("1. Enter a Class to database :");
                            System.out.println("2. List of all the classes   :");

                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();

                            Classes classes =new Classes();

                            if (choice.equals("1"))
                            {System.out.println("-----------------------------------------------------------------");
                                classes.addClasses();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                classes.listClasses();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }

                            break;
                        case "4":
                            System.out.println("1. Enter subject to database :");
                            System.out.println("2. List of all the subject   :");

                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();

                            Subjects subjects=new Subjects();

                            if (choice.equals("1"))
                            {
                                System.out.println("-----------------------------------------------------------------");
                                subjects.addSubjects();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                subjects.listSubjects();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }
                            break;
                        case  "5":

                            System.out.println("1. Enter assign class to subjeect :");
                            System.out.println("2. List of all assigned           :");

                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();

                            AssignClassToSubjects assignClassToSubjects = new AssignClassToSubjects();




                            if (choice.equals("1"))
                            {
                                System.out.println("-----------------------------------------------------------------");
                                assignClassToSubjects.assign();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                assignClassToSubjects.listAssigned();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }

                            break;
                        case "6":
                            System.out.println("1. Enter assign class to subjeect :");
                            System.out.println("2. List of all assigned           :");

                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();
                            AssignTeacherToClass assignTeacherToClass=new AssignTeacherToClass();



                            if (choice.equals("1"))
                            {
                                System.out.println("-----------------------------------------------------------------");
                                assignTeacherToClass.assign();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                assignTeacherToClass.listAssigned();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }
                            break;

                        case "7":
                            AssignStudentToClass assignStudentToClass=new AssignStudentToClass();


                            System.out.println("1. Enter assign class to student  :");
                            System.out.println("2. List of all assigned           :");

                            System.out.print("Enter choice you want to perform :");
                            choice=keyboard.nextLine();





                            if (choice.equals("1"))
                            {
                                System.out.println("-----------------------------------------------------------------");
                                assignStudentToClass.assign();
                                System.out.println("-----------------------------------------------------------------");
                            }else if(choice.equals("2")){
                                System.out.println("-----------------------------------------------------------------");
                                assignStudentToClass.listAssigned();
                                System.out.println("-----------------------------------------------------------------");
                            }else
                            {
                                System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");

                            }
                            break;
                        default:
                            System.out.println("You enter incorrect option, Program will STOP!!!!!!!!!!!!");
                            System.exit(0);
                            break;
                    }


                    System.out.println("1. For Student :");
                    System.out.println("2. For Teacher :");
                    System.out.println("3. For Class   :");
                    System.out.println("4. For Subject :");
                    System.out.println("5. Assign classes for subjects from the master list :");
                    System.out.println("6. Assign teachers to a class for a subject         :");
                    System.out.println("7. All the subjects for all the classes             :");
                    System.out.println("Enter 1234 to Termitare program                     :");

                    System.out.println("-----------------------------------------------------------------");

                    System.out.print("Enter option your want to perform :");
                    option=keyboard.nextLine();

                }
            }
            else
            {
                if(enteredUsername.equals(adminUserName))
                {
                    System.out.println("Incorrect password");
                }else if(enteredPassword.equals(adminPassword))
                {
                    System.out.println("Incorrect username");
                }else {
                    System.out.println("username and password are Incorrect");
                }
                System.out.println("Bye!!!!!!!!!!!!!!!!!!!");
            }


            connection.close();

        }catch (Exception e)
        {
            System.out.println("Not Connect to database......................");
        }





    }
}
