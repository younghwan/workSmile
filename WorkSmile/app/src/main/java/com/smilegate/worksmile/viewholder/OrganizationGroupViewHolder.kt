package com.smilegate.worksmile.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smilegate.worksmile.R
import com.smilegate.worksmile.model.OrganizationGroupData
import kotlinx.android.synthetic.main.item_organization_group.view.*

class OrganizationGroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var mGroupName: TextView = view.findViewById(R.id.tv_groupName_org)

    fun bind(group: OrganizationGroupData) {
        mGroupName.text = group.name
    }
}