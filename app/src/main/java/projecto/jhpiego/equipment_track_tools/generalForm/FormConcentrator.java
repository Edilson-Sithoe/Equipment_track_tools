package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormConcentrator extends AppCompatActivity {

    private Button btnBack, btnNext;
    private TextView txtHFCO, txtBrokenCO, txtFPMCO, txtMCCO, txtCPMCONCO, txtMPCO, txtCommentCO;
    String[] mensagens = {"Preencha todos os campos", "Falha ao registar", "Registado com sucesso"};
    private String cbo_conc_health_fac, cbo_active_pm_program, cbo_carrie_by, cbo_logbook_pm_cm, cbo_logbook_upd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_concentrator);

        //  getSupportActionBar().hide();
        IniciarComponentes();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String concentrator_in_health_fac = cbo_conc_health_fac;
                String number_concentrator = txtHFCO.getText().toString();
                String concentrator_broken = txtBrokenCO.getText().toString();
                String active_pm_program_conc = cbo_active_pm_program;
                String active_carrie_by = cbo_carrie_by;
                String frequency_conce = txtFPMCO.getText().toString();
                String name_maintenance_company = txtMCCO.getText().toString();
                String average_cost_per_year = txtCPMCONCO.getText().toString();
                String budgbet_maitanance_progra = txtMPCO.getText().toString();
                String logbbook_maintenance_conc = cbo_logbook_pm_cm;
                String logbbook_update_cenc = cbo_logbook_upd;
                String comments_conc = txtCommentCO.getText().toString();

                if (TextUtils.isEmpty(number_concentrator) || TextUtils.isEmpty(concentrator_broken) || TextUtils.isEmpty(frequency_conce) ||
                        TextUtils.isEmpty(average_cost_per_year) || TextUtils.isEmpty(budgbet_maitanance_progra)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setConcentrator_in_health_fac(concentrator_in_health_fac);
                    Assessment.assessment_model.setNumber_concentrator(txtHFCO.getText().toString());
                    Assessment.assessment_model.setConcentrator_broken(txtBrokenCO.getText().toString());
                    Assessment.assessment_model.setActive_pm_program_conc(active_pm_program_conc);
                    Assessment.assessment_model.setActive_carrie_by(active_carrie_by);
                    Assessment.assessment_model.setFrequency_conce(txtFPMCO.getText().toString());
                    Assessment.assessment_model.setName_maintenance_company(txtMCCO.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year(txtCPMCONCO.getText().toString());
                    Assessment.assessment_model.setBudgbet_maitanance_progra(txtMPCO.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintenance_conc(logbbook_maintenance_conc);
                    Assessment.assessment_model.setLogbbook_update_cenc(logbbook_update_cenc);
                    Assessment.assessment_model.setComments_conc(txtCommentCO.getText().toString());

                    Intent i = new Intent(FormConcentrator.this, FormManiFold.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conc = new Intent(FormConcentrator.this, FormCylinders.class);
                startActivity(conc);
            }
        });
    }

    public void onRadioButtonClicked_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesCO:
                if (checked)
                    cbo_conc_health_fac = "Sim";
                break;
            case R.id.idChkNoCO:
                if (checked)
                    cbo_conc_health_fac = "Não";
                break;
        }
    }

    public void onRadioButtonClicked1_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesPMCO:
                if (checked)
                    cbo_active_pm_program = "Sim";
                break;
            case R.id.idChkNoPMCO:
                if (checked)
                    cbo_active_pm_program = "Não";
                break;
        }
    }

    public void onRadioButtonClicked2_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPHFCO:
                if (checked)
                    cbo_carrie_by = "Internal Technical Personnel of the health facility";
                break;
            case R.id.idChkPDICO:
                if (checked)
                    cbo_carrie_by = "Personnel of the Department of Infrastructure";
                break;
            case R.id.idChkSubCCO:
                if (checked)
                    cbo_carrie_by = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked3_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesPMCMCO:
                if (checked)
                    cbo_logbook_pm_cm = "Sim";
                break;
            case R.id.idChkNoPMCMCO:
                if (checked)
                    cbo_logbook_pm_cm = "Não";
                break;
        }
    }

    public void onRadioButtonClicked4_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesLBCO:
                if (checked)
                    cbo_logbook_upd = "Sim";
                break;
            case R.id.idChkNoLBCO:
                if (checked)
                    cbo_logbook_upd = "Não";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_backCO);
        btnNext = findViewById(R.id.btn_next);


        txtHFCO = findViewById(R.id.idTxtHFCO);
        txtBrokenCO = findViewById(R.id.idTxtBrokenCO);
        txtFPMCO = findViewById(R.id.idTxtFPMCO);
        txtMCCO = findViewById(R.id.idTxtMCCO);
        txtCPMCONCO = findViewById(R.id.idTxtCPMCONCO);
        txtMPCO = findViewById(R.id.idTxtMPCO);

        txtCommentCO = findViewById(R.id.idTxtCommentCO);
    }

    public void LimparCampos() {
        txtBrokenCO.setText("");
        txtCPMCONCO.setText("");
        txtFPMCO.setText("");
        txtCommentCO.setText("");
        txtHFCO.setText("");
        txtMCCO.setText("");
        txtMPCO.setText("");
    }
}