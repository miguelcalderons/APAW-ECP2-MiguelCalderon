# Proyecto Arquitecturas y Patrones Web
#### APAW-ECP2
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

**DEVELOP:** [![Build Status](https://travis-ci.org/miguelcalderons/APAW-ECP2-MiguelCalderon.svg?branch=develop)](https://travis-ci.org/miguelcalderons/APAW-ECP2-MiguelCalderon)  

# Proyecto Arquitecturas y Patrones Web
#### APAW-ECP2
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

**DEVELOP:** [![Build Status](https://travis-ci.org/miguelcalderons/APAW-ECP2-MiguelCalderon.svg?branch=develop)](https://travis-ci.org/miguelcalderons/APAW-ECP2-MiguelCalderon)  

## API
### POST /Captain

- `email`: String
- `name`: String

#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
---
### PUT /captain/{id}
#### Parámetros del cuerpo
- `email`: String
- `name`: String
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
--- 
### POST /report
#### Parámetros del cuerpo
- `safeLanding`: Boolean
- `description`: String
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
---
### POST /flights
#### Parámetros del cuerpo
- `flightId`: String
- `destination`: String
- `weather`: weather

#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /flight
#### Respuesta
- 200 OK 
  - `[ {id:String,destination:String} ]`
---
### DELETE /flight/{id}
#### Respuesta
- 200 OK 
---
### POST /flight/{id}/passengers
#### Parámetros del cuerpo
- `value`: Integer
- 'name': String
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /flight/{id}/average
#### Respuesta
- 200 OK 
  - `average`: Double
- 404 NOT_FOUND
---
### PATH /flight/{id}/weather
#### Parámetros del cuerpo
- `weather`: String 
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /flight/search?q=average:>=3
#### Respuesta
- 200 OK
  - `[ {id:String,destination:String} ]`
- 403 BAD_REQUEST