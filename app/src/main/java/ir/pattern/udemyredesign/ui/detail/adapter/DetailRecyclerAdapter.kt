package ir.pattern.udemyredesign.ui.detail.adapter

import android.view.View
import android.view.ViewGroup
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.*
import ir.pattern.udemyredesign.ui.detail.holder.*
import ir.pattern.udemyredesign.ui.detail.listener.RecyclerItemState
import ir.pattern.udemyredesign.utils.GraphicUtils


class DetailRecyclerAdapter : BaseAdapter() {

    private var dimension: GraphicUtils.Companion.Dimension? = null
    var onVideoViewState: RecyclerItemState? =
        null

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
                holder = VideoViewHolder(view, onVideoViewState)
            }
            CourseInfoData.VIEW_TYPE -> {
                holder = CourseInfoViewHolder(view)
            }
            TextTitleData.VIEW_TYPE -> {
                holder = TextTitleViewHolder(view)
            }
            TextDescriptionData.VIEW_TYPE -> {
                holder = TextDescriptionViewHolder(view)
            }
            PriceViewData.VIEW_TYPE -> {
                holder = PriceViewHolder(view)
            }
            CreatorViewData.VIEW_TYPE -> {
                holder = CreatorViewHolder(view)
            }
            CurriculumViewData.VIEW_TYPE -> {
                holder = CurriculumViewHolder(view)
            }
            CourseDescriptionViewData.VIEW_TYPE -> {
                holder = CourseDescriptionViewHolder(view)
            }
            QuestionAnswerViewData.VIEW_TYPE -> {
                holder = QuestionAnswerViewHolder(view)
            }
        }
        return holder!!
    }

    fun setDimension(dimension: GraphicUtils.Companion.Dimension) {
        this.dimension = dimension
    }

    fun setVideoViewStateListener(onVideoViewState: RecyclerItemState) {
        this.onVideoViewState = onVideoViewState
    }

}