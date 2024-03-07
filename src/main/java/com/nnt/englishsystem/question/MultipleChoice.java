/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

import com.nnt.englishsystem.question.Level;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class MultipleChoice extends Question {

    public MultipleChoice() {
    }

    public MultipleChoice(Question qs) {
        super(qs);
    }

    public MultipleChoice(List<Option> options) {
        super(null, null, null, options);
    }

    public MultipleChoice(String content, List<Option> options) {
        super(null, null, content, options);
    }

    public MultipleChoice(Category category, Level level, String content, List<Option> options) {
        super(category, level, content, options);
    }

    public void show() {
//        System.out.printf("Danh muc: %s\n", this.getCategory().getName());
//        System.out.printf("Muc do: %s\n", this.getLevel().getName());
        System.out.printf("Noi dung: %s\n", this.getContent());
        char alphabet = 'A';
        for (Option option : this.getOptions()) {
            if (option.getContent().length() > 20) {
                System.out.printf("%s. %s \n", alphabet, option.getContent());
            } else {
                System.out.printf("%s. %s\t\t\t", alphabet, option.getContent());
            }
            System.out.println();
            alphabet++;
        }
    }

    public Question docFile() {
        Category category = new Category(Configuration.sc.nextLine());
        String level = Configuration.sc.nextLine().toUpperCase();
        Level lv = Enum.valueOf(Level.class, level);
        String content = Configuration.sc.nextLine();
        List<Option> options = new ArrayList<>();
        boolean first = false;
        while (Configuration.sc.hasNext()) {
            String ct = Configuration.sc.nextLine();
            if (ct.isEmpty()) {
                break;
            }
            String note = Configuration.sc.nextLine();

            Option option = new Option(ct, note);
            options.add(option);
            if (first == false) {
                first = true;
                option.setAnswer(first);
            }
        }
        Question Multiple = new MultipleChoice(category, lv, content, options);
        return Multiple;
    }
}
