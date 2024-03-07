/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.practice;

import com.nnt.englishsystem.question.Configuration;
import com.nnt.englishsystem.question.Conversation;
import com.nnt.englishsystem.question.MultipleChoice;
import com.nnt.englishsystem.question.Option;
import com.nnt.englishsystem.question.Question;
import com.nnt.englishsystem.question.QuestionManagenment;
import com.nnt.englishsystem.user.User;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ngoct
 */
public class PraticeConversation extends Practice {

    public PraticeConversation(User user) {
        super(user);
    }

    @Override
    public void listQuestions(QuestionManagenment qlch) {
        QuestionManagenment listConver = new QuestionManagenment();
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
                    .filter(qs -> qs instanceof Conversation && qs.getLevel().getName().equals(finalS) && !this.getUser().hasAnsweredQuestion(qs))
                    .forEach(listConver.getDsQuestions()::add);
            // Các thao tác tiếp theo với listConver ở đây
        } else {
            System.out.println("Muc do khong hop le!");
        }

        if (listConver.getDsQuestions().size() < 1) {
            System.out.println("Het cau hoi!!!!");
        } else if (listConver.getDsQuestions().size() == 1) {

        } else {
            int index = (int) (Math.random() * listConver.getDsQuestions().size());
            Question qsTemp = listConver.getDsQuestions().get(index);
            Question qs = qsTemp;
            Conversation conver = (Conversation) qsTemp;
            for (MultipleChoice ch : conver.getQuestions()) {
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
        Conversation qs = (Conversation) ch;
        qs.getQuestions().forEach(multipleChoice -> {
            System.out.printf("%s\n", multipleChoice.getContent());
            char alphabet = 'A';
            for (Option option : multipleChoice.getOptions()) {
                System.out.printf("%s. %s \n", alphabet, option.getContent());
                alphabet++;
            }

        });
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
        Conversation cv = (Conversation) ch;
        System.out.println("------------------Ket Qua Bai Luyen Tap------------------");
        System.out.printf("So dap an dung: %d\n", this.getCorrecAnswer());
        System.out.printf("Diem: %.1f\n", (10.0 / cv.getQuestions().size() * 1.0) * this.getCorrecAnswer());
        int i = 0;
        for (Question qs : cv.getQuestions()) {
            System.out.printf("%s\n", qs.getContent());
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
