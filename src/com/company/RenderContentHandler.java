package com.company;

public class RenderContentHandler extends RequestHandler {

    public void handleRequest(WebRequest request) {
        if (request.getPath() == "/dashboard" ) {
            System.out.println("Status 200 : Dashboard content here");
        } else if (request.getPath() == "/home" ){
            System.out.println("Status 200 : Home content here");
        }else {
            this.successorHandleRequest(request);
        }
    }
}
