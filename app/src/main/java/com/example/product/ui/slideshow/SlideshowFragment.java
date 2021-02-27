package com.example.product.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.product.Cannabis;
import com.example.product.R;


public class SlideshowFragment extends Fragment {


    EditText edittextpassword;
    Button submitButton;
    Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        context=getActivity().getApplicationContext();
       edittextpassword=root.findViewById(R.id.edittextpassword);
        submitButton=root.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextpassword.getText().toString().equalsIgnoreCase("cannabis")){
                    Intent intent=new Intent(context, Cannabis.class);
                    startActivity(intent);
                    edittextpassword.setText("");
                }else {
                    Toast.makeText(context, "Wrong password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return root;
    }
}
