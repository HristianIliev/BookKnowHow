package com.example.hristian.knowhowcom.tags;

import com.example.hristian.knowhowcom.Contracts.ITagsPresenter;
import com.example.hristian.knowhowcom.Contracts.ITagsView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/25/2017.
 */

public class TagsPresenter implements ITagsPresenter {

    private final ITagsView view;

    @Inject
    public TagsPresenter(@Named("tagsView")ITagsView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public ITagsView getView() {
        return this.view;
    }
}
