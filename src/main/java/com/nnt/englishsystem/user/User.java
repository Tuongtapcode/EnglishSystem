/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.user;

import com.nnt.englishsystem.practice.Practice;
import com.nnt.englishsystem.question.Configuration;
import com.nnt.englishsystem.question.Question;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class User {

    private boolean Admin = false;
    private String fullName;
    private String hometown;
    private boolean gender; // 0 la nam, 1 la nu
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
    private List<Question> answeredQuestions = new ArrayList<>();
    private List<Practice> pratice = new ArrayList<>();
    private static int count;
    private String id;
    private String userName;
    private String password;

    public User() {
        this.joinDate = LocalDate.now();
        this.id = String.format("US%d_%04d", this.joinDate.getYear(), count++);
    }

    public User(String fullName, String hometown, boolean gender, String dateOfBirth) {
        this();
        this.fullName = fullName;
        this.hometown = hometown;
        this.gender = gender;
        this.dateOfBirth = Configuration.convertStringToLocalDate(dateOfBirth);
    }

    public void enterInfor() {
        System.out.printf("Nhap ho ten: ");
        this.fullName = Configuration.SC.nextLine();
        System.out.printf("Nhap que quan: ");
        this.hometown = Configuration.SC.nextLine();
        System.out.printf("Nhap gioi tinh: ");
        String gt = Configuration.SC.nextLine();
        if (gt.equalsIgnoreCase("Nam")) {
            this.setGender(true);
        } else if (gt.equalsIgnoreCase("Nu")) {
            this.setGender(false);
        }
        System.out.print("Nhap ngay sinh: ");
        this.dateOfBirth = Configuration.convertStringToLocalDate(Configuration.SC.nextLine());
    }

    public void show() {
        String gt;
        if (this.isGender()) {
            gt = "Nam";
        } else {
            gt = "Nu";
        }
        System.out.printf("Id: %s\nHo ten: %s\nQue quan: %s\nGioi tinh:%s\nNgay sinh:%s\n", this.getId(), this.getFullName(), this.getHomeTown(), gt,
                this.getDateOfBirth().format(DateTimeFormatter.ofPattern(Configuration.DATE_PATTERN)));
    }

    public boolean hasAnsweredQuestion(Question question) {
        for (Question answeredQuestion : getAnsweredQuestions()) {
            if (answeredQuestion.getContent().equals(question.getContent())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the hometown
     */
    public String getHomeTown() {
        return hometown;
    }

    /**
     * @param homeTown the homeTown to set
     */
    public void setHomeTown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * @return the gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the joinDate
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return the answeredQuestions
     */
    public List<Question> getAnsweredQuestions() {
        return answeredQuestions;
    }

    /**
     * @param answeredQuestions the answeredQuestions to set
     */
    public void setAnsweredQuestions(List<Question> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    /**
     * @return the pratice
     */
    public List<Practice> getPratice() {
        return pratice;
    }

    /**
     * @param pratice the pratice to set
     */
    public void setPratice(List<Practice> pratice) {
        this.pratice = pratice;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
