![Heroe image](/art/logo_marvel.jpg?raw=true)

Heroe
--------------
Visualize information about comics of your favorite Marvel character. By default,
the character selected is Captain America.

Clean approach
--------------
This app is modeled using the Clean Architecture approach. To reach the main goals of Clean, the app has the following patterns:

 * **MVP**: Separates the presentation layer from the logic.
 * **Interactor (Use Cases)**: Contains the business logic code. These are run in the background thread and communicate events to the upper layer using callbacks.
 * **Repository**: Picks different data sources depending on certain conditions. Right now
 the app has just a Http data source, but it is ready to add others like persistence or memory.
 * **Navigator**: Allows to navigate through different UI elements.
