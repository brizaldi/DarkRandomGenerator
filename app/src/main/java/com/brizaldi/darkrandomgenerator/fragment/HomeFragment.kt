package com.brizaldi.darkrandomgenerator.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.brizaldi.darkrandomgenerator.R
import com.brizaldi.darkrandomgenerator.activity.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =  inflater.inflate(R.layout.fragment_home, container, false)
        mContext = rootView.context

        populateItems()

        // Inflate the layout for this fragment
        return rootView
    }

    private fun populateItems() {
        val expandingList = rootView.expanding_list_main

        val item0 = expandingList.createNewItem(R.layout.expanding_layout_home)
        item0.findViewById<TextView>(R.id.title).text = rootView.resources.getString(R.string.label_games)
        item0.createSubItems(2)
        item0.setIndicatorColorRes(R.color.textBackground)
        item0.setIndicatorIconRes(R.drawable.ic_confirmation_number_black_24dp)
        val subItem00 = item0.getSubItemView(0)
        subItem00.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_coin)
        subItem00.setOnClickListener {
            val intent = Intent(mContext, CoinActivity::class.java)
            startActivity(intent)
        }
        val subItem01 = item0.getSubItemView(1)
        subItem01.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_dice)
        subItem01.setOnClickListener {
            val intent = Intent(mContext, DiceActivity::class.java)
            startActivity(intent)
        }

        val item1 = expandingList.createNewItem(R.layout.expanding_layout_home)
        item1.findViewById<TextView>(R.id.title).text = rootView.resources.getString(R.string.label_numbers)
        item1.createSubItems(2)
        item1.setIndicatorColorRes(R.color.textBackground)
        item1.setIndicatorIconRes(R.drawable.ic_format_list_numbered_black_24dp)
        val subItem10 = item1.getSubItemView(0)
        subItem10.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_integer)
        subItem10.setOnClickListener {
            val intent = Intent(mContext, IntegerActivity::class.java)
            startActivity(intent)
        }
        val subItem11 = item1.getSubItemView(1)
        subItem11.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_sequence)
        subItem11.setOnClickListener {
            val intent = Intent(mContext, SequenceActivity::class.java)
            startActivity(intent)
        }

        val item2 = expandingList.createNewItem(R.layout.expanding_layout_home)
        item2.findViewById<TextView>(R.id.title).text = rootView.resources.getString(R.string.label_strings)
        item2.createSubItems(4)
        item2.setIndicatorColorRes(R.color.textBackground)
        item2.setIndicatorIconRes(R.drawable.ic_text_fields_black_24dp)
        val subItem20 = item2.getSubItemView(0)
        subItem20.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_list)
        subItem20.setOnClickListener {
            val intent = Intent(mContext, ListActivity::class.java)
            startActivity(intent)
        }
        val subItem21 = item2.getSubItemView(1)
        subItem21.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_string)
        subItem21.setOnClickListener {
            val intent = Intent(mContext, StringActivity::class.java)
            startActivity(intent)
        }
        val subItem22 = item2.getSubItemView(2)
        subItem22.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_date)
        subItem22.setOnClickListener {
            val intent = Intent(mContext, DateActivity::class.java)
            startActivity(intent)
        }
        val subItem23 = item2.getSubItemView(3)
        subItem23.findViewById<TextView>(R.id.sub_title).text = rootView.resources.getString(R.string.label_clock)
        subItem23.setOnClickListener {
            val intent = Intent(mContext, ClockActivity::class.java)
            startActivity(intent)
        }
    }

}