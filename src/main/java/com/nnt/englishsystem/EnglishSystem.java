/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nnt.englishsystem;

import com.nnt.englishsystem.practice.Practice;
import com.nnt.englishsystem.practice.PracticeMultiple;
import com.nnt.englishsystem.practice.PraticeConversation;
import com.nnt.englishsystem.practice.PraticeIncomplete;
import com.nnt.englishsystem.question.Category;
import com.nnt.englishsystem.question.Configuration;
import com.nnt.englishsystem.question.Conversation;
import com.nnt.englishsystem.question.Incomplete;
import com.nnt.englishsystem.question.Level;
import com.nnt.englishsystem.question.MultipleChoice;
import com.nnt.englishsystem.question.Option;
import com.nnt.englishsystem.question.Question;
import com.nnt.englishsystem.question.QuestionManagenment;
import com.nnt.englishsystem.user.User;
import com.nnt.englishsystem.user.UserManager;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class EnglishSystem {

    private static void menuFindQuestions(QuestionManagenment questionManagenment) {
        int choice;
        do {
            System.out.println("=============  Find Questions =============");
            System.out.println("1. By content");
            System.out.println("2. By category");
            System.out.println("3. By level ");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.printf("Enter the content to search: ");
                    String content = Configuration.SC.nextLine();
                    questionManagenment.showListFind(questionManagenment.searchQuestion(content));
                }

                case 2 -> {
                    System.out.printf("Enter the category to search: ");
                    String nameCategory = Configuration.SC.nextLine();
                    Category category = new Category(nameCategory);
                    questionManagenment.showListFind(questionManagenment.searchQuestion(category));
                }
                case 3 -> {
                    System.out.printf("Enter the level to search: ");
                    String nameLevel = Configuration.SC.nextLine();
                    Level level = Enum.valueOf(Level.class, nameLevel);
                    questionManagenment.showListFind(questionManagenment.searchQuestion(level));
                }
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuQuestionManagenment(QuestionManagenment questionManagenment) {
        int choice;
        do {
            System.out.println("============= Question Managenment =============");
            System.out.println("1. Find questions");
            System.out.println("2. See list of questions");
            System.out.println("0. Exit the program");
            System.out.print("Enter your selection: ");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 ->
                    menuFindQuestions(questionManagenment);
                case 2 ->
                    questionManagenment.show();
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuSearchUser(UserManager usm) {
        int choice;
        do {
            System.out.println("============= Search user =============");
            System.out.println("1. By full name");
            System.out.println("2. By gender(Boy/girl)");
            System.out.println("3. By day of birth");
            System.out.println("4. By home town");
            System.out.println("0. Exit");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the full name to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 2 -> {
                    System.out.print("Enter the gentder to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 3 -> {
                    System.out.print("Enter day of birth to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 4 -> {
                    System.out.print("Enter the home town to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuUpdateUser(UserManager usm) {
        int choice;
        do {
            System.out.println("============= Search user =============");
            System.out.println("1. By full name");
            System.out.println("2. By gender(Boy/girl)");
            System.out.println("3. By day of birth");
            System.out.println("4. By home town");
            System.out.println("0. Exit");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the full name to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 2 -> {
                    System.out.print("Enter the gentder to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 3 -> {
                    System.out.print("Enter day of birth to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 4 -> {
                    System.out.print("Enter the home town to search: ");
                    String kw = Configuration.SC.nextLine();
                }
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuUserManagement(UserManager usm) {
        int choice;
        do {
            System.out.println("============= User Management =============");
            System.out.println("1. Add user");
            System.out.println("2. View list of user");
            System.out.println("3. Search user");
            System.out.println("4. Update information user");
            System.out.println("5. Delete user");
            System.out.println("0. Exit");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    User us = new User();
                    us.enterInfor();
                    usm.addUser(us);
                }
                case 2 ->
                    usm.show();
                case 3 ->
                    menuSearchUser(usm);
                case 4 -> {
                    menuUpdateUser(usm);
                }
                case 5 -> {

                }
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuAdmin2(QuestionManagenment questionManagenment, UserManager userManager) {
        int choice;
        do {
            System.out.println("=============English System =============");
            System.out.println("1. Question management");
            System.out.println("2. User management");
            System.out.println("0. Exit the program");
            System.out.print("Enter your selection: ");

            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 ->
                    menuQuestionManagenment(questionManagenment);
                case 2 ->
                    menuUserManagement(userManager);
                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menuAdmin(QuestionManagenment questionManagenment, UserManager userManager) {

        int choice;
        do {
            System.out.println("============= ADMIN =============");
            System.out.println("1. Log in");
            System.out.println("2. Exit the program");
            System.out.print("Enter your selection: ");

            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    String acc = "1";
                    String pass = "1";
                    String password, account;
                    System.out.println("============= LOG IN =============");
                    System.out.print("Enter the account: ");
                    account = Configuration.SC.nextLine();
                    System.out.print("Enter the password: ");
                    password = Configuration.SC.nextLine();
                    if (acc.equals(account) && pass.equals(password)) {
                        menuAdmin2(questionManagenment, userManager);
                    }
                }
                case 2 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 2);
    }

    private static void menuUser(QuestionManagenment questionManagenment, UserManager userManager) {
        int choice;
        do {
            System.out.println("=====  Account  =====");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    menuStudy();
                }
                case 2 -> {

                }
                case 0 -> {
                }
                default ->
                    System.out.println(".");
            }
        } while (choice != 0);

    }

    public static void menuStudy() {
        int choice;
        do {
            System.out.println("=====  Study  =====");
            System.out.println("1. Pratice");
            System.out.println("2. Practice information");
            System.out.println("3. Other");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");

            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 ->
                    menyPratice();
                case 2 -> {

                }
                case 0 -> {
                }
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }

    private static void menyPratice() {
        int choice;
        do {
            System.out.println("=====  Pratice  =====");
            System.out.println("1. Multiple choice ");
            System.out.println("2. Conversation");
            System.out.println("3. Incomplete");
            System.out.print("Enter your selection: ");
            System.out.print("Enter your selection: ");
            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 0 -> {
                }
                default ->
                    System.out.println(".");
            }
        } while (choice != 0);

    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        QuestionManagenment questionManagenment = new QuestionManagenment();
        questionManagenment.readFile();
        UserManager userManager = new UserManager();
        userManager.readFile();
        int choice;
        do {
            System.out.println("=============English System =============");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit the program");
            System.out.print("Enter your selection: ");

            choice = Integer.parseInt(Configuration.SC.nextLine());
            switch (choice) {
                case 1 ->
                    menuAdmin(questionManagenment, userManager);
                case 2 ->
                    menuUser(questionManagenment, userManager);

                case 0 ->
                    System.out.println("Chuong trinh ket thuc .");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
    }
}
