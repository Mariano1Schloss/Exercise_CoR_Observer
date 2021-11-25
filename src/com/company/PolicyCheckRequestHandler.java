package com.company;

public class PolicyCheckRequestHandler extends RequestHandler {
    /**
     * Implement a PolicyCheckRequestHandler() that checks that the User has the right to access
     * the requested content. If not it produces the response for the webserver (403), otherwise
     * it passes the request to the next handler()
     * @param request
     */
    public void handleRequest(WebRequest request) {
        if (request.getPath() == "/dashboard" && !request.getLoggedUser().isAdmin()) {
            System.out.println("Status 403 : user is not authorized to access this content");
        } else {
            this.successorHandleRequest(request);
        }
    }
}
