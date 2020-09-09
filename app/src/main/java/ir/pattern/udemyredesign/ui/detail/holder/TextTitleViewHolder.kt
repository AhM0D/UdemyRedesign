package ir.pattern.udemyredesign.ui.detail.holder

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import ir.pattern.udemyredesign.databinding.HolderTextTitleBinding
import ir.pattern.udemyredesign.ui.base.recycler.BaseViewHolder
import ir.pattern.udemyredesign.ui.detail.data.TextTitleData


class TextTitleViewHolder(itemView: View) : BaseViewHolder<TextTitleData>(itemView) {

    private lateinit var binding: HolderTextTitleBinding

    override fun setDataBindingView(viewDataBinding: ViewDataBinding) {
        super.setDataBindingView(viewDataBinding)
        if (viewDataBinding is HolderTextTitleBinding) {
            binding = viewDataBinding as HolderTextTitleBinding
        } else {
            Log.e(TAG, "binding is not incompatible ")
        }
    }

    override fun onBindView(dataText: TextTitleData) {
        binding.title.text = dataText.titleText
    }

    companion object {
        private const val TAG = "TitleViewHolder"
    }
}