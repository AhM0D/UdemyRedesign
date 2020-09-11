package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderCourceInfoItemBinding
import ir.pattern.udemyredesign.databinding.HolderCulumMainBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumMainViewData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData


class CurriculumMainViewHolder(
    itemView: View,
    private val onClickListener: OnClickListener<CurriculumMainViewHolder, CurriculumMainViewData>?
) : BaseViewHolder<CurriculumMainViewData>(itemView) {

    private lateinit var binding: HolderCulumMainBinding
    private var isOpen: Boolean = false
    var position: Int? = null

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderCulumMainBinding) {
            binding = viewDataBinding as HolderCulumMainBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: CurriculumMainViewData) {
        binding.title.text = data.title
        setOnClickListener(itemView, onClickListener, this, data)
        this.position = layoutPosition
    }

    public fun isItemOpen(): Boolean {
        return isOpen
    }

    public fun setIsOpen(boolean: Boolean) {
        if (boolean) {
            binding.moreView.text = "-"
        } else {
            binding.moreView.text = "+"
        }
        this.isOpen = boolean
    }

    companion object {
        private const val TAG = "CourseInfoItemViewHolde"
    }

}