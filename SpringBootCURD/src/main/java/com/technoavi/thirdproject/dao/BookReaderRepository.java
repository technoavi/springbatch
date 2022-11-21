package com.technoavi.thirdproject.dao;

import com.technoavi.thirdproject.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookReaderRepository {
    private List<Book> books = new ArrayList<Book>();

    public Book storeBook(Book book) {
        Book b = new Book();
        b.setId(book.getId());
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setGenre(book.getGenre());
        books.add(b);
        return b;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public String deleteBook(int id) {
        // Book b = new Book();//empty obj
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                //  b=books.get(i);
                //  books.remove(books.get(i));
                books.remove(i);
                return "id :" + id + " is deleted !!";
            }
        }

        return "Id :" + id + " not found!!";


    }

    public Book getById(int id) {
        Book b;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                b = books.get(i);
                return b;
            }
        }
        return null;
    }

    public Book updateBook(Book book) {
        Book b=null;
     if(getById(Math.toIntExact(book.getId()))!=null ) {

         b=getById(Math.toIntExact(book.getId()));
         b.setId(book.getId());
               b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
                b.setGenre(book.getGenre());
         return b;
     }
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).getId()==(book.getId())) {
//
//               // book= new Book();
//                b=books.get(i);
//                b.setId(book.getId());
//               b.setAuthor(book.getAuthor());
//                b.setTitle(book.getTitle());
//                b.setGenre(book.getGenre());
//              //  books.add(b);
//                return b;
//
//            }
//        }

        return null;
    }

    public Book upadteBookById(Book book, int id) {
        Book b=null;
        if(getById(id)!=null ) {

            b=getById(id);
            b.setId(book.getId());
            b.setAuthor(book.getAuthor());
         //   b.setTitle(book.getTitle());
        //    b.setGenre(book.getGenre());
            return b;
        }

        return null;
    }

    public Book upTitle(String title, int id) {
        Book b=null;
        if(getById(id)!=null ) {

            b=getById(id);
            b.setId((long) id);

               b.setTitle(title);
            //    b.setGenre(book.getGenre());
            return b;
        }

        return null;
    }
}