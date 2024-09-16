Features
Clean Architecture: Organizes code into distinct layers for better maintainability and testability.
Retrofit: Handles API calls and network requests.
Hilt: Provides dependency injection to manage and inject dependencies.

Architecture
This project follows Clean Architecture principles, which include the following layers:

Domain Layer:
Contains business logic and domain models.
Defines use cases and repository interfaces.

Data Layer:
Implements repository interfaces defined in the Domain layer.
Handles data sources (e.g., network, database).
Uses Retrofit for network operations.

Presentation Layer:
Contains UI-related code, including Activities, Fragments, and ViewModels.
Observes LiveData or StateFlow from ViewModels to update the UI.
Dependencies
Retrofit: A type-safe HTTP client for Android and Java.
Hilt: A dependency injection library for Android that reduces the boilerplate code for dependency injection.

Setup
Prerequisites
Android Studio
Kotlin
Gradle

Getting Started

Clone the Repository
git clone https://github.com/jiya1010/AndroidApplication.git
Open the Project
Open Android Studio and import the project.
Build the Project
Ensure all dependencies are resolved and the project builds successfully.
Run the Application
Connect an Android device or start an emulator and run the app.
