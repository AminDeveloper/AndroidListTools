package com.paraxco.listtools.adapter.viewPager;

import android.support.v4.view.ViewPager;


import com.paraxco.listtools.dataItem.DataItemBase;
import com.paraxco.listtools.holder.ViewPagerClickableHolder;

import java.util.List;

/**
 *
 */

public class ViewPagerDataItemAdapter<DATA_ITEM_TYPE extends DataItemBase> extends ViewPagerAdapter<DATA_ITEM_TYPE, ViewPagerClickableHolder> {

    private final ViewPager viewPager;

    public ViewPagerDataItemAdapter(ViewPager viewPager, List<DATA_ITEM_TYPE> items) {
        super(viewPager.getContext(), items);
        this.viewPager = viewPager;
        this.viewPager.setAdapter(this);
    }

    public static ViewPagerDataItemAdapter initializeViewPager(ViewPager viewPager, List<? extends DataItemBase> items) {

        // specify an adapter (see also next example)
        ViewPagerDataItemAdapter mAdapter = new ViewPagerDataItemAdapter<>(viewPager, items);

        mAdapter.notifyDataSetChanged();
        return mAdapter;
    }

}

