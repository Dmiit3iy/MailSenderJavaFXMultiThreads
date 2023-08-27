package org.dmiit3iy.service;

import org.dmiit3iy.model.Mail;
import org.dmiit3iy.util.Constants;
import org.dmiit3iy.util.MailSender;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class MailService {
    private LinkedBlockingQueue<Mail> messages = new LinkedBlockingQueue<>();

    private Thread threadSend = new Thread(() -> {
       try {
            while (true) {
                Mail mail = messages.take();
                ArrayList<String> recipients = mail.getRecipients();
                for (String x : recipients) {
                    Thread thread = new Thread(() -> {
                        MailSender mailSender = new MailSender(Constants.EMAIL, Constants.EMAIL_PASSWORD, x);
                        mailSender.send(mail.getTitle(), mail.getMessage());
                    });
                    thread.start();
                }
            }
        } catch (InterruptedException ex) {
           System.out.println("Thread has been interrupted");
        }
    });

    public MailService() {
        this.threadSend.start();
    }

    public void add(Mail mail) {
        //TODO добавить в блок очередь новое сообщение
        messages.add(mail);
    }

    public void stop(){
        this.threadSend.interrupt();
    }
}
