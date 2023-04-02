package com.dembeyo.challengebankin.data.repository

import com.dembeyo.challengebankin.data.network.dto.CategoryDto
import com.dembeyo.challengebankin.data.network.service.CategoryService
import com.dembeyo.challengebankin.domain.model.Category
import com.dembeyo.challengebankin.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val service: CategoryService) :
    CategoryRepository {

    override fun getCategoryWithParent(parentId: Int): Flow<List<Category>> = flow {
        emit(service.getCategories().filter { dto -> dto.parent?.id == parentId }
            .map(CategoryDto::toCategory))
    }


    override fun getAll(): Flow<List<Category>> = flow {
        emit(service.getCategories().map(CategoryDto::toCategory))
    }
}