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
public class Conversation extends Question {

    private List<MultipleChoice> questions = new ArrayList<>();

    public Conversation() {
    }

    public Conversation(Category category, Level level, String content, List<MultipleChoice> questions) {
        super(category, level, content, null);
        this.questions = questions;
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
        this.getQuestions().forEach(multipleChoice -> {
            System.out.printf("%s\n", multipleChoice.getContent());
            char alphabet = 'A';
            for (Option option : multipleChoice.getOptions()) {
                if (option.getContent().length() > 20) {
                    System.out.printf("%s. %s \n", alphabet, option.getContent());
                } else {
                    System.out.printf("%s. %s\t\t\t", alphabet, option.getContent());
                }

                alphabet++;
            }
            System.out.println();
        });

    }

    @Override
    public Question docFile() {
        Category category = new Category(Configuration.sc.nextLine());
        String level = Configuration.sc.nextLine().toUpperCase();
        Level lv = Enum.valueOf(Level.class, level);
        String contentConversation = Configuration.sc.nextLine();
        List<MultipleChoice> questions = new ArrayList<>();
        while (Configuration.sc.hasNext()) {
            String content = Configuration.sc.nextLine();
            if (content.isEmpty()) {
                break;
            }
            List<Option> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                String conTentOption = Configuration.sc.nextLine();
                if (conTentOption.isEmpty()) {
                    break;
                }
                String chuThich = Configuration.sc.nextLine();
                Option op = new Option(conTentOption, chuThich);
                if (i == 0) {
                    op.setAnswer(true);
                }
                options.add(op);
            }
            MultipleChoice qs = new MultipleChoice(content, options);
            questions.add(qs);
        }
        Question conversation = new Conversation(category, lv, contentConversation, questions);
        return conversation;
    }

    /**
     * @return the questions
     */
    public List<MultipleChoice> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<MultipleChoice> questions) {
        this.questions = questions;
    }
    
}
