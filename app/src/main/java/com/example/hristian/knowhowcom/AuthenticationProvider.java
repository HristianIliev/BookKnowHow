package com.example.hristian.knowhowcom;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

/**
 * Created by Hristian on 11/19/2017.
 */

public class AuthenticationProvider {

    @Inject
    public AuthenticationProvider(){

    }

    public Observable<Boolean> authenticate(String email, String password, String url){
        //uncomment when you get the real URL
        return Observable.create((ObservableEmitter<Boolean> e) ->{
//            OkHttpClient client = new OkHttpClient();
//
//            Request request = new Request.Builder()
//                    .url(url + email + password)
//                    .build();
//
//            Response response = client.newCall(request).execute();
//
//            String json = response.body().string();
//
//            Gson gson = new Gson();
//
//            Type stringType = new TypeToken<String>(){}.getType();
//            boolean result = gson.fromJson(json, stringType);

        //should return result
            e.onNext(true);
        });
    }

    public boolean isEmailValid(String email){
        return email.contains("@");
    }

    public boolean isPasswordValid(String password){
        return password.length() > 4;
    }
}
