mvvm:
Model View ViewModel
1. Model - > from where we're fetching our data

    1. for eg. in this class we're fetching data from database or from server
    2. validation will also been performed in this layer only
    3. it'll also help in decision making
       a. for eg. whether fetched data from database or server
       b. apply validations on data if necessary, for eg. validation on email address/password
    4. view model will receive data from model layer

Note: please don't consume with name "model", its not that general model class which store your data.
it is a layer or a class which brings data from any sources(db/model class/server/sharepreferences/files)
 and gives back to viewmodel where viewmodel then further passes to view.

2. ViewModel -> is a layer that comes between model and view
       a.  it is lifecycle observer, will pass data from view to model and will give back from model to view
       b. no validation should performed here

3. View -> its responsibility is to show view on the screen based on data receive from viewmodel, view is your fragments/activities
     a. for instance list of user data in the listview/recyclerview
     b. showing some error, dialogs
