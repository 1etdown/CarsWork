package com.example.springdatabasicdemo.enums;

public  enum Category  {
    Car(0), Buss(1), Truck(2), Motorcycle(3);
    private final int  category_num;
    private Category(int number){this.category_num=number;}

    public int getNumber(){return category_num;}
}
