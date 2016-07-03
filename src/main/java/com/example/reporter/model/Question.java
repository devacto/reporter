package com.example.reporter.model;

import com.google.common.base.MoreObjects;

public class Question {

    private final String theme;

    private final Type type;

    private final String text;

    public enum Type {
        RATING, SINGLE_SELECT
    }

    public Question(String theme, Type type, String text) {
        this.theme = theme;
        this.type = type;
        this.text = text;
    }

    public String getTheme() {
        return theme;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return MoreObjects
                .toStringHelper(this)
                .add("theme", theme)
                .add("type", type.toString())
                .add("text", text)
                .toString();
    }
}
