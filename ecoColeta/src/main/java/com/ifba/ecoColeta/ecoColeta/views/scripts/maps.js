function GetMap()
    {
        var map = new Microsoft.Maps.Map('#myMap', {
            zoom: 60
        });
        
         var pin = new Microsoft.Maps.Pushpin(map.getCenter(), {
            icon: 'images/mapSelectedIcon.svg',
            anchor: new Microsoft.Maps.Point(12, 39)
        });

        map.entities.push(pin);

        Microsoft.Maps.Events.addHandler(map, 'click',getLatlng ); 
    }


function getLatlng(e) { 
    
        if (e.targetType == "map") {
        
            var point = new Microsoft.Maps.Point(e.getX(), e.getY());
            var locTemp = e.target.tryPixelToLocation(point);
            var location = new Microsoft.Maps.Location(locTemp.latitude, locTemp.longitude);
            var newPin = new Microsoft.Maps.Pushpin(location, {
                icon: 'images/coletaIcon.svg',
                anchor: new Microsoft.Maps.Point(12, 39)
            });

            
            e.entities.push(newPin);

        }
    }

    /*
function descartar()
    {

    }*/
