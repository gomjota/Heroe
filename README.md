![Heroe image](/art/logo_marvel.jpg?raw=true)

## Heroe
Visualize information about comics of your favorite Marvel character. By default,
the character selected is Captain America.

## Clean approach
This app is modeled using the Clean Architecture approach. To reach the main goals of Clean, the app has the following patterns:

 * **MVP**: Separates the presentation layer from the logic.
 * **Interactor (Use Cases)**: Contains the business logic code. These are run in the background thread and communicate events to the upper layer using callbacks.
 * **Repository**: Picks different data sources depending on certain conditions. Right now
 the app has just a Http data source, but it is ready to add others like persistence or memory.
 * **Navigator**: Allows to navigate through different UI elements.

The app uses Dagger 2 for dependency injection.

## API
For security reasons, private and public key of Marvel API are not provided. Please, add your public/private keys in build.gradle ("all" buildTypes)

## APK
In order to have a look to the app, you can download the [APK](./art/juangomez_app_marvel.apk)

## Test
The app has instrumentation tests and unit test

## Screenshots
 ![Heroe image](/art/comics_screenshot.jpg?raw=true)

 ![Heroe image](/art/comic_detail_screenshot.jpg?raw=true)

## Developer
Juan Gómez Trapero - [LinkedIn](https://www.linkedin.com/in/juan-gómez-trapero-27019299)
