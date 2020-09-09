package ir.pattern.udemyredesign.ui.detail.adapter

import android.view.View
import android.view.ViewGroup
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.TextTitleData
import ir.pattern.udemyredesign.ui.detail.data.VideoViewData
import ir.pattern.udemyredesign.ui.detail.holder.CourseInfoViewHolder
import ir.pattern.udemyredesign.ui.detail.holder.EmptyViewViewHolder
import ir.pattern.udemyredesign.ui.detail.holder.TextTitleViewHolder
import ir.pattern.udemyredesign.ui.detail.holder.VideoViewHolder
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
            VideoViewData.VIEW_TYPE -> {
                holder = VideoViewHolder(view)
            }
            CourseInfoData.VIEW_TYPE -> {
                holder = CourseInfoViewHolder(view)
            }
            TextTitleData.VIEW_TYPE -> {
                holder = TextTitleViewHolder(view)
            }
        }
        return holder!!
    }

    fun setDimension(dimension: GraphicUtils.Companion.Dimension) {
        this.dimension = dimension
    }

}