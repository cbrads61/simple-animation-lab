package com.colinbradley.animationslab;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup viewGroup;
    private Button addWish;
    private EditText editText;
    private TextView wishText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        viewGroup = (ViewGroup)findViewById(R.id.viewgroup_layout);
        viewGroup.setLayoutTransition(layoutTransition);

        addWish = (Button)findViewById(R.id.addbutton);
        editText = (EditText)findViewById(R.id.edittext);
        wishText = (TextView) findViewById(R.id.wishtext);

        addWish.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addbutton:

                    wishText.setText(editText.getText().toString());

                    TextView text = new TextView(getApplicationContext());
                    text.setText(wishText.getText());
                    viewGroup.addView(text,0);
                    Animation animation = null;

                    animation = AnimationUtils.loadAnimation(this, R.anim.animation);
                    wishText.startAnimation(animation);
                
        }

    }
}
