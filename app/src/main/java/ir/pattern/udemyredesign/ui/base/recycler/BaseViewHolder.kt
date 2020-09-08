package ir.pattern.udemyredesign.ui.base.recycler

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T : BaseRecyclerData>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    interface OnClickListener<V : BaseViewHolder<*>, T> {
        fun onClick(view: View, viewHolder: V, recyclerData: T)
    }

    interface OnLongClickListener<V : BaseViewHolder<*>, T> {
        fun onLongClick(view: View?, viewHolder: V, recyclerData: T)
    }

    open fun <V : BaseViewHolder<*>, K> setOnClickListener(
        view: View,
        onClickListener: OnClickListener<V, K>?,
        viewHolder: V,
        recyclerData: K
    ) {
        if (onClickListener != null) {
            view.setOnClickListener(getOnClickListener(onClickListener, viewHolder, recyclerData))
        }
    }

    protected open fun <V : BaseViewHolder<*>, K> getOnClickListener(
        onClickListener: OnClickListener<V, K>,
        viewHolder: V,
        recyclerData: K
    ): View.OnClickListener? {
        return View.OnClickListener { v -> onClickListener.onClick(v, viewHolder, recyclerData) }
    }

    open fun <V : BaseViewHolder<*>?, K> setOnLongClickListener(
        view: View,
        onLongClickListener: OnLongClickListener<BaseViewHolder<*>, K>?,
        viewHolder: BaseViewHolder<*>,
        recyclerData: K
    ) {
        if (onLongClickListener != null) {
            view.setOnLongClickListener(
                getOnLongClickListener(
                    onLongClickListener, viewHolder,
                    recyclerData
                )
            )
        }
    }

    protected open fun <V : BaseViewHolder<*>, K> getOnLongClickListener(
        onLongClickListener: OnLongClickListener<V, K>,
        viewHolder: V,
        recyclerData: K
    ): View.OnLongClickListener? {
        return View.OnLongClickListener { v ->
            onLongClickListener.onLongClick(v, viewHolder, recyclerData)
            true
        }
    }

    var itemTouchHelper: ItemTouchHelper? = null
    lateinit var viewDataBinding: ViewDataBinding


    abstract fun onBindView(data: T)

    open fun onDetach(data: T) {}

    open fun onAttach(data: T) {}

    override fun toString(): String {
        return super.toString() + javaClass
    }

    open fun isMovable(): Boolean {
        return false
    }

    open fun isDragChangeBackground(): Boolean {
        return false
    }

    open fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        this.viewDataBinding = viewDataBinding
    }
}