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

public class FormStabilizer extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtComent, txtNameOfMant,txtFreqPM, txtOther, txtCapacity;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW,cboMain_gen_pmcm,cboMain_gen_lb;
    private String cboMain_old,cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_stabilizer);

      //  getSupportActionBar().hide();
        IniciarComponentes();

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

                    Intent i = new Intent(FormStabilizer.this, FormUPSOne.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormStabilizer.this, FormGeneratorFour.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkYesSTAB:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoSTAB:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }

    public void onRadioButtonClicked_two_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLessSis:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10Sis:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20Sis:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20Sis:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }
    public void onRadioButtonClicked_three_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkSTABY:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkSTABN:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkSTABPartly:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkSTABDontN:
                if (checked)
                    cboMain_gen_work = "Don't know";
        }
    }
    public void onRadioButtonClicked_four_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkGIUSTAB:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUSTAB:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRSTAB:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRSTAB:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRSTAB:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRSTAB:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaSTAB:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNSTAB:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_five_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMYSTAB:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkPMNSTAB:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }
    public void onRadioButtonClicked_six_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMITPHFSTAB:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDISTAB:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedSTAB:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }
    public void onRadioButtonClicked_seven_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMCMYSTAB:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNSTAB:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_eight_stab(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLoBYSTAB:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNSTAB:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }


    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backSTAB);
        btnNExt = findViewById(R.id.btn_next);

        txtComent = findViewById(R.id.idTxtComentSTAB);
        txtNameOfMant = findViewById(R.id.idTxtNameOfMantSTAB);
        txtFreqPM = findViewById(R.id.idTxtFreqSTAB);
        txtCapacity = findViewById(R.id.idTxtCapGen);
    }

    public void LimparCampos() {
        txtComent.setText("");
        txtFreqPM.setText("");
        txtNameOfMant.setText("");
        txtCapacity.setText("");
    }
}