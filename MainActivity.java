package app.scarnedice;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public int UserScore=0;
    public int UserTurn=0;
    public int ComputerScore=0;
    public int ComputerTurn=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this is for the button reset
        Button reset=(Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserScore=0;
                ComputerScore=0;
                UserTurn=0;
                ComputerTurn=0;
                final TextView view1=(TextView) findViewById(R.id.score);
                  view1.setText("votre score :0 Computer Score : 0");

            }
        });
        // this is for the button hold
        final Button hold=(Button) findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserScore=UserTurn+UserTurn;
                  UserTurn=0;
                final TextView view1=(TextView) findViewById(R.id.score);
                view1.setText("votre score :"+ UserScore+ " Computer Score : 0");
            }
        });
        setContentView(R.layout.activity_main);

    }

    public int selectDice() {
        Random dice = new Random();
        int number = 1 + dice.nextInt(6);
        return number;
    }

    public void updateImage() {
        ImageView image = (ImageView) findViewById(R.id.myimage);
        int dice = selectDice();
        switch (dice) {
            case 1:
                image.setImageResource(R.drawable.dice1);
                 UserTurn=0;
                 TextView view= (TextView)findViewById(R.id.score);
                 view.setText("votre score :0 Computer Score : 0" );
                break;
            case 2:
                image.setImageResource(R.drawable.dice2);
                break;
            case 3:
                image.setImageResource(R.drawable.dice3);
                break;
            case 4:
                image.setImageResource(R.drawable.dice4);
                break;
            case 5:
                image.setImageResource(R.drawable.dice5);
                break;
            case 6:
                image.setImageResource(R.drawable.dice6);
                break;

        }
    }




}
