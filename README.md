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
1. All the navigation related views should be in the activity layout inside coordinator layout. e.g. 
AppbarLayout, FAB, BottomNavBar.
2. DrawerLayout and NavigationView should also be placed in the activity
3. To update the navigation related views with respect the current fragment use navigation listeners 
and if any further assistance then use ViewModel to communicate among them. Also try to make this 
ViewModel without any custom Factory class. The sole purpose of this ViewModel would be to communicate. 
And create this ViewModel in the BaseFragment so that every fragment can use it.
4. If you have so much variation of Appbar or BottomNavigation use include that and in the other 
layout use merge tag to have multiple AppbarLayout or BottomNavigation or any other layout. and for 
better tooling support use ```tools:parentTag``` attribute

```kotlin

        /*
         * this is how you can set-up side navigation with the appbar
         */

        setSupportActionBar(mainBinding.toolbar)
        mainBinding.navigationView.itemIconTintList = null

        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment), mainBinding.drawerLayout)
        //here setOf(..) is the set of parent where icon will be visible for the side nav

        setupActionBarWithNavController(navController, appBarConfiguration)
        mainBinding.navigationView.setupWithNavController(navController)

        // using the listener you can do specific work for specific fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    
                }

                else -> {
                    
                }
            }
        }

```

### Naming convention
1. Name of any view style will start by ```Widget.AppComponent```
2. Name of any theme style will start by ```Theme.AppComponent``` 
3. Name of any textAppearance will start by ```TextAppearance.AppComponent```

