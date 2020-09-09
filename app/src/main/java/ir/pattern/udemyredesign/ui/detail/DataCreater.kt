package ir.pattern.udemyredesign.ui.detail

import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.data.CourseInfoData
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData

class DataCreater {
    companion object {
        public fun createCourseItemView() : List<BaseRecyclerData> {
            return listOf(
                CourseInfoItemData(CourseInfoData("4.6", R.drawable.ic_star)),
                CourseInfoItemData(CourseInfoData("28h", R.drawable.ic_duration)),
                CourseInfoItemData(CourseInfoData("12/2019", R.drawable.ic_date))
            )
        }
    }
}