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

public class ac_login extends AppCompatActivity
{
/*-------------------------------------------------------------------------------------*/
    //Variables Start
    EditText Login_Edit_Text;
    CountDownTimer Timer;
    boolean Action=false;
    ScrollView Main_Content;
    RelativeLayout Wait_Layout;
    //Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
        Refresh();
    }
/*-------------------------------------------------------------------------------------*/
    //Open Signin Activity Start
    public void ac_log_in_On_Click_Signin_Button(View v)
    {
        startActivity(new Intent(getApplicationContext(),ac_sign_in.class));
    }
    //Open Signin Activity End
/*-------------------------------------------------------------------------------------*/
    //Login Button Start
    public void ac_login_on_click_login(View v)
    {

        if(Login_Edit_Text.getText().toString().trim().equals(""))
        {
            Login_Edit_Text.setError(getString(R.string.Please_Fill_All_Edittexts));
            return;
        }

        SHOW_WAIT();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Cls_Main.USER_Login(Login_Edit_Text.getText().toString().trim(),Login_Edit_Text.getText().toString().trim(),Login_Edit_Text.getText().toString().trim(),Login_Edit_Text.getText().toString().trim());
                }
                catch (Exception Err)
                {

                }
            }
        }).start();


        timer();

    }
    //Login Button End
/*-------------------------------------------------------------------------------------*/
    //Timer Start
    public void timer()
    {
        Timer=new CountDownTimer(600000,10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                try
                {

                    if(!Action && Cls_Main.USER_Condition.equals("yes"))
                    {
//                        Log.i("Errt",Cls_Main.USER_Active_Code);
                        startActivity(new Intent(getApplicationContext(),ac_verify.class));
                        SHOW_CONTENT();
                        Action=true;
                    }
                    else if(!Action && Cls_Main.USER_Condition.equals("no"))
                    {
                        USER_NOT_EXIST();
                        Action=true;
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
    //Timer End
/*-------------------------------------------------------------------------------------*/
    //Show Wait And Content Start
    public void SHOW_CONTENT()
    {
        Main_Content.setVisibility(View.VISIBLE);
        Wait_Layout.setVisibility(View.GONE);
    }
    public void SHOW_WAIT()
    {
        Main_Content.setVisibility(View.GONE);
        Wait_Layout.setVisibility(View.VISIBLE);
    }
    //Show Wait And Content End
/*-------------------------------------------------------------------------------------*/
    //User Not Exiest Start
    public void USER_NOT_EXIST()
    {
        if(Action)
        {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.user_Not_exist))
                    .setMessage(getString(R.string.User_Not_Exist))
                    .setNegativeButton(getString(R.string.Understand), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Action = false;
                            EditText[] feilds = {Login_Edit_Text};
                            for (int i = 0; i < feilds.length; i++)
                                feilds[i].setText("");
                            SHOW_CONTENT();
                            Timer.cancel();
                        }
                    }).show();
        }
    }
    //User Not Exiest End
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
    //Get All Variables Start
    public void Refresh()
    {
        Login_Edit_Text=(EditText)findViewById(R.id.ac_log_in_email_edittext);
        Main_Content=(ScrollView)findViewById(R.id.ac_login_content);
        Wait_Layout=(RelativeLayout)findViewById(R.id.ac_login_wait_layout);
    }
    //Get All Variables End
/*-------------------------------------------------------------------------------------*/

}
