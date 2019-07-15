package cn.bit.edu.service.impl;

import cn.bit.edu.dao.AppointmentDao;
import cn.bit.edu.dao.BookDao;
import cn.bit.edu.dto.AppointmentExecution;
import cn.bit.edu.entity.Appointment;
import cn.bit.edu.entity.Book;
import cn.bit.edu.enums.AppointmentEnum;
import cn.bit.edu.exception.AppointException;
import cn.bit.edu.exception.NoNumberException;
import cn.bit.edu.exception.RepeatAppointException;
import cn.bit.edu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookDao bookDao;

    @Autowired
    AppointmentDao appointmentDao;



    public Book getBook(long bookId) {
        return bookDao.queryById(bookId);
    }


    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }


    @Transactional
    public AppointmentExecution appoint(long bookId, long studentId) {
        try{
            int update = bookDao.reduceNumber(bookId);
            if(update<=0){
                throw new NoNumberException("库存不足");
            }else{
                int insert = appointmentDao.insertAppointment(bookId,studentId);
                if(insert <=0){
                    throw new RepeatAppointException("重复预约");
                }else{
                    Appointment appointment = appointmentDao.queryAppointment(bookId,studentId);
                    return new AppointmentExecution(bookId, AppointmentEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e) {
            throw e;
        }catch (RepeatAppointException e) {
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppointException("服务器内部错误:" + e.getMessage());
        }
    }
}
