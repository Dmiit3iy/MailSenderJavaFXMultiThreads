package org.dmiit3iy.model;

import java.util.ArrayList;

public class Mail {
    private String title;
    private String message;
    private ArrayList<String> recipients;

    public Mail(String title, String message, ArrayList<String> recipients) {
        this.title = title;
        this.message = message;
        this.recipients = recipients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    }
}
