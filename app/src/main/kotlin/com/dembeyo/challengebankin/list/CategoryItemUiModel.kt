package com.dembeyo.challengebankin.list

import android.net.Uri
import com.dembeyo.challengebankin.domain.model.Category

/**
 * Category item.
 *
 * @property id identifier
 * @property uri uri
 * @property name name
 * @property parentId parend, can be null.
 */
data class CategoryItemUiModel(
    val id: Int,
    val uri: Uri?,
    val name: String,
    val parentId: Int? = null,
)

/**
 * Mapping method.
 */
fun Category.toItemUiModel() = CategoryItemUiModel(id, uri, name, parentId)