# Product Structure

### ViewData
1. Every parameter of ViewData should be as such that user can define that without context
2. Color should te taken as ColorRes parameter. If you need different alfa value of same color then use colordrawable to do that.
3. Drawable should be taken as DrawableRes parameter
4. Image should be taken ar url.
4. String should be taken as ViewString type specified in the component module. This abstract both StringRes and raw String.
6. Any dimension should be taken as dp int.