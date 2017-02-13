package com.github.juan1393.heroe.domain.useCase;

import com.github.juan1393.heroe.app.executor.MainThread;
import com.github.juan1393.heroe.app.executor.UseCaseExecutor;
import com.github.juan1393.heroe.app.model.Comic;
import com.github.juan1393.heroe.data.exception.CharacterComicsNotFoundException;
import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.domain.repository.ComicRepository;
import com.github.juan1393.heroe.domain.request.GetCharacterComicsRequest;
import com.github.juan1393.heroe.domain.response.GetCharacterComicsResponse;
import com.github.juan1393.heroe.domain.response.Response;

import java.util.List;

/**
 * Created by Juan Gómez on 11/2/17.
 */

public class GetCharacterComicsUseCase extends BaseUseCase<GetCharacterComicsRequest, GetCharacterComicsResponse> {

    private ComicRepository comicRepository;

    public GetCharacterComicsUseCase(ComicRepository comicRepository,
                                     UseCaseExecutor executor, MainThread mainThread) {
        super(executor, mainThread);
        this.comicRepository = comicRepository;
    }

    @Override
    public void run() {
        try {
            Response<List<Comic>> response = comicRepository.getCharacterComics(request);
            notifySuccess(response.getData());
        } catch (NetworkConnectionException e) {
            notifyNetworkConnectionError();
        } catch (CharacterComicsNotFoundException e) {
            notifyComicsNotFound();
        }
    }

    private void notifySuccess(final List<Comic> comics) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                response.onCharacterComicsRetrieved(comics);
            }
        });
    }

    private void notifyComicsNotFound() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                response.onCharacterComicsNotFound();
            }
        });
    }

    private void notifyNetworkConnectionError() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                response.onNetworkConnectionError();
            }
        });
    }
}
