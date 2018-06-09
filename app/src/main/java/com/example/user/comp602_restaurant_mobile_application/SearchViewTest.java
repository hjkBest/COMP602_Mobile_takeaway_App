package com.example.user.comp602_restaurant_mobile_application;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.app.Activity;

public class SearchViewTest extends Activity implements SearchView.OnQueryTextListener {
    private SearchView sv;
    private ListView lv;
    // Auto list
    private final String[] mStrings = { "Fish Fillet Noodle Soup: Restaurant 1 $10",
            "Curry Fish Fillet Noodle Soup: Restaurant 1 $15",
            "Chicken Curry Laksa: Restaurant 1 $10",
            "Vegetable Curry Laksa: Restaurant 1 $12",
            "Seafood Curry Laksa: Restaurant 1 $12.99",
            "Pappa char Koay Teaw: Restaurant 1 $7.99"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search Page");
        SetUpView();
    }


    //set up the component of the search page
    public void SetUpView(){
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));
        lv.setTextFilterEnabled(true);
        sv = (SearchView) findViewById(R.id.sv);

        sv.setIconifiedByDefault(false);
        //Set the event listener for the SearchView component
        sv.setOnQueryTextListener(this);
        //Set the SearchView to display the search button
        sv.setSubmitButtonEnabled(true);
        //Set the default prompt text displayed in the SearchView
        sv.setQueryHint("Search");
    }


    // run method when user is entering words
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            // Clear the ListView filter
            lv.clearTextFilter();
        } else {
            // Filter the list items of the ListView using the user's input
            lv.setFilterText(newText);
        }
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}