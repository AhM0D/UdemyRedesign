package ir.pattern.udemyredesign.ui.detail.data

import ir.pattern.udemyredesign.data.VideoData
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData


class VideoViewData constructor(var videoData: VideoData) : BaseRecyclerData {

    companion object {
        val VIEW_TYPE: Int = ir.pattern.udemyredesign.R.layout.holder_video_view
    }

    override fun getViewType(): Int {
        return VIEW_TYPE
    }

    override fun getSpan(): Int {
        return BaseAdapter.MAX_SPAN
    }

    override fun isFixed(): Boolean {
        return false
    }

}