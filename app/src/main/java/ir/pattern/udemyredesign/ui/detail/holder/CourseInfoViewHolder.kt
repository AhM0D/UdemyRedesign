package ir.pattern.udemyredesign.ui.detail.holder

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import ir.pattern.udemyredesign.databinding.HolderCourceInfoBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.adapter.CourseInfoAdapter
import ir.pattern.udemyredesign.ui.detail.adapter.DetailRecyclerAdapter
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData


class CourseInfoViewHolder(itemView: View) : BaseViewHolder<CourseInfoData>(itemView) {

    private lateinit var binding: HolderCourceInfoBinding
    private lateinit var detailRecyclerAdapter: CourseInfoAdapter
    lateinit var context: Context;

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderCourceInfoBinding) {
            binding = viewDataBinding as HolderCourceInfoBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: CourseInfoData) {
        context = binding.courseInfoRv.context
        detailRecyclerAdapter =
            CourseInfoAdapter()
        detailRecyclerAdapter.submitList(data.courseInfoList)
        binding.courseInfoRv.setHasFixedSize(true)
        binding.courseInfoRv.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.courseInfoRv.adapter = detailRecyclerAdapter
    }

    companion object {
        private const val TAG = "CourseInfoViewHolder"
    }

}