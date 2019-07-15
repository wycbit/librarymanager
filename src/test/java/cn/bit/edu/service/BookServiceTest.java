package cn.bit.edu.service;

import cn.bit.edu.BaseTest;
import cn.bit.edu.dto.AppointmentExecution;
import cn.bit.edu.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceTest extends BaseTest {


    @Autowired
    BookService bookService;

    @Test
    public void testAppoint(){
        long bookId = 1005L;
        long studentId = 1003L;
        AppointmentExecution appointment = bookService.appoint(bookId,studentId);
        System.out.println(appointment);
    }
}
