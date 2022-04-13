package com.dkdus.dementia.ui.game

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dkdus.dementia.R
import kotlinx.android.synthetic.main.fragment_game.view.*

class GameFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game, container, false)
        root.gugu_btn.setOnClickListener {
            var intent: Intent = Intent(context, GuguActivity::class.java)
            startActivity(intent)
        }
        root.rcp_btn.setOnClickListener {
            var intent: Intent = Intent(context, RcpActivity::class.java)
            startActivity(intent)
        }
        return root
    }

}