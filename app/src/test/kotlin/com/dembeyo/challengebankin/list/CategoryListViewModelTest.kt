@file:OptIn(ExperimentalCoroutinesApi::class)

package com.dembeyo.challengebankin.list

import com.dembeyo.challengebankin.domain.repository.CategoryRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Test class for [CategoryListViewModel].
 */
class CategoryListViewModelTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    private lateinit var repositoryMock: CategoryRepository

    // FIXME non valid test
    @Test
    fun getList_shall_returnListOfCategoryItem() = runTest {
        // Arrange
        val expected = CategoryItemUiModel(
            id = 1,
            uri = null,
            name = "test",
            parentId = 2
        )
        coEvery { repositoryMock.getAll() } returns flowOf(listOf(mockk {
            every { toItemUiModel() } returns expected
        }))
        val sut = CategoryListViewModel(repositoryMock)

        // Act
        val result: List<CategoryItemUiModel> = sut.getList().first()

        // Assert
        assertEquals(1, result.size)
        assertEquals(expected.id, result[0].id)
        assertEquals(expected.name, result[0].name)
        assertEquals(expected.uri, result[0].uri)
        assertEquals(expected.parentId, result[0].parentId)
    }
}