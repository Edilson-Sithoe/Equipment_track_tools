package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormGeneratorFour;
import projecto.jhpiego.equipment_track_tools.generalForm.FormStabilizer;
import projecto.jhpiego.equipment_track_tools.generalForm.FormUPSOne;
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

public class Update_stabilizer extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private EditText txtComent, txtNameOfMant, txtFreqPM, txtOther, txtCapacity;
    private RadioButton idChkYesSTAB_editt, idChkNoSTAB_editt;
    private RadioButton idChkLessSis_editt, idChkB3_10Sis_editt, idChkB11_20Sis_editt, idChkMore20Sis_editt;
    private RadioButton idChkSTABY_editt, idChkSTABN_editt, idChkSTABPartly_editt, idChkSTABDontN_editt;
    private RadioButton idChkGIU_upd, idChkGBNU_upd, idChkIU_BNR_upd, idChkIUNNTR_upd, idchkOOSBR_upd, idChkOOSAndNR_upd, idChkStilInstPha_upd, idChkDontN_upd;
    private RadioButton idChkPMYSTAB_editt, idChkPMNSTAB_editt;
    private RadioButton idChkPMITPHF_upd, idChkPMPDI_upd, idChkSubcontracted_upd;
    private RadioButton idChkPMCMY_upd,idChkPMCMN_upd;
    private RadioButton idChkLoBY_upd,idChkLoBN_upd;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW, cboMain_gen_pmcm, cboMain_gen_lb;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stabilizer);
        IniciarComponentes();

        getAndSetIntentData();

        setRBMain_gen_hfSTAB();
        setRBMain_old();
        setRBMain_gen_cond();
        setRBMain_gen_hfSTAB();
        setRBMain_gen_hf();
        setRBMain_gen_lb();
        setRBMain_gen_work();
        setRBMain_gen_pm();
        setRBMain_gen_pmcm();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String voltaStab = cboMain_gen_hf;
                String holdsys = cboMain_old;
                String stabWorking = cboMain_gen_work;
                String conditionEqui = cboMain_gen_cond;
                String capacityStab = txtCapacity.getText().toString();
                String prev_main = cboMain_gen_hf;
                String activCarrie = cboMain_gen_pm;
                String frquencyPM = txtFreqPM.getText().toString();
                String name_mainStab = txtNameOfMant.getText().toString();
                String logbook = cboMain_gen_pmcm;
                String logbookupd = cboMain_gen_lb;
                String comments = txtComent.getText().toString();

                if (idChkYesSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkVoltaStabilizer("Yes");
                else if (idChkNoSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkVoltaStabilizer("No");

                if (idChkLessSis_editt.isChecked())
                    Variaveis.assessment_model.setChkHoldSystem("Less than 3 years");
                else if (idChkB3_10Sis_editt.isChecked())
                    Variaveis.assessment_model.setChkHoldSystem("Between 3-10 years");
                else if (idChkB11_20Sis_editt.isChecked())
                    Variaveis.assessment_model.setChkHoldSystem("Between 11-20 years");
                else if (idChkMore20Sis_editt.isChecked())
                    Variaveis.assessment_model.setChkHoldSystem("More than 20 years");

                if (idChkSTABY_editt.isChecked())
                    Variaveis.assessment_model.setChkStabWorking("Yes");
                else if (idChkSTABN_editt.isChecked())
                    Variaveis.assessment_model.setChkStabWorking("No");
                else if (idChkSTABPartly_editt.isChecked())
                    Variaveis.assessment_model.setChkStabWorking("Partly");
                else if (idChkSTABDontN_editt.isChecked())
                    Variaveis.assessment_model.setChkStabWorking("Don't know");

                if (idChkGIU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Good and in use");
                else if (idChkGBNU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Good, but not in use");
                else if (idChkIU_BNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("In use, but needs repair");
                else if (idChkIUNNTR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("In use, but needs to be replaced");
                else if (idchkOOSBR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Out of service, but repairable");
                else if (idChkOOSAndNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Out of service and needs to be replaced");
                else if (idChkStilInstPha_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Still in the installation phase");
                else if (idChkDontN_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEqu("Don't know");

                if (idChkPMYSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkPrevMain("Yes");
                else if (idChkPMNSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkPrevMain("No");

                if (idChkPMITPHF_upd.isChecked())
                    Variaveis.assessment_model.setChkActiCarries("Internal Technical Personnel of the Health Facility");
                else if (idChkPMPDI_upd.isChecked())
                    Variaveis.assessment_model.setChkActiCarries("Personnel from the Department of Infrastructure");
                else if (idChkSubcontracted_upd.isChecked())
                    Variaveis.assessment_model.setChkActiCarries("Subcontracted");

                if (idChkPMCMY_upd.isChecked())
                    Variaveis.assessment_model.setChklogBookMaint("Yes");
                else if (idChkPMCMN_upd.isChecked())
                    Variaveis.assessment_model.setChklogBookMaint("No");

                if (idChkLoBY_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBookUp("Yes");
                else if (idChkLoBN_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBookUp("No");

                if (TextUtils.isEmpty(frquencyPM) || TextUtils.isEmpty(capacityStab)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkVoltaStabilizer(voltaStab);
                    Assessment.assessment_model.setChkHoldSystem(holdsys);
                    Assessment.assessment_model.setChkStabWorking(stabWorking);
                    Assessment.assessment_model.setChkConditionEqu(conditionEqui);
                    Assessment.assessment_model.setTxtCapacityStab(txtCapacity.getText().toString());
                    Assessment.assessment_model.setChkPrevMain(prev_main);
                    Assessment.assessment_model.setChkActiCarries(activCarrie);
                    Assessment.assessment_model.setTxtFrequenPM(frquencyPM);
                    Assessment.assessment_model.setTxtNameOfMantStab(txtNameOfMant.getText().toString());
                    Assessment.assessment_model.setChklogBookMaint(logbook);
                    Assessment.assessment_model.setChkLogBookUp(logbookupd);
                    Assessment.assessment_model.setTxtComentStab(txtComent.getText().toString());

                    Intent i = new Intent(Update_stabilizer.this, Update_form_ups.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_stabilizer.this, Update_generator_four.class);
                startActivity(i);
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtNameOfMant")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtCapacity.setText(Variaveis.assessment_model.getTxtCapacityStab());
            txtFreqPM.setText(Variaveis.assessment_model.getTxtFrequenPM());
            txtNameOfMant.setText(Variaveis.assessment_model.getTxtNameOfMantStab());
            txtComent.setText(Variaveis.assessment_model.getTxtComentStab());
        }
    }

    public void setRBMain_gen_hfSTAB() {
        idChkYesSTAB_editt = findViewById(R.id.idChkYesSTAB_editt);
        idChkNoSTAB_editt = findViewById(R.id.idChkNoSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkVoltaStabilizer())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkVoltaStabilizer().equalsIgnoreCase("Yes")) {
                idChkYesSTAB_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkVoltaStabilizer().equalsIgnoreCase("No")) {
                idChkNoSTAB_editt.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesSTAB_editt:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoSTAB_editt:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }

    public void setRBMain_old() {
        idChkLessSis_editt = findViewById(R.id.idChkLessSis_editt);
        idChkB3_10Sis_editt = findViewById(R.id.idChkB3_10Sis_editt);
        idChkB11_20Sis_editt = findViewById(R.id.idChkB11_20Sis_editt);
        idChkMore20Sis_editt = findViewById(R.id.idChkMore20Sis_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkHoldSystem())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkHoldSystem().equalsIgnoreCase("Less than 3 years")) {
                idChkLessSis_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSystem().equalsIgnoreCase("Between 3-10 years")) {
                idChkB3_10Sis_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSystem().equalsIgnoreCase("Between 11-20 years")) {
                idChkB11_20Sis_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSystem().equalsIgnoreCase("More than 20 years")) {
                idChkMore20Sis_editt.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_two_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessSis_editt:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10Sis_editt:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20Sis_editt:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20Sis_editt:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void setRBMain_gen_work() {
        idChkSTABY_editt = findViewById(R.id.idChkSTABY_editt);
        idChkSTABN_editt = findViewById(R.id.idChkSTABN_editt);
        idChkSTABPartly_editt = findViewById(R.id.idChkSTABPartly_editt);
        idChkSTABDontN_editt = findViewById(R.id.idChkSTABDontN_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkStabWorking())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkStabWorking().equalsIgnoreCase("Yes")) {
                idChkSTABY_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkStabWorking().equalsIgnoreCase("No")) {
                idChkSTABN_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkStabWorking().equalsIgnoreCase("Partly")) {
                idChkSTABPartly_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkStabWorking().equalsIgnoreCase("Don't know")) {
                idChkSTABDontN_editt.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_three_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkSTABY_editt:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkSTABN_editt:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkSTABPartly_editt:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkSTABDontN_editt:
                if (checked)
                    cboMain_gen_work = "Don't know";
        }
    }

    public void setRBMain_gen_cond() {
        idChkGIU_upd = findViewById(R.id.idChkGIUSTAB_editt);
        idChkGBNU_upd = findViewById(R.id.idChkGBNUSTAB_editt);
        idChkIU_BNR_upd = findViewById(R.id.idChkIU_BNRSTAB_editt);
        idChkIUNNTR_upd = findViewById(R.id.idChkIUNNTRSTAB_editt);
        idchkOOSBR_upd = findViewById(R.id.idchkOOSBRSTAB_editt);
        idChkOOSAndNR_upd = findViewById(R.id.idChkOOSAndNRSTAB_editt);
        idChkStilInstPha_upd = findViewById(R.id.idChkStilInstPhaSTAB_editt);
        idChkDontN_upd = findViewById(R.id.idChkDontNSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkConditionEqu())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Good and in use")) {
                idChkGIU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Good, but not in use")) {
                idChkGBNU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("In use, but needs repair")) {
                idChkIU_BNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("In use, but needs to be replaced")) {
                idChkIUNNTR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Out of service, but repairable")) {
                idchkOOSBR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Out of service and needs to be replaced")) {
                idChkOOSAndNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Still in the installation phase")) {
                idChkStilInstPha_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEqu().equalsIgnoreCase("Don't know")) {
                idChkDontN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_four_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGIUSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNSTAB_editt:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void setRBMain_gen_hf() {
        idChkPMYSTAB_editt = findViewById(R.id.idChkPMYSTAB_editt);
        idChkPMNSTAB_editt = findViewById(R.id.idChkPMNSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkPrevMain())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPrevMain().equalsIgnoreCase("Yes")) {
                idChkPMYSTAB_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPrevMain().equalsIgnoreCase("No")) {
                idChkPMNSTAB_editt.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_five_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMYSTAB_editt:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkPMNSTAB_editt:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }

    public void setRBMain_gen_pm() {
        idChkPMITPHF_upd = findViewById(R.id.idChkPMITPHFSTAB_editt);
        idChkPMPDI_upd = findViewById(R.id.idChkPMPDISTAB_editt);
        idChkSubcontracted_upd = findViewById(R.id.idChkSubcontractedSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkActiCarries())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkActiCarries().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPMITPHF_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkActiCarries().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPMPDI_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkActiCarries().equalsIgnoreCase("Subcontracted")) {
                idChkSubcontracted_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_six_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMITPHFSTAB_editt:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDISTAB_editt:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedSTAB_editt:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void setRBMain_gen_pmcm() {
        idChkPMCMY_upd = findViewById(R.id.idChkPMCMYSTAB_editt);
        idChkPMCMN_upd = findViewById(R.id.idChkPMCMNSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChklogBookMaint())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChklogBookMaint().equalsIgnoreCase("Yes")) {
                idChkPMCMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChklogBookMaint().equalsIgnoreCase("No")) {
                idChkPMCMN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_seven_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMCMYSTAB_editt:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNSTAB_editt:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void setRBMain_gen_lb() {
        idChkLoBY_upd = findViewById(R.id.idChkLoBYSTAB_editt);
        idChkLoBN_upd = findViewById(R.id.idChkLoBNSTAB_editt);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkLogBookUp())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkLogBookUp().equalsIgnoreCase("Yes")) {
                idChkLoBY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLogBookUp().equalsIgnoreCase("No")) {
                idChkLoBN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_eight_stab_editt(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLoBYSTAB_editt:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNSTAB_editt:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_backSTAB_editt);
        btnNExt = findViewById(R.id.btn_next_editt);

        txtComent = findViewById(R.id.idTxtComentSTAB_editt);
        txtNameOfMant = findViewById(R.id.idTxtNameOfMantSTAB_editt);
        txtFreqPM = findViewById(R.id.idTxtFreqSTAB_editt);
        txtCapacity = findViewById(R.id.idTxtCapGen_editt);
    }
}