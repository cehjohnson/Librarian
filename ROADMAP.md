*When an event is triggered inside the toolbar or fileTreeArea, the first order of business MUST be to 
setCurrentLocation of the Brain object.

*After this update has been made to the code, the brain should not publish any hard-coded values; instead it should 
publish whatever it's current location is. The only exception to this rule should be when
"home" or "root" is triggered.

*The Properties area does not have any permissions to trigger any event.

*The Display area does not have any permissions to trigger any event *within* the application,
but it does have permission to ask the OS to open the targeted file when the user triggers an event inside of said
Display area.


TODO: Add logic to the brain (and probably a DirectoryStream or two) to enable it to parse the difference between files 
and folders. Update all update() functions to take advantage of this new logic.

TODO: Add refresh button to the Toolbar.

TODO: Add try block to FileTreeArea to make the LookIn label self-edit so it does not expand the FileTreeArea out beyond
its designated area within the window.

TODO: Add typing input functionality to the Toolbar such that a user can look up a folder location that way.