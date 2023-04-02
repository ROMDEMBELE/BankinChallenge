@file:OptIn(ExperimentalCoroutinesApi::class)

package com.dembeyo.challengebankin.data.repository

import com.dembeyo.challengebankin.data.network.service.CategoryService
import com.dembeyo.challengebankin.domain.model.Category
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Test class for [CategoryRepositoryImpl].
 */
class CategoryRepositoryImplTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    lateinit var serviceMock: CategoryService

    @Test
    fun getAll_returnFlowOfEmptyList() = runTest {
        // Arrange
        coEvery { serviceMock.getCategories() } returns emptyList()
        val sut = CategoryRepositoryImpl(serviceMock)

        // Act
        val result = sut.getAll().first()

        // Assert
        assertEquals(emptyList<Category>(), result)
    }

    @Test
    fun getAll_returnFlowOfCategoryList() = runTest {
        // Arrange
        val expected = Category(
            id = 1,
            uri = null,
            name = "Test",
            parentId = null,
            custom = false,
            other = false
        )
        coEvery { serviceMock.getCategories() } returns listOf(mockk {
            every { toCategory() } returns expected
        })
        val sut = CategoryRepositoryImpl(serviceMock)

        // Act
        val result = sut.getAll().first()

        // Assert
        assertEquals(1, result.size)
        assertEquals(expected, result[0])
    }
}