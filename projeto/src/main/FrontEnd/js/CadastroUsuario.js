//referenciar os elementos html
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById("form-signin");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    
    
    const nome = document.getElementById("inputNome");
    const sobrenome = document.getElementById("inputSobrenome");
    const email = document.getElementById("inputEmail");
    const senha = document.getElementById("inputSenha");
    const confirmarSenha = document.getElementById("inputConfirmarSenha");
    const tipoUsuario = document.getElementById("tipoUsuario");
    var nUsuario = 0;
    if(tipoUsuario.value == "Cliente"){
      nUsuario = 1;
    }else if(tipoUsuario.value == "Prestador"){
      nUsuario = 2;
    }else{
      console.log("Usuario sem tipo")
    }
    validarEntradas(nome, sobrenome, email, senha, confirmarSenha, nUsuario)

})
  
})

function validarEntradas(n, sn, e, s, cs, nUsuario) {
  const nomeValue = String(n.value);
  const sobrenomeValue = String(sn.value);
  const emailValue = String(e.value);
  const senhaValue = String(s.value);
  const confirmarSenhaValue = String(cs.value)
  
  if (validarNome(nomeValue)) {
   inputNome.className = "form-control is-valid";
  }else{
    inputNome.className = "form-control is-invalid";
  }
   
  if (validarNome(sobrenomeValue)){
    inputSobrenome.className = "form-control is-valid";
  }else{
    inputSobrenome.className = "form-control is-invalid";
  }
  if (validarEmail(emailValue)) {
    const p = document.getElementById("email-invalido");
    inputEmail.className = "form-control is-valid";
    p.style.display = "none";
  }
  else if (!validarEmail(emailValue)) {
    const p = document.getElementById("email-invalido");
    console.log("Formato de email inválido");
    inputEmail.className = "form-control is-invalid";
    p.style.display = "block";
  }
  if(validarSenhaUsuario(senhaValue)){
    const p1 = document.getElementById("senha-invalido");
    s.className = "form-control is-valid";
    p1.style.display = "none";
  }
  if(confirmarSenhaValue === senhaValue){
    const p2 = document.getElementById("confirmarsenha-invalido");  
    cs.className = "form-control is-valid";
    p2.style.display = "none";
    if(validarEmail(emailValue)){
      if(validarNome(nomeValue) && validarNome(sobrenomeValue)){
        fetch("http://localhost:8080/usuario", {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(
          { 
              nome: n.value,
              sobrenome: sn.value,
              email: e.value,
              senha: s.value,
              tipoUsuario: {
                idTipoUsuario: nUsuario
              }
          }
    )
})

    .then((res) => {
        console.log(res)
        
    })
    .catch((erro) => { console.error(erro) })
    }
    }
  }
      else{
        const p = document.getElementById("confirmarsenha-invalido");
        cs.className = "form-control is-invalid";
        p.style.display = "block";
      }

   if(!validarSenhaUsuario(senhaValue)){
    console.log(validarSenhaUsuario(senhaValue))
    const p = document.getElementById("senha-invalido");
    s.className = "form-control is-invalid";
     p.style.display = "block";
  }
}
function validarSenhaUsuario(senhaUsuario){
  let regexSenha =/^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{8,15}$/
  return regexSenha.test(senhaUsuario)
}

function validarEmail(ev) {
  let re = /\S+@\S+\.\S+/;
  return re.test(ev);
}
function validarNome(nv) {
  let rn = /[A-Z][a-z].*/;
  return rn.test(nv);
}
