Progra III 

Serie I: los 3 ejercicios tienen pruebas unitarias y tambien se puede comprobar con los paths correspondientes 
ejecutar con **mvn compile quarkus:dev**
  **Palabras Cruzadas**
    Test: passed 2

    Postman post
    [localhost](http://localhost:8080/validar)

    {
    "board": [
        ["H", "E", "L", "L", "O", "#", "W", "O", "R", "D"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
        ["J", "A", "V", "A", "#", "#", "#", "#", "#", "#"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
        ["C", "O", "D", "E", "#", "C", "A", "T", "#", "#"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
        ["#", "#", "P", "Y", "T", "H", "O", "N", "#", "#"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
        ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#"]
    ],
    "diccionario": ["HELLO", "WORLD", "JAVA", "CODE", "CAT", "PYTHON"]
    }

    Devuelve 415 Unsupported Media Type

  **Arbol**
    test passed 2

    postman get
    http://localhost:8080/paths/demo

    Devuelve:
      [
        [
          5,
          4,
          11,
          2
        ],
        [
          5,
          8,
          4,
          5
        ]
      ]

  **Arbol-profundidad**
    test passed 2

    postman post
    http://localhost:8080/arbol/profundidades
    json 1:
    {
      "valor": 1,
      "izquierda": {
      "valor": 2,
      "izquierda": {
      "valor": 4
                   },
    "derecha": {
      "valor": 5
    }
    },
    "derecha": {
    "valor": 3
    }
    }

    retorna:
      {
    "profundidadMinima": 2,
    "profundidadMaxima": 3
      }

Serie II:
API REST con operaciones básicas CRUD para gestionar libros en una biblioteca

  **Biblioteca**

  postman post 
  
  (Crear libro) post
  http://localhost:8080/libros
  json: 
    {
      "titulo": "Cien años de soledad",
      "autor": "Gabriel García Márquez",
      "anioPublicacion": 1967,
      "genero": "Realismo mágico"
    }
    
  Obtener Libro por id GET
  http://localhost:8080/libros/2

  actualizar Libro por id put
  http://localhost:8080/libros/1
  json:
    {
      "titulo": "Cien años de soledad - nueva version",
      "autor": "Gabriel García Márquez",
      "anioPublicacion": 1967,
      "genero": "Realismo mágico"
    }

   Borrar Libro por id delete
   http://localhost:8080/libros/2
   
