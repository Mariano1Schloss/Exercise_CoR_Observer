package com.company;

public  abstract class RequestHandler {
    protected RequestHandler successor;

    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(WebRequest request);

    protected void successorHandleRequest(WebRequest request) {
        if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }
}
