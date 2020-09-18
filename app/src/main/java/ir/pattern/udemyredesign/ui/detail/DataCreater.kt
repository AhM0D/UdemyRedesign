package ir.pattern.udemyredesign.ui.detail

import ir.pattern.udemyredesign.R
import ir.pattern.udemyredesign.data.CourseInfoData
import ir.pattern.udemyredesign.data.CurriculumData
import ir.pattern.udemyredesign.ui.base.recycler.BaseRecyclerData
import ir.pattern.udemyredesign.ui.detail.data.*

class DataCreater {
    companion object {
        public fun createCourseItemView() : ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(CourseInfoItemData(CourseInfoData("4.6", R.drawable.ic_empty_star)))
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

        fun createQuestionItem(): ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(CurriculumMainViewData("In Node.js, how do I make one server call a function on another server?", setAnswerItem()))
            list.add(CurriculumMainViewData("Why is server ignoring changes in the code files even though cache is disabled?", setAnswerItem()))
            list.add(CurriculumMainViewData("Custom effect that simulates a 3d wheel with Swiper 5", setAnswerItem()))
            list.add(CurriculumMainViewData("Does javaScript In the Browser DOM Manipulation and Events ?", setAnswerItem()))
            return list
        }

        fun createRateItem(): ArrayList<BaseRecyclerData> {
            var list: ArrayList<BaseRecyclerData> = ArrayList()
            list.add(RateViewData("5", 61))
            list.add(RateViewData("4", 30))
            list.add(RateViewData("3", 7))
            list.add(RateViewData("2", 1))
            list.add(RateViewData("1", 1))
            return list
        }

        fun createReviewItem(): ArrayList<BaseRecyclerData> {
            var list: ArrayList<BaseRecyclerData> = ArrayList()
            list.add(
                ReviewViewData(
                    "Dani Bachour",
                    "Thank you so very much for this course, it's simply amazing and beautiful, clear, coincise and above of all lot of practices, his explanation is just amazing!",
                    5f,
                    "a month ago"
                )
            )
            list.add(
                ReviewViewData(
                    "Dani Bachour",
                    "Thank you so very much for this course, it's simply amazing and beautiful, clear, coincise and above of all lot of practices, his explanation is just amazing!",
                    2.8f,
                    "a month ago"
                )
            )
            list.add(
                ReviewViewData(
                    "Dani Bachour",
                    "Thank you so very much for this course, it's simply amazing and beautiful, clear, coincise and above of all lot of practices, his explanation is just amazing!",
                    3.2f,
                    "a month ago"
                )
            )
            list.add(
                ReviewViewData(
                    "Dani Bachour",
                    "Thank you so very much for this course, it's simply amazing and beautiful, clear, coincise and above of all lot of practices, his explanation is just amazing!",
                    4.5f,
                    "a month ago"
                )

            )
            list.add(
                ReviewViewData(
                    "Dani Bachour",
                    "Thank you so very much for this course, it's simply amazing and beautiful, clear, coincise and above of all lot of practices, his explanation is just amazing!",
                    5f,
                    "a month ago"
                )

            )
            return list
        }

        fun setAnswerItem(): ArrayList<BaseRecyclerData> {
            var list : ArrayList<BaseRecyclerData> = ArrayList()
            list.add(AnswerViewData("You can use one of the RPC modules, for example dnode."))
            return list
        }

    }
}