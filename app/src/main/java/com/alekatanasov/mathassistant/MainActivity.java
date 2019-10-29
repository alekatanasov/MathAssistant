package com.alekatanasov.mathassistant;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import evaluation.MathHelper;
import interfaces.evaluation.Helper;

public class MainActivity extends AppCompatActivity {
    private EditText inputWindow;
    private TextView outputWindow;
    private Button solveExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.inputWindow = findViewById(R.id.inputWindow);
        this.outputWindow = findViewById(R.id.outputWindow);
        this.solveExpression = findViewById(R.id.solveExpression);

        this.solveExpression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper helper = new MathHelper();

                // get the input math statement and solve it
                String inputExpression = inputWindow.getText().toString();
                String outputExpression = helper.solveMathStatement(inputExpression);

                // display solved statement
                outputWindow.setText(outputExpression);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
