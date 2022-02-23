package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Rapelling extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapelling);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(Rapelling.this).load("data:image/jpeg;base64,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").into(iv);
            String str = "Abseiling (/ˈæbseɪl/ or /ˈɑːpzaɪl/; from German abseilen, 'to rope down'), also known as rappelling (/ɹæˈpɛl/ or /ɹəˈpɛl/) from French rappeler, 'to recall' or 'to pull through'), is a controlled descent off a vertical drop, such as a rock face, using a rope.";
            tv2.setText(str);
        }
    }
}