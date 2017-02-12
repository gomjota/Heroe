package com.github.juan1393.heroe;

import com.github.juan1393.heroe.app.executor.ThreadExecutor;
import com.github.juan1393.heroe.app.executor.UseCaseExecutor;
import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.data.http.HttpDataSource;
import com.github.juan1393.heroe.domain.repository.ComicRepository;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.GetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.useCase.GetCharacterComicsUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * Created by Juan Gómez on 12/2/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class GetCharacterComicsUseCaseTest {

    private final int MAX_TIMEOUT_MILLISECONDS = 15000;
    private final int CHARACTER_ID_OK = 1009220;
    private final int CHARACTER_ID_FAIL = 0;

    private ComicRepository repository;
    private GetCharacterComicsUseCase useCase;

    @Mock
    GetCharacterComicsResponse response;

    @Before
    public void initialize() {
        repository = createRepository();
        useCase = createUseCase();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAListOfComics() {
        GetCharacterComicsRequest request = createRequest(CHARACTER_ID_OK);
        useCase.execute(request, response);
        verify(response, timeout(MAX_TIMEOUT_MILLISECONDS)).onCharacterComicsRetrieved(anyListOf(Comic.class));
    }

    @Test
    public void shouldNotFoundAnyComic() {
        GetCharacterComicsRequest request = createRequest(CHARACTER_ID_FAIL);
        useCase.execute(request, response);
        verify(response, timeout(MAX_TIMEOUT_MILLISECONDS)).onCharacterComicsNotFound();
    }

    private GetCharacterComicsRequest createRequest(int characterId) {
        return new GetCharacterComicsRequest(characterId);
    }

    private ComicRepository createRepository() {
        HttpDataSource httpDataSource = new HttpDataSource();
        return new ComicRepository(httpDataSource);
    }

    private GetCharacterComicsUseCase createUseCase() {
        UseCaseExecutor executor = new ThreadExecutor();
        StubMainThreadImpl stubMainThread = new StubMainThreadImpl();
        return new GetCharacterComicsUseCase(repository, executor, stubMainThread);
    }
}
