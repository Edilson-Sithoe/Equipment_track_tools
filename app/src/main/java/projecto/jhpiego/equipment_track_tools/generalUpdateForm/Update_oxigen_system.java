package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormFreePrevFFS;

import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_oxigen_system extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtConsumOxig, txtComment;
    private RadioButton idChkFactory, idChkLiqTank, idChkManifold, idChkConc, idChkCylinders, idChkNA;
    private RadioButton idChkFactorySS, idChkLiqTankSS, idChkManifoldSS, idChkConcSS, idChkCylindersSS, idChkNASS;
    private RadioButton idChkFactoryES, idChkLiqTankES, idChkManifoldES, idChkConcES, idChkCylindersES, idChkNAES;
    private String cbo_sys_prim, cbo_sys_sec, cbo_sys_emerg;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_oxigen_system);

        InitializerComponents();
        getAndSetIntentData();
        setRB_primary_supply();
        setRB_secondar_supply();
        setRB_emergency_supply();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avarege_consumin = txtConsumOxig.getText().toString();
                String sys_use_prim_supp = cbo_sys_prim;
                String sys_use_sec_supp = cbo_sys_sec;
                String sys_use_emerg_supp = cbo_sys_emerg;
                String comments_solar = txtComment.getText().toString();

                if (idChkFactory.isChecked())
                    Variaveis.assessment_model.setTxtSystem_usePrimarySupply("The whole hospital");
                else if (idChkLiqTank.isChecked())
                    Variaveis.assessment_model.setTxtSystem_usePrimarySupply("Operating theatre");
                else if (idChkManifold.isChecked())
                    Variaveis.assessment_model.setTxtSystem_usePrimarySupply("Emergency Room");
                else if (idChkConc.isChecked())
                    Variaveis.assessment_model.setTxtSystem_usePrimarySupply("Laboratory");
                else if (idChkCylinders.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Maternity");
                else
                    Variaveis.assessment_model.setTxtSystem_usePrimarySupply("N/A");

                if (idChkFactorySS.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_secondary_supply("The whole hospital");
                else if (idChkLiqTankSS.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_secondary_supply("Operating theatre");
                else if (idChkManifoldSS.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_secondary_supply("Emergency Room");
                else if (idChkConcSS.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_secondary_supply("Laboratory");
                else if (idChkCylindersSS.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Maternity");
                else
                    Variaveis.assessment_model.setTxtSystem_use_secondary_supply("N/A");

                if (idChkFactoryES.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_emergency_supply("The whole hospital");
                else if (idChkLiqTankES.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_emergency_supply("Operating theatre");
                else if (idChkManifoldES.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_emergency_supply("Emergency Room");
                else if (idChkConcES.isChecked())
                    Variaveis.assessment_model.setTxtSystem_use_emergency_supply("Laboratory");
                else if (idChkCylindersES.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Maternity");
                else
                    Variaveis.assessment_model.setTxtSystem_use_emergency_supply("N/A");

                if (TextUtils.isEmpty(avarege_consumin)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTxtAverageConsOx(avarege_consumin);
                    Assessment.assessment_model.setTxtSystem_usePrimarySupply(sys_use_prim_supp);
                    Assessment.assessment_model.setTxtSystem_use_secondary_supply(sys_use_sec_supp);
                    Assessment.assessment_model.setTxtSystem_use_emergency_supply(sys_use_emerg_supp);
                    Assessment.assessment_model.setTxtComments_supply(comments_solar);

                    Intent i = new Intent(Update_oxigen_system.this, Update_free_prev_ffs.class);
                    startActivity(i);
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMGS = new Intent(Update_oxigen_system.this, Update_solar_energy.class);
                startActivity(backMGS);
            }
        });
    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtNameOfMantUPS")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtConsumOxig.setText(Variaveis.assessment_model.getTxtAverageConsOx());
            txtComment.setText(Variaveis.assessment_model.getTxtComments_supply());
        }
    }

    public void setRB_primary_supply() {
        idChkFactory = findViewById(R.id.idChkFactory);
        idChkLiqTank = findViewById(R.id.idChkLiqTank);
        idChkManifold = findViewById(R.id.idChkManifold);
        idChkConc = findViewById(R.id.idChkConc);
        idChkCylinders = findViewById(R.id.idChkCylinders);
        idChkNA = findViewById(R.id.idChkNA);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getTxtSystem_usePrimarySupply())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("Factory")) {
                idChkFactory.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("O2 Liquid Tank")) {
                idChkLiqTank.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("Manifold")) {
                idChkManifold.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("Concentrators")) {
                idChkConc.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("Cylinders")) {
                idChkCylinders.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_usePrimarySupply().equalsIgnoreCase("N/A")) {
                idChkNA.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_ox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkFactory:
                if (checked)
                    cbo_sys_prim = "Factory";
                break;
            case R.id.idChkLiqTank:
                if (checked)
                    cbo_sys_prim = "O2 Liquid Tank";
                break;
            case R.id.idChkManifold:
                if (checked)
                    cbo_sys_prim = "Manifold";
                break;
            case R.id.idChkConc:
                if (checked)
                    cbo_sys_prim = "Concentrators";
                break;
            case R.id.idChkCylinders:
                if (checked)
                    cbo_sys_prim = "Cylinders";
                break;
            case R.id.idChkNA:
                if (checked)
                    cbo_sys_prim = "N/A";
                break;
        }
    }

    public void setRB_secondar_supply() {
        idChkFactorySS = findViewById(R.id.idChkFactorySS);
        idChkLiqTankSS = findViewById(R.id.idChkLiqTankSS);
        idChkManifoldSS = findViewById(R.id.idChkManifoldSS);
        idChkConcSS = findViewById(R.id.idChkConcSS);
        idChkCylindersSS = findViewById(R.id.idChkCylindersSS);
        idChkNASS = findViewById(R.id.idChkNASS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getTxtSystem_use_secondary_supply())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("Factory")) {
                idChkFactorySS.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("O2 Liquid Tank")) {
                idChkLiqTankSS.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("Manifold")) {
                idChkManifoldSS.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("Concentrators")) {
                idChkConcSS.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("Cylinders")) {
                idChkCylinders.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_secondary_supply().equalsIgnoreCase("N/A")) {
                idChkNASS.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_two_ox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkFactorySS:
                if (checked)
                    cbo_sys_sec = "Factory";
                break;
            case R.id.idChkLiqTankSS:
                if (checked)
                    cbo_sys_sec = "O2 Liquid Tank";
                break;
            case R.id.idChkManifoldSS:
                if (checked)
                    cbo_sys_sec = "Manifold";
                break;
            case R.id.idChkConcSS:
                if (checked)
                    cbo_sys_sec = "Concentrators";
                break;
            case R.id.idChkCylindersSS:
                if (checked)
                    cbo_sys_sec = "Cylinders";
                break;
            case R.id.idChkNASS:
                if (checked)
                    cbo_sys_sec = "N/A";
                break;
        }
    }

    public void setRB_emergency_supply() {
        idChkFactoryES = findViewById(R.id.idChkFactoryES);
        idChkLiqTankES = findViewById(R.id.idChkLiqTankES);
        idChkManifoldES = findViewById(R.id.idChkManifoldES);
        idChkConcES = findViewById(R.id.idChkConcES);
        idChkCylindersES = findViewById(R.id.idChkCylindersES);
        idChkNAES = findViewById(R.id.idChkNAES);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getTxtSystem_use_emergency_supply())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("Factory")) {
                idChkFactoryES.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("O2 Liquid Tank")) {
                idChkLiqTankES.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("Manifold")) {
                idChkManifoldES.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("Concentrators")) {
                idChkConcES.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("Cylinders")) {
                idChkCylindersES.setChecked(true);
            } else if (Variaveis.assessment_model.getTxtSystem_use_emergency_supply().equalsIgnoreCase("N/A")) {
                idChkNAES.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_three_ox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkFactoryES:
                if (checked)
                    cbo_sys_emerg = "Factory";
                break;
            case R.id.idChkLiqTankES:
                if (checked)
                    cbo_sys_emerg = "O2 Liquid Tank";
                break;
            case R.id.idChkManifoldES:
                if (checked)
                    cbo_sys_emerg = "Manifold";
                break;
            case R.id.idChkConcES:
                if (checked)
                    cbo_sys_emerg = "Concentrators";
                break;
            case R.id.idChkCylindersES:
                if (checked)
                    cbo_sys_emerg = "Cylinders";
                break;
            case R.id.idChkNAES:
                if (checked)
                    cbo_sys_emerg = "N/A";
                break;
        }
    }


    public void InitializerComponents() {

        btnBack = findViewById(R.id.btn_backMGS);
        btnNExt = findViewById(R.id.btn_next);

        txtConsumOxig = findViewById(R.id.idTxtConsumMGS);
        txtComment = findViewById(R.id.idTxtComentMGS);
    }

    public void LimparCampos() {
        txtConsumOxig.setText("");
        txtComment.setText("");
    }
}