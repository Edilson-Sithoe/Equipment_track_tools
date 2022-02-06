package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormConcentrator;
import projecto.jhpiego.equipment_track_tools.generalForm.FormCylinders;
import projecto.jhpiego.equipment_track_tools.generalForm.FormManiFold;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_concentrator extends AppCompatActivity {
    private Button btnBack, btnNext;
    private TextView txtHFCO, txtBrokenCO, txtFPMCO, txtMCCO, txtCPMCONCO, txtMPCO, txtCommentCO;
    private RadioButton idChkYesCO, idChkNoCO;
    private RadioButton idChkYesPMCO, idChkNoPMCO;
    private RadioButton idChkPHFCO, idChkPDICO, idChkSubCCO;
    private RadioButton idChkYesPMCMCO, idChkNoPMCMCO;
    private RadioButton idChkYesLBCO, idChkNoLBCO;
    String[] mensagens = {"Preencha todos os campos", "Falha ao registar", "Registado com sucesso"};
    private String cbo_conc_health_fac, cbo_active_pm_program, cbo_carrie_by, cbo_logbook_pm_cm, cbo_logbook_upd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_concentrator);

        IniciarComponentes();
        getAndSetIntentData();
        setRB_concentrator_in_health();
        setRB_concentrator_pm_program();
        setRBMain_pm_activies();
        setRB_logbook_man();
        setRB_logbook_update();

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

                if (idChkYesCO.isChecked())
                    Variaveis.assessment_model.setConcentrator_in_health_fac("Yes");
                else if (idChkNoCO.isChecked())
                    Variaveis.assessment_model.setConcentrator_in_health_fac("No");

                if (idChkYesCO.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_conc("Yes");
                else if (idChkNoCO.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_conc("No");

                if (idChkPHFCO.isChecked())
                    Variaveis.assessment_model.setActive_carrie_by("Internal Technical Personnel of the health facility");
                else if (idChkPDICO.isChecked())
                    Variaveis.assessment_model.setActive_carrie_by("Personnel of the Department of Infrastructure");
                else if (idChkSubCCO.isChecked())
                    Variaveis.assessment_model.setActive_carrie_by("Subcontracted");

                if (idChkYesPMCMCO.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance_conc("Yes");
                else if (idChkNoPMCMCO.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance_conc("No");

                if (idChkYesLBCO.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_cenc("Yes");
                else if (idChkNoLBCO.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_cenc("No");

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

                    Intent i = new Intent(Update_concentrator.this, Update_manifold.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conc = new Intent(Update_concentrator.this, Update_cylinders.class);
                startActivity(conc);
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtBrokenCO")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtHFCO.setText(Variaveis.assessment_model.getNumber_concentrator());
            txtBrokenCO.setText(Variaveis.assessment_model.getConcentrator_broken());
            txtFPMCO.setText(Variaveis.assessment_model.getFrequency_conce());
            txtMCCO.setText(Variaveis.assessment_model.getName_maintenance_company());
            txtCPMCONCO.setText(Variaveis.assessment_model.getAverage_cost_per_year());
            txtMPCO.setText(Variaveis.assessment_model.getBudgbet_maitanance_progra());
            txtCommentCO.setText(Variaveis.assessment_model.getComments_conc());
        }
    }


    public void setRB_concentrator_in_health() {
        idChkYesCO = findViewById(R.id.idChkYesCO);
        idChkNoCO = findViewById(R.id.idChkNoCO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getConcentrator_in_health_fac())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getConcentrator_in_health_fac().equalsIgnoreCase("Yes")) {
                idChkYesCO.setChecked(true);
            } else if (Variaveis.assessment_model.getConcentrator_in_health_fac().equalsIgnoreCase("No")) {
                idChkNoCO.setChecked(true);
            }
        }
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

    public void setRB_concentrator_pm_program() {
        idChkYesPMCO = findViewById(R.id.idChkYesPMCO);
        idChkNoPMCO = findViewById(R.id.idChkNoPMCO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActive_pm_program_conc())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActive_pm_program_conc().equalsIgnoreCase("Yes")) {
                idChkNoPMCO.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_pm_program_conc().equalsIgnoreCase("No")) {
                idChkNoCO.setChecked(true);
            }
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

    public void setRBMain_pm_activies() {
        idChkPHFCO = findViewById(R.id.idChkPHFCO);
        idChkPDICO = findViewById(R.id.idChkPDICO);
        idChkSubCCO = findViewById(R.id.idChkSubCCO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActive_carrie_by())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActive_carrie_by().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPHFCO.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_carrie_by().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPDICO.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_carrie_by().equalsIgnoreCase("Subcontracted")) {
                idChkSubCCO.setChecked(true);
            }
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

    public void setRB_logbook_man() {
        idChkYesPMCMCO = findViewById(R.id.idChkYesPMCMCO);
        idChkNoPMCMCO = findViewById(R.id.idChkNoPMCMCO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_maintenance_conc())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_maintenance_conc().equalsIgnoreCase("Yes")) {
                idChkYesPMCMCO.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_maintenance_conc().equalsIgnoreCase("No")) {
                idChkNoPMCMCO.setChecked(true);
            }
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

    public void setRB_logbook_update() {
        idChkYesLBCO = findViewById(R.id.idChkYesLBCO);
        idChkNoLBCO = findViewById(R.id.idChkNoLBCO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_update_cenc())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_update_cenc().equalsIgnoreCase("Yes")) {
                idChkYesLBCO.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_update_cenc().equalsIgnoreCase("No")) {
                idChkNoLBCO.setChecked(true);
            }
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