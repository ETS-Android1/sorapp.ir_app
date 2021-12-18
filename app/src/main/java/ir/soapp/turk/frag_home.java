package ir.soapp.turk;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class frag_home extends Fragment
{

/*-------------------------------------------------------------------------------------*/
    //All Variables Start
    public static GridView Main_Grid;
    public static SearchView searchView;
    public static ImageView logo;
    public static RelativeLayout main_content,empty_layout;
    public static Boolean GET_SEARCH_OPEN=false;
    public static Boolean Timer_Is_Run=false;
    public CountDownTimer Timer;
    RelativeLayout Wait,Content;
    //All Variables End
/*-------------------------------------------------------------------------------------*/
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.frag_home, container, false);
        Refresh(view);
        Show_Wait();
        Timer();
        return view;
    }
/*-------------------------------------------------------------------------------------*/
    private void Refresh(View v)
    {
        main_content=(RelativeLayout)v.findViewById(R.id.frag_home_search);
        Main_Grid=(GridView)v.findViewById(R.id.home_frag_grid_view);
        logo=(ImageView)v.findViewById(R.id.frag_home_header_logo);
        searchView=(SearchView)v.findViewById(R.id.frag_home_search_view);
        Wait=(RelativeLayout)v.findViewById(R.id.frag_home_wait);
        Content=(RelativeLayout)v.findViewById(R.id.frag_home_main_context);
        empty_layout=(RelativeLayout)v.findViewById(R.id.frag_home_empty_layout);

        GET_SEARCH();


        /** Grid View Usage Start */
        Main_Grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ac_post.Post=Cls_Main.ALL_POSTS_ID.get(position);
                startActivity(new Intent(getActivity(),ac_post.class));
            }
        });
        /** Grid View Usage End */

    }
/*-------------------------------------------------------------------------------------*/
    private void GET_SEARCH()
    {
        searchView.setOnSearchClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SEARCHING();
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener()
        {
            @Override
            public boolean onClose()
            {
                SEARCH_CLOSE();
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                if(query.length()>=3)
                {
                    startActivity(new Intent(getContext(), ac_search.class));
                    ac_search.Search_Value = query;
                }
                else
                {
                    Toast.makeText(getContext(), R.string.Plase_3_Char, Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

    }
/*-------------------------------------------------------------------------------------*/
    public static void SEARCHING()
    {
        logo.setVisibility(View.GONE);
        main_content.setVisibility(View.VISIBLE);
        GET_SEARCH_OPEN=true;
    }
    public static void SEARCH_CLOSE()
    {
        searchView.onActionViewCollapsed();
        main_content.setVisibility(View.GONE);
        logo.setVisibility(View.VISIBLE);
        GET_SEARCH_OPEN=false;
    }
/*-------------------------------------------------------------------------------------*/
    //Wait Ly And Content Start
    public void Show_Wait()
    {
        searchView.setVisibility(View.GONE);
        Content.setVisibility(View.GONE);
        Wait.setVisibility(View.VISIBLE);
    }
    public void Show_Content()
    {
        searchView.setVisibility(View.VISIBLE);
        Content.setVisibility(View.VISIBLE);
        Wait.setVisibility(View.GONE);
    }
    //Wait Ly And Content End
/*-------------------------------------------------------------------------------------*/
    //Empty Layout Start
    public void Show_Empty()
    {
        searchView.setVisibility(View.GONE);
        Content.setVisibility(View.GONE);
        Wait.setVisibility(View.GONE);
        empty_layout.setVisibility(View.VISIBLE);
    }
    //Empty Layout End

    //Get Timer Start
    public void Timer()
    {
        if(!Timer_Is_Run)
        {
            Timer_Is_Run = true;
            Timer = new CountDownTimer(600000, 2500)
            {
                @Override
                public void onTick(long millisUntilFinished)
                {
                    try
                    {
                        if (!Cls_Main.ALL_POSTS_ID.get(0).equals("") || !Cls_Main.ALL_POSTS_ID.get(0).equals(null))
                        {
                            try
                            {
                                frag_home.Main_Grid.setAdapter(new Home_Frag_Adaptor());
                                Show_Content();
                                Timer.cancel();
                            }
                            catch (Exception Err)
                            {

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
                    Show_Empty();
                    Timer.cancel();
                }
            }.start();
        }
    }
    //Get Timer End
/*-------------------------------------------------------------------------------------*/
    public class Home_Frag_Adaptor extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return Cls_Main.ALL_POSTS_ID.size();
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
            Title.setText(Cls_Main.ALL_POSTS_Title.get(position));

            try
            {
                ImageView Image=(ImageView)view.findViewById(R.id.tripe_grid_layout_image_view);
                Picasso.get().load(Cls_Main.ALL_POSTS_Image.get(position)).into(Image);
            }
            catch (Exception Err)
            {
//                Log.i("Errt",Err.getMessage());
            }

            return view;
        }
    }
/*-------------------------------------------------------------------------------------*/

}

