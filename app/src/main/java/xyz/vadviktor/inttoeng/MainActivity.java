package xyz.vadviktor.inttoeng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertInteger(View view) {
        Switch   toggle = (Switch) findViewById(R.id.switch_version);
        boolean  us     = toggle.isChecked();
        EditText input  = (EditText) findViewById(R.id.editText_number);
        String   number = input.getText().toString();
        TextView output = (TextView) findViewById(R.id.textView_Result);

        input.setText("");
        output.setText(IntToEng.convert(number, us));
    }

}
