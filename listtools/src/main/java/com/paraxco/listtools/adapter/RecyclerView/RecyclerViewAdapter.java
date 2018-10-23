package com.paraxco.listtools.adapter.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.paraxco.listtools.adapter.AdapterHelper;
import com.paraxco.listtools.dataItem.DataItemBase;
import com.paraxco.listtools.holder.RecyclerViewClickableHolder;
import com.paraxco.listtools.interfaces.ItemViewHolder;

import java.util.List;

/**
 *
 */
public abstract class RecyclerViewAdapter<DATA_ITEM_TYPE extends DataItemBase, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    AdapterHelper<DATA_ITEM_TYPE> adapterHelper;

    public RecyclerViewAdapter(Context context, List<DATA_ITEM_TYPE> items) {
        adapterHelper = new AdapterHelper<>(context, items);
    }

    @Override
    public int getItemViewType(int position) {
        return adapterHelper.getItemViewType(position);
    }

//    public int getTypeResource(int viewType) {
//        return adapterHelper.getTypeResource(viewType);
//    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = adapterHelper.getView(viewGroup, viewType);
        VH viewHolder = getViewHolder(view);
        return viewHolder;
    }

    public void setItems(List<DATA_ITEM_TYPE> items) {
        adapterHelper.setItems(items);
    }

    public DATA_ITEM_TYPE getItem(int position) {
        return adapterHelper.getItem(position);
    }

    protected VH getViewHolder(View view) {
        return (VH) new RecyclerViewClickableHolder(view);
    }
//    protected abstract void bindToViewHolder(DATA_ITEM_TYPE dataItem, VH holder);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        adapterHelper.bindToViewHolder((ItemViewHolder) holder, position);
    }

    @Override
    public long getItemId(int position)  {
        return adapterHelper.getItemId(position);//for hasStableIds method
    }

    @Override
    public int getItemCount() {
        return adapterHelper.getItemCount();
    }

    protected int getIndexOf(DATA_ITEM_TYPE dataItem) {
        return adapterHelper.getIndexOf(dataItem);
    }

    @Override
    public void onViewRecycled(VH holder) {
        super.onViewRecycled(holder);
        adapterHelper.recycleViewHolder((ItemViewHolder) holder);
    }

    @Override
    public void onViewAttachedToWindow(VH holder) {
        super.onViewAttachedToWindow(holder);
        adapterHelper.onViewHolderShowed((ItemViewHolder) holder);

    }

    @Override
    public void onViewDetachedFromWindow(VH holder) {
        super.onViewDetachedFromWindow(holder);
        adapterHelper.onViewHolderHide((ItemViewHolder) holder);

    }

    public void clearItems() {
        adapterHelper.clearItems();
        notifyDataSetChanged();
    }
}