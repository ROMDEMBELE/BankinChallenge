package com.dembeyo.challengebankin.domain.repository

import com.dembeyo.challengebankin.domain.model.Category
import kotlinx.coroutines.flow.Flow

/**
 * Interface, define the use case method of [Category] object.
 *
 */
interface CategoryRepository {

    /**
     * Get the list of [Category] with parentId.
     */
    fun getCategoryWithParent(parentId: Int): Flow<List<Category>>

    /**
     * Get the complete list of [Category].
     */
    fun getAll(): Flow<List<Category>>
}