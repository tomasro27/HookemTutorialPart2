package rodrigueztomas.com.hookem;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class HookemFragment extends Fragment {

    private ListView friendsListView;
    private Button plusButton;
    private EditText addFriendEditText;
    private Button logoutButton;
    private final String LOG_TAG = "HookemFragment";

    private List<ParseObject> friends;


    public static HookemFragment newInstance() {
        HookemFragment fragment = new HookemFragment();
        return fragment;
    }

    public HookemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //TODO: PARSE INSTALLATION FOR PUSH NOTIFICATIONS
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hookem, container, false);

        friendsListView = (ListView) v.findViewById(R.id.friends);


        plusButton = (Button) v.findViewById(R.id.plus);
        addFriendEditText = (EditText) v.findViewById(R.id.addFriend);
        logoutButton = (Button) v.findViewById(R.id.logout);

        plusButton.setTypeface(MainActivity.MonseratBold(getActivity().getApplicationContext()));
        addFriendEditText.setTypeface(MainActivity.MonseratBold(getActivity().getApplicationContext()));
        logoutButton.setTypeface(MainActivity.MonseratBold(getActivity().getApplicationContext()));



        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusButton.setVisibility(View.GONE);
                addFriendEditText.setVisibility(View.VISIBLE);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser currentUser = ParseUser.getCurrentUser();
                currentUser.logOut();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, LoginSignupFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });


        //TODO: setOnEditorActionListener for the addFriendEditText in order to add friends in PARSE




        //TODO: update friends


        return v;
    }

    //TODO: create a function called updateFriends() to update friends from PARSE on the listview

    //TODO: setOnItemClickListener in the ListView to send PUSH NOTIFICATIONS with PARSE to other USERS.!


}
