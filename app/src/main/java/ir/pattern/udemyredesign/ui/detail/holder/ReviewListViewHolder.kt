package ir.pattern.udemyredesign.ui.detail.holder

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import ir.pattern.udemyredesign.data.CurriculumData
import ir.pattern.udemyredesign.databinding.HolderCourceInfoBinding
import ir.pattern.udemyredesign.databinding.HolderCurriculumBinding
import ir.pattern.udemyredesign.databinding.HolderReviewBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.adapter.CourseInfoAdapter
import ir.pattern.udemyredesign.ui.detail.adapter.CurriculmAdapter
import ir.pattern.udemyredesign.ui.detail.data.CurriculumMainViewData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumViewData
import ir.pattern.udemyredesign.ui.detail.data.ReviewListViewData


class ReviewListViewHolder(itemView: View) : BaseViewHolder<ReviewListViewData>(itemView) {

    private lateinit var binding: HolderReviewBinding
    private lateinit var adapter: CurriculmAdapter
    lateinit var context: Context;

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderReviewBinding) {
            binding = viewDataBinding as HolderReviewBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(viewData: ReviewListViewData) {
        context = binding.reviewRv.context
        adapter =
            CurriculmAdapter()
        binding.reviewRv.setHasFixedSize(true)
        binding.reviewRv.layoutManager =
            LinearLayoutManager(context)
        binding.reviewRv.adapter = adapter

        if (viewData.limit == (viewData.reviewsList.size - 1) && viewData.limit > viewData.reviewsList.size) {
            binding.moreTxt.visibility = View.GONE
        } else {
            var  arrayList: ArrayList<BaseRecyclerData> = ArrayList()
            for (i in 0..viewData.limit) {
                arrayList.add(viewData.reviewsList.get(i))
            }
            adapter.submitList(arrayList)
            binding.moreTxt.setOnClickListener(View.OnClickListener {
                for (i in viewData.limit + 1 until viewData.reviewsList.size) {
                    adapter.addItem(viewData.reviewsList.get(i), i)
                }
                binding.more.visibility = View.GONE
                binding.reviewRv.scrollToPosition(viewData.reviewsList.size - 1)
            })
        }


    }

    companion object {
        private const val TAG = "CurriculumViewHolder"
    }

}