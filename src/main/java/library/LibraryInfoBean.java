package library;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
@Remote(LibraryInfo.class)
public class LibraryInfoBean implements LibraryInfo {
    @EJB
    library.LibraryState state;
    @Override
    public String printBook(int bookId) {
        library.Book book = state.getBook(bookId);
        StringBuilder builder= new StringBuilder();
        builder.append("<br/>");
        builder.append(book.getId()+". "+ book.getName()+ " : " +book.getAuthor());
        builder.append("<br/>");
        return builder.toString();
    }

    @Override
    public String printNotBorrowedBooks() {
        List<library.Book> books = state.getNotBorrowedBooks();
        StringBuilder builder= new StringBuilder();
        for(library.Book book : books){
            builder.append("<br/>");
            builder.append(book.getId()+". "+book.getName()+ " : " +book.getAuthor());
            builder.append("<br/>");
        }
        return builder.toString();

    }

    @Override
    public String printNotReservedBooks() {
        List<library.Book> books = state.getNotBorrowedBooks();
        StringBuilder builder= new StringBuilder();
        for(library.Book book : books){
            builder.append("<br/>");
            builder.append(book.getId()+". "+book.getName()+ " : " +book.getAuthor());
            builder.append("<br/>");
        }
        return builder.toString();
    }
}
