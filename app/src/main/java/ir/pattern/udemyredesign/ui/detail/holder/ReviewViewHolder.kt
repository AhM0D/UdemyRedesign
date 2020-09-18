package ir.pattern.udemyredesign.ui.detail.holder

import android.media.Image
import android.util.Log
import android.view.View
import android.widget.ImageView
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
        binding.userName.text = data.userName
        binding.desc.text = data.desc
        binding.duration.text = data.date
        setStars(data.rate)
    }

    private fun setStars(rate: Float) {
        for (i in 1..5) {
            var star: ImageView? = getCorrectStar(i)
            star?.let {
                if (rate > i-1 && rate < i) {
                    star.setImageResource(R.drawable.ic_half_star)
                } else if (rate > i-1 && rate >= i) {
                    star.setImageResource(R.drawable.ic_star)
                } else {
                    star.setImageResource(R.drawable.ic_empty_star)
                }
            }
        }
    }

    fun getCorrectStar(number: Int): ImageView? {
        when(number) {
            1 -> return binding.rate1
            2 -> return binding.rate2
            3 -> return binding.rate3
            4 -> return binding.rate4
            5 -> return binding.rate5
        }
        return null
    }

    companion object {
        private const val TAG = "ReviewViewHolder"
    }

}