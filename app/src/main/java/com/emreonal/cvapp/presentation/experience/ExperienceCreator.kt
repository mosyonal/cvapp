package com.emreonal.cvapp.presentation.experience

import android.content.Context
import com.emreonal.cvapp.R
import java.text.SimpleDateFormat

object ExperienceCreator {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")

    fun create(context: Context): List<ExperienceItem> {
        val list = mutableListOf<ExperienceItem>()

        val basarsoftIntern = InnerExperienceItem(
            title = context.getString(R.string.experience_basarsoft_intern_title),
            startDate = dateFormatter.parse("02/06/2017"),
            endDate = dateFormatter.parse("30/08/2017")
        )
        val basarsoftDeveloper = InnerExperienceItem(
            title = context.getString(R.string.experience_basarsoft_developer_title),
            startDate = dateFormatter.parse("01/09/2017"),
            endDate = dateFormatter.parse("10/10/2020")
        )
        val basarsoft = ExperienceItem(
            title = context.getString(R.string.experience_basarsoft_main_title),
            logoId = R.drawable.ic_basarsoft,
            info = context.getString(R.string.experience_basarsoft_info),
            startDate = dateFormatter.parse("02/06/2017"),
            endDate = dateFormatter.parse("10/10/2020"),
            innerExperiences = listOf(basarsoftIntern, basarsoftDeveloper)
        )
        list.add(basarsoft)

        val etsturDeveloper = InnerExperienceItem(
            title = context.getString(R.string.experience_etstur_developer_title),
            startDate = dateFormatter.parse("12/10/2020"),
            endDate = dateFormatter.parse("12/10/2021")
        )
        val etsturLead = InnerExperienceItem(
            title = context.getString(R.string.experience_etstur_lead_title),
            startDate = dateFormatter.parse("12/10/2021"),
            endDate = null
        )
        val etstur = ExperienceItem(
            title = context.getString(R.string.experience_etstur_main_title),
            logoId = R.drawable.ic_etstur,
            info = context.getString(R.string.experience_etstur_info),
            startDate = dateFormatter.parse("12/10/2020"),
            endDate = null,
            innerExperiences = listOf(etsturDeveloper, etsturLead)
        )
        list.add(etstur)

        return list
    }

}