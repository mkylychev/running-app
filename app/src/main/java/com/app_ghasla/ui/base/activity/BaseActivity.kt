package com.app_ghasla.ui.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.viewbinding.ViewBinding
import com.app_ghasla.R
import com.app_ghasla.ui.base.dialog.SimpleDialogFragment

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

    private fun initBinding() {
        _binding = bindingInflater(layoutInflater)
        setContentView(binding.root)
    }

    protected fun showErrorDialog(message: String) {
        if (message.isNotEmpty()) {
            SimpleDialogFragment(
                title = getString(R.string.dialog_titleWhoops),
                description = message,
                buttonPositiveTitle = getString(R.string.dialog_buttonOk)
            ).show(supportFragmentManager)
        }
    }
}