# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# ************************************************************


# Warning: kotlinx.coroutines.flow.FlowKt...
# https://github.com/Kotlin/kotlinx.coroutines/issues/1270
# - 52 unresolved references to program class members.
 -dontwarn kotlinx.coroutines.flow.**inlined**

## okhttp
# https://github.com/square/okhttp/blob/5fe3cc2d089810032671d6135ad137af6f491d28/README.md##proguard
# - 35 unresolved references to classes or interfaces.
 -dontwarn okhttp3.**

# Kotlin cross-platform / multi-format reflectionless serialization
# https://github.com/Kotlin/kotlinx.serialization
 -keepattributes *Annotation*, InnerClasses
 -dontnote kotlinx.serialization.SerializationKt
 -keep,includedescriptorclasses class com.example.mvppattern.**$$serializer { *; } # <-- change package name to your app's
 -keepclassmembers class com.example.mvppattern.**{ # <-- change package name to your app's
    *** Companion;
}
-keepclasseswithmembers class com.example.mvppattern.**{ # <-- change package name to your app's
    kotlinx.serialization.KSerializer serializer(...);
}

#Removing logging
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
  }