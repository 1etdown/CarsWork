package com.example.springdatabasicdemo.enums;

public  enum Role  {
    User ("Пользователь", 0),
    Admin ("Администратор", 1),
    Moderator ("Модератор", 2);

    private String type;
    private int number;

    Role(String type, int number) {
        this.type = type;
        this.number = number;
    }
}

