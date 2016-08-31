package CobSpecApp;

import HTTPServer.DataStorage;
import HTTPServer.Handler;
import HTTPServer.Setup;

import java.util.HashMap;
import java.util.Map;

public class CobSpecRoutes {
    public static Map<String, Handler> generate(Setup settings, DataStorage dataStore) {
        HashMap<String, Handler> routes = new HashMap();
        routes.put("/form", new FormHandler(settings, dataStore));
        routes.put("GET", new GetHandler(settings, dataStore));
        routes.put("HEAD", new HeadHandler(settings, dataStore));
        routes.put("OPTIONS", new OptionsHandler(settings, dataStore));
        routes.put("POST", new PostHandler(settings, dataStore));
        routes.put("PUT", new PutHandler(settings, dataStore));
        return routes;
    }
}
