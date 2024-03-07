/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.practice;

import com.nnt.englishsystem.question.Configuration;
import com.nnt.englishsystem.question.MultipleChoice;
import com.nnt.englishsystem.question.Option;
import com.nnt.englishsystem.question.Question;
import com.nnt.englishsystem.question.QuestionManagenment;
import com.nnt.englishsystem.user.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ngoct
 */
public class PracticeMultiple extends Practice {

    public PracticeMultiple(User user) {
        super(user);
    }

    @Override
    public void listQuestions(QuestionManagenment qlch) {
        int numberOfQuestions;

        QuestionManagenment listMultiple = new QuestionManagenment();
        System.out.print("Nhap so cau hoi multiple: ");
        numberOfQuestions = Integer.parseInt(Configuration.SC.nextLine());
        //&& this.getUser().hasAnsweredQuestion(qs)
        qlch.getDsQuestions().stream().filter(qs -> qs instanceof MultipleChoice && !this.getUser().hasAnsweredQuestion(qs))
                .forEach(listMultiple.getDsQuestions()::add);

        if (numberOfQuestions == listMultiple.getDsQuestions().size()) {
            Collections.shuffle(listMultiple.getDsQuestions());
            for (Question x : listMultiple.getDsQuestions()) {
                Question qs = x.clone();
                Collections.shuffle(qs.getOptions());
               
                Collections.shuffle(qs.getOptions());
                this.getListQuestion().add(qs);
                this.getUser().getAnsweredQuestions().add(qs);
            }
        } else if (numberOfQuestions < listMultiple.getDsQuestions().size()) {
            int i = 0;
            ArrayList<Integer> generated = new ArrayList<>();
            while (i < numberOfQuestions) {
                int index = (int) (Math.random() * listMultiple.getDsQuestions().size());
                if (!generated.contains(index)) {
                    Question qsTemp = listMultiple.getDsQuestions().get(index);
                    Question qs = qsTemp.clone();
                    Collections.shuffle(qs.getOptions());
                    qs.setOptions(qs.getOptions());
                    this.getListQuestion().add(qs);
                    this.getUser().getAnsweredQuestions().add(listMultiple.getDsQuestions().get(index));
                    i++;
                }
            }
        } else {
            System.out.println("So cau hoi khong du!!!");
        }
    }

    @Override
    public void exercise() {
        System.out.println("------------------Bai luyen tap------------------");
        int i = 0;
        for (Question qs : this.getListQuestion()) {
            System.out.printf("Question %d. %s\n", ++i, qs.getContent());
            char alphabet = 'A';
            for (Option option : qs.getOptions()) {
                if (option.getContent().length() > 22) {
                    System.out.printf("%s. %s", alphabet, option.getContent());
                } else {
                    String formatString = "%s. %-" + 25 + "s"; // Tạo chuỗi định dạng với khoảng trắng cố định là n kí tự
                    System.out.printf(formatString, alphabet, option.getContent());
                }

                alphabet++;
            }
            System.out.println();
            System.out.printf("Nhap dap an %d/%d): ", this.getListAnswer().size() + 1, this.getListQuestion().size());
            int ketQuaInt = (int) (Configuration.SC.nextLine().toUpperCase().charAt(0)) - 65;
            if (qs.getOptions().get(ketQuaInt).isAnswer()) {
                this.setCorrecAnswer(this.getCorrecAnswer() + 1);
            }
            this.getListAnswer().add(ketQuaInt);
        }
    }

    public void show() {
        System.out.println("------------------Ket Qua Bai Luyen Tap------------------");
        System.out.printf("So dap an dung: %d\n", this.getCorrecAnswer());
        System.out.printf("Diem: %.1f\n", (10.0 / this.getListQuestion().size() * 1.0) * this.getCorrecAnswer());
        int i = 0;
        for (Question qs : this.getListQuestion()) {
            System.out.printf("Question %d. %s\n", i + 1, qs.getContent());
            char alphabet = 'A';
            for (Option option : qs.getOptions()) {
                if (option.getContent().length() > 22) {
                    System.out.printf("%s. %s", alphabet, option.getContent());
                } else {
                    String formatString = "%s. %-" + 25 + "s"; // Tạo chuỗi định dạng với khoảng trắng cố định là n kí tự
                    System.out.printf(formatString, alphabet, option.getContent());
                }
                alphabet++;
            }

            System.out.println();
            char dapAnCuaBan = (char) (65 + this.getListAnswer().get(i));
            System.out.printf("Dap an cua ban (%d/ %d): %c (%b)\n", i + 1, this.getListAnswer().size(),
                    dapAnCuaBan, qs.getOptions().get(this.getListAnswer().get(i)).isAnswer());
            Optional<Option> dungOptional = qs.getOptions().stream().filter((t) -> t.isAnswer() == true).findFirst();
            Option dung = dungOptional.get();
            System.out.printf("Dap an dung : %s\nGiai thich : %s\n", dung.getContent(), dung.getNote());
            i++;
        }

    }
}
