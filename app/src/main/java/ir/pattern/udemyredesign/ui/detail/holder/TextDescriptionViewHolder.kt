package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderTextDescriptionBinding
import ir.pattern.udemyredesign.databinding.HolderTextTitleBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.TextDescriptionData
import ir.pattern.udemyredesign.ui.detail.data.TextTitleData


class TextDescriptionViewHolder(itemView: View) : BaseViewHolder<TextDescriptionData>(itemView) {

    private lateinit var binding: HolderTextDescriptionBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderTextDescriptionBinding) {
            binding = viewDataBinding as HolderTextDescriptionBinding
        } else {
            Log.e(TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(dataText: TextDescriptionData) {
        binding.title.text = dataText.titleText
    }

    companion object {
        private const val TAG = "TitleViewHolder"
    }
}