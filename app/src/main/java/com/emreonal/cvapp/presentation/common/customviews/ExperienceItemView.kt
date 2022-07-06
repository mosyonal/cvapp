package com.emreonal.cvapp.presentation.common.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.emreonal.cvapp.databinding.LayoutExperienceItemBinding
import com.emreonal.cvapp.databinding.ListItemExperienceBinding
import com.emreonal.cvapp.presentation.experience.ExperienceItem
import com.emreonal.cvapp.util.extensions.betweenDateExperience
import com.emreonal.cvapp.util.extensions.inflater

class ExperienceItemView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutExperienceItemBinding.inflate(context.inflater(), this, true)

    var listener: IExperienceItem? = null
    var experience: ExperienceItem? = null
        set(value) {
            field = value
            binding.tvTitle.text = value?.title
            binding.tvTime.text = value?.startDate?.betweenDateExperience(value.endDate, context)
            value?.logoId?.let { binding.ivLogo.setImageResource(it) }
            value?.innerExperiences?.forEachIndexed { index, item ->
                val itemView = ListItemExperienceBinding.inflate(context.inflater(), binding.llItems, true)
                itemView.tvJobTitle.text = item.title
                itemView.tvTimeJob.text = item.startDate?.betweenDateExperience(item.endDate, context)
                itemView.dashedLine.isVisible = index < value.innerExperiences.size - 1
            }
        }

    init {
        binding.tvTitle.setOnClickListener {
            listener?.onInfoClick(experience?.info)
        }
    }

}