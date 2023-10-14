function togglePopup() {
    var overlay = document.getElementById('overlay');
    var popup = document.getElementById('popup');

    if (overlay && popup) {
        overlay.style.display = overlay.style.display === 'none' ? 'block' : 'none';
        popup.style.display = popup.style.display === 'none' ? 'block' : 'none';
    }
}

function obterMateriaisSelecionados() {
    var checkboxes = document.getElementsByName('material');
    var materiaisSelecionados = [];

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            var label = checkboxes[i].parentElement.textContent.trim();
            materiaisSelecionados.push(label);
        }
    }

    return materiaisSelecionados.toString();
}
