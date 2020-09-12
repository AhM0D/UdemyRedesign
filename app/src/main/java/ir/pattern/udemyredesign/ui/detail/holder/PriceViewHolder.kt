package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.databinding.HolderPriceBinding
import ir.pattern.udemyredesign.databinding.HolderTextDescriptionBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.CurriculumMainViewData
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.PriceViewData
import kotlinx.android.synthetic.main.recycler_fragment.*


class PriceViewHolder(
    itemView: View,
    private val onClickListener: OnClickListener<PriceViewHolder, PriceViewData>?
) : BaseViewHolder<PriceViewData>(itemView), Animation.AnimationListener {

    private lateinit var binding: HolderPriceBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderPriceBinding) {
            binding = viewDataBinding as HolderPriceBinding
        } else {
            Log.e(TAG, "binding is not incompatible ")
        }
    }


    override fun onBindView(data: PriceViewData) {
        binding.title.text = data.price
        setOnClickListener(itemView, onClickListener, this, data)
    }

    fun changePurchaseTxt() {
        val animation: Animation =
            AnimationUtils.loadAnimation(itemView.context, R.anim.purchase_anim)
        binding.purchaseTxt.startAnimation(animation)
        animation.setAnimationListener(this)
    }

    companion object {
        private const val TAG = "PriceViewHolder"
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        binding.purchaseTxt.text = "Go to Cart"
        binding.priceCard.setCardBackgroundColor(itemView.context.resources.getColor(R.color.appColorDarkAccent))
    }

    override fun onAnimationStart(p0: Animation?) {

    }

}