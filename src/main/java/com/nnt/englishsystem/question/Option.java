/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

/**
 *
 * @author ngoct
 */
public class Option implements Cloneable {

    private String Content;
    private boolean Answer = false;
    private String Note;

    public Option(String Content, String Note) {
        this.Content = Content;
        this.Note = Note;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * @return the Content
     */
    public String getContent() {
        return Content;
    }

    /**
     * @param Content the Content to set
     */
    public void setContent(String Content) {
        this.Content = Content;
    }

    /**
     * @return the Answer
     */
    public boolean isAnswer() {
        return Answer;
    }

    /**
     * @param Answer the Answer to set
     */
    public void setAnswer(boolean Answer) {
        this.Answer = Answer;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

}
