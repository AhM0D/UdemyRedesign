package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderAnswerBinding
import ir.pattern.udemyredesign.databinding.HolderCourseDescriptionBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.AnswerViewData
import ir.pattern.udemyredesign.ui.detail.data.CourseDescriptionViewData


class AnswerViewHolder(itemView: View) :
    BaseViewHolder<AnswerViewData>(itemView) {

    private lateinit var binding: HolderAnswerBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderAnswerBinding) {
            binding = viewDataBinding as HolderAnswerBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: AnswerViewData) {
        binding.answer.text = data.answer
    }

    companion object {
        private const val TAG = "CourseDescriptionViewHo"
    }

}