package com.emreonal.cvapp.presentation.common.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.emreonal.cvapp.R
import com.emreonal.cvapp.util.extensions.color
import com.emreonal.cvapp.util.extensions.safeLet

class DashedLineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var density: Float = 0f
    private var paint: Paint? = null
    private var path: Path? = null
    private var effects: PathEffect? = null

    private var color: Int? = null
    set(value) {
        try {
            paint?.color = value ?: context.color(R.color.light_grey)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        field = value
    }

    init {
        density = context.resources.displayMetrics.density
        paint = Paint()
        paint?.style = Paint.Style.STROKE
        paint?.strokeWidth = density * 4
        path = Path()
        effects = DashPathEffect(floatArrayOf(10f, 10f, 10f, 10f), 0f)

        attrs?.let {
            val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.dashed_line_view, 0, 0)
            try {
                color = typedArray.getColor(R.styleable.dashed_line_view_lineColor, context.color(R.color.light_grey))
            } finally {
                typedArray.recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint?.pathEffect = effects
        val measuredHeight = measuredHeight
        val measuredWidth = measuredWidth
        if (measuredHeight <= measuredWidth) {
            // horizontal
            path?.moveTo(0f, 0f)
            path?.lineTo(measuredWidth.toFloat(), 0f)
            safeLet(path, paint) { path, paint ->
                canvas?.drawPath(path, paint)
            }
        } else {
            // vertical
            path?.moveTo(0f, 0f)
            path?.lineTo(0f, measuredHeight.toFloat())
            safeLet(path, paint) { path, paint ->
                canvas?.drawPath(path, paint)
            }
        }
    }

}