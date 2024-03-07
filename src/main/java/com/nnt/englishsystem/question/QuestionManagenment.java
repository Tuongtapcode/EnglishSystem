/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ngoct
 */
public class QuestionManagenment {

    private List<Question> dsQuestions = new ArrayList<>();

    public QuestionManagenment() {
    }

    public List<Question> searchQuestion(Category category) {
        return this.getDsQuestions().stream().filter(qs -> qs.getCategory().getName().equals(category.getName()))
                .collect(Collectors.toList());
    }

    public List<Question> searchQuestion(Level level) {
        return this.getDsQuestions().stream().filter(qs -> qs.getLevel().getName().equals(level.getName()))
                .collect(Collectors.toList());
    }

    public List<Question> searchQuestion(String content) {
        return this.getDsQuestions().stream()
                .filter(qs -> qs.getContent().contains(content))
                .collect(Collectors.toList());
    }

    public void showListFind(List<Question> list) {
        if (list.isEmpty()) {
            System.out.println("Khong co cau hoi nao duoc tim thay.");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Danh sach cau hoi tim thay:");
            for (Question qs : list) {
                qs.show();
                System.out.println("------------------------");
            }
        }
    }

    public void readFile() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        while (Configuration.sc.hasNext()) {
            String classPath = Configuration.sc.nextLine();
            Class c = Class.forName("com.nnt.englishsystem.question." + classPath);
            Question ch = (Question) c.getConstructor().newInstance();
            this.getDsQuestions().add(ch.docFile());
        }
    }

    public void show() {
        this.getDsQuestions().forEach(question -> {
            question.show();
        });
    }

    public void addQuestion(Question qs) {
        this.getDsQuestions().add(qs);
    }

    public void addQuestion(Question... a) {
        this.getDsQuestions().addAll(Arrays.asList(a));
    }

    /**
     * @return the dsQuestions
     */
    public List<Question> getDsQuestions() {
        return dsQuestions;
    }

    /**
     * @param dsQuestions the dsQuestions to set
     */
    public void setDsQuestions(List<Question> dsQuestions) {
        this.dsQuestions = dsQuestions;
    }

}
