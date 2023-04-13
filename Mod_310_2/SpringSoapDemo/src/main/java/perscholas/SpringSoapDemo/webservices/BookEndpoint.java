package perscholas.SpringSoapDemo.webservices;
import com.perscholas.xml.book.GetBookRequest;
import com.perscholas.xml.book.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import perscholas.SpringSoapDemo.dao.BookRepository;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "http://www.perscholas.com/xml/book";
    private BookRepository bookRepository;
    @Autowired
    public BookEndpoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getCountry(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findBookById(request.getId()));
        return response;
    }
}