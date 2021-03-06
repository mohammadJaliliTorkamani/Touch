package com.seeds.touch.Technical;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.seeds.touch.Management.Manager.MainActivity;
import com.seeds.touch.R;

public final class Helper {
    public final static String API_KEY = "";
    //touch log messages
    public static final String LOG_TOUCH_ERROR = "Error_In_Touch";
    //helpers
    public static Context MainActivity_context;
    public static Resources MainActivity_resource;
    public static String userID;
    public static AHBottomNavigation bottomNavigation;
    public static TextView tab_details_text_view;
    public static TextView total_items_Details_in_toolbar_text_view;
    public static ImageView setting_toolbar_icon;
    public static ImageView filter_toolbar_icon;
    public static AHBottomNavigationItem item1;
    public static AHBottomNavigationItem item2;
    public static AHBottomNavigationItem item3;
    public static  AHBottomNavigationItem item4;
    public static Button login_signInButton;
    public static Button login_registerButton;
    public static TextView login_forgetPasswordTextView;
    public static ImageView login_Facebook_Register;
    public static ImageView login_Google_Facebook;
    public static ImageView login_Twitter_Instagram;
    public static EditText login_UsernameEditText;
    public static EditText login_PasswordEditText;
    public static EditText register_phonenumberEdittext;
    public static EditText register_userNameEdittext;
    public static EditText register_passwordEdittext;
    public static Button register_signUpButton;

    public static EditText complete_fullName_edittext;
    public static EditText complete_ID_edittext;
    public static Spinner complete_genderSpinner;
    public static Button complete_completeButton;

    public static TextView mainProfileName;
    public static TextView mainProfileFollowersNumber;
    public static TextView mainProfileFollowingsNumber;
    public static TextView mainProfileBiography;

    public static TextView profileName;
    public static TextView profileFollowersNumber;
    public static TextView profileFollowingsNumber;
    public static TextView profileBiography;
    public static TextView profileFollowButton;

    public static EditText cinemaTitleEdittext;
    public static EditText cinemaDescriptionEdittext;
    public static EditText cinemaLocationEdittext;
    public static EditText cinemaFilmNameEdittext;
    public static TextView cinemaDateTextView;
    public static Spinner cinemaRangeSpinner;
    public static Spinner cinemaAccessTypeSpinner;
    public static TextView cinemaSaveTextView;
    public static ImageView cinemaCancelTextView;

    public static EditText restaurantTitleEdittext;
    public static EditText restaurantDescriptionEdittext;
    public static EditText restaurantLocationEdittext;
    public static EditText restaurantFilmNameEdittext;
    public static TextView restaurantDateTextView;
    public static TextView restaurantSaveTextView;
    public static ImageView restaurantCancelTextView;
    public static Spinner restaurantRangeSpinner;
    public static Spinner restaurantMealTypeSpinner;
    public static Spinner restaurantAccessTypeSpinner;

    public static EditText tripTitleEdittext;
    public static EditText tripDescriptionEdittext;
    public static EditText tripLocationEdittext;
    public static TextView tripDateTextView;
    public static Spinner tripRangeSpinner;
    public static Spinner tripAccessTypeSpinner;
    public static TextView tripSaveTextView;
    public static ImageView tripCancelTextView;

    public static RecyclerView newsRecyclerView;
    public static RecyclerView.Adapter newsAdapter;
    public static RecyclerView.LayoutManager newsLayoutManager;





    //final keys
    public static final String USER_ID_KEY ="USER_ID_KEY";
    public static final String NO_VALUE_FOUND_FOR_KEY="NO_VALUE_FOUND_FOR_KEY";
    public static final String LOGIN_STATUS_KEY="LOGIN_STATUS_KEY";

    public static final String TAG = "MainActivity - ";
    public static RecyclerView fragment1_RecyclerView;
    public static RecyclerView fragment2_RecyclerView;
    public static LinearLayoutManager fragment1_LinearLayoutManager;
    public static LinearLayoutManager fragment2_LinearLayoutManager;
    public static RecyclerView.Adapter fragment1_Adapter;
    public static RecyclerView.Adapter fragment2_Adapter;


    public static void reNewObjects(Context context) {
        MainActivity_context=context;
        MainActivity_resource=context.getResources();

        item1 = new AHBottomNavigationItem(MainActivity.getStringValueOf(R.string.home), R.mipmap.home_icon);
        item2 = new AHBottomNavigationItem(MainActivity.getStringValueOf(R.string.world), R.mipmap.world_icon);
        item3 = new AHBottomNavigationItem(MainActivity.getStringValueOf(R.string.profile), R.mipmap.profile_icon);
        item4 = new AHBottomNavigationItem(MainActivity.getStringValueOf(R.string.news), R.mipmap.notification_icon);
//        dialogPermissionListener= DialogOnDeniedPermissionListener.Builder
//                .withContext(context)
//                .withTitle("Camera permission")
//                .withMessage("Camera permission is needed to take pictures of your cat")
//                .withButtonText(android.R.string.ok)
//                .withIcon(R.drawable.ic_menu_camera)
//                .build();
    }
}
