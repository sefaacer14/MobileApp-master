package com.sefaacer.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    MaterialToolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.lytTab0)
    FrameLayout lytEmail;
    @BindView(R.id.lytTab1)
    FrameLayout lytUsers;
    @BindView(R.id.lytTab2)
    FrameLayout lytSensors;
    @BindView(R.id.btnSendMail)
    MaterialButton btnSendMail;
    FloatingActionButton fab;

    EditText to;
    EditText subject;
    EditText messages;
    Button buttonSend;
    private Unbinder unbinder;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        configureLayouts(Tabs.EMAIL);

        to = findViewById(R.id.textEmailAddress);
        subject = findViewById(R.id.textEmailSubject);
        messages = findViewById(R.id.txtMessage);

        buttonSend.setOnClickListener(v -> {
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
            email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            email.putExtra(Intent.EXTRA_TEXT, messages.getText().toString());
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "E Posta Gönderme Seçenekleri: "));

        });
    }


    public void configureLayouts(Tabs tabInit) {
        switch (tabInit) {
            case EMAIL:
                lytEmail.setVisibility(View.VISIBLE);
                lytUsers.setVisibility(View.GONE);
                lytSensors.setVisibility(View.GONE);
                toolbar.setTitle("Send e-Mail");
                fab.setVisibility(View.GONE);
                break;
            case USERS:
                lytEmail.setVisibility(View.GONE);
                lytUsers.setVisibility(View.VISIBLE);
                lytSensors.setVisibility(View.GONE);
                toolbar.setTitle("Users");
                fab.setVisibility(View.VISIBLE);
                break;
            case SENSORS:
                lytEmail.setVisibility(View.GONE);
                lytUsers.setVisibility(View.GONE);
                lytSensors.setVisibility(View.VISIBLE);
                toolbar.setTitle("Sensors");
                fab.setVisibility(View.GONE);
                break;
        }

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            configureLayouts(Tabs.EMAIL);
                            break;
                        case 1:
                            configureLayouts(Tabs.USERS);
                            break;
                        case 2:
                            configureLayouts(Tabs.SENSORS);
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }

