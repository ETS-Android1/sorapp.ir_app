package ir.soapp.turk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import org.apache.http.util.ByteArrayBuffer;

import java.io.InputStream;

public class ac_post extends AppCompatActivity
{

    public static String Post="";
    WebView Webview;
    RelativeLayout Main,Wait;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_post);

        Webview=(WebView)findViewById(R.id.ac_post_web_View);
        Main=(RelativeLayout)findViewById(R.id.ac_post_main_context);
        Wait=(RelativeLayout)findViewById(R.id.ac_post_in_wait_layout);

        Webview.setVerticalScrollBarEnabled(false);
        Webview.setHorizontalScrollBarEnabled(false);

        Webview.getSettings().setLoadsImagesAutomatically(true);
        Webview.getSettings().setJavaScriptEnabled(true);
        Webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);

        Webview.loadUrl("http://www.sorapp.ir/?p="+Post+"&type=mobile");

        Webview.setWebChromeClient(new WebChromeClient());
        Webview.setWebViewClient(new WebViewClient()
        {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                SHOW_WAIT();
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                SHOW_CONTEXT();
                super.onPageFinished(view, url);
            }
        });

    }

    public void SHOW_CONTEXT()
    {
        Main.setVisibility(View.VISIBLE);
        Wait.setVisibility(View.GONE);
    }

    public void SHOW_WAIT()
    {
        Main.setVisibility(View.GONE);
        Wait.setVisibility(View.VISIBLE);
    }




}
