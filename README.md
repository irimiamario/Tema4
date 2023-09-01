# Tema4

Dark Mode

Implement a web app that is able to support Dark Mode display.

Endpoints:

GET /api/cars
Displays two things (with a DTO):
A list of cars from the database (Controller, Service, Repository required)
Information about whether dark mode is true or false
May receive the "darkmode" cookie (in a client header) and provide the response accordingly (in the previous DTO)
Dark Mode Endpoints (cont.):

PUT /api/dark-mode
Receives in body a DTO with dark mode setting (true or false):
json
Copy code
{
  "darkMode": true
}
Sends a header response with user preference ("Set-Cookie" header)
Dark Mode Example of DTO provided by the GET /api/cars endpoint:

json
Copy code
{
  "darkMode": true,
  "cars": [
    {
      "name": "Tesla",
      "model": "Model 3"
    },
    {
      "name": "Dacia",
      "model": "Logan"
    }
]
}
