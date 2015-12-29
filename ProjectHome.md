# Candroid #

#### <sup> A Android Game Engine </sup> ####
[![](http://dl.dropbox.com/u/2024237/Android/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=J2A5Q968LPM6N)
<br />If you like what I'm doing, support me with a donation.<br /><br /><br />
### Current Version 1.1.1 ###
[Download](http://code.google.com/p/candroidengine/downloads/detail?name=CandroidGameEngine1.1.1.jar)<br /><br />
Candroid is a game engine for Android Game Developer to simplify their work.
<br /><br />
![http://candroidengine.googlecode.com/files/logo_small.png](http://candroidengine.googlecode.com/files/logo_small.png)
<br />

### [Getting Started](http://code.google.com/p/candroidengine/wiki/GettingStarted) to develp your own game ###

## Download the Examples ##
![http://dl.dropbox.com/u/2024237/candroid.png](http://dl.dropbox.com/u/2024237/candroid.png)

First I wrote a few of classes I needed for my current game.<br />
My target was (is) that I can use all my classes for every game.
<br />But after some time there were more and more classes and so I decided to expand it to a full working game engine. I wrote all the classes so that they can be used in every game. They should be very flexible and easy to understand.<br />
Candroid will check all the input methods and draw the game very quickly with Canvas on the screen.

## Candroid 1.1.0 includes the dummy game [AndroidHunt](http://code.google.com/p/candroidengine/source/browse/trunk/src/at/bartinger/example/androidhunt/AndroidHuntView.java). ##

<br /><br />The current operational functions are:

  * very fast drawing sprites with canvas
  * Tileanimation
  * Backgrounds:
    * Colorbackground
    * Fixedbackground
    * ScrollingBackground
    * Spritebackground<br />
  * Events which are automatically called<br />
    * onTouchDown(int touchX, int touchY, int pressure)<br />
    * onTouchMove(int touchX, int touchY, int pressure)<br />
    * onTouchUp(int touchX, int touchY, int pressure)<br />
    * onTrackballLeft()<br />
    * onTrackballRight()<br />
    * onTrackballUp()<br />
    * onTrackballDown()<br />
    * onTrackballPress()
    * onAccelerometerChanged(float x, float y, float z)
    * onShaking()
  * rendering Fonts
  * background-sound
  * soundeffects for an fast playback (SFX)
  * D-Pad listeners
  * Shape drawing
  * Examples of everything

If you have more ideas or some wish write it [here](http://code.google.com/p/candroidengine/wiki/Wishlist)
