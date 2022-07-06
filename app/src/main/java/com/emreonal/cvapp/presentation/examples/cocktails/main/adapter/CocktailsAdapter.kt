package com.emreonal.cvapp.presentation.examples.cocktails.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emreonal.core.data.local.entity.cocktail.CocktailEntity
import com.emreonal.cvapp.databinding.ListItemCocktailBinding
import com.emreonal.cvapp.presentation.examples.cocktails.main.ICocktails
import com.emreonal.cvapp.util.extensions.inflater

class CocktailsAdapter(val listener: ICocktails?) : ListAdapter<CocktailEntity, RecyclerView.ViewHolder>(object :
    DiffUtil.ItemCallback<CocktailEntity>() {
    override fun areItemsTheSame(oldItem: CocktailEntity, newItem: CocktailEntity): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CocktailEntity, newItem: CocktailEntity): Boolean =
        oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ListItemCocktailBinding.inflate(parent.context.inflater(), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(currentList[position])
    }

    inner class ViewHolder(private val binding: ListItemCocktailBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktail: CocktailEntity) {
            binding.item = cocktail
            binding.mcvImage.setOnClickListener {
                listener?.onCocktailClick(cocktail, binding.ivImage)
            }
        }

    }

}