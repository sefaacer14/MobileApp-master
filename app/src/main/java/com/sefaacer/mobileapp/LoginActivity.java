package com.sefaacer.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class LoginActivity extends AppCompatActivity {

    private static EditText userName;
    private static EditText passWord;
    private static Button loginButton;

    SharedPreferences sharedpreferences;
    public Boolean bulduMu = false;

    public class User {

        public String name;
        public String password;

        User(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.txtUserName);
        passWord = findViewById(R.id.txtPassword);
        loginButton = findViewById(R.id.btnLogin);

        User[] sefa = new User[3];
        sefa[0] = new User("111", "111");
        sefa[1] = new User("sefa", "sefa");
        sefa[2] = new User("acer", "acer");

        loginButton.setOnClickListener(v -> {

                    for (User item : sefa) {
                        if (userName.getText().toString().equals(item.name) && passWord.getText().toString().equals(item.password)) {
                            bulduMu = true;
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    if (bulduMu == false) {
                        Toast.makeText(LoginActivity.this, "please check username and password..", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Succesfully loggedin..", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

/*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.item_user);
        recyclerView = findViewById(R.id.rvUsers);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // mAdapter = new UserAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }

    public abstract class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.MyViewHolder> {

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView textName;
            public TextView textAge;
            public TextView textWeight;

            public MyViewHolder(TextView view) {
                super(view);
                textName = view.findViewById(R.id.txtName);
                textAge = view.findViewById(R.id.txtAge);
                textWeight = view.findViewById(R.id.txtWeight);
            }
        }

        List<String> list_person;
        LoginActivity listener;

        public SimpleRecyclerAdapter(List<String> list_person, LoginActivity listener) {

            this.list_person = list_person;
            this.listener = listener;

           public SimpleRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
                final MyViewHolder view_holder = new MyViewHolder(v);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(v, view_holder.getPosition());
                    }
                });

                return view_holder;
            }

        }

        public void onResume() {
            super.onResume();

            @SuppressLint("WrongConstant")
            SharedPreferences meliz = getSharedPreferences("mirac", MODE_APPEND);
            String aaa = meliz.getString("name", "");
            String bbb = meliz.getString("gender", "");
            int ccc = meliz.getInt("age", 0);
            int ddd = meliz.getInt("weight", 0);
            int eee = meliz.getInt("height", 0);


        }

    }

    */




