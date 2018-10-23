package com.paraxco.listtools.helper

import android.os.Build
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.paraxco.commontools.Activities.BaseActivity
import com.paraxco.commontools.Observers.RetryHelper
import com.paraxco.listtools.R
import java.util.*


/**
 *
 * if noServiceCall =true null will be received in getListOfModels()
 */

abstract class SpinnerListHelper<MODEL>(var baseActivity: BaseActivity, private val spinner: Spinner, var autoInit: Boolean = true, val noServiceCall: Boolean = false) {

    private var itemss: MutableList<MODEL>? = null
    var selectedItem: MODEL? = null
        private set
    private var selectedItemPosition = 0
    protected abstract val defaultItem: MODEL?
    protected abstract var isWhiteTextColor: Boolean
    var selectionListener: ((MODEL?) -> Unit)? = null

    init {
        if (autoInit)
            init()
    }

    var retryHelper: RetryHelper? = null

    fun init() {
        selectedItemPosition = 0
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (itemss != null) {
                    selectedItem = itemss!![position]
                    selectedItemPosition = position
                    ItemSelected(selectedItem)
                    selectionListener?.invoke(selectedItem)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        if (!noServiceCall)
            retryHelper = RetryHelper.getInstanceAndCall(baseActivity, {
                loadServers()
            })
        else {
            fillList()
        }
    }

    protected abstract fun CallService()
    abstract fun ItemSelected(selectedItem: MODEL?)
    protected abstract fun getListOfModels(result: Any?): List<MODEL>

    private fun loadServers() {
        SpinerAdapterHelper.initSpinner(baseActivity, spinner, baseActivity.getString(R.string.loading))
        spinner.isEnabled = false
        itemss = null
    }
    /**
     * it should be called after unSuccessful service call
     */
    fun serviceError(e: Throwable?=null) {
        if (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    !baseActivity.isDestroyed
                } else {
                    true
                })
            retryHelper?.retry()

//                spinner.postDelayed({
//                    if (!baseActivity.isDestroyed)
//                        loadServers()
//                }, 3000)
    }

    fun disableListener() {
        spinner.onItemSelectedListener = null
    }

    /**
     * it should be called after successful service call
     */
     fun fillList(result: Any?=null) {
        fillServerList(getListOfModels(result))
        SpinerAdapterHelper.initSpinner(baseActivity, spinner, itemss!!, isWhiteTextColor)
        spinner.isEnabled = true
        spinner.setSelection(selectedItemPosition)
        retryHelper?.finished()

    }

    private fun fillServerList(list: List<MODEL>) {
        val currentItem = defaultItem

        var position = 0
        itemss = LinkedList()

        for (item in list) {
            if (item == currentItem) {
                selectedItem = item
                selectedItemPosition = position
            }
            position++
            itemss!!.add(item)
        }
    }
}
