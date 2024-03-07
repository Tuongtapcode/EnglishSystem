/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.user;

import com.nnt.englishsystem.question.Configuration;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ngoct
 */
public class UserManager {

    private List<User> users = new ArrayList<>();
    public void addUser(User us){
        this.users.add(us);
    }
   
    public void registerUser() {
        User us = new User();
        System.out.println("Nhap thong tin dang ky: ");
        us.enterInfor();
        System.out.println("Nhap thong tin tai khoan va mat khau: ");
        System.out.printf("Nhap user name: ");
        us.setUserName(Configuration.SC.nextLine());
        System.out.printf("Nhap pass word: ");
        us.setPassword(Configuration.SC.nextLine());
        this.getUsers().add(us);
        System.out.println("Dang ky thanh cong !!! ");
    }

    public void show() {
        this.getUsers().forEach(us -> {
            us.show();
        });
    }

    public void readFile() throws FileNotFoundException {
        File f = new File("src/main/resources/DanhSachDangKy.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            User us = new User();
            us.setId(sc.nextLine());
            us.setFullName(sc.nextLine());
            us.setHomeTown(sc.nextLine());
            String gt = sc.nextLine();
            if (gt.equalsIgnoreCase("Nam")) {
                us.setGender(true);
            } else if (gt.equalsIgnoreCase("Nu")) {
                us.setGender(false);
            }
            us.setDateOfBirth(Configuration.convertStringToLocalDate(sc.nextLine()));
            us.setJoinDate(Configuration.convertStringToLocalDate(sc.nextLine()));
            us.setUserName(sc.nextLine());
            us.setPassword(sc.nextLine());
            this.getUsers().add(us);
        }
    }

    public void writeFile(String nameFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true))) {
            for (User us : this.getUsers()) {
                // Kiểm tra giá trị null trước khi sử dụng
                if (us != null) {
                    String gt;
                    if (us.isGender()) {
                        gt = "Nam";
                    } else {
                        gt = "Nu";
                    }
                    writer.write(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n\n",
                            us.getId(),
                            us.getFullName(),
                            us.getHomeTown(),
                            gt,
                            us.getDateOfBirth() != null ? us.getDateOfBirth().format(DateTimeFormatter.ofPattern(Configuration.DATE_PATTERN)) : "",
                            us.getJoinDate() != null ? us.getJoinDate().format(DateTimeFormatter.ofPattern(Configuration.DATE_PATTERN)) : "",
                            us.getUserName(),
                            us.getPassword()));
                }
            }
        } catch (IOException e) {
            System.out.println("Ghi file thất bại!");
            e.printStackTrace();
        }
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
