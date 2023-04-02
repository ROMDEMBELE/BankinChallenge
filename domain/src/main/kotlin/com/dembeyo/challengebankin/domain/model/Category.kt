package com.dembeyo.challengebankin.domain.model

import android.net.Uri

/**
 * Class define Category model.
 *
 * @property id identifier of the category.
 * @property uri uri of the category resource.
 * @property name name of the category.
 * @property parentId identifier of the parent's category, can be null.
 * @property custom boolean flag define if category is custom.
 * @property other boolean flag define if category is other.
 */
data class Category(
    val id: Int,
    val uri: Uri?,
    val name: String,
    val parentId: Int? = null,
    val custom: Boolean,
    val other: Boolean,
)