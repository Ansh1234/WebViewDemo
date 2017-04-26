package com.example.anshul.webview;

import android.content.Context;
import android.os.ParcelUuid;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by anshul on 18/04/17.
 */


public class WebViewJsInterface {

  private WebView webView;
  private Context context;

  public WebViewJsInterface(Context context, WebView webView) {
    this.webView = webView;
    this.context=context;
  }

  @JavascriptInterface
  public void handleMessage(String message) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }

  @JavascriptInterface
  public void setWebViewTextCallback(){
    String script = WebViewUtils.formatScript("setText","This is a text from Android which is set " +
        "in the html page.");
    WebViewUtils.callJavaScriptFunction(webView,script);
  }

}
