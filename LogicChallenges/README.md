# Desafios de Lógica


## 1. Elementos pares

Dada una lista de elementos (array), crear una funcion que retorne una nueva lista con solo los elementos que aparecen una cantidad n veces repetidos sean pares.

```js
["A","B","A","C","C","C","C"] // -> ["A","C"]
[1,2,3,1,2] // -> [1,2]
```

## 2. Isograma

Un isograma es una palabra que no tiene letras repetidas. 

Consideraciones Adicionales:
- Un string vacío es un isograma.
- La función tiene que ser case insensitive e ignorar acentos.
- Si el string tiene mas de una palabra retornar false.
- Se tiene que hacer clean up del string antes de comparar.

Ejemplos:

```js
func("Murciélago"); // returns true
func("reto"); // returns true
func("Casa"); // returns false
func("PeRrO"); // returns false
func("GaTo"); // returns true
```

## 3. Letras por números

Reemplazar las letras de un string por su index en el alfabeto `(e.g. A = 1 , B = 2 , C = 3 ...)`

Consideraciones Adicionales:
- Ignorar espacios.
- Hacer clean up del string antes de comenzar el swap (para eliminar acentos y caracteres especiales, se sugiere meter en este proceso de clean up el ignorado de espacios).

Ejemplo:

```js
func("abc def"); // returns '1 2 3 4 5 6';
```

## 4. String termina con

Hacer una función que reciba 2 strings (siempre los va a recibir), y devuelva si el primero termina con el segundo.
Ejemplos:

```js
func("abc", "bc"); // returns true
func("abc", "d"); // returns false
```

## 5. Transformador

Hacer una función que reciba un objeto 'data' y lo transforme en la estructura output.

```js
const data = {
  nombres: [STRING],
  edades: [INT],
}
const output = [
  { id: [STRING], nombre: [STRING], edad: [INT] },
  ...
]
```

Ejemplo:

```js
func({ nombres: ["Bruno", "Andrea"], edades: [20, 19] });
```

Devuelve:

```js
[
  { id: "1", nombre: "Bruno", edad: 20 },
  { id: "2", nombre: "Andrea", edad: 19 },
];
```

## 6. Mover los ceros al final

Escribir una función que tome un array de valores y retorne el mismo array pero moviendo los ceros al final.

Ejemplo:

```js
moverCeros([false, 1, 0, 1, 2, 0, 1, 3, "a"]); // [false,1,1,2,1,3,"a",0,0]
```

Bonus: Implementar la función sin usar una variable de contador

## 7. Continentes representados

Escribir una función que recibe como parametro una lista de desarrolladores que se anotaron para asistir a una meetup. La función debe devolver `true` si existe al menos una persona de cada continente (Africa, Americas, Asia, Europe, Oceania).

Nota: Los continentes siempre estarán presentes y escritos correctamente.

Ejemplo:

```js
continentesRepresentados([
  {
    firstName: "Fatima",
    lastName: "A.",
    country: "Algeria",
    continent: "Africa",
    age: 25,
    language: "JavaScript",
  },
  {
    firstName: "Agustín",
    lastName: "M.",
    country: "Chile",
    continent: "Americas",
    age: 37,
    language: "C",
  },
  {
    firstName: "Jing",
    lastName: "X.",
    country: "China",
    continent: "Asia",
    age: 39,
    language: "Ruby",
  },
  {
    firstName: "Laia",
    lastName: "P.",
    country: "Andorra",
    continent: "Europe",
    age: 55,
    language: "Ruby",
  },
  {
    firstName: "Oliver",
    lastName: "Q.",
    country: "Australia",
    continent: "Oceania",
    age: 65,
    language: "PHP",
  },
]); // true
```

Bonus:

- Hacer otra función para retornar la cantidad de JavaScript developers que vienen de Europa y escribir los tests necesarios
- Hacer otra función que retorne el mismo array pero con una nueva propiedad `greeting` que contenga el valor `Hi < firstName here >, what do you like the most about < language here >?` y escribir los tests necesarios
- Hacer otra función que liste los lenguajes representados, sin repetir y escribir los tests necesarios

## 8. Palindromos

Un palindromo es una palabra, frase, número o secuencia de caracteres que se lee igual al derecho o al reves.

Ejemplo:

```js
232
110011
54322345
```

Escribir una función que verifique si un número puede ser reordenado para formar un palíndromo.

Nota: Los valores siempre serán numéricos y positivos.

Ejemplo:

```js
5        =>  true
2121     =>  true
1331     =>  true
3357665  =>  true
1294     =>  false
```

## 9. Validar paréntesis

Escribe una función que tome como parametro un string con paréntesis y determina si el orden de los paréntesis es válido. La función debería retornar `true` si es válido o `false` si no lo es.

```js
"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true
```