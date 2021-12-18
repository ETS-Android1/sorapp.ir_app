package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class ac_notfound_user extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_notfound_user);
    }

    public void ac_notfound_user_on_click_retry_button(View v)
    {
        SharedPreferences.Editor editor=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE).edit();
        editor.putString("ID","");
        editor.putString("Email","");
        editor.putString("Phone","");

        startActivity(new Intent(getApplicationContext(),ac_sign_in.class));
    }

    @Override
    public void onBackPressed()
    {
        Intent Main=new Intent();
        Main.setAction(Intent.ACTION_MAIN);
        Main.addCategory(Intent.CATEGORY_HOME);
        startActivity(Main);
    }
}
