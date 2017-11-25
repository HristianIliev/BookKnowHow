package com.example.hristian.knowhowcom.posts;

import com.example.hristian.knowhowcom.Contracts.IPostsPresenter;
import com.example.hristian.knowhowcom.Contracts.IPostsView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/25/2017.
 */

public class PostsPresenter implements IPostsPresenter {

    private IPostsView view;

    @Inject
    public PostsPresenter(@Named("postsView") IPostsView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public IPostsView getView() {
        return this.view;
    }
}
