package com.example.springdatabasicdemo.enums;

public  enum TransmissionType  {
    MANUAL(0), AUTOMATIC(1);
    private final int  transmissiontype_num;
    private TransmissionType(int number){this.transmissiontype_num=number;}

    public int getNumber(){return transmissiontype_num;}
}

