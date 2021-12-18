package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class ac_not_regestered extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_not_regestered);
        Clear_SharedPerformance();
    }
/*-------------------------------------------------------------------------------------*/
    //On Click Retry Button Start
    public void ac_not_regestred_on_click_check_Retry(View v)
    {
        startActivity(new Intent(getApplicationContext(),ac_logo.class));
    }
    //On Click Retry Button End
/*-------------------------------------------------------------------------------------*/
    public void Clear_SharedPerformance()
    {
        SharedPreferences.Editor editor=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE).edit();
        editor.putString("ID",Cls_Main.USER_ID);
        editor.putString("Email",Cls_Main.USER_EMAIL);
        editor.putString("Phone",Cls_Main.PHONE);
        editor.apply();
    }
/*-------------------------------------------------------------------------------------*/
    //On Backpressed Start
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(getApplicationContext(),ac_logo.class));
    }
    //On Backpressed End
/*-------------------------------------------------------------------------------------*/

}
