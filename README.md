# Raitha-Varta (Farmer's Voice)

An AI-powered agricultural advisory app designed for farmers, featuring high-contrast UI, local language support, and GenAI-driven crop insights.

## Project Structure

- `/app`: Native Android application (Kotlin + Jetpack Compose).
- `/backend`: Node.js + Express API for AI features (Disease detection, Tip generation).
- `/firestore.rules`: Security rules for User profiles and Marketplace.

## Features

- **Daily 1-Minute Tips**: Swipable flash-cards with voice-over support.
- **AI Disease Detection**: Analyze leaf photos using Gemini AI.
- **Expert Ask**: Connect with experts for farm-related queries.
- **Local Marketplace**: Buy and sell agricultural products.
- **Hyperlocal Weather**: Personalized weather advisories.

## Setup Instructions

### Backend
1. Ensure `GEMINI_API_KEY` is set in your environment (Secrets in AI Studio).
2. Run `npm install` in the root.
3. Run `npm run dev` to start the backend.

### Android App
1. Open the project root in **Android Studio**.
2. Sync the Gradle files.
3. Replace the `baseUrl` in your Retrofit client with your backend URL.
4. Build and Run on an emulator or physical device (Min SDK 24).

## Languages Supported
- Kannada (Primary)
- English
- Hindi
- Tamil

## Tech Stack
- **Android**: Kotlin, Jetpack Compose, Material 3, Navigation, Hilt, Room, Coil, Retrofit.
- **Backend**: Node.js, Express, @google/genai (Gemini AI).
- **Database**: Firebase Firestore, Firebase Authentication.
