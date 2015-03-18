package in.juspay.godel.integ.examples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebSettings;

import in.juspay.godel.analytics.GodelTracker;
import in.juspay.godel.integ.examples.util.Constants;
import in.juspay.godel.ui.JuspayBrowserFragment;
import in.juspay.godel.ui.JuspayWebView;


public class BaseActivity extends ActionBarActivity {

    private JuspayBrowserFragment juspayBrowserFragment;


    public void setupCallbacks(JuspayBrowserFragment browserFragment) {
        this.juspayBrowserFragment = browserFragment;
        juspayBrowserFragment.setupJuspayWebviewCallbackInterface(juspayWebviewCallback);
        juspayBrowserFragment.setupJuspayBackButtonCallbackInterface(backButtonCallback);
    }

    protected void setJuspayArgumentBundle (JuspayBrowserFragment browserFragment) {
        browserFragment.setArguments(getJuspayArgumentBundle());
    }

    protected Bundle getJuspayArgumentBundle(){
        Bundle args = new Bundle();
        args.putString("url", Constants.URL);
        args.putString("postData", Constants.POST_DATA);
        args.putString("merchantId", Constants.MERCHANT_ID);
        args.putString("clientId", Constants.CLIENT_ID);
        args.putString("transactionId", Constants.getTransactionId());
        args.putString("displayNote", Constants.DISPLAY_NOTE);
        args.putString("remarks", Constants.REMARKS);
        args.putString("amount", String.valueOf(Constants.AMOUNT));
        args.putString("customerPhoneNumber", Constants.CUSTOMER_PHONE_NUMBER);
        args.putString("UDF_FIRST", "first_value");
        args.putString("UDF_SECOND", "second_value");
        args.putString("UDF_THIRD", "third_value");
        args.putString("UDF_FOURTH", "fourth_value");

        return args;
    }

    void initWebView(JuspayWebView webView, JuspayBrowserFragment juspayBrowserFragment) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);

        CustomWebViewClient viewClient = new CustomWebViewClient(webView, juspayBrowserFragment, this);
        webView.setWebViewClient(viewClient);
    }

    JuspayBrowserFragment.JuspayWebviewCallback juspayWebviewCallback = new JuspayBrowserFragment.JuspayWebviewCallback() {
        @Override
        public void webviewReady() {
            JuspayWebView webView = juspayBrowserFragment.getWebView();
            initWebView(webView, juspayBrowserFragment);
        }
    };

    JuspayBrowserFragment.JuspayBackButtonCallback backButtonCallback = new JuspayBrowserFragment.JuspayBackButtonCallback() {
        @Override
        public void transactionCancelled() {
            finish();
        }
    };

    /**
     * Payment is completed for the existing request. Process the url and send back the payment status.
     * */
    public void handlePaymentResponse(String url) {
        if (url.contains("success")) {
            GodelTracker.getInstance().trackPaymentStatus(Constants.getTransactionId(), GodelTracker.PaymentStatus.SUCCESS);
        } else if (url.contains("failure")) {
            GodelTracker.getInstance().trackPaymentStatus(Constants.getTransactionId(), GodelTracker.PaymentStatus.FAILURE);
        } else {
            GodelTracker.getInstance().trackPaymentStatus(Constants.getTransactionId(), GodelTracker.PaymentStatus.CANCELLED);
        }
    }
}
