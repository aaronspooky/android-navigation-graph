package dev.jaque.navigationgraph.ui.dashboard.new_action

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.jaque.navigationgraph.R

/**
 * A simple [Fragment] subclass.
 */
class NewDashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_dashboard, container, false)
    }

}
