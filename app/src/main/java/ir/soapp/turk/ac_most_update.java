package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ac_most_update extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_most_update);
    }

    public void ac_most_update_onclick_update_button(View v)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Cls_Main.APP_DOWNLOAD_URL)));
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
