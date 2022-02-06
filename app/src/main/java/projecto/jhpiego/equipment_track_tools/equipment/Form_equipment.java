package projecto.jhpiego.equipment_track_tools.equipment;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.mais.Menu_main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Form_equipment extends AppCompatActivity {
    private Button btn_save, btn_back;
    private TextView txt_equipm, txt_obs;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    Database_connection DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_equipment);
        InitComponents();

        DB = new Database_connection(this);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txt_equipm.getText().toString();
                String observacao = txt_obs.getText().toString();

                if (TextUtils.isEmpty(nome)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Boolean insertEquipment = DB.equipment(nome, observacao);
                    if (insertEquipment == true) {
                        Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(176, 224, 230));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                        LimparCampo();
                        Intent intent = new Intent(Form_equipment.this, Form_equipment_view.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(216, 191, 216));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                    }
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_equipment.this, Menu_main.class);
                startActivity(intent);
            }
        });
    }

    private void LimparCampo() {
        txt_equipm.setText("");
        txt_obs.setText("");
    }

    public void InitComponents() {
        btn_back = findViewById(R.id.btn_back_equipm);
        btn_save = findViewById(R.id.btn_save_equipm);

        txt_equipm = findViewById(R.id.txt_equipment);
        txt_obs = findViewById(R.id.txt_observacoes);
    }
}