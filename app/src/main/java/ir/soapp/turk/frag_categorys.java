package ir.soapp.turk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class frag_categorys extends Fragment
{

/*-------------------------------------------------------------------------------------*/
    //Get All Variables Start
    GridView Categorys;
    RelativeLayout Wait;
    CountDownTimer Timer;
    public static Boolean Timer_Is_Run=false;
    //Get All Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.frag_categorys, container, false);
        Timer();
        Refresh(view);
        SHOW_WAIT();
        return view;
    }
/*-------------------------------------------------------------------------------------*/
    //GET SERVER Data Start
    public void Timer()
    {
        if(!Timer_Is_Run)
        {
            Timer_Is_Run=true;
            Timer = new CountDownTimer(120000, 1000)
            {
                @Override
                public void onTick(long millisUntilFinished)
                {

                    try
                    {
                        if (!Cls_Main.Categorys_Id.get(0).equals(""))
                        {
                            Categorys.setAdapter(new Categorys_Adaptor());
                            SHOW_CONTENT();
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
        }
    }
    //GET SERVER Data End
/*-------------------------------------------------------------------------------------*/
    //GET ALL Components Start
    private void Refresh(View view)
    {
        Wait=(RelativeLayout)view.findViewById(R.id.frag_categorys_wait);
        Categorys=(GridView)view.findViewById(R.id.frag_categorys_grid_view);
    }
    //GET ALL Components End
/*-------------------------------------------------------------------------------------*/
    //Get Wait Start
    public void SHOW_CONTENT()
    {
        Wait.setVisibility(View.GONE);
        Categorys.setVisibility(View.VISIBLE);
    }
    public void SHOW_WAIT()
    {
        Wait.setVisibility(View.VISIBLE);
        Categorys.setVisibility(View.GONE);
    }
    //Get Wait End
/*-------------------------------------------------------------------------------------*/
    class Categorys_Adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return Cls_Main.Categorys_Id.size();
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
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View view=getLayoutInflater().inflate(R.layout.one_grid_layout,null);

            RelativeLayout Content=(RelativeLayout)view.findViewById(R.id.one_grid_layout_main_content);

            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            {
                Content.setBackgroundResource(R.drawable.ripple);
            }

            TextView textView=(TextView)view.findViewById(R.id.one_grid_layout_textview);
            textView.setText(Cls_Main.Categorys.get(position));


            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    new Thread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                Cls_Main.POSTS_BY_CATEGORY_ID.clear();
                                Cls_Main.POSTS_BY_CATEGORY_Title.clear();
                                Cls_Main.POSTS_BY_CATEGORY_Image.clear();

                                Cls_Main.GET_POSTS_OF_A_CATEGORY(Cls_Main.Categorys_Id.get(position));
                            }
                            catch (Exception Err)
                            {

                            }
                        }
                    }).start();

                    startActivity(new Intent(getActivity(),ac_posts_of_a_category.class));
                }
            });


            return view;
        }
    }
/*-------------------------------------------------------------------------------------*/

}
