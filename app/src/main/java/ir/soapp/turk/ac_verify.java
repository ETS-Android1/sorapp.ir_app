package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class ac_verify extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    //Vars Start
    EditText Verify;
    CountDownTimer Timer;
    boolean Action=false;
    ScrollView Main_Content;
    RelativeLayout Wait_Layout;
    //Vars End
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_verify);
        Refresh();
    }
/*-------------------------------------------------------------------------------------*/
    //On Click Verify Button Start
    public void ac_verify_on_click_verify_button(View v)
    {
        if(Verify.getText().toString().trim().equals(""))
        {
            Verify.setError(getString(R.string.Please_Fill_All_Edittexts));
        }
        else
        {
            if(Verify.getText().toString().trim().equals(Cls_Main.USER_Active_Code))
            {
                Save_Data();
            }
            else
            {
                Toast.makeText(this, getString(R.string.Code_Is_False), Toast.LENGTH_SHORT).show();
            }
        }
    }
    //On Click Verify Button End
/*-------------------------------------------------------------------------------------*/
    public void Save_Data()
    {

        SHOW_WAIT();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Cls_Main.REGISTER();
                }
                catch (Exception Err)
                {
//                    Log.i("Errt",Err.getMessage());
                }
            }
        }).start();


        Timer=new CountDownTimer(6000000,10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                try
                {
                    if(!Cls_Main.Register_Condition.equals(""))
                    {
                        if(!Cls_Main.Register_Condition.toUpperCase().equals(""))
                        {

                            SharedPreferences.Editor editor=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE).edit();
                            editor.putString("ID",Cls_Main.USER_ID);
                            editor.putString("Email",Cls_Main.USER_EMAIL);
                            editor.putString("Phone",Cls_Main.PHONE);
                            editor.apply();

                            startActivity(new Intent(getApplicationContext(), ac_logo.class));
                            Action = true;
                            Timer.cancel();
                        }

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
/*-------------------------------------------------------------------------------------*/
    // Get All Components Start
    public void Refresh()
    {
        Verify=(EditText)findViewById(R.id.ac_verify_code_edit_text);
        Wait_Layout=(RelativeLayout)findViewById(R.id.ac_verify_waiting_layout);
        Main_Content=(ScrollView)findViewById(R.id.ac_verify_main_content_layout);
    }
    // Get All Components End
/*-------------------------------------------------------------------------------------*/
    //SHOW Waite Start
    public void SHOW_WAIT()
    {
        Wait_Layout.setVisibility(View.VISIBLE);
    }
    //SHOW Waite End
    //SHOW CONTENT START
    public void SHOW_CONTENT()
    {
        Wait_Layout.setVisibility(View.GONE);
    }
    //SHOW CONTENT End
/*-------------------------------------------------------------------------------------*/

}
