package ir.soapp.turk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.StatusBarManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ac_main extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
        {
            LinearLayout Home_LY=(LinearLayout)findViewById(R.id.ac_main_menu_home_item);
            LinearLayout Category_LY=(LinearLayout)findViewById(R.id.ac_main_menu_category_item);
            LinearLayout Profile_LY=(LinearLayout)findViewById(R.id.ac_main_menu_profile_item);

            Home_LY.setBackgroundResource(R.drawable.ripple);
            Category_LY.setBackgroundResource(R.drawable.ripple);
            Profile_LY.setBackgroundResource(R.drawable.ripple);
        }

    }
/*-------------------------------------------------------------------------------------*/



/*-------------------------------------------------------------------------------------*/
    //Onclick On Navigation Button Start
    public void ac_main_on_click_navigation_view_menu(View v)
    {

        switch (v.getId())
        {
            case R.id.ac_main_menu_home_item:
                try
                {
                    Home_Item();
                }
                catch (Exception Err){}
            break;
            case R.id.ac_main_menu_category_item:
                try {
                Category_Item();
                }
                catch (Exception Err){}
            break;
            case R.id.ac_main_menu_profile_item:
                try {
                Profile_Item();
                }
                catch (Exception Err){}
            break;
        }

    }
    //Onclick On Navigation Button End
/*-------------------------------------------------------------------------------------*/
    //On Back Button Press Start
    @Override
    public void onBackPressed()
    {
        if(!frag_home.GET_SEARCH_OPEN)
        {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        else
        {
            frag_home.SEARCH_CLOSE();
        }
    }
    //On Back Button Press End
/*-------------------------------------------------------------------------------------*/
    public void Home_Item() throws Exception
    {
        Clear_Items();
        ImageView Home=(ImageView)findViewById(R.id.ac_main_menu_home_item_image);
        Home.setImageResource(R.drawable.ic_home_select);
        RelativeLayout Home_Panel =(RelativeLayout)findViewById(R.id.ac_main_home_frag_panel);
        Home_Panel.setVisibility(View.VISIBLE);
    }
/*-------------------------------------------------------------------------------------*/
    public void Category_Item() throws Exception
    {
        Clear_Items();
        ImageView Category=(ImageView)findViewById(R.id.ac_main_menu_category_item_image);
        Category.setImageResource(R.drawable.ic_view_list_select);
        RelativeLayout Category_Panel =(RelativeLayout)findViewById(R.id.ac_main_categry_frag_panel);
        Category_Panel.setVisibility(View.VISIBLE);
    }
/*-------------------------------------------------------------------------------------*/
    public void Profile_Item() throws Exception
    {
        Clear_Items();
        ImageView Profile=(ImageView)findViewById(R.id.ac_main_menu_profile_item_image);
        Profile.setImageResource(R.drawable.ic_account_circle_select);
        RelativeLayout Profile_Panel =(RelativeLayout)findViewById(R.id.ac_main_profile_frag_panel);
        Profile_Panel.setVisibility(View.VISIBLE);
    }
/*-------------------------------------------------------------------------------------*/
    //Clear All Items Start
    public void Clear_Items() throws Exception
    {

        try
        {
            ImageView []Items=new ImageView[3];
            Items[0]=(ImageView)findViewById(R.id.ac_main_menu_home_item_image);
            Items[1]=(ImageView)findViewById(R.id.ac_main_menu_category_item_image);
            Items[2]=(ImageView)findViewById(R.id.ac_main_menu_profile_item_image);

            Items[0].setImageResource(R.drawable.ic_home_not_select);
            Items[1].setImageResource(R.drawable.ic_view_list_not_select);
            Items[2].setImageResource(R.drawable.ic_account_circle_not_select);

            RelativeLayout []All_Panels=new RelativeLayout[3];
            All_Panels[0]=(RelativeLayout)findViewById(R.id.ac_main_home_frag_panel);
            All_Panels[1]=(RelativeLayout)findViewById(R.id.ac_main_categry_frag_panel);
            All_Panels[2]=(RelativeLayout)findViewById(R.id.ac_main_profile_frag_panel);

            for(int a=0;a<All_Panels.length;a++)
                All_Panels[a].setVisibility(View.GONE);

            frag_home.SEARCH_CLOSE();

        }
        catch (Exception Err)
        {

        }

    }
    //Clear All Items End
/*-------------------------------------------------------------------------------------*/
    //Exit Of Account Click Event Start
    public void frag_profile_onclick_exit_of_account_btn(View v)
    {
        SharedPreferences.Editor editor=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE).edit();
        editor.putString("ID","");
        editor.putString("Email","");
        editor.putString("Phone","");
        editor.apply();
        startActivity(new Intent(getApplicationContext(),ac_logo.class));
    }
    //Exit Of Account Click Event End
/*-------------------------------------------------------------------------------------*/
    //Share App Link Click Event Start
    public void frag_profile_onclick_share_app_link_btn(View v)
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Cls_Main.APP_DOWNLOAD_URL);
        startActivity(Intent.createChooser(sharingIntent, "ارسال به"));
    }
    //Share App Link Click Event End
/*-------------------------------------------------------------------------------------*/

}
