package cn.bit.edu.enums;

import cn.bit.edu.entity.Appointment;

public enum AppointmentEnum {

    SUCCESS(1,"预约成功"),NO_NUMBER(2,"库存不足"),REPEAT_APPOINT(-1,"重复预约"),INNER_NUMBER(-2,"系统异常");

    private int num;
    private String msg;
    private  AppointmentEnum(int num,String msg){
        this.num = num;
        this.msg= msg;
    }

    public int getNum() {
        return num;
    }

    public String getMsg() {
        return msg;
    }

    public static AppointmentEnum stateOf(int index){
        for (AppointmentEnum appointmentEnum : values()){
            if(appointmentEnum.getNum() == index){
                return appointmentEnum;
            }
        }
        return null;
    }
}
