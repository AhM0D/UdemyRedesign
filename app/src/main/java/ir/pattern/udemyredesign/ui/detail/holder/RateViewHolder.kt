package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderAnswerBinding
import ir.pattern.udemyredesign.databinding.HolderCourseDescriptionBinding
import ir.pattern.udemyredesign.databinding.HolderRateItemBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.AnswerViewData
import ir.pattern.udemyredesign.ui.detail.data.CourseDescriptionViewData
import ir.pattern.udemyredesign.ui.detail.data.RateViewData


class RateViewHolder(itemView: View) :
    BaseViewHolder<RateViewData>(itemView) {

    private lateinit var binding: HolderRateItemBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderRateItemBinding) {
            binding = viewDataBinding as HolderRateItemBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: RateViewData) {
        binding.progressBar.progress = data.progress
        binding.rateNumber.text = data.startNumber
        binding.rate.text = "${data.progress}%"
    }

    companion object {
        private const val TAG = "CourseDescriptionViewHo"
    }

}