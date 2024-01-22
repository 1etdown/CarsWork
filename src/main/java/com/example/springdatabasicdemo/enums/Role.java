package com.example.springdatabasicdemo.enums;

public  enum Role  {
    User ("user", 0),
    Admin ("admin", 1),
    Moderator ("moder", 2);

    private String type;
    private int number;

    Role(String type, int number) {
        this.type = type;
        this.number = number;
    }
}

