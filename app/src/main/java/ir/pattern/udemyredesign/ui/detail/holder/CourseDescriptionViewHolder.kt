package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderCourseDescriptionBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CourseDescriptionViewData


class CourseDescriptionViewHolder(itemView: View) :
    BaseViewHolder<CourseDescriptionViewData>(itemView) {

    private lateinit var binding: HolderCourseDescriptionBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderCourseDescriptionBinding) {
            binding = viewDataBinding as HolderCourseDescriptionBinding
        } else {
            Log.e(Companion.TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(data: CourseDescriptionViewData) {
        binding.moreTxt.setOnClickListener(View.OnClickListener {
            binding.more.visibility = View.GONE
            binding.desc.maxLines = 15
        })
    }

    companion object {
        private const val TAG = "CourseDescriptionViewHo"
    }

}