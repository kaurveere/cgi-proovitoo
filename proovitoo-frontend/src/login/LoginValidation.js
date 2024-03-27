function Validation(values){
    let error = {}

    if(values.username === ""){
        error.username = "Field should not be empty"
    }else{
        error.username = ""
    }

    if(values.password === ""){
        error.password = "Field should not be empty"
    }else{
        error.password = ""
    }

    return error;
}

export default Validation;