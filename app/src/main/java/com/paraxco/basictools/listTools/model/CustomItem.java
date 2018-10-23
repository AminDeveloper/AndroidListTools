package com.paraxco.basictools.listTools.model;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.paraxco.basictools.R;
import com.paraxco.commontools.Utils.SmartLogger;
import com.paraxco.listtools.dataItem.DataItemBase;

/**
 *
 */
public class CustomItem extends DataItemBase {
    private int parentIndex;
    int i = 0;
    Context context;

    public CustomItem(Context context, int i) {
        super(R.layout.item_layout);
        this.i = i;
        this.context = context;
    }
    public CustomItem(Context context, int i,int parentIndex) {
        super(R.layout.item_layout);
        this.i = i;
        this.parentIndex=parentIndex;
        this.context = context;
    }

    @Override
    public void initializeView(View view) {
        TextView title = (TextView) findView(R.id.title);
//      Toast.makeText(context,"initializeView "+i,Toast.LENGTH_SHORT).show();
        title.setText("item :"+parentIndex+"-"+i);
        SmartLogger.logDebug("item :"+parentIndex+","+i);
    }

    @Override
    public void releaseView() {
        super.releaseView();
//        Toast.makeText(context,"releaseView "+i,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHideItem() {
        super.onHideItem();
//        Toast.makeText(context, "onHideItem " + i, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onShowItem() {
        super.onShowItem();
//        Toast.makeText(context, "onShowItem " + i, Toast.LENGTH_SHORT).show();

    }
}
