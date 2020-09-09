package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderCourceInfoItemBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData


class CourseInfoItemViewHolder(itemView: View) : BaseViewHolder<CourseInfoItemData>(itemView) {

    private lateinit var binding: HolderCourceInfoItemBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderCourceInfoItemBinding) {
            binding = viewDataBinding as HolderCourceInfoItemBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: CourseInfoItemData) {
        binding.courseInfoText.setText(data.courseInfoItem.title)
        binding.courseInfoIcon.setImageResource(data.courseInfoItem.icon)
    }

    companion object {
        private const val TAG = "CourseInfoItemViewHolde"
    }

}