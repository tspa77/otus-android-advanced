package com.example.clean.presentation.presenter

import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview
import com.example.clean.domain.repo.Repository
import com.example.clean.presentation.view.CardMovieView
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class CardMoviePresenterImplTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var view: CardMovieView

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var mockOnDoneList: Function1<List<MoviePreview>, Unit>

    @Mock
    lateinit var mockOnDoneMovie: Function1<MovieInfo, Unit>

    @Mock
    lateinit var mockOnError: Function1<Throwable, Unit>

    lateinit var cardMoviePresenter: CardMoviePresenter


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cardMoviePresenter = CardMoviePresenterImpl(view, repository)
    }

    @Test
    fun getMovieInfo_error() {
        val error = RuntimeException("error!")
        `when`(repository.getMovieInfo(1, mockOnDoneMovie, mockOnError))
            .thenThrow(error)
        cardMoviePresenter.getMovieInfo(1)

        verify(view, times(1)).showLoading()
        verify(repository, times(1))
            .getMovieInfo(1, {}, {})
    }

    @Test
    fun getMovieInfo_ok() {
    }

    @After
    fun tearDown() {
    }

}
