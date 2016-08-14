package com.example.khumalo.firebase.activeLists;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.khumalo.firebase.utils.Utils;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.example.khumalo.firebase.Model.ShoppingList;
import com.example.khumalo.firebase.R;

import java.text.SimpleDateFormat;

/**
 * Populates the list_view_active_lists inside ShoppingListsFragment
 */
public class ActiveListAdapter extends FirebaseListAdapter<ShoppingList> {

    /**
     * Public constructor that initializes private instance variables when adapter is created
     */
    public ActiveListAdapter(Activity activity, Class<ShoppingList> modelClass, int modelLayout,
                             Query ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }

    /**
     * Protected method that populates the view attached to the adapter (list_view_active_lists)
     * with items inflated from single_active_list.xml
     * populateView also handles data changes and updates the listView accordingly
     */
    @Override
    protected void populateView(View view, ShoppingList list) {

        /**
         * Grab the needed Textivews and strings
         */
        TextView textViewListName = (TextView) view.findViewById(R.id.text_view_list_name);
        TextView textViewCreatedByUser = (TextView) view.findViewById(R.id.text_view_created_by_user);

        TextView textViewEdited = (TextView) view.findViewById(R.id.text_view_edit_time);
        /* Set the list name and owner */
        textViewListName.setText(list.getListName());
        textViewCreatedByUser.setText(list.getOwner());
        textViewEdited.setText(Utils.SIMPLE_DATE_FORMAT.format(list.getTimestampLastChangedLong()));
    }
}
