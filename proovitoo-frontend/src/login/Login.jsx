import React, {useState} from 'react';
import {Link, useNavigate} from 'react-router-dom';
import axios from "axios";

function Login() {
    let navigate = useNavigate();
    const [values, setValues] = useState({
        username: '',
        password: ''
    })
    const [errors, setErrors] = useState({})
    const handleInput = (event) => {
        const { name, value } = event.target;
        setValues(prev => ({ ...prev, [name]: value }));
    };

    const handleChange = (event) => {
        event.preventDefault();
    }
    const testin = event => {
        event.preventDefault();
        console.log(values.username); // Access updated username after state update
        console.log(values.password);
    }
    const handleSubmit = async (event) => {
        const { username, password } = values;
        event.preventDefault();
        try {
            const response = await axios.get('http://localhost:8080/api/login/' + username + '/' + password, { params: values });
            if (response.status === 200) {
                console.log('Username: ' + values.username); // Access updated username after state update
                console.log('Password: ' + values.password); // Access updated password after state update
                console.log('Login successful:', response.status);
                navigate('/films/${values.username}', { replace: true });
            }
        } catch (error) {
            {/*console.error('Login error:', error);*/}
        }
    }

    return (
        <div className='d-flex justify-content-center align-items-center bg-primary vh-100'>
            <div className='bg-white p-3 rounded w-25'>
                <form action="" onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="username">Username</label>
                        <input type="text" placeholder='Enter username' onChange={handleInput} name='username' className='form-control rounded-0'/>
                        {errors.username && <span className='text-danger'>{errors.username}</span>}
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password">Password</label>
                        <input type="password" placeholder='Enter password' onChange={handleInput} name='password' className='form-control rounded-0'/>
                        {errors.password && <span className='text-danger'>{errors.password}</span>}
                    </div>
                    <button type='submit' className='btn btn-success w-100'>Log in</button>
                    <p>Sign up:</p>
                    <Link to="/signup" className='btn btn-success w-100'>Sign up</Link>
                </form>
            </div>
        </div>
    );
}

export default Login;
