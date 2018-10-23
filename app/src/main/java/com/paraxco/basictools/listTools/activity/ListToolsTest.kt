package com.paraxco.basictools.listTools.activity

import android.os.Bundle
import com.paraxco.basictools.R
import com.paraxco.basictools.listTools.model.RecyclerDataItem
import com.paraxco.calendarview.Fragments.CalendarFragments.StringListSlidingMenue
import com.paraxco.commontools.Activities.BaseActivity
import com.paraxco.listtools.adapter.RecyclerView.RecyclerViewDataItemAdapter
import kotlinx.android.synthetic.main.list_tools_test.*

import com.paraxco.listtools.dataItem.DataItemBase


/**
 *
 */

class ListToolsTest : BaseActivity() {
    private val items: MutableList<DataItemBase<Any>>?= mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_tools_test)

        for(i in 1..100)
            items?.add(RecyclerDataItem(this,i))
        var adapter= RecyclerViewDataItemAdapter.initializeLinearRecyclerView(recycler_view,items)

        button.setOnClickListener {

            var stringListSlidingMenue= StringListSlidingMenue()
            stringListSlidingMenue.setTitleList(arrayListOf("item1", "item2", "item3"))

            stringListSlidingMenue.show(supportFragmentManager)
        }
    }
}
