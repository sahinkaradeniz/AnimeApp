# AnimeApp - Multi-Module Android App
This is an application to understand Multi-Module architecture and Kotlin technologies.

## Project Screens
HOME SCREEN | DETAİL SCREEN | DETAİL SCREEN | 
--- | --- | --- | 
![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/229534880-c3eee580-9ca6-4dfc-adff-0bd48f1bdfeb.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/229292046-cd52374b-39d9-4f8c-8f5a-1d683058cb7b.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/229535097-55060382-07fa-44a3-8770-abe3b4086456.png) |


## Project Tech stack 

- [Kotlin](https://developer.android.com/kotlin)
 
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

- [Kotlin Flow](https://developer.android.com/kotlin/flow)

- [Kotlin Coroutine](https://developer.android.com/kotlin/coroutines)
 
- [Dependency Injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

- [Navigation Component](https://developer.android.com/guide/navigation)

- [Retrofit](https://square.github.io/retrofit/)

- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

- [UseCase](https://developer.android.com/topic/architecture/domain-layer)

- [Repository](https://developer.android.com/topic/architecture/data-layer)

- [Glide ](https://github.com/bumptech/glide)

## Project Graph

<img width="233" alt="Ekran Resmi 2023-03-26 12 11 59" src="https://user-images.githubusercontent.com/85341568/229533259-66561285-a573-41f8-b2ea-0fedeef4cef8.png">

## Project Modules

#### Data Module

* This module contains the code related to the data layer of your application. This layer is responsible for accessing the application's data sources (API, database, etc.) and preparing and processing data received from these sources. The code in this module usually includes operations like retrieving data from data sources, data processing, data storage, etc. Examples of code that could be included in this module are Room database operations, Retrofit API calls, data models, etc.

![Untitled (1)](https://user-images.githubusercontent.com/85341568/229533449-de102855-f7a6-4d80-990d-e39017ea8fbf.jpg)

#### Domain Module

* This module contains the code related to the business logic of your application. This layer processes the data received from data sources and contains the code that implements the application's features. The code in this module usually includes the business logic that is specific to your application's features. Examples of code that could be included in this module are user account operations, anime data filtering operations, favorite anime lists, etc.

![Untitled (2)](https://user-images.githubusercontent.com/85341568/229533722-5fa0775b-1f18-4d50-8361-949357ff1866.jpg)

#### Presentation Module

* This module contains the code related to the user interface of your application. This layer provides the design and functionality of your application's user interface. The code in this module usually includes activities, fragments, custom views, etc. Examples of code that could be included in this module are the main page, detail page, anime list, etc.

![Untitled (3)](https://user-images.githubusercontent.com/85341568/229533864-4855e808-f491-4716-a5ed-6ab994644890.jpg)

#### Common Module

* This module contains the common code that is used across different modules of your application. This module helps to reduce code duplication across different modules and makes your application more modular. The code in this module usually includes helper classes, general functions, etc. that are used in different parts of your application.

![Untitled (5)](https://user-images.githubusercontent.com/85341568/229533921-5fc6445d-0549-455b-8137-89c52a36cf59.jpg)


## API

[Jikan Anime Api](https://jikan.moe/)

