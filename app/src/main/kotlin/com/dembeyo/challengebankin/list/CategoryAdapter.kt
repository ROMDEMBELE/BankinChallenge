package com.dembeyo.challengebankin.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dembeyo.challengebankin.R
import com.dembeyo.challengebankin.databinding.ItemCategoryBinding

/**
 * Adapter for [CategoryItemUiModel].
 *
 * @property categories list of [CategoryItemUiModel] to display.
 */
class CategoryAdapter(
    private val categories: List<CategoryItemUiModel>,
    private val presenter: CategoryListPresenter,
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCategoryBinding.bind(itemView)

        fun bind(category: CategoryItemUiModel) {
            binding.item = category
            binding.root.setOnClickListener { presenter.onCategoryClick(category.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}