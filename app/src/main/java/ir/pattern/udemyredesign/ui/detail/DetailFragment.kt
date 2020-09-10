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
import ir.pattern.udemyredesign.ui.detail.listener.RecyclerItemState
import ir.pattern.udemyredesign.utils.GraphicUtils

class DetailFragment : BaseRecyclerFragment(), RecyclerItemState{

    private lateinit var detailRecyclerAdapter: DetailRecyclerAdapter
    private lateinit var graphicUtils: GraphicUtils
    val list: ArrayList<BaseRecyclerData> = ArrayList()

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel


    override fun getDataList(): ArrayList<BaseRecyclerData> {
        list.add(VideoViewData(VideoData("","","")))
        list.add(CourseInfoData(DataCreater.createCourseItemView()))
        list.add(TextTitleData("The Compelete JavaScript Course 2020: Build Real Projects!"))
        list.add(TextDescriptionData("Master JavaScript with the most complete course! Projects, challenges, quizzes, JavaScript ES6+, OOP, AJAX, Webpack"))
        list.add(PriceViewData("£199.99"))
        list.add(CreatorViewData())
        list.add(CurriculumData())
        list.add(EmptyViewData())
        return list
    }

    override fun createAdapter(): BaseAdapter {
        detailRecyclerAdapter =
            DetailRecyclerAdapter()
        activity?.let {
            graphicUtils = GraphicUtils(requireContext())
            detailRecyclerAdapter.setDimension(graphicUtils.getAppScreenResolution(it))
        }
        detailRecyclerAdapter.setVideoViewStateListener(this)
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

    override fun onDetach(data: BaseRecyclerData) {
        if (data is VideoViewData) {
            showToolbarShadow()
        }
    }

    override fun onAttach(data: BaseRecyclerData) {
        if (data is VideoViewData) {
            hideToolbarShadow()
        }
    }


}