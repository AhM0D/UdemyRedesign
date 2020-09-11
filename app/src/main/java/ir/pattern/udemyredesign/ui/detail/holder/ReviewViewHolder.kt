package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.databinding.HolderCourceInfoItemBinding
import ir.pattern.udemyredesign.databinding.HolderCulumSecondBinding
import ir.pattern.udemyredesign.databinding.HolderItemReviewBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumSecondViewData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.ReviewViewData


class ReviewViewHolder(itemView: View) :
    BaseViewHolder<ReviewViewData>(itemView) {

    private lateinit var binding: HolderItemReviewBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderItemReviewBinding) {
            binding = viewDataBinding as HolderItemReviewBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: ReviewViewData) {

    }

    companion object {
        private const val TAG = "ReviewViewHolder"
    }

}