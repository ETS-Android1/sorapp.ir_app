package ir.soapp.turk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class ac_sign_in extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    //Variables Start
    EditText NameAndFamily,Email,Username,Phone;
    ScrollView Main_Content;
    RelativeLayout Wait_Layout;
    public static boolean Action=false;
    CountDownTimer timer;
    //Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sign_in);
        Refresh();
    }
/*-------------------------------------------------------------------------------------*/
    //Open Login Activity Start
    public void ac_sing_in_On_Click_Login_Button(View v)
    {
        startActivity(new Intent(getApplicationContext(),ac_login.class));
    }
    //Open Login Activity End
/*-------------------------------------------------------------------------------------*/
    //On Back Button Press Event Start
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    //On Back Button Press Event End
/*-------------------------------------------------------------------------------------*/
    //On Click Sign Button Start
    public void ac_sing_in_On_Click_Signin_Button(View v)
    {

        EditText []feilds={NameAndFamily,Email,Username,Phone};
        boolean Values=true;

        for(int i=0;i<feilds.length;i++)
        {
            if(feilds[i].getText().toString().trim().equals(""))
            {
                feilds[i].setError(getString(R.string.Please_Fill_All_Edittexts));
                Values=false;
            }
        }

        if(!Values)
        {
            return;
        }

        Show_Waite();
        Sign_Timer();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Cls_Main.NEW_USER(NameAndFamily.getText().toString().trim(), Email.getText().toString().trim(), Username.getText().toString().trim(), Phone.getText().toString().trim());
                }
                catch (Exception Err)
                {
                }
            }
        }).start();

    }
    //On Click Sign Button End
/*-------------------------------------------------------------------------------------*/
    // Content And Waite Start
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
    //Sign Timer Start
    public void Sign_Timer()
    {
        timer=new CountDownTimer(600000,10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                try
                {
                    if(!Action && Cls_Main.USER_Condition.equals("USER_EXIST"))
                    {
                        User_Exist();
                        Action=true;
                        timer.cancel();
                    }
                    else if(!Action)
                    {
                        startActivity(new Intent(getApplicationContext(), ac_verify.class));
                        Show_Content();
                        Action=true;
                        timer.cancel();
                    }
                }
                catch (Exception Err)
                {

                }
            }

            @Override
            public void onFinish()
            {

            }
        }.start();
    }
    //Sign Timer End
/*-------------------------------------------------------------------------------------*/
    //Alert Exitst User Start
    public void User_Exist()
    {
        if(Action) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.user_exist))
                    .setMessage(getString(R.string.User_Exist))
                    .setNegativeButton(getString(R.string.Understand), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Action = false;
                            EditText[] feilds = {NameAndFamily, Email, Username, Phone};
                            for (int i = 0; i < feilds.length; i++)
                                feilds[i].setText("");
                            Show_Content();
                            timer.cancel();
                        }
                    }).show();
        }
    }
    //Alert Exitst User End
/*-------------------------------------------------------------------------------------*/
    //Get Refresh Start
    public void Refresh()
    {
        Main_Content=(ScrollView)findViewById(R.id.ac_sign_in_main_content);
        Wait_Layout=(RelativeLayout)findViewById(R.id.ac_sign_in_wait_layout);
        NameAndFamily=(EditText)findViewById(R.id.ac_sign_in_name_and_family_edittext);
        Email=(EditText)findViewById(R.id.ac_sign_in_email_edittext);
        Username=(EditText)findViewById(R.id.ac_sign_in_nikname_edittext);
        Phone=(EditText)findViewById(R.id.ac_sign_in_phone_edittext);
    }
    //Get Refresh End
/*-------------------------------------------------------------------------------------*/
}
