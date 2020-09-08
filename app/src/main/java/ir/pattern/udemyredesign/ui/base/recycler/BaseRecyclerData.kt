package ir.pattern.udemyredesign.ui.base.recycler

import java.io.Serializable

interface BaseRecyclerData : Serializable {
    fun getViewType(): Int

    fun getSpan(): Int

    fun isFixed(): Boolean

}