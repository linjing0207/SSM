package com.linjing.controller;

import com.linjing.pojo.Books;
import com.linjing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller @RequestMapping("/book") public class BookController {

    @Autowired @Qualifier("bookServiceImpl") private BookService bookService;

    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list", list);
        return "allBooks";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage() {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books book) {
        System.out.println("add book:" + book);
        bookService.addBook(book);
        return "redirect:/book/allBooks"; //重定向到我们@RequestMapping("/allBooks")请求
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpDatePage(int id, Model model) {
        System.out.println(id);
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    //跳转到修改书籍页面
    @RequestMapping("/updateBook")
    public String updatePage(Books book) {
        bookService.updateBook(book);
        ///book/allBooks:链接自带查询功能
        return "redirect:/book/allBooks";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBooks";
    }

    //查询书籍
    @RequestMapping("queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books book = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        if (book == null) {
            list = bookService.queryAllBooks();
            model.addAttribute("error", "未查到相关书籍");
        } else {
            list.add(book);
        }
        model.addAttribute("list", list);
        return "allBooks";
    }
}
