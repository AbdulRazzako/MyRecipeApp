# 🍽️ Recipe App

A simple Android app **created to practice Android development using Kotlin**, Jetpack Compose, and Clean Architecture (MVVM).  
It fetches recipe categories from [TheMealDB API](https://www.themealdb.com/) to demonstrate API integration, modern UI design, and architectural best practices.

---

## 🚀 Features

- 🧑‍🍳 Browse recipe categories from TheMealDB
- 📄 View category details on a separate screen
- 🔄 API integration using **Retrofit**
- 🧼 Clean MVVM architecture
- 📱 Modern UI with **Jetpack Compose**
- 🖼️ Image loading via **Coil**
- 🔍 Error handling and loading indicators

---

## 🧰 Tech Stack

| Layer         | Library/Tool                             |
|---------------|-------------------------------------------|
| UI            | Jetpack Compose, Material3               |
| Architecture  | MVVM (ViewModel, State)                  |
| Networking    | Retrofit, Gson converter                 |
| Image Loading | Coil                                     |
| Language      | Kotlin                                   |
| State         | Compose State APIs                       |
| Navigation    | Jetpack Navigation-Compose               |

---

## 🧭 Navigation

The app uses **Jetpack Navigation Compose** to manage screen transitions.

- 🏠 `RecipeScreen`: Lists all categories retrieved from the API.
- 📄 `DetailScreen`: Displays more info about a selected category.

Data is passed between screens using `NavController` and `savedStateHandle`:

```kotlin
navController.currentBackStackEntry?.savedStateHandle?.set("cat", selectedCategory)
navController.navigate(Screen.DetailScreen.route)
