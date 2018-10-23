package com.paraxco.listtools.dataItem;

import android.view.View;

import com.paraxco.listtools.interfaces.ItemViewHolder;
import com.paraxco.listtools.interfaces.ListItemClickListener;


/**
 * item of a row which contains Data needed for it
 */

public abstract class DataItemBase<DATA_TYPE> {
    DATA_TYPE data;
    ItemViewHolder holder;

    private ListItemClickListener clickListener;
    int layoutResourceID;

    public DataItemBase(int layoutResourceID) {
        this.layoutResourceID = layoutResourceID;
    }

    /**
     * initialize inflated view
     *
     * @param view
     */
    public abstract void initializeView(View view);

    public void releaseView() {

    }

    public void onShowItem() {

    }

    public void onHideItem() {

    }

    /**
     * set hasStableIds to true in recycler view and implement this method
     * @return item Id or -1 for no Id
     */
    public  long getItemId() {
        return -1;
    }


    public View getView() {
        if (holder != null)
            return holder.getView();
        else
            return null;
    }

    public View findView(int id) {
        return holder.findView(id);

    }

    public ListItemClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ListItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setLongClickListener(ListItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public DATA_TYPE getData() {
        return data;
    }

    public void setData(DATA_TYPE data) {
        this.data = data;
    }

    public ItemViewHolder getHolder() {
        return holder;
    }

    public void setHolder(ItemViewHolder holder) {
        this.holder = holder;
        initializeView(holder.getView());
    }

    public int getLayoutResourceID() {
        return layoutResourceID;
    }

}
