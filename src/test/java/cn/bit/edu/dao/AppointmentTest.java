package cn.bit.edu.dao;

import cn.bit.edu.BaseTest;
import cn.bit.edu.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentTest extends BaseTest {


    @Autowired
    AppointmentDao appointmentDao;


    @Test
    public void testInsertAppointment(){
        Long bookId = 1001L;
        Long studentId = 1003L;
        int i = appointmentDao.insertAppointment(bookId,studentId);
        System.out.println(i);
    }

    @Test
    public void testQueryAppointment(){
        Long bookId = 1001L;
        Long studentId = 1003L;
        Appointment appointment = appointmentDao.queryAppointment(bookId,studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
