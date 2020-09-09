package ir.pattern.udemyredesign.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.data.VideoData
import ir.pattern.udemyredesign.ui.base.fragment.BaseRecyclerFragment
import ir.pattern.udemyredesign.ui.base.fragment.LayoutType
import ir.pattern.udemyredesign.ui.base.recycler.BaseAdapter
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.detail.adapter.DetailRecyclerAdapter
import ir.pattern.udemyredesign.ui.detail.data.*
import ir.pattern.udemyredesign.utils.GraphicUtils

class DetailFragment : BaseRecyclerFragment() {

    private lateinit var detailRecyclerAdapter: DetailRecyclerAdapter
    private lateinit var graphicUtils: GraphicUtils

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel


    override fun getDataList(): List<BaseRecyclerData> {
        return listOf(
            VideoViewData(VideoData("","","")),
            CourseInfoData(DataCreater.createCourseItemView()),
            TextTitleData("The Compelete JavaScript Course 2020: Build Real Projects!"),
            TextDescriptionData("Master JavaScript with the most complete course! Projects, challenges, quizzes, JavaScript ES6+, OOP, AJAX, Webpack"),
            PriceViewData("£199.99"),
            EmptyViewData()
        )
    }

    override fun createAdapter(): BaseAdapter {
        detailRecyclerAdapter =
            DetailRecyclerAdapter()
        activity?.let {
            graphicUtils = GraphicUtils(requireContext())
            detailRecyclerAdapter.setDimension(graphicUtils.getAppScreenResolution(it))
        }
        return detailRecyclerAdapter
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
        val leftIconLayout = toolbar.findViewById<View>(R.id.leftIconLayout)
        val rightIconLayout = toolbar.findViewById<View>(R.id.rightIconLayout)
        val leftIcon: ImageView = toolbar.findViewById<ImageView>(R.id.left_icon)
        val rightIcon: ImageView = toolbar.findViewById<ImageView>(R.id.right_icon)
        leftIconLayout.visibility = View.VISIBLE
        rightIconLayout.visibility = View.VISIBLE
        rightIcon.setImageResource(R.drawable.ic_search)
        leftIcon.setImageResource(R.drawable.ic_back)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}