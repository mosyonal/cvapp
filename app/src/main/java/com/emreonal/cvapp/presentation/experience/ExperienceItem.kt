package com.emreonal.cvapp.presentation.experience

import java.util.*

data class ExperienceItem(
    val title: String?,
    val logoId: Int?,
    val info: String?,
    val startDate: Date?,
    val endDate: Date?,
    val innerExperiences: List<InnerExperienceItem>?
)