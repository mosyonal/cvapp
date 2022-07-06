package com.emreonal.cvapp.presentation.examples.cocktails.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreonal.cvapp.databinding.ListItemIngredientBinding
import com.emreonal.cvapp.util.extensions.load

class CocktailIngredientsAdapter : RecyclerView.Adapter<CocktailIngredientsAdapter.ViewHolder>() {

    var list: List<Map<String, String>> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ListItemIngredientBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Map<String, String>) {
            item.entries.forEach {
                binding.tvName.text = it.key
                binding.tvQuantity.text = it.value
                binding.ivImage.load(binding.root.context, "https://www.thecocktaildb.com/images/ingredients/${it.key.replace(" ", "%20")}.png")
            }
        }
    }

}