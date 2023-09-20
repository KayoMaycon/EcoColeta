const formulario = document.querySelector("form");

formulario.addEventListener('submit', function (event){
    event.preventDefault();
    open('moradorMap.html')
});