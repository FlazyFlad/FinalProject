package com.kz.narxoz.FinalProject.Service.Implementation;

import com.kz.narxoz.FinalProject.Entity.Book;
import com.kz.narxoz.FinalProject.Repository.BookRepository;
import com.kz.narxoz.FinalProject.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookServiceImplementation implements BookServiceInterface {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> FindAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book deleteBook(Long id) {
        bookRepository.deleteById(id);
        return null;
    }
}
