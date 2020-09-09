package ir.pattern.udemyredesign.ui.base.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import kotlinx.android.synthetic.main.recycler_fragment.*

abstract class BaseRecyclerFragment : Fragment(R.layout.recycler_fragment) {

    private lateinit var adapter: BaseAdapter

    abstract fun getDataList(): ArrayList<BaseRecyclerData>
    abstract fun createAdapter(): BaseAdapter
    abstract fun getLayoutType(): LayoutType
    abstract fun getMaxSpan(): Int
    abstract fun getIsToolbarAvailable(): Boolean
    abstract fun setToolbarIcons(toolbar: Toolbar)


    fun getLayoutManager(): RecyclerView.LayoutManager? {
        return when (getLayoutType()) {
            LayoutType.LINEAR_LAYOUT ->
                LinearLayoutManager(activity)
            LayoutType.HORIZONTAL_LAYOUT ->
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            LayoutType.GRID_LAYOUT ->
                GridLayoutManager(activity, getMaxSpan())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (getIsToolbarAvailable()) {
            setToolbarIcons(toolbar)
        } else {
            toolbar.visibility = View.GONE
        }
        adapter = createAdapter()
        adapter.submitList(getDataList())
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(getLayoutManager())
        recyclerView.setAdapter(adapter)
        recyclerView.setPadding(0, 0, 0, 0)
    }


}

enum class LayoutType() {
    LINEAR_LAYOUT(),
    HORIZONTAL_LAYOUT,
    GRID_LAYOUT,
}