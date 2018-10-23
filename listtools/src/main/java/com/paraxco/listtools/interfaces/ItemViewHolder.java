package com.paraxco.listtools.interfaces;

import android.view.View;

import com.paraxco.listtools.dataItem.DataItemBase;


/**
 *
 */

public interface ItemViewHolder {
    View getView();

    void bindToDataItem(DataItemBase dataItem);
    void recycle();
    DataItemBase getDataItem();
    View findView(int id);

    void onShowed();

    void onHide();
}
