package com.example.kisiel.cookbook;

import com.example.kisiel.cookbook.data.CookBook;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestBackgroundTask {

    @RootContext
    ListaActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void getCookBook() {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            CookBook cookBook = restClient.getCookBook();
            publishResult(cookBook);

        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(CookBook cookBook) {
        activity.updateCookbook(cookBook);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
