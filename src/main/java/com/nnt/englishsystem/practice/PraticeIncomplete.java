/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.practice;

import com.nnt.englishsystem.question.Configuration;
import com.nnt.englishsystem.question.Conversation;
import com.nnt.englishsystem.question.Incomplete;
import com.nnt.englishsystem.question.MultipleChoice;
import com.nnt.englishsystem.question.Option;
import com.nnt.englishsystem.question.Question;
import com.nnt.englishsystem.question.QuestionManagenment;
import com.nnt.englishsystem.user.User;
import java.util.Collections;
import java.util.Optional;

/**
 *
 * @author ngoct
 */
public class PraticeIncomplete extends Practice {

    public PraticeIncomplete(User user) {
        super(user);
    }

    @Override
    public void listQuestions(QuestionManagenment qlch) {
        QuestionManagenment listImcom = new QuestionManagenment();
        System.out.println("-------HAY LUA CHON MUC DO-------");
        System.out.print("1.DE\n2.TRUNG BINH\n3.KHO\n");
        System.out.print("LUA CHON CUA BAN: ");
        int lc = Integer.parseInt(Configuration.SC.nextLine());
        final String finalS;
        switch (lc) {
            case 1:
                finalS = "EASY";
                break;
            case 2:
                finalS = "MEDIUM";
                break;
            case 3:
                finalS = "DIFFICULT";
                break;
            default:
                finalS = null; // Đảm bảo finalS là non-null nếu không có mức độ nào được chọn
                break;
        }

        if (finalS != null) {

            qlch.getDsQuestions().stream()
                    .filter(qs -> qs instanceof Incomplete && qs.getLevel().getName().equals(finalS)&& !this.getUser().hasAnsweredQuestion(qs))
                    .forEach(listImcom.getDsQuestions()::add);
            // Các thao tác tiếp theo với listConver ở đây
        } else {
            System.out.println("Muc do khong hop le!");
        }

        if (listImcom.getDsQuestions().size() < 1) {
            System.out.println("Het cau hoi!!!!");
        } else if (listImcom.getDsQuestions().size() == 1) {

        } else {
            int index = (int) (Math.random() * listImcom.getDsQuestions().size());
            Question qsTemp = listImcom.getDsQuestions().get(index);
            Question qs = qsTemp;
            Incomplete imcomplete = (Incomplete) qsTemp;
            for (MultipleChoice ch : imcomplete.getQuestions()) {
                Collections.shuffle(ch.getOptions());
            }
            this.getListQuestion().add(qs);
        }
    }

    @Override
    public void exercise() {
        String[] words = this.getListQuestion().get(0).getContent().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println(); // Xuống dòng sau mỗi 20 từ
            }
        }
        System.out.println();
        Question ch = this.getListQuestion().get(0);
        Incomplete qs = (Incomplete) ch;
        int i = 1;
        for (Question multi : qs.getQuestions()) {
            System.out.printf("(%d)  ", i);
            char alphabet = 'A';
            for (Option option : multi.getOptions()) {
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

        int n = 0;

        while (n < qs.getQuestions().size()) {
            System.out.printf("Nhap dap an cau %d: ", n + 1);
            char dapAn = Configuration.SC.nextLine().toUpperCase().charAt(0);
            int ketQuaInt = (int) (dapAn) - 65;
            if (qs.getQuestions().get(n).getOptions().get(ketQuaInt).isAnswer() == true) {
                this.setCorrecAnswer(this.getCorrecAnswer() + 1);

            }
            this.getListAnswer().add(ketQuaInt);
            n++;
        }

    }

    public void show() {
        Question ch = this.getListQuestion().get(0);
        Incomplete imcomplete = (Incomplete) ch;
        System.out.println("------------------Ket Qua Bai Luyen Tap------------------");
        System.out.printf("So dap an dung: %d\n", this.getCorrecAnswer());
        System.out.printf("Diem: %.1f\n", (10.0 / imcomplete.getQuestions().size() * 1.0) * this.getCorrecAnswer());
        int i = 0;
        for (Question qs : imcomplete.getQuestions()) {
            System.out.printf("(%d) ", i + 1);
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
