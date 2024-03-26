import React, {useEffect, useState} from 'react';
import {listFilms} from "../services/FilmService.js";

const ListFilmsComponent = () => {

    const [films, setFilms] = useState([])

    useEffect(() => {
        listFilms().then((response) => {
                setFilms(response.data)
            }).catch(error => {
                console.error(error)
        })

        }, []);

    return (
        <div className='container'>
            <h2>List of Films</h2>
            <div className='row'>
                {films.map(film => (
                    <div key={film.id} className='col-sm-2 mb-3'>
                        <div className='card'>
                            <div className='card-body' style={{ height: '150px' }}> {/* Set a fixed height */}
                                <h5 className='card-title'>{film.name}</h5>
                                <p className='card-text'>Rating: {film.rating}</p>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ListFilmsComponent;
