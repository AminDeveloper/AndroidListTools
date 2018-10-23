package com.paraxco.listtools.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.ListPopupWindow
import android.support.v7.widget.RecyclerView
import android.view.*
import com.paraxco.listtools.adapter.RecyclerView.RecyclerViewDataItemAdapter
import com.paraxco.listtools.dataItem.DataItemBase
import com.paraxco.listtools.R

/**
 *
 */
 open class SlidingDialogMenu : DialogFragment() {
    val items = java.util.LinkedList<DataItemBase<*>>()

    private var recyclerView: RecyclerView? = null

    private var adapter: RecyclerViewDataItemAdapter<DataItemBase<*>>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.simple_list, container, false)
        recyclerView = view.findViewById(R.id.list)
        fillItems()
        adapter = RecyclerViewDataItemAdapter.initializeLinearRecyclerView(recyclerView, items) as RecyclerViewDataItemAdapter<DataItemBase<*>>?

        return view
    }

    //fill items to be shown in menu
    protected open fun fillItems(){

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        // request a window without the title
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog.getWindow()
        val wlp = window.getAttributes()

        wlp.gravity = Gravity.BOTTOM
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
        wlp.width = ListPopupWindow.MATCH_PARENT
        window.setAttributes(wlp)

        return dialog
    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog
        if (dialog != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.BOTTOM)
        }
    }


    override fun getTheme(): Int {
        return R.style.DialogSlideAnim
    }

//    companion object {
//        fun show(menuItems: java.util.ArrayList<String>,fm: FragmentManager) {
//            val data = Bundle()
//            data.putStringArrayList(Tag.ITEMS, menuItems)
//            val slidingMenuDialog = SlidingDialogMenu()
//            slidingMenuDialog.arguments = data
//            slidingMenuDialog.show(fm, "gallery Fragment")
//        }
//    }

//

    fun show(supportFragmentManager: FragmentManager?) {

//        val data = Bundle()
//        data.putStringArrayList(Tag.ITEMS, menuItems)
//        val slidingMenuDialog = SlidingDialogMenu()
//        slidingMenuDialog.arguments = data
        show(supportFragmentManager, "gallery Fragment")

    }
}