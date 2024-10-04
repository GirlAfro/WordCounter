package com.example.wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wordcounter.TextCounter;


public class MainActivity extends AppCompatActivity {

    private EditText txtInputText;
    private Spinner spinnerCountOptions;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInputText = findViewById(R.id.txtInputText);
        spinnerCountOptions = findViewById(R.id.spinnerCountOptions);
        txtResult = findViewById(R.id.txtResult);
        Button btnCount = findViewById(R.id.btnCount);

        // Set up spinner options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountOptions.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = txtInputText.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_empty_text, Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedOption = spinnerCountOptions.getSelectedItem().toString();
                int result = 0;

                if (selectedOption.equals(getString(R.string.count_words))) {
                    result = TextCounter.countWords(inputText);
                } else if (selectedOption.equals(getString(R.string.count_characters))) {
                    result = TextCounter.countCharacters(inputText);
                }

                txtResult.setText(String.valueOf(result));
            }
        });
    }

}

