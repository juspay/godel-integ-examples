package in.juspay.godel.integ.examples;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import in.juspay.godel.ui.JuspayBrowserFragment;
import in.juspay.godel.ui.JuspayWebView;


public class FrameLayoutExtendedActivity extends BaseActivity {

    private PaymentFragment paymentFragment;
    private JuspayWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        if(savedInstanceState!=null) {
            paymentFragment = (PaymentFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, "paymentFragment");
        } else {
            paymentFragment = new PaymentFragment();
            setJuspayArgumentBundle(paymentFragment);
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, paymentFragment);
            transaction.commit();
        }
        setupCallbacks(paymentFragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Put the lastFragment in the outState Bundle
        getSupportFragmentManager().putFragment(outState, "paymentFragment", paymentFragment);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {
        if(paymentFragment!=null) {
            paymentFragment.juspayBackPressedHandler(true);
        } else{
            super.onBackPressed();
        }
    }

    /**
     *  fragment extending JuspayBrowserFragment.
     */
    public static class PaymentFragment extends JuspayBrowserFragment {

        public PaymentFragment() {
        }
    }
}
