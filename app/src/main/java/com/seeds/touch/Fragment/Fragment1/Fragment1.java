package com.seeds.touch.Fragment.Fragment1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.seeds.touch.Adapter.F1_Adapter;
import com.seeds.touch.Entity.Entities.Item;
import com.seeds.touch.Entity.Entities.Person;
import com.seeds.touch.Management.Interface.HomeItemAPI;
import com.seeds.touch.Management.Interface.ProfileAPI;
import com.seeds.touch.R;
import com.seeds.touch.Server.ServiceGenerator;
import com.seeds.touch.Server.ServiceGenerator3;
import com.seeds.touch.Technical.GSON_Wrapper;
import com.seeds.touch.Technical.Helper;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

import static com.seeds.touch.Technical.Helper.TAG;


//starter item will cause to minus 1  ALL NECESSARY PARTS
public class Fragment1 extends Fragment {
    private List<Item> items = new ArrayList<>();
    private HomeItemAPI api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        items.clear();
        addStarterItem();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        findViews(view);
        tuneRecyclerView(view);
        api = ServiceGenerator.createService(HomeItemAPI.class);


//        ItemManager.getInstance().readItems(view.getContext(), Enums.EventTypes.HOME, objects -> {
//
///*
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.YEAR, 2019);
//
//
//            HashSet<Comment> comments = new HashSet<>();
//            comments.add(new Comment("Salam , aali bood", Calendar.getInstance(), "Hasan"));
//            comments.add(new Comment("Merciiii", Calendar.getInstance(), "Parvaneh"));
//
//            HashSet<String> attenders = new HashSet<>();
//            attenders.add("Reza");
//            attenders.add("Baghiat");
//            attenders.add("Company");
//
//            HashSet<String> tags = new HashSet<>();
//            tags.add("Bagh");
//            tags.add("Flowers");
//            tags.add("Beauty");
//
//            HashSet<String> pictures = new HashSet<>();
//            pictures.add("url1");
//            pictures.add("url2");
//            pictures.add("url3");
//
//            Location location = new Location("Touch");
//            Bundle bundle = new Bundle();
//            bundle.putString("NAME", "California");
//            location.setExtras(bundle);
//            location.setLatitude(2365.12);
//            location.setLongitude(7654.70);
//
//            Event event = new CinemaEvent("Watch The Best Film", Calendar.getInstance(), Calendar.getInstance(), location, "Can You Get A One?1", 45, "Ali O Dani1");
//            Event event2 = new TripEvent("Watch The Best Film2", Calendar.getInstance(), calendar, location, "Can You Get A One?2", 46);
//            Event event3 = new RestaurantEvent("Watch The Best Film3", Calendar.getInstance(), Calendar.getInstance(), location, "Can You Get A One?3", 47, Enums.MealMode.BREAKFAST);
//            Event event4 = new CinemaEvent("Watch The Best Film4", Calendar.getInstance(), Calendar.getInstance(), location, "Can You Get A One?4", 48, "Ali O Dani4");
//
//            Item item  = new Item("10", pictures, Calendar.getInstance(), tags, event, "Mohammad", attenders, comments, 12, Enums.Status.SHOWN, Enums.AccessType.PUBLIC);
//            Item item2 = new Item("2", pictures, Calendar.getInstance(), tags, event2, "Simin", attenders, comments, 10, Enums.Status.SHOWN, Enums.AccessType.PUBLIC);
//            Item item3 = new Item("3", pictures, Calendar.getInstance(), tags, event3, "Shirin", attenders, comments, 65, Enums.Status.SHOWN, Enums.AccessType.PUBLIC);
//            Item item4 = new Item("4", pictures, Calendar.getInstance(), tags, event4, "Nafas", attenders, comments, 0, Enums.Status.SHOWN, Enums.AccessType.FRIENDS);
//            items.add(item);// = (LinkedList<Item>) objects[0];
//            items.add(item2);// = (LinkedList<Item>) objects[0];
//            items.add(item3);// = (LinkedList<Item>) objects[0];
//            items.add(item4);// = (LinkedList<Item>) objects[0];
//*/            Fragment1.updateList();
//        });

        return view;
    }

    private void load(int index) {
        Call<Person> personCall = ServiceGenerator3.createService(ProfileAPI.class).getProfile(Helper.userID);
        personCall.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.body() != null) {
                    Call<List<Item>> itemCall = api.getItems(index, GSON_Wrapper.getInstance().toJson(response.body().getFollowings()));
                    itemCall.enqueue(new Callback<List<Item>>() {
                        @Override
                        public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                            Log.d("vcxvFGHBVNC", GSON_Wrapper.getInstance().toJson(response.body()));
                            if (response.isSuccessful()) {
                                items.addAll(response.body());
                                ((F1_Adapter) Helper.fragment1_Adapter).notifyDataChanged();
                            } else {
                                Log.e(TAG, " Response Error " + String.valueOf(response.code()));
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Item>> call, Throwable t) {
                            Log.e(TAG, " Rxcvesponse Error " + t.getMessage());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.d(Helper.LOG_TOUCH_ERROR, "ERROR");
            }
        });
    }

    private void addStarterItem() {
        items.add(null);
    }

    private void tuneRecyclerView(View view) {
        Helper.fragment1_LinearLayoutManager = new LinearLayoutManager(getContext());
        Helper.fragment1_RecyclerView.setHasFixedSize(true);
        Helper.fragment1_RecyclerView.setLayoutManager(Helper.fragment1_LinearLayoutManager);
        Helper.fragment1_Adapter = new F1_Adapter(items, view.getContext(), Helper.fragment1_RecyclerView);
        ((F1_Adapter) Helper.fragment1_Adapter).setLoadMoreListener(() -> {

            Helper.fragment1_RecyclerView.post(() -> {
                int index = items.size() - 1;
                Fragment1.this.loadMore(getContext(), index);// a method which requests remote data
            });
            //Calling loadMore function in Runnable to fix the
            // java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling error
        });
        Helper.fragment1_RecyclerView.setAdapter(Helper.fragment1_Adapter);

    }

    private void loadMore(Context context, int index) {
        Item item = new Item();
        item.setLoadItem(true);
//add loading progress view
        items.add(item);
        Helper.fragment1_Adapter.notifyItemInserted(items.size() - 1);

        Call<Person> personCall = ServiceGenerator3.createService(ProfileAPI.class).getProfile(Helper.userID);
        personCall.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if(response.body()!=null)
                {
                    Log.d("IOPU",GSON_Wrapper.getInstance().toJson(response.body()));
                    Log.d("dsfh",GSON_Wrapper.getInstance().toJson(response.body().getFollowings()));

                    Call<List<Item>> itemCall = ServiceGenerator.createService(HomeItemAPI.class).
                            getItems(index,GSON_Wrapper.getInstance().toJson(com.seeds.touch.
                                    Configuration.Converter.putDoubleQuotationAroundEachItemOfHashSet(response.body().getFollowings())));
                    itemCall.enqueue(new Callback<List<Item>>() {
                        @Override
                        public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                            Log.d("DFGCxcxcB", GSON_Wrapper.getInstance().toJson(response.body()));
                            if (response.isSuccessful()) {

                                //remove loading view
                                items.remove(items.size() - 1);
                                List<Item> result = response.body();
                                if (result.size() > 0) {
                                    //add loaded data
                                    items.addAll(result);
                                } else {//result size 0 means there is no more data available at server
                                    ((F1_Adapter) Helper.fragment1_Adapter).setMoreDataAvailable(false);

                                    //telling adapter to stop calling load more as no more server data available
                                    Toast.makeText(context, "No More Data Available", Toast.LENGTH_LONG).show();
                                }
                                ((F1_Adapter) Helper.fragment1_Adapter).notifyDataChanged();
                                //should call the custom method adapter.notifyDataChanged here to get the correct loading status
                            } else {
                                Log.e(TAG, " Load More Response Error " + String.valueOf(response.code()));
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Item>> call, Throwable t) {
                            Log.e(TAG, " Load More Response Error " + t.getMessage());
                        }
                    });
                }
                else
                {
                    Log.d(Helper.LOG_TOUCH_ERROR, "****Error");
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.d(Helper.LOG_TOUCH_ERROR, "Error***");
            }
        });
    }

    private void findViews(View view) {
        Helper.fragment1_RecyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview);
    }
}
