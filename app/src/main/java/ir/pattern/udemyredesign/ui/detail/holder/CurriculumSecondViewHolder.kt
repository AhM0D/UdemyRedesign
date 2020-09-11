package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.databinding.HolderCourceInfoItemBinding
import ir.pattern.udemyredesign.databinding.HolderCulumSecondBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumSecondViewData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData


class CurriculumSecondViewHolder(itemView: View) :
    BaseViewHolder<CurriculumSecondViewData>(itemView) {

    private lateinit var binding: HolderCulumSecondBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderCulumSecondBinding) {
            binding = viewDataBinding as HolderCulumSecondBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: CurriculumSecondViewData) {
        if (data.type == CurriculumSecondViewData.MediaType.VIDEO) {
            binding.courseIcon.setImageResource(R.drawable.ic_play)
            binding.videoDesc.text = "Video - " + data.duration + " mins"
        } else {
            binding.courseIcon.setImageResource(R.drawable.ic_article)
            binding.videoDesc.text = "Article "
        }
        binding.videoTitle.text = data.title
        binding.txtNumber.text = "${data.index}"
    }

    companion object {
        private const val TAG = "CourseInfoItemViewHolde"
    }

}