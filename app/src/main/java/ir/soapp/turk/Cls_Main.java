package ir.soapp.turk;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.jalasoft.net.http.HttpClient;

public class Cls_Main
{

    public static String ROOT_URL="http://sorapp.ir";
    public static String URL=ROOT_URL+"/wp-content/plugins/Fta_Mobile_API_Application/Fta_Mobile_API_Application.php";

    public static ArrayList<String> Categorys_Id=new ArrayList<>();
    public static ArrayList<String> Categorys=new ArrayList<>();

    public static ArrayList<String> ALL_POSTS_ID=new ArrayList<>();
    public static ArrayList<String> ALL_POSTS_Title=new ArrayList<>();
    public static ArrayList<String> ALL_POSTS_Image=new ArrayList<>();

    public static ArrayList<String> POSTS_BY_CATEGORY_ID=new ArrayList<>();
    public static ArrayList<String> POSTS_BY_CATEGORY_Title=new ArrayList<>();
    public static ArrayList<String> POSTS_BY_CATEGORY_Image=new ArrayList<>();

    public static ArrayList<String> SEARCH_VALUES_ID=new ArrayList<>();
    public static ArrayList<String> SEARCH_VALUES_Title=new ArrayList<>();
    public static ArrayList<String> SEARCH_VALUES_Image=new ArrayList<>();

    public static String USER_EMAIL="";
    public static String PHONE="";
    public static String Version_Code="";
    public static String APP_DOWNLOAD_URL="";
    public static String USER_ID="";
    public static String USER_Active_Code="";
    public static String USER_Condition="";
    public static String Register_Condition="";
    public static String Log_Condition="";

    public static String PROFILE_ID="";
    public static String PROFILE_Username="";
    public static String PROFILE_FullName="";
    public static String PROFILE_Phone="";
    public static String PROFILE_Email="";
    public static String PROFILE_Image="";
    public static String PROFILE_StartDate="";

/*-------------------------------------------------------------------------------------*/
    public static String GET_WEB_SCRAP_WITH_URL_AND_POST(ArrayList<NameValuePair> Post)
    {
        try
        {
            DefaultHttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(URL);
            httpPost.setEntity(new UrlEncodedFormEntity(Post,"UTF-8"));
            HttpResponse httpResponse=httpClient.execute(httpPost);
            HttpEntity httpEntity=httpResponse.getEntity();
            String Json=EntityUtils.toString(httpEntity);
            return Json;
        }
        catch (Exception Err)
        {

        }
        return null;
    }
/*-------------------------------------------------------------------------------------*/
    //Get Version From Start Start
    public static void GET_VERSION() throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","Version"));
        GET_VERSION_BY_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    //Get Version From Start End

    //Get Json Version Start
    public static void GET_VERSION_BY_JSON(String Json)
    {
        try
        {
            JSONObject Js = new JSONObject(Json);
            Version_Code=Js.getString("Version");
            APP_DOWNLOAD_URL=Js.getString("URL");
        }
        catch (Exception Err)
        {

        }
    }
    //Get Json Version End
/*-------------------------------------------------------------------------------------*/
    //New User Start
    public static void NEW_USER(String nameANDfamily,String Email,String Nikname,String Phone)throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","NEW_USER"));
        Post.add(new BasicNameValuePair("USER_NAME",Nikname));
        Post.add(new BasicNameValuePair("NameAndFamily",nameANDfamily));
        Post.add(new BasicNameValuePair("Email",Email));
        Post.add(new BasicNameValuePair("Phone",Phone));
        GET_NEW_USER_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    //New User End

    //GET NEW USER JSON RESULT Start
    public static void GET_NEW_USER_JSON(String Json) throws Exception
    {
        JSONObject jsonObject=new JSONObject(Json);

        USER_Condition=jsonObject.getString("Condition");

        try
        {
            USER_ID = jsonObject.getString("Id");
            USER_Active_Code = jsonObject.getString("Register_Code");
        }
        catch (Exception Err)
        {

        }
    }
    //GET NEW USER JSON RESULT End
/*-------------------------------------------------------------------------------------*/
    //New User Start
    public static void USER_Login(String nameANDfamily,String Email,String Username,String Phone)throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","Login_USER"));
        Post.add(new BasicNameValuePair("USER_NAME",Username));
        Post.add(new BasicNameValuePair("NameAndFamily",nameANDfamily));
        Post.add(new BasicNameValuePair("Email",Email));
        Post.add(new BasicNameValuePair("Phone",Phone));

        GET_USER_Login_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    //New User End

    //GET NEW USER JSON RESULT Start
    public static void GET_USER_Login_JSON(String Json) throws Exception
    {
        JSONObject jsonObject=new JSONObject(Json);

        USER_Condition=jsonObject.getString("Condition");

        try
        {
            USER_ID = jsonObject.getString("Id");
            USER_EMAIL = jsonObject.getString("Email");
            PHONE = jsonObject.getString("Phone");
            USER_Active_Code = jsonObject.getString("Register_Code");
        }
        catch (Exception Err)
        {

        }
    }
    //GET NEW USER JSON RESULT End
/*-------------------------------------------------------------------------------------*/
    //Register Code Start
    public static void REGISTER()throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","USER_REGESTER"));
        Post.add(new BasicNameValuePair("ID",USER_ID));
        Post.add(new BasicNameValuePair("CODE",USER_Active_Code));

        JSONObject Json=new JSONObject(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
        Register_Condition=Json.getString("Condition");
    }
    //Register Code End
/*-------------------------------------------------------------------------------------*/
    //Log Start
    public static void LOG(String ID) throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","Log"));
        Post.add(new BasicNameValuePair("User_Id",ID));

        LOG_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void LOG_JSON(String Json)throws Exception
    {
        JSONObject jsonObject=new JSONObject(Json);
        Log_Condition=jsonObject.getString("Condition").toString().trim();
    }
    //Log End
/*-------------------------------------------------------------------------------------*/
    //Get Categorys Start
    public static void GET_CATEGORYS() throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","Categorys"));

        GET_CATEGORYS_BY_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void GET_CATEGORYS_BY_JSON(String Json) throws Exception
    {

        Categorys_Id.clear();
        Categorys.clear();

        JSONArray Js=new JSONArray(Json);

        for(int i=0;i<Js.length();i++)
        {
            JSONObject Js_Obg=new JSONObject(Js.get(i).toString());
            Categorys_Id.add(Js_Obg.getString("Id"));
            Categorys.add(Js_Obg.getString("Name"));
        }

    }
    //Get Categorys End
/*-------------------------------------------------------------------------------------*/
    //Get All Posts Start
    public static void GET_ALL_POSTS() throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","GET_ALL_POSTS"));

        GET_JSON_ALL_POSTS(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void GET_JSON_ALL_POSTS(String Json) throws Exception
    {
        try
        {
            if (!ALL_POSTS_ID.get(0).trim().equals(""))
            {
                return;
            }
        }
        catch (Exception Err)
        {
            JSONArray jsonArray = new JSONArray(Json);
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                ALL_POSTS_ID.add(jsonObject.getString("Id"));
                ALL_POSTS_Title.add(jsonObject.getString("Title"));
                ALL_POSTS_Image.add(jsonObject.getString("Image"));
            }
        }
    }
    //Get All Posts End
/*-------------------------------------------------------------------------------------*/
    //Get Posts Of A Category Start
    public static void GET_POSTS_OF_A_CATEGORY(String CATEGORY_ID) throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","Posts_Of_Category"));
        Post.add(new BasicNameValuePair("Category_Id",CATEGORY_ID));

        GET_POSTS_OF_A_CATEGORY_OF_JSON(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void GET_POSTS_OF_A_CATEGORY_OF_JSON(String Json) throws Exception
    {
        JSONArray Js=new JSONArray(Json);

        for(int i=0;i<Js.length();i++)
        {
            JSONObject jsonObject=new JSONObject(Js.getString(i));
            POSTS_BY_CATEGORY_ID.add(jsonObject.getString("Id"));
            POSTS_BY_CATEGORY_Title.add(jsonObject.getString("Title"));
            POSTS_BY_CATEGORY_Image.add(jsonObject.getString("Image"));
        }
    }
    //Get Posts Of A Category End
/*-------------------------------------------------------------------------------------*/
    //Get User Profile Start
    public static void GET_USER_PROFILE(String ID) throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","GET_USER"));
        Post.add(new BasicNameValuePair("ID",ID));

        GET_USER_PROFILE_By_Json(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void GET_USER_PROFILE_By_Json(String Json)throws Exception
    {
        JSONObject jsonObject=new JSONObject(Json);

        PROFILE_ID=jsonObject.getString("ID");
        PROFILE_Username=jsonObject.getString("Username");
        PROFILE_FullName=jsonObject.getString("FullName");
        PROFILE_Phone=jsonObject.getString("Phone");
        PROFILE_Email=jsonObject.getString("Email");
        PROFILE_Image=jsonObject.getString("Image");
        PROFILE_StartDate=jsonObject.getString("Start_Date");

    }
    //Get User Profile End
/*-------------------------------------------------------------------------------------*/
    //Get Search Start
    public static void GET_SEARCH_A_VALUE(String Value) throws Exception
    {
        ArrayList<NameValuePair> Post=new ArrayList<>();
        Post.add(new BasicNameValuePair("Get_Action","SEARCH"));
        Post.add(new BasicNameValuePair("VALUE",Value));

        GET_SEARCH_A_VALUE_By_Json(GET_WEB_SCRAP_WITH_URL_AND_POST(Post));
    }
    public static void GET_SEARCH_A_VALUE_By_Json(String Json) throws Exception
    {

        SEARCH_VALUES_ID.clear();
        SEARCH_VALUES_Title.clear();
        SEARCH_VALUES_Image.clear();

        JSONArray jsonArray = new JSONArray(Json);
        if(jsonArray.length()>0)
        {
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                SEARCH_VALUES_ID.add(jsonObject.getString("Id"));
                SEARCH_VALUES_Title.add(jsonObject.getString("Title"));
                SEARCH_VALUES_Image.add(jsonObject.getString("Image"));
            }
        }
        else
        {
            SEARCH_VALUES_ID.add("EMPTY");
            SEARCH_VALUES_Title.add("EMPTY");
            SEARCH_VALUES_Image.add("EMPTY");
        }

    }
    //Get Search End
/*-------------------------------------------------------------------------------------*/


}
