package ir.pattern.udemyredesign.ui.detail.holder

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import ir.pattern.udemyredesign.databinding.HolderQuestionAnswerBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.adapter.CurriculmAdapter
import ir.pattern.udemyredesign.ui.detail.data.CurriculumMainViewData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumViewData
import ir.pattern.udemyredesign.ui.detail.data.QuestionAnswerViewData


class QuestionAnswerViewHolder(itemView: View) : BaseViewHolder<QuestionAnswerViewData>(itemView),
    BaseViewHolder.OnClickListener<CurriculumMainViewHolder, CurriculumMainViewData> {

    private lateinit var binding: HolderQuestionAnswerBinding
    private lateinit var adapter: CurriculmAdapter
    lateinit var context: Context;

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderQuestionAnswerBinding) {
            binding = viewDataBinding as HolderQuestionAnswerBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(viewData: QuestionAnswerViewData) {
        context = binding.curriculumRv.context
        adapter =
            CurriculmAdapter()

        binding.curriculumRv.setHasFixedSize(true)
        binding.curriculumRv.layoutManager =
            LinearLayoutManager(context)
        binding.curriculumRv.adapter = adapter
        adapter.SetCurriculmItemClickListener(this)

        if (viewData.limit == (viewData.courseInfoList.size - 1) && viewData.limit > viewData.courseInfoList.size) {
            binding.moreTxt.visibility = View.GONE
        } else {
            var  arrayList: ArrayList<BaseRecyclerData> = ArrayList()
            for (i in 0..viewData.limit) {
                arrayList.add(viewData.courseInfoList.get(i))
            }
            adapter.submitList(arrayList)
                binding.moreTxt.setOnClickListener(View.OnClickListener {
                    for (i in viewData.limit + 1 until viewData.courseInfoList.size) {
                        adapter.addItem(viewData.courseInfoList.get(i), i)
                    }
                    binding.more.visibility = View.GONE
                    binding.curriculumRv.scrollToPosition(viewData.courseInfoList.size - 1)
                })
        }

    }

    companion object {
        private const val TAG = "QuestionAnswerViewHolder"
    }

    override fun onClick(
        view: View,
        viewHolder: CurriculumMainViewHolder,
        recyclerData: CurriculumMainViewData
    ) {
        if (!viewHolder.isItemOpen()) {
            var position: Int = binding.curriculumRv.getChildAdapterPosition(view)
            for (item in recyclerData.descItems) {
                position += 1
                adapter.addItem(item, position)
            }
        } else {
            var position: Int = binding.curriculumRv.getChildAdapterPosition(view)
            position +=1
            for (item in recyclerData.descItems) {
                adapter.removeItem(position)
            }
        }
       viewHolder.setIsOpen(!viewHolder.isItemOpen())
    }

}