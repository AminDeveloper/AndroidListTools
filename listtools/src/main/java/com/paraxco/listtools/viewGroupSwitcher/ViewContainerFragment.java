package com.paraxco.listtools.viewGroupSwitcher;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paraxco.commontools.Fragment.BaseFragment;
import com.paraxco.commontools.Utils.SmartLogger;

/**
 *
 */
public abstract class ViewContainerFragment extends BaseFragment implements ViewGroupSwitcher.ViewContainer {
    View view;

    @Nullable
//    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        SmartLogger.Companion.logDebug(String.valueOf(getViewRes()));
        return inflater.inflate(getViewRes(), container, false);
    }


    @Override
    public void setView(View view) {
        this.view = view;
        SmartLogger.Companion.logDebug("");
        onViewCreated(view, null);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        SmartLogger.Companion.logDebug(String.valueOf(view == null));

        if (view == null && isAttached())
            return super.getView();
        else
            return view;
    }

    @Override
    public int getViewRes() {
        return 0;//implement it if you want ViewContainer
    }

    @Override
    public void onShowingView() {
        onPageShow();
    }

    //    @Override
    public void onPageShow() {

    }

    @Override
    public void onHidingView() {

    }

    @Override
    public Context getContext() {
        if (view == null)
            return super.getContext();
        else return view.getContext();
    }

    public Resources getViewResources() {

        return getContext().getResources();
    }

}
