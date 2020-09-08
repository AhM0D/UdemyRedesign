package ir.pattern.udemyredesign.ui.detail

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import ir.pattern.udemyredesign.ui.base.fragment.BaseRecyclerFragment
import ir.pattern.udemyredesign.ui.base.fragment.LayoutType
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData

class DetailFragment : BaseRecyclerFragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel


    override fun getDataList(): List<BaseRecyclerData> {
        TODO("Not yet implemented")
    }

    override fun createAdapter(): BaseAdapter {
        TODO("Not yet implemented")
    }

    override fun getLayoutType(): LayoutType {
        return LayoutType.LINEAR_LAYOUT
    }

    override fun getMaxSpan(): Int {
        TODO("Not yet implemented")
    }

    override fun getIsToolbarAvailable(): Boolean {
        return true
    }

    override fun setToolbarIcons(toolbar: Toolbar) {
        TODO("Not yet implemented")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}