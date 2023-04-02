package com.dembeyo.challengebankin.list

import androidx.lifecycle.ViewModel
import com.dembeyo.challengebankin.domain.model.Category
import com.dembeyo.challengebankin.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ViewModel for [CategoryListFragment].
 */
@HiltViewModel
class CategoryListViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    fun getList(): Flow<List<CategoryItemUiModel>> =
        repository.getAll().map { it.map(Category::toItemUiModel) }

}