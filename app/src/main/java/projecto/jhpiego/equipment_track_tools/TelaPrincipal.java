package projecto.jhpiego.equipment_track_tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.generalForm.Form_all_data_view;
import projecto.jhpiego.equipment_track_tools.login.FormLogin;
import projecto.jhpiego.equipment_track_tools.mais.Menu_main;
import projecto.jhpiego.equipment_track_tools.view.inventory.Form_inventory_view;

public class TelaPrincipal extends AppCompatActivity {

    private Button btnLogout;
    private Button btn_all, btn_fomr, idBtnEquip_inv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

//        getSupportActionBar().hide();
        InitializerComponents();

        btn_fomr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent identInter = new Intent(TelaPrincipal.this, Form_all_data_view.class);
                   startActivity(identInter);
                   Toast.makeText(TelaPrincipal.this, "Formulario geral", Toast.LENGTH_SHORT).show();
            }
        });

        idBtnEquip_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent equipIvent = new Intent(TelaPrincipal.this, Form_inventory_view.class);
                startActivity(equipIvent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iclose = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(iclose);
                finish();
            }
        });

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interviw = new Intent(TelaPrincipal.this, Menu_main.class);
                startActivity(interviw);
            }
        });
    }

    private void InitializerComponents() {
        btn_all = findViewById(R.id.id_all);
        idBtnEquip_inv = findViewById(R.id.idBtnEquip_inv);
        btn_fomr = findViewById(R.id.idBtnForm);
        btnLogout = findViewById(R.id.id_close);
    }
}