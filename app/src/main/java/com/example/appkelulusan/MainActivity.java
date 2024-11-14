package com.example.appkelulusan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText namaTxt, nimTxt, nilaiTxt;
    private TextView nama, nim, nilai, grade;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hitung = findViewById(R.id.hitungnilai);
        namaTxt = findViewById(R.id.namatxt);
        nimTxt = findViewById(R.id.nimtxt);
        nilaiTxt = findViewById(R.id.nilaitxt);

        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        nilai = findViewById(R.id.nilai);
        grade = findViewById(R.id.grade);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void hitung(View view) {
        String nama = namaTxt.getText().toString();
        String nim = nimTxt.getText().toString();
        String nilai = nilaiTxt.getText().toString();

        if (nama.isEmpty() || nim.isEmpty() || nilai.isEmpty()) {
            return;
        }

        double nilaiDouble = Double.parseDouble(nilai);
        String grade;

        if (nilaiDouble >= 80) {
            grade = "A";
        } else if (nilaiDouble >= 70) {
            grade = "B";
        } else if (nilaiDouble >= 60) {
            grade = "C";
        } else if (nilaiDouble >= 50) {
            grade = "D";
        } else {
            grade = "E";
        }

        this.nama.setText(nama);
        this.nim.setText(nim);
        this.nilai.setText(nilai);
        this.grade.setText(grade);
    }
}
