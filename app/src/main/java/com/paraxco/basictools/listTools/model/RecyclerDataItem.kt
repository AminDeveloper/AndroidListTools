package com.paraxco.basictools.listTools.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.paraxco.basictools.R
import com.paraxco.listtools.adapter.RecyclerView.RecyclerViewDataItemAdapter
import com.paraxco.listtools.dataItem.DataItemBase

class RecyclerDataItem(val context: Context,var index:Int) : DataItemBase<Any>(R.layout.recycler_item) {

    private val items = mutableListOf<DataItemBase<Any>>()

    override fun initializeView(view: View?) {

        for (i in 1..100)
            items?.add(CustomItem(context, i,index))

        val recyclerView = findView(R.id.recycler_view) as RecyclerView?
        var adapter = RecyclerViewDataItemAdapter.initializeHorrizentalRecyclerView(recyclerView, items)
    }
}
