package com.emreonal.cvapp.presentation.experience

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import com.emreonal.cvapp.presentation.common.customviews.ExperienceItemView
import com.emreonal.cvapp.presentation.common.customviews.IExperienceItem

@BindingAdapter("experiences", "experienceListener")
fun setExperiences(linearLayout: LinearLayout, experiences: List<ExperienceItem>?, experienceListener: IExperienceItem?) {
    linearLayout.removeAllViews()
    experiences?.forEach {
        val item = ExperienceItemView(linearLayout.context)
        item.experience = it
        item.listener = experienceListener
        linearLayout.addView(item)
    }
}