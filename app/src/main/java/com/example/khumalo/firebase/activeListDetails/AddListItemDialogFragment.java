package com.example.khumalo.firebase.activeListDetails;

import android.app.Dialog;
import android.os.Bundle;

import com.example.khumalo.firebase.Model.ShoppingList;
import com.example.khumalo.firebase.R;
import com.example.khumalo.firebase.utils.Constants;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;


/**
 * Lets user add new list item.
 */
public class AddListItemDialogFragment extends EditListDialogFragment {

    /**
     * Public static constructor that creates fragment and passes a bundle with data into it when adapter is created
     */
    public static AddListItemDialogFragment newInstance(ShoppingList shoppingList,String listId) {
        AddListItemDialogFragment addListItemDialogFragment = new AddListItemDialogFragment();

        Bundle bundle = newInstanceHelper(shoppingList, R.layout.dialog_add_item,listId);
        addListItemDialogFragment.setArguments(bundle);

        return addListItemDialogFragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /** {@link EditListDialogFragment#createDialogHelper(int)} is a
         * superclass method that creates the dialog
         **/
        return super.createDialogHelper(R.string.positive_button_add_list_item);
    }

    /**
     * Adds new item to the current shopping list
     */
    @Override
    protected void doListEdit() {
        Firebase ref = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST_ITEMS).child(mListId);
        Firebase postRef = ref.push();
        Map<String, String> post1 = new HashMap<String, String>();
        post1.put("author", "gracehop");
        post1.put("title", "Announcing COBOL, a New Programming Language");
        postRef.setValue(post1);
    }
}
