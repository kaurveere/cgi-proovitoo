package com.cinema.backend.service;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.exception.ResourceNotFoundException;

import java.util.List;

public interface FilmService {
    FilmDto createFilm(FilmDto filmDto);

    FilmDto getFilmById(Long filmId) throws ResourceNotFoundException;

    List<FilmDto> getAllFilms();

    FilmDto updateFilm(Long filmId, FilmDto updatedFilm) throws ResourceNotFoundException;

    void deleteFilm(Long filmId) throws ResourceNotFoundException;
}
