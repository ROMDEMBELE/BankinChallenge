package com.dembeyo.challengebankin.data.network.dto

import android.net.Uri
import com.dembeyo.challengebankin.domain.model.Category

data class CategoryDto(
    val id: Int,
    val resource_uri: String,
    val resource_type: String,
    val name: String,
    val parent: ParentDto?,
    val custom: Boolean,
    val other: Boolean,
    val is_deleted: Boolean,
) {

    fun toCategory() = Category(
        id = id,
        uri = Uri.parse(resource_uri),
        name = name,
        parentId = parent?.id,
        custom = custom,
        other = other
    )
}