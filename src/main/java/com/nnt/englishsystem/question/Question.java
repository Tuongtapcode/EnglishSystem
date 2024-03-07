/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.englishsystem.question;

import com.nnt.englishsystem.question.Level;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public abstract class Question implements Cloneable {

    private Category category;
    private List<Option> options = new ArrayList<>();
    private Level level;
    private String content;

    public Question() {
    }

    @Override
    public Question clone() {
        try {
            Question clonedQuestion = (Question) super.clone();
            // Cloning mutable fields
            clonedQuestion.category = (Category) this.category.clone();
            clonedQuestion.options = new ArrayList<>(this.options);
            clonedQuestion.level = this.level; // Level là enum nên không cần sao chép
            clonedQuestion.content = this.content; // String là immutable nên không cần sao chép
            return clonedQuestion;
        } catch (CloneNotSupportedException e) {
            // This should never happen
            throw new AssertionError();
        }
    }

    public Question(Category category, Level level, String content, List<Option> options) {
        this.category = category;
        this.level = level;
        this.content = content;
        this.options = options;
    }

    public Question(Question qs) {
        this.category = qs.category;
        this.level = qs.level;
        this.content = qs.content;
        this.options = qs.options;
    }

    public abstract void show();

    public abstract Question docFile();

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the options
     */
    public List<Option> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
