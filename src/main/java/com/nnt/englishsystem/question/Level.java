/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.nnt.englishsystem.question;

/**
 *
 * @author ngoct
 */
public enum Level {
    DIFFICULT("DIFFICULT"),
    MEDIUM("MEDIUM"),
    EASY("EASY");
    private final String name;

    private Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
