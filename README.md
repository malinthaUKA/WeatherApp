![launchericon](https://github.com/malinthaUKA/WeatherApp/assets/161362224/b3c4150c-c52d-42fd-a076-882ba43c6b1b)

# Weather App

This is a simple Weather App built using Android Studio with Java and XML. The app fetches weather data from the OpenWeatherMap API and displays it to the user. The app also utilizes the Android Volley library for making network requests.


## Features

* Get current weather information for any city.
* Display weather details such as temperature, humidity, wind speed, etc.


## Requirements

* Android Studio
* Android 7 Nougat (API 24) or higher
* OpenWeatherMap API key

  
## Dependencies

The app uses the following dependencies:

```
dependencies {
    implementation 'com.android.volley:volley:1.2.1'
}
```


## Installation

1. Clone the repository:

```

git clone https://github.com/malinthaUKA/WeatherApp.git

```

2. Open the project in Android Studio.
3. Add your OpenWeatherMap API key to the MainActivity.java file:

```

private final String appid = "YOUR_API_KEY_HERE";

```

4. Build and run the project on an Android device or emulator.


## Usage

* When the app is launched, it will request permission to access the device's location. Allow the app to access the location.

* To search for the weather in a different city, click the "Click Here to Get Weather For New City" button and enter the city name.


## Screenshots

![Screenshot_20240605-190826_Weather_App](https://github.com/malinthaUKA/WeatherApp/assets/161362224/591baf5e-ee9d-4c77-aa77-14ab58831541)

![Screenshot_20240605-190853_Weather_App](https://github.com/malinthaUKA/WeatherApp/assets/161362224/5a2113cc-ff37-48f7-bbba-662ba56780a8)

![Screenshot_20240605-190845_Weather_App](https://github.com/malinthaUKA/WeatherApp/assets/161362224/0d735a4b-5a97-492e-a3a5-9af77a52aed8)



