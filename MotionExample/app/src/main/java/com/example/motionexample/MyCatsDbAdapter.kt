package com.example.motionexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCatsDbAdapter(private var myDataSet: List<MyCatsDb>):
    RecyclerView.Adapter<MyCatsDbAdapter.ProjectViewHolder>() {

    class ProjectViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.my_cats_list_card, parent, false))
    {
        private var catListView: TextView? = null
        private var catIdView: TextView? = null

        init {
            catListView = itemView.findViewById(R.id.cat_list)
            catIdView = itemView.findViewById(R.id.cat_id)
        }

        fun bind(project: MyCatsDb) {
            catListView?.text = project.catName
            catIdView?.text = project.catId.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProjectViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project: MyCatsDb = myDataSet[position]
        holder.bind(project)
    }

    fun setItems(projects: List<MyCatsDb>){
        myDataSet = projects
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = myDataSet.size
}