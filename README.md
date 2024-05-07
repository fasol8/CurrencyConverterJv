# Currency Converter

Este es un simple convertidor de divisas que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del convertidor de divisas">

## Requisitos

- Java JDK 8 o superior.
- Acceso a Internet para realizar consultas a la API.

## Uso

1. Clona este repositorio o descarga el archivo `CurrencyConverter.java`.
2. Compila el archivo Java utilizando tu IDE o mediante la línea de comandos:
   ```bash
   javac CurrencyConverter.java
   ```
3. Ejecuta el programa compilado:
   ```bash
   java CurrencyConverter
   ```
4. Sigue las instrucciones en pantalla para seleccionar las divisas de origen y destino, ingresa la cantidad a convertir y obtén el resultado.

## API Key

Para utilizar este convertidor, necesitas obtener una clave API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/). Una vez que hayas obtenido tu clave, reemplaza el valor de `API_KEY` en el código con tu clave API.

```java
String API_KEY = "tu_clave_api";
```

## Notas

- Las conversiones están sujetas a las tasas de cambio en tiempo real proporcionadas por la API.
- Este programa solo admite las siguientes divisas: MXN, USD, EUR, BRL, COP, PEN.

---

Si necesitas más detalles o ajustes, házmelo saber.