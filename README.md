# Product Structure

### ViewData
1. Every parameter of ViewData should be as such that user can define that without context
2. Color should te taken as ColorRes parameter. If you need different alfa value of same color then use colorDrawable to do that. 
If you want to use theme color you can definitely do that. Just create another colorDrawable using that attribute.
3. Drawable should be taken as DrawableRes parameter
4. Image should be taken ar url.
4. String should be taken as ViewString type specified in the component module. This abstract both StringRes and raw String.
6. Any dimension should be taken as dp int.
7. If at the end you need to set data as String to the view then use ViewString for that kind of data

### Navigation Views
1. All the navigation related views should be in the activity layout inside coordinator layout. e.g. AppbarLayout, FAB, BottomNavBar.
2. DrawerLayout and NavigationView should also be placed in the activity
3. To update the navigation related views with respect the current fragment use navigation listeners and if any further assistance then use viewmodel to communicate among them.