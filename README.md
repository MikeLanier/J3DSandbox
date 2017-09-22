# J3DSandbox
A Java App to learn, practice and test OpenGL and (if possible) DirectX programming.

### 09/22/2017
* create controls for defining options (09/14/2017)
  * controls for defining multiple lights (09/14/2017)
  * controls for selecting a face to view, Top, Front, etc...  (09/14/2017)
  * controls for pan, zoom and fit   (09/14/2017)
    * zoom using mouse wheel (09/15/2017)
  * display options for shaded, wireframe, etc (09/14/2017)
  * control to rotate 90 about z axis (09/14/2017)
* when selecting a face or reseting, animate to position (09/14/2017)
* recall the teapot model and implement (09/14/2017)
* Add text to the SixFace model to label the faces, front 
back, left etc. (09/15/2017)
* BUG: grid create does not work well for cell size other than 10
### 09/17/2017
* ~~create controls for defining options (09/14/2017)~~
  * ~~controls for starting a perpetual rotation (09/17/2017)~~
### 09/15/2017
* ~~create controls for defining options (09/14/2017)~~
  * ~~Checklist or combo box to define which model to display (09/15/2017)~~
### 09/14/2017
* ~~modularize the model display so that I can pick and choose what is
displayed (09/12/2017)~~
* ~~BUG: keyboard not being handled: Added a keypress event handler
to MainFrame and called a method in Sandbox.DisplayPanel to handle the
event (09/14/2017)~~
### 09/12/2017
* ~~create panel for 3D display~~

#Notes
Regarding the addition of non-rotating text. I was thinking of adding
non-rotating text to the Sandbox.SixFaces model, but, the way I have things 
wired up in the app, everything I add to the display will rotate. 
Maybe I need a layer above the root Sandbox.Xform where non-rotating stuff can
be added. Something I didn't want to dive into at the time since I had
basic display working and didn't want to break it.  The more I learn,
the more I want to complicate things. Eventually, I'll come back to 
this. (09/15/2017)

A circular helix of radius a and slope b/a (or pitch 2πb) is described by the following parametrisation:

    x (t) = a cos(t)
    y (t) = a sin(t)
    z (t) = bt. 