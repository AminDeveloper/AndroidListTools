package com.paraxco.listtools.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.paraxco.listtools.dataItem.DataItemBase;
import com.paraxco.listtools.interfaces.ItemViewHolder;


/**
 *
 */

public class RecyclerViewClickableHolder extends RecyclerView.ViewHolder implements ItemViewHolder {
    HolderHelper holderHelper=new HolderHelper();

    public RecyclerViewClickableHolder(View itemView) {
        super(itemView);
    }


    public View getView() {
        return itemView;
    }

    @Override
    public void bindToDataItem(DataItemBase dataItem) {
        holderHelper.bindToDataItem(this, dataItem);
    }

    @Override
    public void recycle() {
        holderHelper.recycle();
    }
    @Override
    public void onShowed() {
        holderHelper.showed();
    }

    @Override
    public void onHide() {
        holderHelper.hide();

    }
    @Override
    public DataItemBase getDataItem() {
        return holderHelper.dataItem;
    }

    @Override
    public View findView(int id) {
        return holderHelper.findView(id,getView());
    }



}

