function btnOnClick(login){
    if(login){
        window.location = "http://localhost:8080/login.jsp"
    }else{
        window.location =  "http://localhost:8080/create.jsp"
    }
}

const userCreateForm = document.getElementById("createUserForm");
const userLoginForm = document.getElementById("loginForm");
if(userCreateForm){
    userCreateForm.addEventListener("submit",async (e)=>{
        e.preventDefault()

        const userDTO = {
            username:userCreateForm.username.value,
            password:userCreateForm.password.value
        }

        console.log(userCreateForm.username.value)

        await fetch("http://localhost:8080/UserCreate",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userDTO),
        }).then(response=>response.json()).then((responseDTO)=>{
            if(responseDTO.status){
                window.location = "login.jsp"
            }else{
                alert("User creation failed");
                console.log(responseDTO.status)
            }
        }).catch((err)=>{
            console.log(err)
        })
    })
}

if(userLoginForm){
    userLoginForm.addEventListener("submit",async (e)=>{
        e.preventDefault();
        const userDTO = {
            username:userLoginForm.username.value,
            password:userLoginForm.password.value
        }

        await fetch("http://localhost:8080/UserLogin",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userDTO),
        }).then(response=>response.json()).then((responseDTO)=>{
            if(responseDTO.status){
                window.location = "home.jsp"
            }else{
                alert("User login failed");
            }
        }).catch((err)=>{
            console.log(err)
        })
    })
}