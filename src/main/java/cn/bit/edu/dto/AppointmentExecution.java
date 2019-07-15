package cn.bit.edu.dto;

import cn.bit.edu.entity.Appointment;
import cn.bit.edu.enums.AppointmentEnum;

public class AppointmentExecution {

    private Long bookId;
    private Appointment appointment;
    private int num;
    private String msg;

    public AppointmentExecution() {
    }

    public AppointmentExecution(Long bookId, AppointmentEnum appointmentEnum) {
        this.num = appointmentEnum.getNum();
        this.msg = appointmentEnum.getMsg();
        this.bookId = bookId;
    }

    public AppointmentExecution(Long bookId,AppointmentEnum appointmentEnum,Appointment appointment) {
        this.bookId = bookId;
        this.num = appointmentEnum.getNum();
        this.msg = appointmentEnum.getMsg();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointmentExecution{" +
                "bookId=" + bookId +
                ", appointment=" + appointment +
                ", num=" + num +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
