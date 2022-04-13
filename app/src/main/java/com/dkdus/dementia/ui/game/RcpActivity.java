package com.dkdus.dementia.ui.game;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.dkdus.dementia.R;

import java.util.Random;

public class RcpActivity extends AppCompatActivity {
    int s_comHand;
    ImageView handAnyImageView;
    ImageView setHandImageView;

    ImageButton rockButton;
    ImageButton paperButton;
    ImageButton scissorsButton;
    ImageButton replayButton;


    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcp);
        handAnyImageView = findViewById(R.id.hand_any_image_view);
        setHandImageView = findViewById(R.id.set_hand_image_view);

        rockButton = findViewById(R.id.rock_button);
        paperButton = findViewById(R.id.paper_button);
        scissorsButton = findViewById(R.id.scissors_button);
        replayButton = findViewById(R.id.replay_button);
        // setHandImageView.setVisibility(View.VISIBLE);
        // handAnyImageView.setVisibility(View.GONE);
        //animationDrawable = (AnimationDrawable) handAnyImageView.getDrawable();
        //animationDrawable.start();
    }

    public void button_click(View view) {
        switch (view.getId()){
            case R.id.replay_button:
                //setHandImageView.setVisibility(View.GONE);
                //handAnyImageView.setVisibility(View.VISIBLE);
                //animationDrawable.start();
                replayButton.setEnabled(false);
                rockButton.setEnabled(true);
                paperButton.setEnabled(true);
                scissorsButton.setEnabled(true);
                s_comHand = new Random().nextInt(3)+1;
                switch (s_comHand){
                    case 1:
                        setHandImageView.setImageResource(R.drawable.com_rock);
                        break;
                    case 2:
                        setHandImageView.setImageResource(R.drawable.com_scissors);
                        break;
                    case 3:
                        setHandImageView.setImageResource(R.drawable.com_paper);
                        break;
                }
                break;

            case R.id.rock_button:
            case R.id.paper_button:
            case R.id.scissors_button:
                replayButton.setEnabled(true);
                rockButton.setEnabled(false);
                paperButton.setEnabled(false);
                scissorsButton.setEnabled(false);
                //버튼활성화 비활성화 설정
                //animationDrawable.stop();
                //handAnyImageView.setVisibility(View.GONE);
                //setHandImageView.setVisibility(View.VISIBLE);
                //애니메이션 설정
                int userHand = Integer.parseInt(view.getTag().toString());
                winCheck(userHand,s_comHand);
                break;

            default:
                setHandImageView.setImageResource(R.drawable.com_scissors);
                break;
        }
    }

    public void winCheck (int userHand, int comHand){
        int result=(3+userHand-comHand)%3;
        switch (result){
            case 0://비김
            case 1://짐
                setHandImageView.setImageResource(R.drawable.x);
                break;
            case 2://이김
                setHandImageView.setImageResource(R.drawable.o);
                break;
        }


    }
}

