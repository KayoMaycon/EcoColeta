var map;

function initMap(){
    map = new google.maps.Map(document.getElementById('map'),{
        center: {lat: -11.2999, lng:-41.8568},
        zoom: 15
    });
}