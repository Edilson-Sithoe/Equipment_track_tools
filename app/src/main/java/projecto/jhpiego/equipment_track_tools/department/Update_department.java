package projecto.jhpiego.equipment_track_tools.department;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;
import projecto.jhpiego.equipment_track_tools.view.inventory.Form_inventory_view;
import projecto.jhpiego.equipment_track_tools.view.inventory.Update_equipm_inventory;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_department extends AppCompatActivity {

    private Button btn_update, btn_delete;
    private EditText txt_department, txt_obs;

    int id;
    String department, observacoes;

    String[] mensagens = {"Preencha todos os campos", "Actualizado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    Database_connection DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_department);
        InitComponents();
        getAndSetIntentData();
        confirmDialog();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(department);
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingData();

                Database_connection database_connection = new Database_connection(Update_department.this);
                if (database_connection.updateDataDepart(id, department, observacoes)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(216, 191, 216));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();

                    Intent i = new Intent(Update_department.this, Form_department_view.class);
                    startActivity(i);
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    private void settingData() {
        id = Variaveis.department.getId();
        department = txt_department.getText().toString().trim();
        observacoes = txt_obs.getText().toString().trim();
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("department") && getIntent().hasExtra("type_equipment")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txt_department.setText(Variaveis.department.getNome_department());
            txt_obs.setText(Variaveis.department.getObs());
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover " + Variaveis.department.getNome_department() + " ?");
        builder.setMessage("Pretende apagar " + Variaveis.department.getObs() + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Update_department.this);
                database_connection.deleteOneRow_dept(Variaveis.department.getId());
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


    public void InitComponents() {
        btn_delete = findViewById(R.id.btn_delete_depart);
        btn_update = findViewById(R.id.btn_update_depart);

        txt_department = findViewById(R.id.txtDept);
        txt_obs = findViewById(R.id.txtTypeEquip);
    }

}