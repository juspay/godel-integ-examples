package in.juspay.godel.integ.examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends ActionBarActivity {
    private static final String LOG_TAG = HomeActivity.class.getName();
    private static final String EMBEDDED_BUTTON = "Embedded Fragment";
    private static final String EXTENDED_BUTTON = "FL + JBF Extended";
    private static final String SIMPLE_BUTTON = "FL + JBF Direct";



    private Intent intent;
    private Button embedButton;
    private Button extendedButton;
    private Button simpleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        embedButton = (Button) findViewById(R.id.embed_fragment);
        extendedButton = (Button) findViewById(R.id.FL_Extended);
        simpleButton = (Button) findViewById(R.id.FL_Simple);
        intent = new Intent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        enableButtons();
    }

    private void enableButtons() {
        embedButton.setEnabled(true);
        extendedButton.setEnabled(true);
        simpleButton.setEnabled(true);
        embedButton.setText(EMBEDDED_BUTTON);
        extendedButton.setText(EXTENDED_BUTTON);
        simpleButton.setText(SIMPLE_BUTTON);
    }

    private void disableButtons() {
        embedButton.setEnabled(false);
        extendedButton.setEnabled(false);
        simpleButton.setEnabled(false);
    }

    public void embedFragmentButtonClicked(View view) {
        disableButtons();
        embedButton.setText("Processing...");
        intent.setClass(this, EmbeddedFragmentActivity.class);
        startActivity(intent);
    }

    public void extendedButtonClicked(View view) {
        disableButtons();
        extendedButton.setText("Processing...");
        intent.setClass(this, FrameLayoutExtendedActivity.class);
        startActivity(intent);
    }

    public void directButtonClicked(View view) {
        disableButtons();
        simpleButton.setText("Processing...");
        intent.setClass(this, FrameLayoutSimpleActivity.class);
        startActivity(intent);
    }
}
