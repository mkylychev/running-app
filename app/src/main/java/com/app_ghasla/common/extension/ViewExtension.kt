import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import com.app_ghasla.common.extension.getColor
import com.google.android.material.card.MaterialCardView

/**
 * View: Show/Hide
 */
fun View.show() {
    if (isVisible) return
    visibility = View.VISIBLE
}

fun View.hide() {
    if (!isVisible) return
    visibility = View.GONE
}

/**
 * View: Update text
 */
inline var TextView.updateText
    get() = text.toString()
    set(value) {
        if (updateText != value) text = value
    }

inline var EditText.updateText
    get() = text.toString()
    set(value) {
        if (updateText != value) setText(value)
    }

/**
 * TextView: Drawable
 */
fun TextView.setStartDrawable(@DrawableRes drawableId: Int) {
    setCompoundDrawablesWithIntrinsicBounds(drawableId, 0, 0, 0)
}

fun TextView.setDrawableTint(@ColorRes color: Int) {
    TextViewCompat.setCompoundDrawableTintList(
        this, AppCompatResources.getColorStateList(context, color)
    )
}

/**
 * TextView: Error message
 */
fun TextView.asErrorMessage(message: String?) {
    when (message.isNullOrEmpty()) {
        true -> hide()
        false -> {
            text = message
            show()
        }
    }
}

/**
 * EditText: Set text with disabled TextWatcher
 */
fun EditText.updateTextWithoutTextWatcher(
    textWatcher: TextWatcher,
    block: EditText.() -> Unit
) {
    removeTextChangedListener(textWatcher)
    block()
    addTextChangedListener(textWatcher)
}

/**
 * ImageView: Change drawable tint
 */
fun ImageView.setTint(@ColorRes color: Int) {
    setColorFilter(ContextCompat.getColor(context, color))
}

/**
 * CardView: Change stroke
 */
fun MaterialCardView.changeStrokeColor(@ColorRes color: Int) {
    strokeColor = getColor(color)
}

/**
 * CardView: Change color
 */
fun MaterialCardView.changeBackgroundColor(@ColorRes color: Int) {
    setCardBackgroundColor(getColor(color))
}

/**
 * Checkbox
 */
inline var CheckBox.updateIsChecked
    get() = isChecked
    set(value) {
        if (updateIsChecked != value) isChecked = value
    }

/**
 * Clear Focus
 */
fun Fragment.clearFocus() = runCatching {
    requireActivity().currentFocus?.clearFocus()
}