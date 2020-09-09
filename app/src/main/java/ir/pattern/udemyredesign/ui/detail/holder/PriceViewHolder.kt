package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderPriceBinding
import ir.pattern.udemyredesign.databinding.HolderTextDescriptionBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.EmptyViewData
import ir.pattern.udemyredesign.ui.detail.data.PriceViewData


class PriceViewHolder(itemView: View) : BaseViewHolder<PriceViewData>(itemView) {

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
    }

    companion object {
        private const val TAG = "PriceViewHolder"
    }

}