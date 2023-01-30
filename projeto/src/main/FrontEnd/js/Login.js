document.addEventListener('DOMContentLoaded', () =>{
    const login = document.getElementById('login')
    const email = document.getElementById('email')
    const senha = document.getElementById('senha')
    login.addEventListener('submit', async(e)=>{
        e.preventDefault();
        fetch("http://localhost:8080/usuario/login/" + email.value + "/" + senha.value)
        .then(res => {
            return res.json();
        }).then(saida =>{
            if(saida != null){
                localStorage.setItem('idUsuario',saida.idUsuario)
                alert("bem vindo" + saida.nome)
            }
        }).then(window.location.replace('index.html'))
        .catch((erro) =>{console.log(erro)})
    })
})