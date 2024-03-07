/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

import com.nnt.englishsystem.question.Level;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class Incomplete extends Question {

    private List<MultipleChoice> questions = new ArrayList<>();

    public Incomplete() {
    }

    public Incomplete(Category category, Level level, String content, List<MultipleChoice> question) {
        super(category, level, content, null);
        this.questions = question;
    }

    public void show() {
        System.out.printf("Danh muc:%s\nMuc do: %s\n", this.getCategory().getName(), getLevel().getName());
        String[] words = this.getContent().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println(); // Xuống dòng sau mỗi 20 từ
            }
        }
        System.out.println();
        int i = 1;
        for (Question question : questions) {
            System.out.printf("(%d)  ", i);
            char alphabet = 'A';
            for (Option option : question.getOptions()) {
                if (option.getContent().length() > 20) {
                    System.out.printf("%s. %s", alphabet, option.getContent());
                } else {
                    String formatString = "%s. %-" + 25 + "s"; // Tạo chuỗi định dạng với khoảng trắng cố định là n kí tự
                    System.out.printf(formatString, alphabet, option.getContent());
                }

                alphabet++;
            }
            System.out.println();
            i++;
        }
    }

    @Override
    public Question docFile() {
        Category category = new Category(Configuration.sc.nextLine());
        String level = Configuration.sc.nextLine().toUpperCase();
        Level lv = Enum.valueOf(Level.class, level);
        String contentIncomplete = Configuration.sc.nextLine();
        List<MultipleChoice> questions = new ArrayList<>();
        while (Configuration.sc.hasNext()) {
            String conTentOption = Configuration.sc.nextLine();
            if (conTentOption.isEmpty()) {
                break; // Thoát khỏi vòng lặp nếu gặp dòng trống
            }
            List<Option> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Option op;
                if (i == 0) {
                    String chuThich = Configuration.sc.nextLine();
                    op = new Option(conTentOption, chuThich);
                    op.setAnswer(true);

                } else {
                    conTentOption = Configuration.sc.nextLine();
                    String chuThich = Configuration.sc.nextLine();
                    op = new Option(conTentOption, chuThich);

                }
                options.add(op);
            }
            MultipleChoice qs = new MultipleChoice(options);
            questions.add(qs);
        }
        Question imcomQuestion = new Incomplete(category, lv, contentIncomplete, questions);
        return imcomQuestion;
    }

    public List<MultipleChoice> getQuestions() {
        return questions;
    }

}
