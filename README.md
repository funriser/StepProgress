# StepProgress
[![](https://jitpack.io/v/funriser/StepProgress.svg)](https://jitpack.io/#funriser/StepProgress)

StepProgress is an android library that implements progress view with states and transitions between them.
## Gradle
To get a StepProgress library into your build:

Step 1. Add in your top-level build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency to your module-level build.gradle:
```gradle
dependencies {
    implementation 'com.github.funriser:StepProgress:0.1.0'
}
```
## Description
### Initial state
![alt text](https://raw.githubusercontent.com/funriser/StepProgress/master/screenshots/state_empty.png)
### Filled state
You can switch state of a progress by selecting step manually or by using API methods (described below):

![alt text](https://raw.githubusercontent.com/funriser/StepProgress/master/screenshots/state_filled.png)
### Scaled state
Step progress view can scale itself to fit the layout or to show better proportions:

![alt text](https://raw.githubusercontent.com/funriser/StepProgress/master/screenshots/state_scaled.png)
## Usage
### XML
```xml
<com.funrisestudio.stepprogress.StepProgressView
        android:id="@+id/vStepProgress"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:stepsCount="4"
        app:arcPadding="10dp"
        app:nodeHeight="50dp"
        app:titlesEnabled="true"
        app:textNodeColor="@color/colorAccent"
        app:textNodeSize="18sp"
        app:textNodeTitleColor="@color/colorPrimary"
        app:textNodeTitleSize="14sp"
        app:textTitlePadding="5dp"/>
```
### Kotlin/Java
You can update steps count and their titles programmatically:
```kotlin
val stepsCount = 4
vStepProgress.setStepsCount(stepsCount)
vStepProgress.setStepTitles(List(stepsCount) { "Step ${it + 1}" })
```
You can update state of a progress programmatically:
```kotlin
btnNext.setOnClickListener {
    //pass "true" to nextStep method to mark current selected step as finished
    val isFinished = vStepProgress.nextStep(true)
    //if all steps of a progress are finished
    if (isFinished) {
        //do something
    }
}
```
## XML attributes
```xml
<com.funrisestudio.stepprogress.StepProgressView
        ...
        app:stepsCount="4" <!-- set steps count for progress -->
        app:arcPadding="10dp" <!-- padding between step and its ark -->
        app:nodeHeight="50dp" <!-- height of the step -->
        app:titlesEnabled="true" <!-- enables or disables titles above steps -->
        app:textNodeColor="@color/colorAccent" <!-- color of a number inside the step -->
        app:textNodeSize="18sp" <!-- size of a number inside the step -->
        app:textNodeTitleColor="@color/colorPrimary" <!-- color of a title above the step -->
        app:textNodeTitleSize="14sp" <!-- size of a title above the step -->
        app:textTitlePadding="5dp" <!-- padding between title and step below it -->
        app:colorInactive="@color/colorGrey" <!-- color of inactive views -->
        app:nodeColor="@color/colorPrimary" <!-- color of step circle -->
        app:arcWidth="2dp" <!-- width of the arc between steps -->
        app:arcColor="@color/colorAccent" <!-- color of the arc between steps -->
        ...
/>
```
## Methods
```kotlin
val stepsCount = 4
//Set number of steps for progress
vStepProgress.setStepsCount(stepsCount)
//Set title for each step
vStepProgress.setStepTitles(List(stepsCount) { "Step ${it + 1}" })
//!Two methods above should be applied together to ensure progress state consistence

//Go to next step. Receives boolean value which decides if current step should be marked as done
vStepProgress.nextStep(true)
...
//Mark current selected step as done
vStepProgress.markCurrentAsDone()
...
//Mark current selected step as undone
vStepProgress.markCurrentAsUndone()
...
//Checks if step in a specific position is finished
vStepProgress.isStepDone(0)
...
//Checks if all steps of a progress are finished
vStepProgress.isProgressFinished()
...
```

