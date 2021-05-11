package id.revan.tryjetpackcompose.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment

class InfoDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(): InfoDialogFragment {
            return InfoDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    SuccessContent {
                        // on click button close
                        dismiss()
                    }
                }
            }
        }
    }
}