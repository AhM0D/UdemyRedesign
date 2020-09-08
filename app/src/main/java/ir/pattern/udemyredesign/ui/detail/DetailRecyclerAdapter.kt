package ir.pattern.udemyredesign.ui.detail

import android.view.View
import android.view.ViewGroup
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.holder.EmptyViewViewHolder
import ir.pattern.udemyredesign.utils.GraphicUtils


class DetailRecyclerAdapter : BaseAdapter() {

    private var dimension: GraphicUtils.Companion.Dimension? = null

    override fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int,
        view: View
    ): BaseViewHolder<*> {
        var holder: BaseViewHolder<*>? = null
        when (viewType) {
            EmptyViewData.VIEW_TYPE -> {
                holder = EmptyViewViewHolder(view)
            }
        }
        return holder!!
    }

    fun setDimension(dimension: GraphicUtils.Companion.Dimension) {
        this.dimension = dimension
    }

}