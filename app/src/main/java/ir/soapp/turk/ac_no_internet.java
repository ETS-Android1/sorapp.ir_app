package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.snackbar.Snackbar;

public class ac_no_internet extends AppCompatActivity
{

    //Variables Start
    ScrollView Main_Scroll;
    //Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_no_internet);
    }
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
    //Internet Conntion Check Start
    public  boolean isInternetConnection()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //Internet Conntion Check End
/*-------------------------------------------------------------------------------------*/
    //On Click Try Agin Button For Internet Check Start
    public void ac_no_internet_on_click_check_conntion(View v)
    {
        try
        {
            if(isInternetConnection())
            {
                startActivity(new Intent(getApplicationContext(),ac_logo.class));
            }
            else
            {
                Main_Scroll=(ScrollView)findViewById(R.id.ac_no_internet_view);
                Snackbar.make(Main_Scroll,getString(R.string.no_internet_conntion),Snackbar.LENGTH_SHORT).show();
            }
        }
        catch (Exception Err)
        {

        }
    }
    //On Click Try Agin Button For Internet Check End
/*-------------------------------------------------------------------------------------*/

}
