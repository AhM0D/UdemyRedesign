package ir.pattern.udemyredesign.ui.detail.adapter

import android.view.View
import android.view.ViewGroup
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.VideoViewData
import ir.pattern.udemyredesign.ui.detail.holder.CourseInfoItemViewHolder
import ir.pattern.udemyredesign.ui.detail.holder.EmptyViewViewHolder
import ir.pattern.udemyredesign.ui.detail.holder.VideoViewHolder
import ir.pattern.udemyredesign.utils.GraphicUtils


class CourseInfoAdapter : BaseAdapter() {

    private var dimension: GraphicUtils.Companion.Dimension? = null

    override fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int,
        view: View
    ): BaseViewHolder<*> {
        var holder: BaseViewHolder<*>? = null
        when (viewType) {
            CourseInfoItemData.VIEW_TYPE -> {
                holder = CourseInfoItemViewHolder(view)
            }
        }
        return holder!!
    }

    fun setDimension(dimension: GraphicUtils.Companion.Dimension) {
        this.dimension = dimension
    }

}