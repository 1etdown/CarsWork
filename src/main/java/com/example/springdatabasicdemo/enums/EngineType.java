package com.example.springdatabasicdemo.enums;

public  enum EngineType  {
    GASOLINE(0), DIESEL(1), ELECTRIC(2), HYBRID(3);
    private final int  enginetype_num;
    private EngineType(int number){this.enginetype_num=number;}

    public int getNumber(){return enginetype_num;}
}
