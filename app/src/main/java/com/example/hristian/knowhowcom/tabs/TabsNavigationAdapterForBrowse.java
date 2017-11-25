package com.example.hristian.knowhowcom.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hristian.knowhowcom.Contracts.ICategoriesPresenter;
import com.example.hristian.knowhowcom.Contracts.IPostsPresenter;
import com.example.hristian.knowhowcom.Contracts.ITagsPresenter;
import com.example.hristian.knowhowcom.Contracts.IUsersPresenter;

/**
 * Created by Hristian on 11/25/2017.
 */

public class TabsNavigationAdapterForBrowse extends FragmentStatePagerAdapter{
    private final IPostsPresenter postsPresenter;
    private final ICategoriesPresenter categoriesPresenter;
    private final ITagsPresenter tagsPresenter;
    private final IUsersPresenter usersPresenter;

    public TabsNavigationAdapterForBrowse(FragmentManager supportFragmentManager,
                                          IPostsPresenter postsPresenter,
                                          ICategoriesPresenter categoriesPresenter,
                                          ITagsPresenter tagsPresenter,
                                          IUsersPresenter usersPresenter) {
        super(supportFragmentManager);

        this.postsPresenter = postsPresenter;
        this.categoriesPresenter = categoriesPresenter;
        this.tagsPresenter = tagsPresenter;
        this.usersPresenter = usersPresenter;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return (Fragment)this.postsPresenter.getView();
            case 1:
                return (Fragment)this.categoriesPresenter.getView();
            case 2:
                return (Fragment)this.tagsPresenter.getView();
            case 3:
                return (Fragment)this.usersPresenter.getView();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence pageTitle = "";

        switch(position){
            case 0:
                pageTitle = "Posts";
                break;
            case 1:
                pageTitle = "Categories";
                break;
            case 2:
                pageTitle = "Tags";
                break;
            case 3:
                pageTitle = "Users";
                break;
        }

        return pageTitle;
    }
}
