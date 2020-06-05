package com.example.barcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtBarcodeJ;
    private WebView wvURLJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReadBarcode();
        ReadURL();
    }

    private void ReadBarcode() {
        Button btnBarcodeJ = (Button)findViewById(R.id.btnBarcode);

        btnBarcodeJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent, 0);
            }
        });
    }

    private void ReadURL() {
        Button btnURLJ = (Button)findViewById(R.id.btnURL);
        edtBarcodeJ = (EditText)findViewById(R.id.edtBarcode);
        wvURLJ = (WebView)findViewById(R.id.wvURL);
        btnURLJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wvURLJ.loadUrl(edtBarcodeJ.getText().toString());
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        edtBarcodeJ = (EditText)findViewById(R.id.edtBarcode);

        if(requestCode == 0) {
            edtBarcodeJ.setText(intent.getStringExtra("SCAN_RESULT"));
        }
    }
}