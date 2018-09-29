package qenawi.panda.task_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {
    String st1 = "Cool Fancy Text Generator is a copy and paste font generator and font changer that creates Twitter, Facebook, Instagram fonts. It converts a normal text to different free cool fonts styles, such as tattoo fonts, calligraphy fonts, web script fonts, cursive fonts, handwriting fonts, old English fonts, word fonts, pretty fonts, font art... Facebook, Twitter, Instagram Fonts or Fonts for Instagram, Twitter, Facebook - If that is what you want then this tool is a perfect place to go because it provides more than that!";
    String st2 = "Am terminated it excellence invitation projection as. She graceful shy believed distance use nay. Lively is people so basket ladies window expect. Supply as so period it enough income he genius. Themselves acceptance bed sympathize get dissimilar way admiration son. Design for are edward regret met lovers. This are calm case roof and";
    String st3 = "Arrived compass prepare an on as. Reasonable particular on my it in sympathize. Size now easy eat hand how. Unwilling he departure elsewhere dejection at. Heart large seems may purse means few blind. Exquisite newspaper attending on certainty oh suspicion of. He less do quit evil is. Add matter family active mutual put wishes happen. \n" +
            "\n" +
            "Conveying or northward offending admitting perfectly my. Colonel gravity get thought fat smiling add but. Wonder twenty hunted and put income set desire expect. Am cottage calling my is mistake cousins talking up. Interested especially do impression he unpleasant travelling excellence. All few our knew time done draw ask. \n" +
            "\n" +
            "Certainty determine at of arranging perceived situation or. Or wholly pretty county in oppose. Favour met itself wanted settle put garret twenty. In astonished apartments resolution so an it. Unsatiable on by contrasted to reasonable companions an. On otherwise no admitting to suspicion furniture it. ";
    String st4 = "Case read they must it of cold that. Speaking trifling an to unpacked moderate debating learning. An particular contrasted he excellence favourable on. Nay preference dispatched difficulty continuing joy one. Songs it be if ought hoped of. Too carriage attended him entrance desirous the saw. Twenty sister hearts garden limits put gay has. We hill lady will both sang room by. Desirous men exercise overcame procured speaking her followed. \n";
    String st5 = "Performed suspicion in certainty so frankness by attention pretended. Newspaper or in tolerably education enjoyment. Extremity excellent certainty discourse sincerity no he so resembled. Joy house worse arise total boy but. Elderly up chicken do at feeling is. Like seen drew no make fond at on rent. Behaviour extremely her explained situation yet september gentleman are who. Is thought or pointed hearing he. \n" +
            "\n" +
            "Is we miles ready he might going. Own books built put civil fully blind fanny. Projection appearance at of admiration no. As he totally cousins warrant besides ashamed do. Therefore by applauded acuteness supported affection it. Except had sex limits county enough the figure former add. Do sang my he next mr soon. It merely waited do unable. ";
    String st6 = "On then sake home is am leaf. Of suspicion do departure at extremely he believing. Do know said mind do rent they oh hope of. General enquire picture letters garrets on offices of no on. Say one hearing between excited evening all inhabit thought you. Style begin mr heard by in music tried do. To unreserved projection no introduced invitation.";

    @BindView(R.id.title2)
    TextView textView;
    @BindView(R.id.img)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemext);
        ButterKnife.bind(this);
        Random random = new Random();
        int x = random.nextInt(6 + 1);
        switch (x) {
            case 1:
                textView.setText(st1);
                break;
            case 2:
                textView.setText(st2);
                break;
            case 3:
                textView.setText(st3);
                break;
            case 4:
                textView.setText(st4);
                break;
            case 5:
                textView.setText(st5);
                break;
            case 6:
                textView.setText(st6);
                break;
        }

        RequestOptions options = new RequestOptions().centerCrop();

        Random random2 = new Random();
        int x2 = random2.nextInt(3) + 1;

        switch (x2) {
            case 1:
                Glide.with(this).load(R.drawable.men).apply(options).into(imageView);
                break;
            case 2:
                Glide.with(this).load(R.drawable.women).apply(options).into(imageView);
                break;
            case 3:
                Glide.with(this).load(R.drawable.kids).apply(options).into(imageView);
                break;
        }

    }
    @OnClick(R.id.backarrow)
    void back(View view)
    {
        finish();
    }
}
