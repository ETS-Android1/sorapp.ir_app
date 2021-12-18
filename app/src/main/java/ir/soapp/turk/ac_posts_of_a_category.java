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

public class ac_posts_of_a_category extends AppCompatActivity
{

    //Variables Start
    GridView gridView;
    RelativeLayout Context,WAIT;
    CountDownTimer Timer;
    //Variables End

    //Get Start
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_posts_of_a_category);
        Refresh();
    }
    //Get End

    //Get All Components Start
    public void Refresh()
    {
        Context=(RelativeLayout)findViewById(R.id.ac_posts_of_a_category_main_context);
        WAIT=(RelativeLayout)findViewById(R.id.ac_posts_of_a_category_wait);
        gridView=(GridView)findViewById(R.id.ac_posts_of_a_category_gridview);

        Timer=new CountDownTimer(6000000,10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                try
                {
                    if (!Cls_Main.POSTS_BY_CATEGORY_ID.get(0).equals(""))
                    {
                        gridView.setAdapter(new Adaptor());
                        SHOW_CONTEXT();
                        Timer.cancel();
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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ac_post.Post=Cls_Main.POSTS_BY_CATEGORY_ID.get(position);
                startActivity(new Intent(getApplicationContext(),ac_post.class));
            }
        });

    }
    //Get All Components End

    //Wait And Context Start
    public void SHOW_CONTEXT()
    {
        Context.setVisibility(View.VISIBLE);
        WAIT.setVisibility(View.GONE);
    }
    public void SHOW_WAIT()
    {
        Context.setVisibility(View.GONE);
        WAIT.setVisibility(View.VISIBLE);
    }
    //Wait And Context End

    //Adaptor Start
    class Adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return Cls_Main.POSTS_BY_CATEGORY_ID.size();
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
            View view=getLayoutInflater().inflate(R.layout.triple_grid_layout,null);


            LinearLayout Content=(LinearLayout)view.findViewById(R.id.triple_grid_layout_main_item_content);


            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            {
                Content.setBackgroundResource(R.drawable.ripple);
            }


            TextView Title=(TextView)view.findViewById(R.id.tripe_grid_layout_text_view);
            Title.setText(Cls_Main.POSTS_BY_CATEGORY_Title.get(position));

            try
            {
                ImageView Image=(ImageView)view.findViewById(R.id.tripe_grid_layout_image_view);
                Picasso.get().load(Cls_Main.POSTS_BY_CATEGORY_Image.get(position)).into(Image);
            }
            catch (Exception Err)
            {
//                Log.i("Errt",Err.getMessage());
            }

            return view;
        }
    }
    //Adaptor End

}
