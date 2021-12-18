package ir.soapp.turk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ac_search extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    //Variables Start
    public static String Search_Value="";
    RelativeLayout Wait,Main_Content,not_found;
    CountDownTimer timer;
    GridView main_grid;
    //Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_search);
        Refresh();
        SHOW_WAIT();
        GET_SEARCH();
        GET_TIMER();
    }
/*-------------------------------------------------------------------------------------*/
    //Get All Componnets Start
    private void Refresh()
    {
        Wait=(RelativeLayout)findViewById(R.id.ac_search_wait);
        Main_Content=(RelativeLayout)findViewById(R.id.ac_search_main_content);
        main_grid=(GridView)findViewById(R.id.ac_search_gridview);
        not_found=(RelativeLayout)findViewById(R.id.ac_search_not_found);
    }
    //Get All Componnets End
/*-------------------------------------------------------------------------------------*/
    public void SHOW_WAIT()
    {
        Wait.setVisibility(View.VISIBLE);
        Main_Content.setVisibility(View.GONE);
        not_found.setVisibility(View.GONE);
    }
    public void SHOW_CONTENT()
    {
        Wait.setVisibility(View.GONE);
        Main_Content.setVisibility(View.VISIBLE);
        not_found.setVisibility(View.GONE);
    }
    public void SHOW_NOT_FOUND()
    {
        Wait.setVisibility(View.GONE);
        Main_Content.setVisibility(View.GONE);
        not_found.setVisibility(View.VISIBLE);
    }
/*-------------------------------------------------------------------------------------*/
    //Get Search By A Value Start
    public void GET_SEARCH()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Cls_Main.GET_SEARCH_A_VALUE(Search_Value);
                }
                catch (Exception Err)
                {

                }
            }
        }).start();
    }
    //Get Search By A Value End
/*-------------------------------------------------------------------------------------*/
    //TIMER START
    public void GET_TIMER()
    {
        timer=new CountDownTimer(600000,10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                try
                {
                    if(!Cls_Main.SEARCH_VALUES_ID.get(0).equals(""))
                    {
                        if(!Cls_Main.SEARCH_VALUES_ID.get(0).equals("EMPTY"))
                        {
                            Fill_Grid_View();
                        }
                        else
                        {
                            SHOW_NOT_FOUND();
                        }
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
    //TIMER END
/*-------------------------------------------------------------------------------------*/
    //Fill Gridview Start
    public void Fill_Grid_View()
    {
        main_grid.setAdapter(new Adaptor());
        main_grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ac_post.Post=Cls_Main.SEARCH_VALUES_ID.get(position);
                startActivity(new Intent(getApplicationContext(),ac_post.class));
            }
        });

        SHOW_CONTENT();
    }
    //Fill Gridview End
/*-------------------------------------------------------------------------------------*/
    //Search Adaptor Start
    class Adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return Cls_Main.SEARCH_VALUES_ID.size();
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if(Cls_Main.SEARCH_VALUES_ID.get(0)!=null
            && Cls_Main.SEARCH_VALUES_Title.get(0)!=null
            && Cls_Main.SEARCH_VALUES_Image.get(0)!=null)
            {
                View view = getLayoutInflater().inflate(R.layout.triple_grid_layout, null);

                LinearLayout Content = (LinearLayout) view.findViewById(R.id.triple_grid_layout_main_item_content);

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    Content.setBackgroundResource(R.drawable.ripple);
                }

                TextView Title = (TextView) view.findViewById(R.id.tripe_grid_layout_text_view);
                Title.setText(Cls_Main.SEARCH_VALUES_Title.get(position));

                try {
                    ImageView Image = (ImageView) view.findViewById(R.id.tripe_grid_layout_image_view);
                    Picasso.get().load(Cls_Main.SEARCH_VALUES_Image.get(position)).into(Image);
                } catch (Exception Err) {
//                    Log.i("Errt", Err.getMessage());
                }

                return view;
            }
            else
            {
                return null;
            }
        }
    }
    //Search Adaptor End
/*-------------------------------------------------------------------------------------*/
    @Override
    public void onBackPressed()
    {
        Cls_Main.SEARCH_VALUES_ID.clear();
        Cls_Main.SEARCH_VALUES_Title.clear();
        Cls_Main.SEARCH_VALUES_Image.clear();

        super.onBackPressed();
    }
/*-------------------------------------------------------------------------------------*/

}
