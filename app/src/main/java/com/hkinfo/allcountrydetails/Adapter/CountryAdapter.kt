package com.hkinfo.allcountrydetails.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.hkinfo.allcountrydetails.Model.CountryModal
import com.hkinfo.allcountrydetails.databinding.CountryItemBinding

class CountryAdapter(list: List<CountryModal>, clickItem: Any?) : RecyclerView.Adapter<CountryAdapter.CountryHolder>(){

    lateinit var context: Context
    var list = list
    var clickItem = clickItem

    class CountryHolder(itemView: CountryItemBinding) : ViewHolder(itemView.root){
        var imgFlag = itemView.imgFlag
        var txtCountry = itemView.txtcountry
        var txtCap = itemView.txtCapital
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
    context = parent.context
    var binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return CountryHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {

        holder.txtCountry.text = list.get(position).name
        holder.txtCap.text = list.get(position).capital
        Glide.with(context).load(list.get(position).flags?.png).into(holder.imgFlag)
    }

    fun setList(list: ArrayList<CountryModal>) {
        this.list = list
    }
}