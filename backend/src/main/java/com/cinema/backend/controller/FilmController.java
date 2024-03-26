package com.cinema.backend.controller;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.exception.ResourceNotFoundException;
import com.cinema.backend.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/films")
public class FilmController {

    private FilmService filmService;

    // Build Add Film REST API
    @PostMapping
    public ResponseEntity<FilmDto> createFilm(@RequestBody FilmDto filmDto){
        FilmDto savedFilm = filmService.createFilm(filmDto);
        return new ResponseEntity<>(savedFilm, HttpStatus.CREATED);
    }

    //Build Get Film REST API
    @GetMapping("{id}")
    public ResponseEntity<FilmDto> getFilmById(@PathVariable("id") Long filmId) throws ResourceNotFoundException {
        FilmDto filmDto = filmService.getFilmById(filmId);
        return ResponseEntity.ok(filmDto);
    }

    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms(){
        List<FilmDto> films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
    }

    //Build Update Film REST API
    @PutMapping("{id}")
    public ResponseEntity<FilmDto> updateFilm(@PathVariable("id") Long filmId, @RequestBody FilmDto updatedFilm) throws ResourceNotFoundException {
        FilmDto filmDto = filmService.updateFilm(filmId, updatedFilm);
        return ResponseEntity.ok(filmDto);
    }

    //Build Delete REST API
    @DeleteMapping("{id}")
    ResponseEntity<String> deleteFilm(@PathVariable("id") Long filmId) throws ResourceNotFoundException {
        filmService.deleteFilm(filmId);
        return ResponseEntity.ok("Film deleted successfully");
    }
}
