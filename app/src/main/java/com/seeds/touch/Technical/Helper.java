package com.seeds.touch.Technical;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.seeds.touch.Management.Manager.MainActivity;
import com.seeds.touch.R;

public final class Helper {
    //touch log messages
    public static final String LOG_TOUCH_ERROR = "Error_In_Touch";
    //helpers
    public static Context MainActivity_context;
    public static Resources MainActivity_resource;
    public static String encryptedUserID;
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
    public static Button login_Facebook_Register;
    public static Button login_Google_Facebook;
    public static Button login_Twitter_Facebook;
    public static EditText login_UsernameEditText;
    public static EditText login_PasswordEditText;
    public static EditText register_phonenumberEdittext;
    public static EditText register_userNameEdittext;
    public static EditText register_passwordEdittext;
    public static Button register_signUpButton;

    public static EditText complete_fullName_edittext;
    public static Spinner complete_genderSpinner;
    public static Button complete_completeButton;


    //final keys
    public static final String ENCRYPTED_USER_ID_KEY="ENCRYPTED_USER_ID_KEY";
    public static final String NO_VALUE_FOUND_FOR_KEY="NO_VALUE_FOUND_FOR_KEY";
    public static final String LOGIN_STATUS_KEY="LOGIN_STATUS_KEY";


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
