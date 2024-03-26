package com.cinema.backend.service.impl;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.entity.Film;
import com.cinema.backend.exception.ResourceNotFoundException;
import com.cinema.backend.mapper.FilmMapper;
import com.cinema.backend.repository.FilmRepository;
import com.cinema.backend.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    @Override
    public FilmDto createFilm(FilmDto filmDto) {

        Film film = FilmMapper.mapToFilm(filmDto);
        Film savedFilm = filmRepository.save(film);
        return FilmMapper.mapToFilmDto(savedFilm);
    }

    @Override
    public FilmDto getFilmById(Long filmId) throws ResourceNotFoundException {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Film doesn't exist by given ID: " + filmId));
        return FilmMapper.mapToFilmDto(film);
    }

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        return films.stream().map((film) -> FilmMapper.mapToFilmDto(film))
                .collect(Collectors.toList());
    }

    @Override
    public FilmDto updateFilm(Long filmId, FilmDto updatedFilm) throws ResourceNotFoundException {
        Film film = filmRepository.findById(filmId).orElseThrow(() ->
                new ResourceNotFoundException("Film doesn't exist by given ID: " + filmId)
                );

        film.setName(updatedFilm.getName());
        film.setRating(updatedFilm.getRating());

        Film updatedFilmObj = filmRepository.save(film);

        return FilmMapper.mapToFilmDto(updatedFilmObj);
    }

    @Override
    public void deleteFilm(Long filmId) throws ResourceNotFoundException {
        Film film = filmRepository.findById(filmId).orElseThrow(() ->
                new ResourceNotFoundException("Film doesn't exist by given ID: " + filmId)
        );

        filmRepository.deleteById(filmId);
    }
}
