package com.cinema.backend.mapper;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.entity.Film;

public class FilmMapper {

    public static FilmDto mapToFilmDto(Film film){
        return new FilmDto(
                film.getId(),
                film.getName(),
                film.getRating(),
                film.getTimestamp(),
                film.getRoomId(),
                film.getGenre(),
                film.getAgeRestriction()
        );
    }

    public static Film mapToFilm(FilmDto filmDto){
        return new Film(
                filmDto.getId(),
                filmDto.getRoomId(),
                filmDto.getName(),
                filmDto.getRating(),
                filmDto.getTimestamp(),
                filmDto.getGenre(),
                filmDto.getAgeRestriction()
        );
    }
}
