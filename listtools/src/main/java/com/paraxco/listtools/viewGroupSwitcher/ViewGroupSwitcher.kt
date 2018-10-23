package com.paraxco.listtools.viewGroupSwitcher

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paraxco.commontools.Utils.SmartLogger


/**
 *
 */
class ViewGroupSwitcher(var viewGroup: ViewGroup) {
    private val viewList = mutableListOf<ViewContainer>()
    var currentItem: Int? = null

    private var inflator: LayoutInflater? = null
    var onPageChangeListener: ViewPager.OnPageChangeListener? = null
    fun addView(view: ViewContainer): Int {
        viewList.add(view)
        return viewList.size - 1
    }

    fun showView(position: Int) {
        SmartLogger.logDebug("position = " + position)
        System.out.println("showView ==> position = " + position)

        currentItem?.let {
            viewList[currentItem!!].onHidingView()
        }
        viewGroup.removeAllViews()
//       var progressBar= ProgressBar(viewGroup.context)
//        progressBar.isIndeterminate=true
////        progressBar.layoutParams=Lay
//        viewGroup.addView(progressBar,0,ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT))
        viewGroup.addView(getView(position), ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT))
//        viewGroup.removeViewAt(0)
        currentItem = position
        viewList[position].onShowingView()
        onPageChangeListener?.onPageSelected(position)

    }

    private fun getView(position: Int): View? {
        if (viewList[position].getView() == null) {
            SmartLogger.logDebug("view was null")
            if (inflator == null)
                inflator = viewGroup.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            viewList[position].setView((inflator?.inflate(viewList[position].getViewRes(), viewGroup, false)))
        }
//        else{
//            viewList[position].setView(viewList[position].getView())
//        }
        SmartLogger.logDebug("view was not null")

        return viewList[position].getView()
    }

    fun addOnPageChangeListener(onPageChangeListener: ViewPager.OnPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener
    }

    fun getItem(position: Int): ViewContainer {
        return viewList.get(position)
    }

    /**
     * fragments can act as view in view adapters by implementing this interface
     */
    interface ViewContainer {
        /**
         * will be called by adapter with recycled view
         */
        fun setView(view: View?)

        /**
         * will be called when  View is about to hide
         */
        fun onHidingView()

        fun getView(): View?
        /**
         * will be called when  View is about to show
         */
        fun onShowingView()

        /**
         * @return requested view res
         */
        fun getViewRes(): Int
    }


}