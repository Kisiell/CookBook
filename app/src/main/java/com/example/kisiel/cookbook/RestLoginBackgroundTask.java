package com.example.kisiel.cookbook;

import com.example.kisiel.cookbook.data.EmailAndPassword;
import com.example.kisiel.cookbook.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestLoginBackgroundTask {

    @RootContext
    LoginActivity activity;

    @RestService
    CookbookRestClient restClient;

    @Background
    void login(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            User user = restClient.email(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}