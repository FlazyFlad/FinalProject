package com.kz.narxoz.FinalProject.Service;

import com.kz.narxoz.FinalProject.Entity.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> FindAllBooks();
    Book saveBook(Book book);
    Book findById(Long id);
    Book deleteBook(Long id);
}
