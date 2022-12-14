package com.example.odstask.ui.notifications;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.odstask.Fragment1;
import com.example.odstask.Fragment2;
import com.example.odstask.R;
import com.example.odstask.VPAdapter;
import com.example.odstask.databinding.FragmentNotificationsBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;

public class NotificationsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    private int[] tabicon={
            R.drawable.post,R.drawable.img
    };

//    Spinner spinner;
//    String[] data= {"ramakrishna_boddula"};
//    ArrayAdapter<String> arrayAdapter;

    ImageView imagesheet;

    ImageView settingsheet;

    ImageView downsheet;

    TextView ramname;

  private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        tabLayout=root.findViewById(R.id.tablayoutid);
        viewPager=root.findViewById(R.id.viewpagerid);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.post));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.img));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final VPAdapter adapter = new VPAdapter(getFragmentManager(),getContext(),tabLayout.getTabCount());
            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            tabLayout.setupWithViewPager(viewPager);



        loadtab();




        settingsheet=root.findViewById(R.id.settings);
        settingsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                secondDialog();
            }
        });


        imagesheet=root.findViewById(R.id.imagesheet);
        imagesheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });

        downsheet=root.findViewById(R.id.downarrow);
        downsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                thirdDialog();
            }
        });
        ramname=root.findViewById(R.id.ramnameid);
        ramname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdDialog();
            }
        });
        return root;

    }

    private void thirdDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom2_layout);

        LinearLayout raamlayout = dialog.findViewById(R.id.ralayoutid1);
        LinearLayout accountlayout = dialog.findViewById(R.id.acountid1);

        raamlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "ramakrishna_boddula is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        accountlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Add account is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);



    }


    private void secondDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom1_layout);

        LinearLayout settingslayout = dialog.findViewById(R.id.layoutsettings);
        LinearLayout archiveLayout = dialog.findViewById(R.id.layoutarchive);
        LinearLayout activityLayout = dialog.findViewById(R.id.layoutactivity);
        LinearLayout codeLayout = dialog.findViewById(R.id.layoutcode);
        LinearLayout savedLayout = dialog.findViewById(R.id.layoutsaved);
        LinearLayout friendsLayout = dialog.findViewById(R.id.layoutfriends);
        LinearLayout favoritesLayout = dialog.findViewById(R.id.layoutfavorites);
        LinearLayout covidLayout = dialog.findViewById(R.id.layoutcovid);


        settingslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Settings is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        archiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Archive is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        activityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Your activity is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        codeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "QR Code is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        savedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Saved is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        friendsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Close Friends is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        favoritesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Favorites is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        covidLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Covid-19 In formation Center is Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


    }


    private void loadtab() {
        tabLayout.getTabAt(0).setIcon(tabicon[0]);
        tabLayout.getTabAt(1).setIcon(tabicon[1]);

    }

    private void showDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_layout);

        LinearLayout reelLayout = dialog.findViewById(R.id.layoutreel);
        LinearLayout postLayout = dialog.findViewById(R.id.layoutpost);
        LinearLayout storyLayout = dialog.findViewById(R.id.layoutstory);
        LinearLayout highlightLayout = dialog.findViewById(R.id.layouthighlight);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutlive);
        LinearLayout guideLayout = dialog.findViewById(R.id.layoutguide);

        reelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Reel is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        postLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Post is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        storyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Story is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        highlightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Story Highlight is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Live is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        guideLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Guide is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


    }


    }



