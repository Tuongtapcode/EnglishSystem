/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class Configuration {

    public static final Scanner SC = new Scanner(System.in);
    public static final File f = new File("src/main/resources/newfile");
    public static final Scanner sc;
    public static final String DATE_PATTERN = "dd/MM/yyyy";

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        sc = scanner;
    }

    public static LocalDate convertStringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(Configuration.DATE_PATTERN));
    }

    public static String convertLocalDatetoString(LocalDate lcd) {
        return lcd.format(DateTimeFormatter.ofPattern(Configuration.DATE_PATTERN));
    }

}
