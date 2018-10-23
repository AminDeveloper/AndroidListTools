package com.paraxco.listtools.holder;

import android.view.View;

import com.paraxco.listtools.interfaces.ListItemClickListener;
import com.paraxco.listtools.dataItem.DataItemBase;
import com.paraxco.listtools.interfaces.ItemViewHolder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class HolderHelper {

    DataItemBase dataItem;
    private Map<Integer, View> foundView = new HashMap<>();


    private void setClickListener(View itemView, final ListItemClickListener clickListener) {
//            View root=itemView.findViewById(R.id.root);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null)
                    clickListener.onSelected(dataItem);
            }
        });
    }

    public void bindToDataItem(ItemViewHolder itemViewHolder, DataItemBase dataItem) {
        this.dataItem = dataItem;
        setClickListener(itemViewHolder.getView(), dataItem.getClickListener());
        this.dataItem.setHolder(itemViewHolder);
    }


    public void recycle() {
        this.dataItem.releaseView();
    }
    public void showed(){
        this.dataItem.onShowItem();
    }
    public void hide(){
        this.dataItem.onHideItem();
    }

    public View findView(int id, View itemView) {
        if (foundView.containsKey(id))
            return foundView.get(id);
        else {
            View found = itemView.findViewById(id);
            foundView.put(id, found);
            return found;
        }
    }
}
