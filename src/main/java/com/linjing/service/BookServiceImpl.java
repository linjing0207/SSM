package com.linjing.service;

import com.linjing.dao.BookMapper;
import com.linjing.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {

    //service业务层调dao层
    private BookMapper bookMapper;

    //若用注解，还可以直接注入
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        //若有其他操作，事物，可以直接用spring横切aop来完成。
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
