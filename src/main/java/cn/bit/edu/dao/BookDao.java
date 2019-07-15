package cn.bit.edu.dao;

import cn.bit.edu.entity.Book;

import java.util.List;

public interface BookDao {
    public Book queryById(Long bookId);
    public List<Book> queryAll(Integer offset,Integer limit);
    public int reduceNumber(Long bookId);
}
