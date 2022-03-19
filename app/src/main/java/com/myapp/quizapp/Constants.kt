package com.myapp.quizapp

object Constants {
    val USER_NAME:String="username"
    val CORRECT_ANSWERS="correct"
    val TOTAL_QUESTIONS="total"
    fun getQuestionsInfo(): ArrayList<QuestionsInfo> {
        val QuestionsInfosList = ArrayList<QuestionsInfo>()

        // 1
        val que1 = QuestionsInfo(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        QuestionsInfosList.add(que1)

        // 2
        val que2 = QuestionsInfo(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        QuestionsInfosList.add(que2)

        // 3
        val que3 = QuestionsInfo(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        QuestionsInfosList.add(que3)

        // 4
        val que4 = QuestionsInfo(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        QuestionsInfosList.add(que4)

        // 5
        val que5 = QuestionsInfo(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        QuestionsInfosList.add(que5)

        // 6
        val que6 = QuestionsInfo(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        QuestionsInfosList.add(que6)

        // 7
        val que7 = QuestionsInfo(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        QuestionsInfosList.add(que7)

        // 8
        val que8 = QuestionsInfo(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        QuestionsInfosList.add(que8)

        // 9
        val que9 = QuestionsInfo(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        QuestionsInfosList.add(que9)

        // 10
        val que10 = QuestionsInfo(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        QuestionsInfosList.add(que10)

        return QuestionsInfosList
    }
}