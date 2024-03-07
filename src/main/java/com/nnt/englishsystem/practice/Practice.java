/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.practice;

import com.nnt.englishsystem.question.Question;
import com.nnt.englishsystem.question.QuestionManagenment;
import com.nnt.englishsystem.user.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public abstract class Practice {

    private User user;
    private double point;
    private int correcAnswer;
    private LocalDate time;
    private List<Question> listQuestion = new ArrayList<>();
    private List<Integer> listAnswer = new ArrayList<>();

    public Practice(User user) {
        this.time = LocalDate.now();
        this.user = user;
    }

    public abstract void listQuestions(QuestionManagenment qlch);

    public abstract void exercise();

    public void show() {

    }

    /**
     * @return the time
     */
    public LocalDate getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalDate time) {
        this.time = time;
    }

    /**
     * @return the listQuestion
     */
    public List<Question> getListQuestion() {
        return listQuestion;
    }

    /**
     * @param listQuestion the listQuestion to set
     */
    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    /**
     * @return the listAnswer
     */
    public List<Integer> getListAnswer() {
        return listAnswer;
    }

    /**
     * @param listAnswer the listAnswer to set
     */
    public void setListAnswer(List<Integer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    /**
     * @return the point
     */
    public double getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(double point) {
        this.point = point;
    }

    /**
     * @return the correcAnswer
     */
    public int getCorrecAnswer() {
        return correcAnswer;
    }

    /**
     * @param correcAnswer the correcAnswer to set
     */
    public void setCorrecAnswer(int correcAnswer) {
        this.correcAnswer = correcAnswer;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
