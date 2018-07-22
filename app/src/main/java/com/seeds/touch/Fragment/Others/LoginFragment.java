package com.seeds.touch.Fragment.Others;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.seeds.touch.Activity.CompleteUserProfileActivity;
import com.seeds.touch.Configuration.Setting;
import com.seeds.touch.Entity.Entities.Person;
import com.seeds.touch.Management.Interface.ProfileAPI;
import com.seeds.touch.Management.Manager.MainActivity;
import com.seeds.touch.R;
import com.seeds.touch.Server.Server;
import com.seeds.touch.Server.ServiceGenerator2;
import com.seeds.touch.Technical.Enums;
import com.seeds.touch.Technical.Enums.LoginResult;
import com.seeds.touch.Technical.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.seeds.touch.Configuration.Setting.USER_INFORMATION_SHARED_PREFERENCES_TABLE;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        findViews(view);
        handleButtonListeners(view);
        return view;
    }

    private void handleButtonListeners(View view) {
        Helper.login_signInButton.setOnClickListener(v -> {
            String userIdentityField = Helper.login_UsernameEditText.getText().toString();
            String password = Helper.login_PasswordEditText.getText().toString();
            if (userIdentityField != null && !userIdentityField.isEmpty() && password != null && !password.isEmpty()) {
                Call<Integer> call = ServiceGenerator2.createService(ProfileAPI.class).loginProfile(userIdentityField, password);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        switch (LoginResult.values()[response.body()]) {
                            case SUCCESSFUL_COMPLETED:
                                Helper.userID = userIdentityField;
                                Setting.saveSetting(view.getContext(), USER_INFORMATION_SHARED_PREFERENCES_TABLE, Helper.USER_ID_KEY, Helper.userID);
                                Setting.saveSetting(view.getContext(), USER_INFORMATION_SHARED_PREFERENCES_TABLE, Helper.LOGIN_STATUS_KEY, Enums.LoginStatus.USER.toString());
                                Toast.makeText(view.getContext(), "Welcome " + userIdentityField, Toast.LENGTH_SHORT).show();
                                MainActivity.openActivity_GeneralMode(view.getContext(), Enums.ActivityRepository.MAIN_ACTIVITY, true);

                                break;
                            case SUCCESSFUL_NOT_COMPLETED:
                                Intent intent=new Intent(v.getContext(), CompleteUserProfileActivity.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("ID",userIdentityField);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                break;
                            case NOT_EXIST:
                                Toast.makeText(view.getContext(), "This User does not exist !", Toast.LENGTH_LONG).show();
                                break;
                            case WRONG_PASSWORD:
                                Toast.makeText(view.getContext(), "Wrong password ...", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.d("DFDSF", "ERRROR LOGIN");
                    }
                });
            } else
                Toast.makeText(view.getContext(), "Empty Fields Should Be Filled", Toast.LENGTH_LONG).show();
        });
        Helper.login_registerButton.setOnClickListener(v -> {
            Fragment registerFragment = new RegisterFragment();
            FragmentManager fragmentManager = getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.user_veify_fragment, registerFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        Helper.login_forgetPasswordButton.setOnClickListener(v -> {

        });

    }

    private void findViews(View view) {
        Helper.login_signInButton = (Button) view.findViewById(R.id.login_login_button);
        Helper.login_registerButton = (Button) view.findViewById(R.id.login_sign_up_button);
        Helper.login_forgetPasswordButton = (Button) view.findViewById(R.id.login_forget_password_text);
        Helper.login_UsernameEditText = (EditText) view.findViewById(R.id.login_username_edittext);
        Helper.login_PasswordEditText = (EditText) view.findViewById(R.id.login_password_edittext);
        Helper.login_Facebook_Register = (Button) view.findViewById(R.id.login_login_with_facebook);
        Helper.login_Twitter_Facebook = (Button) view.findViewById(R.id.login_login_with_twitter);
        Helper.login_Google_Facebook = (Button) view.findViewById(R.id.login_login_with_google_plus);
    }
}
