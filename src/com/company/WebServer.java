package com.company;

import java.util.ArrayList;

public class WebServer implements WebRequestObservable {
    RequestHandler firstHandler;
    //registers observers on the web server
    private ArrayList<WebRequestObserver> observers = new ArrayList();

    //register every webrequest made to the server
    private ArrayList<WebRequest> allRquests = new ArrayList<WebRequest>();

    //Setter
    public void setFirstHandler(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    //We notify the request to the observers and send it to the first handler
    public void getRequest(WebRequest request) {
        this.firstHandler.handleRequest(request);
        this.notifyObservers(request);
    }

    public void attach(WebRequestObserver observer) {
        this.observers.add(observer);
    }
    public void detach(WebRequestObserver observer) {
        this.observers.remove(observer);
    }
    //any web request made to the web server should notify all
    // the registered observers with the WebRequest object + we add the request to allRequests
    public void notifyObservers(WebRequest request) {
        for (WebRequestObserver observer : observers) {
            observer.update(request);
        }
        this.allRquests.add(request);
    }



}
