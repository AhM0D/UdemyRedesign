package ir.pattern.udemyredesign.ui.detail.adapter

import android.view.View
import android.view.ViewGroup
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.*
import ir.pattern.udemyredesign.ui.detail.holder.*
import ir.pattern.udemyredesign.utils.GraphicUtils


class CurriculmAdapter : BaseAdapter() {

    private var dimension: GraphicUtils.Companion.Dimension? = null

    var onCurriculmItemClickListener: BaseViewHolder.OnClickListener<CurriculumMainViewHolder, CurriculumMainViewData>? =
        null

    override fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int,
        view: View
    ): BaseViewHolder<*> {
        var holder: BaseViewHolder<*>? = null
        when (viewType) {
            CurriculumMainViewData.VIEW_TYPE -> {
                holder = CurriculumMainViewHolder(view, onCurriculmItemClickListener)
            }
            CurriculumSecondViewData.VIEW_TYPE -> {
                holder = CurriculumSecondViewHolder(view)
            }
        }
        return holder!!
    }

    fun setDimension(dimension: GraphicUtils.Companion.Dimension) {
        this.dimension = dimension
    }

    fun SetCurriculmItemClickListener(onCurriculmItemClickListener: BaseViewHolder.OnClickListener<CurriculumMainViewHolder, CurriculumMainViewData>) {
        this.onCurriculmItemClickListener = onCurriculmItemClickListener
    }


}