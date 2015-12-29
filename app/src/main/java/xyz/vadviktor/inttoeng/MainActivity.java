package xyz.vadviktor.inttoeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public Integer version = 0;
    public Switch toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toggle = (Switch) findViewById(R.id.switch_version);

        this.toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    set_version_us();
                } else {
                    set_version_uk();
                }
            }
        });
    }

    protected void set_version_uk() {
        this.version = 0;
    }

    protected void set_version_us() {
        this.version = 1;
    }

}
