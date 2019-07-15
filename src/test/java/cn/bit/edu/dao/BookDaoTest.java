package cn.bit.edu.dao;

import cn.bit.edu.BaseTest;
import cn.bit.edu.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() {
        Long bookId = 1000L;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll(){
        List<Book> list = bookDao.queryAll(0,3);
        for (Book book:list
             ) {
            System.out.println(book);

        }
    }

    @Test
    public void testReduceNumber(){
        Long bookId = 1002L;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
        int i = bookDao.reduceNumber(bookId);
        Book book1 = bookDao.queryById(bookId);
        System.out.println(i);
        System.out.println(book1);
    }
}
