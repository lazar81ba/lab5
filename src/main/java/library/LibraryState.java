package library;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Startup
public class LibraryState {
    private List<Book> books = new ArrayList<Book>();

    @PostConstruct
    public void setupLibrary(){
        books.addAll(Arrays.asList(
                new Book(0,"Wiedzmin","Sapkowski",false,false),
                new Book(1,"Wladca Pierscieni","Tolkien",false,false),
                new Book(2,"Poczatek","Dan Brown",false,false),
                new Book(3,"Deadpool","Marvel",true,false),
                new Book(4,"Batman","DC",true,false)
        ));
    }

    @Lock(LockType.READ)
    public List<Book> getBooks() {
        return books;
    }
    @Lock(LockType.READ)
    public Book getBook(int bookId) {
        return books.get(bookId);
    }
    @Lock(LockType.READ)
    public List<Book> getNotBorrowedBooks() {
        return books.stream().filter(x->x.isBorrowed()==false).collect(Collectors.toList());
    }
    @Lock(LockType.READ)
    public List<Book> getNotReservedBooks(int id) {
        return books.stream().filter(x->x.isReserved()==false && x.isBorrowed()==false).collect(Collectors.toList());
    }
    @Lock(LockType.READ)
    public List<Book> getReservedBooks(int id) {
        return books.stream().filter(x->x.isReserved()==true).collect(Collectors.toList());
    }

    @Lock(LockType.WRITE)
    public void reserveBook(int bookId ) {
        books.get(bookId).setReserved(true);
    }
    @Lock(LockType.WRITE)
    public void freeBook(int bookId ) {
        books.get(bookId).setReserved(true);
    }
    @Lock(LockType.WRITE)
    public void borrowBook(int bookId ) {
        books.get(bookId).setBorrowed(true);
        if(books.get(bookId).isReserved()==true)
            books.get(bookId).setReserved(false);
    }
    @Lock(LockType.WRITE)
    public void returnBook(int bookId ) {
        books.get(bookId).setBorrowed(false);
    }
}
