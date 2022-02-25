# Toast-It
Toast library for android


<div align="center">
	<img src="https://i.imgur.com/tcjICAv.png" width="128">
</div>

Fancy toast with material colors.

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.mrpascal1:Toast-It:1.0.2'
}
```

## Configuration

This step is optional, but if you want you can configure some ToastIt parameters. Place this anywhere in your app:

### Kotlin
```kotlin
ToastIt.Config.getInstance()
    .tintIcon(tintIcon Boolean) // optional (apply textColor also to the icon)
    .setToastTypeface(typeface Typeface) // optional
    .setTextSize(sizeInSp Int) // optional
    .allowQueue(allowQueue Boolean) // optional (prevents several Toasts from queuing)
    .setGravity(isRTL Boolean, xOffset Int, yOffset Int) // optional (set toast gravity, offsets are optional)
    .supportDarkTheme(isRTL Boolean) // optional (whether to support dark theme or not)
    .setRTL(isRTL Boolean) // optional (icon is on the right)
    .apply() // required
```

You can reset the configuration by using `reset()` method:

```kotlin
ToastIt.Config.reset()
```

### Java
```java
ToastIt.Config.getInstance()
    .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
    .setToastTypeface(@NonNull Typeface typeface) // optional
    .setTextSize(int sizeInSp) // optional
    .allowQueue(boolean allowQueue) // optional (prevents several Toasts from queuing)
    .setGravity(boolean isRTL, int xOffset, int yOffset) // optional (set toast gravity, offsets are optional)
    .supportDarkTheme(boolean isRTL) // optional (whether to support dark theme or not)
    .setRTL(boolean isRTL) // optional (icon is on the right)
    .apply(); // required
```

If you want you can reset the configuration:

```java
ToastIt.Config.reset();
```

## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

To display an error Toast:

``` kotlin
ToastIt.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show()
```
To display a success Toast:

``` kotlin
ToastIt.success(yourContext, "Success!", Toast.LENGTH_SHORT, true).show()
```
To display an info Toast:

``` kotlin
ToastIt.info(yourContext, "Here is some info for you.", Toast.LENGTH_SHORT, true).show()
```
To display a warning Toast:

``` kotlin
ToastIt.warning(yourContext, "Beware of the dog.", Toast.LENGTH_SHORT, true).show()
```
To display the usual Toast:

``` kotlin
ToastIt.normal(yourContext, "Normal toast w/o icon").show()
```
To display the usual Toast with icon:

``` kotlin
ToastIt.normal(yourContext, "Normal toast w/ icon", yourIconDrawable).show()
```

You can also create your custom Toasts with the `custom()` method:
``` kotlin
ToastIt.custom(yourContext, "I'm a custom Toast", yourIconDrawable, tintColor, duration, withIcon, 
shouldTint).show()
```
### Extra
[You can even pass formatted text to ToastIt!](https://github.com/mrpascal1/Toast-It/blob/f7d9b0d083e79856c062aed2902e66426e5375e8/app/src/main/java/com/shahid/toastitdemo/MainActivity.kt#L66)

**There are variants of each method, feel free to explore the library.**

## Screenshots

**Please click the image below to enlarge.**

<img src="https://raw.githubusercontent.com/GrenderG/Toasty/master/art/collage.png">
