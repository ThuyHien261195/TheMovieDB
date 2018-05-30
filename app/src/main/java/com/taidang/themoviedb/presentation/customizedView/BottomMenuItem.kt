package com.taidang.themoviedb.presentation.customizedView

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.View
import android.widget.LinearLayout
import com.taidang.themoviedb.R
import kotlinx.android.synthetic.main.bottom_menu_item.view.*

/**
 * Created by thuyhien on 5/23/18.
 */
class BottomMenuItem @JvmOverloads constructor(context: Context,
                                               attrs: AttributeSet? = null,
                                               defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.bottom_menu_item, this)
        setupAttribues(attrs)
        initView()
    }

    private var imageSrc: Drawable? = null
    private var active: Boolean = false
    private var menuItemTitle: String = ""
    private var activeColor: Int = -1
    private var inactiveColor: Int = -1

    private fun setupAttribues(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.BottomMenuItem, 0, 0)

        try {
            imageSrc = typedArray.getDrawable(R.styleable.BottomMenuItem_imageSrc)
            active = typedArray.getBoolean(R.styleable.BottomMenuItem_active, false)
            menuItemTitle = typedArray.getString(R.styleable.BottomMenuItem_titleMenuItem)
            activeColor = typedArray.getColor(R.styleable.BottomMenuItem_activeColor,
                    ContextCompat.getColor(context, R.color.text_dark_blue))
            inactiveColor = typedArray.getColor(R.styleable.BottomMenuItem_inactiveColor,
                    ContextCompat.getColor(context, android.R.color.black))

        } finally {
            typedArray.recycle()
        }
    }

    private fun initView() {
        this.orientation = VERTICAL
        this.gravity = CENTER

        imageSrc?.let {
            ivIcon.setImageDrawable(imageSrc)
        } ?: ivIcon.setImageResource(R.drawable.ic_movie)

        tvTitle.text = menuItemTitle

        if(active) {
            setActive()
        } else {
            setInActive()
        }
    }

    fun setActive() {
        tvTitle.setTextColor(ContextCompat.getColor(context, R.color.text_dark_blue))
        ivIcon.setColorFilter(ContextCompat.getColor(context, R.color.text_dark_blue))
    }

    fun setInActive() {
        tvTitle.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        ivIcon.setColorFilter(ContextCompat.getColor(context, android.R.color.black))
    }
}