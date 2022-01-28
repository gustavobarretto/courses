// const v = [ ['x', 'y'], ['x', 'y']];

// const v2 = v.join(';')

// console.log(v2);

// console.log(v2.split(';').map( item => item.split(',')))
const fs = require('fs');
const axios = require('axios');

async function main() {
  
  const { data } = await axios.get("https://bhmap.pbh.gov.br/v2/api/idebhgeo/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=namespace:ADE_INTERESSE_AMBIENTAL_11181&outputFormat=json");
    
  const arrCoordinatesSA = data.features.map( item => {
    return findArr(item.geometry);
  })

  const arr = arrCoordinatesSA.join(';');
  fs.writeFileSync('arr.txt', arr);

}

function findArr(geometry) {
  switch(geometry?.type) {
    case "Polygon":
      return geometry?.coordinates[0][0];
    case "Point":
      return geometry?.coordinates;
    case "MultiPolygon":
      return geometry?.coordinates[0][0][0]; 
    case "MultiLineString":
      return geometry?.coordinates[0][0]; 
    case "LineString":
      return geometry?.coordinates[0]; 
    default:
      return geometry.coordinates;
  }
}

main()

