package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormOxigenSystem extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtConsumOxig, txtComment;
    private String cbo_sys_prim, cbo_sys_sec, cbo_sys_emerg;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_oxygen_system);

     //   getSupportActionBar().hide();
        InitializerComponents();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avarege_consumin = txtConsumOxig.getText().toString();
                String sys_use_prim_supp = cbo_sys_prim;
                String sys_use_sec_supp = cbo_sys_sec;
                String sys_use_emerg_supp = cbo_sys_emerg;
                String comments_solar = txtComment.getText().toString();

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

                    Intent i = new Intent(FormOxigenSystem.this, FormFreePrevFFS.class);
                    startActivity(i);
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMGS = new Intent(FormOxigenSystem.this, FormSolarEnergy.class);
                startActivity(backMGS);
            }
        });

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