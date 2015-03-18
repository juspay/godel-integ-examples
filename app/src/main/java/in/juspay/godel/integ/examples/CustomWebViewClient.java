package in.juspay.godel.integ.examples;

import android.webkit.WebView;

import in.juspay.godel.browser.JuspayWebViewClient;
import in.juspay.godel.ui.JuspayBrowserFragment;

/**
 * Created by stpl on 18/3/15.
 */
public class CustomWebViewClient extends JuspayWebViewClient {

    private final BaseActivity activity;

    public CustomWebViewClient(WebView webView, JuspayBrowserFragment browserFragment, BaseActivity activity) {
        super(webView, browserFragment);
        this.activity = activity;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if(view.getTitle() != null && view.getTitle().equals("Juspay Payment Response")) {
            activity.handlePaymentResponse(url);
        }
        else {
            super.onPageFinished(view, url);
        }
    }

}
