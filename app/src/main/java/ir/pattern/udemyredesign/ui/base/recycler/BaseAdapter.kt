package ir.pattern.udemyredesign.ui.base.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter() : RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        val MAX_SPAN = -1
    }

    lateinit var list: ArrayList<BaseRecyclerData>

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BaseRecyclerData>() {

        override fun areItemsTheSame(
            oldItem: BaseRecyclerData,
            newItem: BaseRecyclerData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BaseRecyclerData,
            newItem: BaseRecyclerData
        ): Boolean {
            return oldItem.getViewType() == newItem.getViewType()
        }

    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    abstract fun getViewHolder(
        parent: ViewGroup?,
        viewType: Int,
        view: View
    ): BaseViewHolder<*>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder: BaseViewHolder<*>
        val binding: ViewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, viewType, parent, false)
        val view: View
        view = binding?.root ?: inflater.inflate(viewType, parent, false)
        viewHolder = getViewHolder(parent, viewType, view)
        viewHolder.setDataBindingView(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val recyclerData: BaseRecyclerData = differ.currentList[position]
        holder as BaseViewHolder<BaseRecyclerData>
        holder.onBindView(recyclerData)
    }

    override fun getItemViewType(position: Int): Int {
        return differ.currentList[position].getViewType()
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<*>) {
        super.onViewDetachedFromWindow(holder)
        val adapterPosition: Int = holder.getAdapterPosition()
        if (adapterPosition < differ.currentList.size && adapterPosition > -1) {
            holder as BaseViewHolder<BaseRecyclerData>
            holder.onDetach(differ.currentList[adapterPosition])
        }
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<*>) {
        super.onViewAttachedToWindow(holder)
        val adapterPosition: Int = holder.getAdapterPosition()
        if (adapterPosition < differ.currentList.size && adapterPosition > -1) {
            holder as BaseViewHolder<BaseRecyclerData>
            holder.onAttach(differ.currentList[adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: ArrayList<BaseRecyclerData>) {
        this.list = list
        differ.submitList(list)
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        differ.submitList(list)
        notifyItemRemoved(position)
    }

    fun addItem(baseRecyclerData: BaseRecyclerData, position: Int) {
        list.add(position, baseRecyclerData)
        differ.submitList(list)
        notifyItemInserted(position)
    }
}