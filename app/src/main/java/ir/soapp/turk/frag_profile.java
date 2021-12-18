package ir.soapp.turk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Timer;

public class frag_profile extends Fragment
{

/*-------------------------------------------------------------------------------------*/
    //All Variables Start
    ImageView Profile_Image;
    CountDownTimer timer;
    RelativeLayout Main_Content;
    RelativeLayout Wait_Layout;
    TextView name_and_familly,username,email,phone,Version_TEXTVIEW;
    Button Edit_Profile;
    public static Boolean Timer_Is_Run=false;
    //All Variables End
/*-------------------------------------------------------------------------------------*/
    //Fragment Functions Start
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.frag_profile, container, false);
        Refresh(view);
        return view;
    }
    //Fragment Functions End
/*-------------------------------------------------------------------------------------*/
    //Get All Components Start
    private void Refresh(View view)
    {
        Profile_Image=(ImageView)view.findViewById(R.id.frag_profile_user_image_view);
        Wait_Layout=(RelativeLayout)view.findViewById(R.id.frag_profile_in_wait_layout);
        Main_Content=(RelativeLayout)view.findViewById(R.id.frag_profile_main_content);

        name_and_familly=(TextView)view.findViewById(R.id.frag_profile_name_and_family_textview);
        username=(TextView)view.findViewById(R.id.frag_profile_username_textview);
        email=(TextView)view.findViewById(R.id.frag_profile_email_textview);
        phone=(TextView)view.findViewById(R.id.frag_profile_phone_textview);
        Version_TEXTVIEW=(TextView)view.findViewById(R.id.frag_profile_version_textview);

        Edit_Profile=(Button)view.findViewById(R.id.frag_profile_edit_button);
        Edit_Profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(Cls_Main.ROOT_URL+"/wp-login.php")));
            }
        });

        Show_Waite();
        Timer();
    }
    //Get All Components End
/*-------------------------------------------------------------------------------------*/
    //Get Fill All Components Start
    private void Timer()
    {
        if(!Timer_Is_Run)
        {
            Timer_Is_Run=true;
            timer = new CountDownTimer(600000, 10)
            {
                @Override
                public void onTick(long millisUntilFinished)
                {
                    if (!Cls_Main.PROFILE_ID.equals(""))
                    {
                        Show_Content();

                        name_and_familly.setText((Cls_Main.PROFILE_FullName.equals("") ? "-" : Cls_Main.PROFILE_FullName));
                        username.setText((Cls_Main.PROFILE_Username.equals("") ? "-" : Cls_Main.PROFILE_Username));
                        email.setText((Cls_Main.PROFILE_Email.equals("") ? "-" : Cls_Main.PROFILE_Email));
                        phone.setText((Cls_Main.PROFILE_Phone.equals("") ? "-" : Cls_Main.PROFILE_Phone));

                        Picasso.get().load(Cls_Main.PROFILE_Image).into(Profile_Image);
                        timer.cancel();

                        Version_TEXTVIEW.setText("  نسخه  "+Cls_Main.Version_Code);

                    }
                }

                @Override
                public void onFinish()
                {

                }
            }.start();
        }
    }
    //Get Fill All Components End
/*-------------------------------------------------------------------------------------*/
    public void Show_Waite()
    {
        Main_Content.setVisibility(View.GONE);
        Wait_Layout.setVisibility(View.VISIBLE);
    }
    public void Show_Content()
    {
        Main_Content.setVisibility(View.VISIBLE);
        Wait_Layout.setVisibility(View.GONE);
    }
/*-------------------------------------------------------------------------------------*/

}
