package ir.pattern.udemyredesign.ui.detail.holder

import android.view.View
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.VideoViewData
import ir.pattern.udemyredesign.ui.detail.listener.RecyclerItemState


class VideoViewHolder(itemView: View, var onVideoState: RecyclerItemState?) :
    BaseViewHolder<VideoViewData>(itemView) {

    override fun onBindView(data: VideoViewData) {
        // here data.videoUrl or videoImage can use

    }

    override fun onDetach(data: VideoViewData) {
        onVideoState?.onDetach(data)
        super.onDetach(data)
    }

    override fun onAttach(data: VideoViewData) {
        super.onAttach(data)
        onVideoState?.onAttach(data)
    }

}