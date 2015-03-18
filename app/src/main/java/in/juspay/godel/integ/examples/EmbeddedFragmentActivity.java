package in.juspay.godel.integ.examples;

import android.os.Bundle;
import in.juspay.godel.ui.JuspayBrowserFragment;

public class EmbeddedFragmentActivity extends BaseActivity {

    private JuspayBrowserFragment browserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embedded_fragment);
        browserFragment = (JuspayBrowserFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        browserFragment.startPaymentWithArguments(getJuspayArgumentBundle());
        setupCallbacks(browserFragment);
    }

    @Override
    public void onBackPressed() {
        if(browserFragment!=null) {
            browserFragment.juspayBackPressedHandler(true);
        } else{
            super.onBackPressed();
        }
    }
}
