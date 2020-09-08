package ir.pattern.udemyredesign.ui.base.recycler

import java.io.Serializable

data class RecyclerItem(
    val span: Int,
    val viewType: Int,
    val cumulativeSpan: Int,
    val data: BaseRecyclerData
) : Serializable {

}