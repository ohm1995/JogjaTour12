package id.handi.jogjatour.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import id.handi.jogjatour.R;

public class HargaActivity extends AppCompatActivity {
    //MENDEKLARASIKAN SEBUAH VARIABEL
    TextView jumlahtiket,totalharga;
    Button btnOk;
    CheckBox internasional,lokal;
    int tiket;
    int hargatiket = 1;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga2);

        //Membaca Interface dari XML

        totalharga = (TextView) findViewById(R.id.totalharga);
        jumlahtiket = (TextView) findViewById(R.id.jumlahtiket);
        btnOk = (Button) findViewById(R.id.btnOk);
        internasional = (CheckBox) findViewById(R.id.internasional);
        lokal = (CheckBox) findViewById(R.id.lokal);

        // LISTEN JUMLAH TIKET DIKALIKAN DENGAN MENGGUNAKAN PERCABANGAN//
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jumlahtiket.getText().equals("0")) {
                    totalharga.setText("Rp 0");
                    Toast.makeText(HargaActivity.this, "Mohon Maaf anda belum menentukan Pilihan",
                            Toast.LENGTH_SHORT).show();
                }
                else  {
                    String sTiket = "Rp. " + (tiket * hargatiket);
                    totalharga.setText(sTiket);
                    Toast.makeText(HargaActivity.this, "Cek harga Berhasil\nSudah termasuk PPN Rp.1",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        //CHECKBOX ADD-ONS TURIS LOKAL//
        lokal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lokal.isChecked()) {
                    hargatiket = hargatiket + 10000;
                } else {
                    hargatiket = hargatiket - 10000;
                }
            }
        });

        //CHECKBOX ADD-ONS INTERNASIONAL//
        internasional.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (internasional.isChecked()) {
                    hargatiket = hargatiket + 15000;

                } else {
                    hargatiket = hargatiket - 15000;
                }
            }
        });
    }

    public void tampiltiket (int n) {
        jumlahtiket.setText(n+"");
    }

    public void  tambahtiket (View v) {
        tiket = tiket + 1;
        if (tiket > 0) {
            lokal.setEnabled(true);
            internasional.setEnabled(true);
        }
        tampiltiket(tiket);
    }

    public void kurangtiket (View v) {
        tiket = tiket - 1;
        if (tiket == 0) {
            lokal.setEnabled(false);
            internasional.setEnabled(false);
        }
        tampiltiket(tiket);
    }

    public void tambahlokal (View v) {
        lokal.setEnabled(false);
    }

    public void  tambahinternasioanl (View v) {
        internasional.setEnabled(false);
    }

}

