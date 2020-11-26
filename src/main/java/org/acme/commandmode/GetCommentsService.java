package org.acme.commandmode;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
public class GetCommentsService {

    @Inject
    @RestClient
    ApiService apiService;

    @Transactional
    public void execute () {
        apiService.getComments().forEach(comment -> {
            new Comment(comment.name, comment.email, comment.body).persist();
        });
        System.out.println("There are " + Comment.count() + " comments created");
    }
}
