*When an event is triggered inside the toolbar or fileTreeArea, the first order of business MUST be to 
setCurrentLocation of the Brain object.

*After this update has been made to the code, the brain should not publish any hard-coded values; instead it should 
publish whatever its current location is. The only exception to this rule should be when
"home" or "root" is triggered.

*The Properties area does not have any permissions to trigger any event.

*The Display area does not have any permissions to trigger any event *within* the application,
but it does have permission to ask the OS to open the targeted file when the user triggers an event inside of said
Display area.

*The Brain does not need to know the difference between a folder and a file. This can take place at the component
update() level.

*Methods should be declared in alphabetical order in their corresponding object.

TODO: Add typing input functionality to the Toolbar such that a user can look up a folder location that way.

TODO: Add copy/paste functionality to the Toolbar text field.

TODO: PropertiesArea should display the following features of the targeted folder or file: size, filetype, parent directory.

TODO: Add field to Brain: something along the lines of currentTarget. This can be the Brain's current location, but
if some file is selected in DisplayArea, that input should override currentTarget if currentTarget is equal to 
currentLocation.

TODO: PropertiesArea should take input from DisplayArea; but when no input is triggered from DisplayArea, 
PropertiesArea should default to the information it can extract from the Brain's currentLocation.