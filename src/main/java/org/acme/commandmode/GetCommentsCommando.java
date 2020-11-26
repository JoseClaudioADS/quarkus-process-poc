package org.acme.commandmode;

import javax.inject.Inject;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class GetCommentsCommando implements QuarkusApplication {

    @Inject
    GetCommentsService getCommentsService;

    @Override
    public int run(String... args) throws Exception {
        getCommentsService.execute();
        System.exit(0);
        return 0;
    }
}
