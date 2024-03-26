package com.cinema.backend.mapper;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.entity.Film;

public class FilmMapper {

    public static FilmDto mapToFilmDto(Film film){
        return new FilmDto(
                film.getId(),
                film.getName(),
                film.getRating()
        );
    }

    public static Film mapToFilm(FilmDto filmDto){
        return new Film(
                filmDto.getId(),
                filmDto.getName(),
                filmDto.getRating()
        );
    }
}
