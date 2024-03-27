import React, {useState} from 'react';
import {Link} from "react-router-dom";
import Validation from "./LoginValidation.js";

function Signup() {
    const [values, setValues] = useState({
        username: '',
        password: ''
    })
    const [errors, setErrors] = useState({})
    const handleInput = (event) => {
        setValues(prev => ({...prev, [event.target.name] : [event.target.value]}))
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        setErrors(Validation(values));
    }
    return (
        <div className='d-flex justify-content-center align-items-center bg-primary vh-100'>
            <div className='bg-white p-3 rounded w-25'>
                <form action="" onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="username">Username</label>
                        <input type="text" placeholder='Enter username' name='username' onChange={handleInput} className='form-control rounded-0'/>
                        {errors.username && <span className='text-danger'>{errors.username}</span>}
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password">Password</label>
                        <input type="password" placeholder='Enter password' name='password' onChange={handleInput} className='form-control rounded-0'/>
                        {errors.password && <span className='text-danger'>{errors.password}</span>}
                    </div>
                    <button type='submit' className='btn btn-success w-100'>Sign up</button>
                </form>
            </div>
        </div>
    );
}

export default Signup;