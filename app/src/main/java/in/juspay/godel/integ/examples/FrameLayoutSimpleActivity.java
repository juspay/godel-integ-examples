package in.juspay.godel.integ.examples;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import java.util.Set;

import in.juspay.godel.ui.JuspayBrowserFragment;
import in.juspay.godel.ui.JuspayWebView;


public class FrameLayoutSimpleActivity extends BaseActivity {
    JuspayBrowserFragment juspayBrowserFragment;
    JuspayWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        if(savedInstanceState!=null) {
            juspayBrowserFragment = (JuspayBrowserFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, "juspayBrowserFragment");
        } else {
            juspayBrowserFragment = new JuspayBrowserFragment();
            setJuspayArgumentBundle(juspayBrowserFragment);
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container,juspayBrowserFragment);
            transaction.commit();
        }
        setupCallbacks(juspayBrowserFragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Put the lastFragment in the outState Bundle
        getSupportFragmentManager().putFragment(outState, "juspayBrowserFragment", juspayBrowserFragment);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {
        if(juspayBrowserFragment!=null) {
            juspayBrowserFragment.juspayBackPressedHandler(true);
        } else{
            super.onBackPressed();
        }
    }
}
