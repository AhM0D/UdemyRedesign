package ir.pattern.udemyredesign.ui.detail.listener

import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.detail.data.VideoViewData

interface RecyclerItemState {
    fun onDetach(data: BaseRecyclerData)
    fun onAttach(data: BaseRecyclerData)
}