package com.linjing.service;

import com.linjing.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBooks();

    //根据名字查询书本
    Books queryBookByName(String bookName);
}
