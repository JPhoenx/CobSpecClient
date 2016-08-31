package CobSpecApp;

import HTTPServer.*;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.util.Map;

public class CobSpecRoutesTest extends TestCase {
    public void test_it_can_generate_a_map_of_routes_pointint_at_handlers() throws Exception {
        Request request = new RequestFactory().create(new ByteArrayInputStream("GET / HTTP/1.1\r\n\r\n".getBytes()));
        Map routes = CobSpecRoutes.generate(new Setup(new String[0]), new DataStore());
        Handler handler = (Handler) routes.get("GET");

        Response response = handler.handle(request);

        assertEquals("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n", new String(response.getHeader(), "UTF-8"));
    }
}
