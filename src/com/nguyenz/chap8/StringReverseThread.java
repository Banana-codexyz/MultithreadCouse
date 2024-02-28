package com.nguyenz.chap8;

import java.util.List;

public class StringReverseThread extends Thread {
    private List<Character> names;
    private String message;

    public StringReverseThread(List<Character> names, String message) {
        this.names = names;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < message.length(); i++) {
            names.add(message.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(names);
    }
}
