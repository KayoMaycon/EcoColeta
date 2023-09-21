const cardSlider = document.querySelector('.card-slider');

let cardIndex = 0;

function showCard(index) {
    cardSlider.style.transform = `translateX(-${index * 100}%)`;
}

showCard(cardIndex);

setInterval(() => {
    cardIndex = (cardIndex + 1) % 3;
    showCard(cardIndex);
}, 3000);
