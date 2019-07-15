package cn.bit.edu.service;

import cn.bit.edu.dto.AppointmentExecution;
import cn.bit.edu.entity.Book;

import java.util.List;

public interface BookService {

    public Book getBook(long bookId);

    public List<Book> getList();

    public AppointmentExecution appoint(long bookId,long studentId);

}
