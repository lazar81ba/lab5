package library;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Hashtable;


@ManagedBean
public class RemoteLibrary implements Serializable {
    @EJB(mappedName = "java:global/lab5/LibraryInfoBean!library.LibraryInfo")
    private LibraryInfo libraryInfo;
    @EJB(mappedName = "java:global/lab5/LibraryBean!library.Library")
    private Library library;
    private final static Hashtable jndiProperties = new Hashtable();


    public RemoteLibrary() throws NamingException{
        jndiProperties.put(Context.URL_PKG_PREFIXES,
                "org.jboss.ejb.client.naming");
        libraryInfo=lookupLibraryInfoEJB();
        library=lookupLibraryEJB();
    }

    public String test(){
        return libraryInfo.printNotBorrowedBooks();
    }

    public LibraryInfo getLibraryInfo() throws NamingException{
        return libraryInfo;
    }

    public void setLibraryInfo(LibraryInfo libraryInfo) {
        this.libraryInfo = libraryInfo;
    }

    public Library getLibrary()throws NamingException {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    private static LibraryInfo lookupLibraryInfoEJB() throws NamingException {
        final Context context = new InitialContext(jndiProperties);
        return (LibraryInfo) context.lookup("java:global/lab5/LibraryInfoBean!library.LibraryInfo");
    }
    private static Library lookupLibraryEJB() throws
            NamingException {
        final Context context = new InitialContext(jndiProperties);
        return (Library) context.lookup("java:global/lab5/LibraryBean!library.Library");
    }


}
