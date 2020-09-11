package ir.pattern.udemyredesign.ui.detail.holder

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import ir.pattern.udemyredesign.databinding.HolderCourceInfoBinding
import ir.pattern.udemyredesign.databinding.HolderFeedbackBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.adapter.CourseInfoAdapter
import ir.pattern.udemyredesign.ui.detail.adapter.DetailRecyclerAdapter
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.FeedbackViewData


class FeedbackViewHolder(itemView: View) : BaseViewHolder<FeedbackViewData>(itemView) {

    private lateinit var binding: HolderFeedbackBinding
    private lateinit var detailRecyclerAdapter: CourseInfoAdapter
    lateinit var context: Context;

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderFeedbackBinding) {
            binding = viewDataBinding as HolderFeedbackBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: FeedbackViewData) {
        context = binding.rateRv.context
        detailRecyclerAdapter =
            CourseInfoAdapter()
        detailRecyclerAdapter.submitList(data.rateList)
        binding.rateRv.setHasFixedSize(true)
        binding.rateRv.layoutManager =
            LinearLayoutManager(context)
        binding.rateRv.adapter = detailRecyclerAdapter
    }

    companion object {
        private const val TAG = "CourseInfoViewHolder"
    }

}