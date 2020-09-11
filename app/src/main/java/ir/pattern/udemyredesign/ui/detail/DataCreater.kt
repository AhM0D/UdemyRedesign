package ir.pattern.udemyredesign.ui.detail

import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.data.CourseInfoData
import ir.pattern.udemyredesign.data.CurriculumData
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.detail.data.CourseInfoItemData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumMainViewData
import ir.pattern.udemyredesign.ui.detail.data.CurriculumSecondViewData

class DataCreater {
    companion object {
        public fun createCourseItemView() : ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(CourseInfoItemData(CourseInfoData("4.6", R.drawable.ic_star)))
            list.add(CourseInfoItemData(CourseInfoData("28h", R.drawable.ic_duration)))
            list.add(CourseInfoItemData(CourseInfoData("12/2019", R.drawable.ic_date)))
            return list
        }

        fun createCurriculumItem(): ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(CurriculumMainViewData("Course Introduction", setSecondItems()))
            list.add(CurriculumMainViewData("JavaScript Language Basics", setSecondItems()))
            list.add(CurriculumMainViewData("How JavaScript Works Behind the Scenes", setSecondItems()))
            list.add(CurriculumMainViewData("JavaScript In the Browser: DOM Manipulation and Events", setSecondItems()))
            list.add(CurriculumMainViewData("Advanced Java Script: Objects and Functions", setSecondItems()))
            return list
        }

        fun setSecondItems(): ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(CurriculumSecondViewData(1,"Welcome to the Cours", CurriculumSecondViewData.MediaType.VIDEO, "03:41"))
            list.add(CurriculumSecondViewData(2,"READ BEFORE YOU STAR", CurriculumSecondViewData.MediaType.ARTICLE, ""))
            list.add(CurriculumSecondViewData(3,"Setting up Our Tools", CurriculumSecondViewData.MediaType.VIDEO, "04:17"))
            return list
        }

    }
}