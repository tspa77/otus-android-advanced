package com.example.clean.data.repository

import com.example.clean.data.api.Api
import com.example.clean.domain.dto.ListMoviePreviews
import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview
import com.example.clean.domain.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.UnstableDefault
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
class RepositoryImplTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var api: Api

    @Mock
    lateinit var mockOnDoneMovie: Function1<MovieInfo, Unit>

    @Mock
    lateinit var mockOnDoneList: Function1<List<MoviePreview>, Unit>

    @Mock
    lateinit var mockOnError: Function1<Throwable, Unit>

    //https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-test#providing-an-explicit-testcoroutinedispatcher
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var repository: Repository

    @UnstableDefault
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = RepositoryImpl(api)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun getMovieInfo_ok()  = runBlockingTest {
        val movieInfo = MovieInfo(id = 0,title = "",overview = "",posterPath = "",releaseDate = "",voteAverage = 0.0,popularity = "")
        `when`(api.getMovie(1)).thenReturn(movieInfo)
        repository.getMovieInfo(1, mockOnDoneMovie, mockOnError)
        verify(mockOnDoneMovie).invoke(movieInfo)
    }

    @Test
    fun getMovieInfo_error() = runBlockingTest {
        val error = RuntimeException()
        `when`(api.getMovie(1)).thenThrow(error)
        repository.getMovieInfo(1, mockOnDoneMovie, mockOnError)
        verify(mockOnError).invoke(error)
    }

    @Test
    fun getListMoviePreviews() = runBlockingTest {
        val expectedList = listOf<MoviePreview>()
        val incomingList = ListMoviePreviews(expectedList)
        `when`(api.getListPopularMovies()).thenReturn(incomingList)
        repository.getListMoviePreviews(mockOnDoneList, mockOnError)
        verify(mockOnDoneList).invoke(expectedList)
    }
}
