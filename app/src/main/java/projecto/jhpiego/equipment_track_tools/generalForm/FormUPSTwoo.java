package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

public class FormUPSTwoo extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtOtherUPS, txtCapacityUPS, txtFreqPMUPS, txtNameOfMantUPS, txtComentUPS;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW, cboMain_gen_pmcm, cboMain_gen_lb, cboMain_gene_pm;
    private String cboMain_supp, cboMain_gen_fuel;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ups_twoo);

        IniciarComponentes();

        getAndSetIntentData();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sup_upss_twoo = cboMain_gen_hf;
                String prov_ups_twoo = cboMain_supp;
                String txtOther_ups_twoo = txtOtherUPS.getText().toString();
                String oldSys_ups_twoo = cboMain_old;
                String working_ups_twoo = cboMain_gen_work;
                String condEquip_ups_twoo = cboMain_gen_cond;
                String capacity_ups_twoo = txtCapacityUPS.getText().toString();
                String pmp_ups_twoo = cboMain_gene_pm;
                String carrie_by_ups_twoo = cboMain_gen_pm;
                String frequency_ups_twoo = txtFreqPMUPS.getText().toString();
                String nameOfMain_ups_twoo = txtNameOfMantUPS.getText().toString();
                String pmcm_ups_twoo = cboMain_gen_pmcm;
                String logbook_ups_twoo = cboMain_gen_lb;
                String comments_ups_twoo = txtComentUPS.getText().toString();

                if (TextUtils.isEmpty(capacity_ups_twoo) || TextUtils.isEmpty(nameOfMain_ups_twoo) || TextUtils.isEmpty(frequency_ups_twoo)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkSupUPSSTwhoo(sup_upss_twoo);
                    Assessment.assessment_model.setChkProvUPTwhooS(prov_ups_twoo);
                    Assessment.assessment_model.setTxtOtherUPSTwhoo(txtOther_ups_twoo);
                    Assessment.assessment_model.setChkOldSystemUPSTwhoo(oldSys_ups_twoo);
                    Assessment.assessment_model.setChkWorkingUPSTwhoo(working_ups_twoo);
                    Assessment.assessment_model.setChkCondEquipmUPSTwhoo(condEquip_ups_twoo);
                    Assessment.assessment_model.setTxtCapacityUPSv(txtCapacityUPS.getText().toString());
                    Assessment.assessment_model.setChkPMPUPSTwhoo(pmp_ups_twoo);
                    Assessment.assessment_model.setChkCarrByUPSTwhoo(carrie_by_ups_twoo);
                    Assessment.assessment_model.setTxtFreqPMUPSTwhoo(txtFreqPMUPS.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantUPSv(txtNameOfMantUPS.getText().toString());
                    Assessment.assessment_model.setChkPMCMUPSTwhoo(pmcm_ups_twoo);
                    Assessment.assessment_model.setChklogbBookUPSTwhoo(logbook_ups_twoo);
                    Assessment.assessment_model.setTxtComentUPSTwhoo(comments_ups_twoo);

                    Intent i = new Intent(FormUPSTwoo.this, FormSolarEnergy.class);
                 //   Intent i = new Intent(FormUPSTwoo.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormUPSTwoo.this, FormUPSOne.class);
                startActivity(i);
            }
        });


    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtNameOfMant")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtCapacityUPS.setText(Variaveis.assessment_model.getTxtCapacityUPS());
            txtFreqPMUPS.setText(Variaveis.assessment_model.getTxtFreqPMUPS());
            txtNameOfMantUPS.setText(Variaveis.assessment_model.getTxtNameOfMantUPS());
            txtComentUPS.setText(Variaveis.assessment_model.getTxtComentUPS());
        }
    }

    public void onRadioButtonClicked_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesUPSTwoo:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoUPSTwoo:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }

    public void onRadioButtonClicked_two_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkWhoHospUPSTwoo:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatreUPSTwoo:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoomUPSTwoo:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLabUPSTwoo:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;
        }
    }

    public void onRadioButtonClicked_three_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessUPSTwoo:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10UPSTwoo:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20UPSTwoo:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20UPSTwoo:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked_four_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkUPSYTwoo:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkUPSNTwoo:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkUPSPartlyTwoo:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkUPSDontNTwoo:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_five_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGIUUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNUPSTwoo:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_six_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMYUPSTwoo:
                if (checked)
                    cboMain_gene_pm = "Yes";
                break;
            case R.id.idChkPMNUPSTwoo:
                if (checked)
                    cboMain_gene_pm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_seven_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMITPHFUPSTwoo:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDIUPSTwoo:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedUPSTwoo:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked_eight_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMCMYUPSTwoo:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNUPSTwoo:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_nine_ups_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLoBYUPSTwoo:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNUPSTwoo:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back);
        btnNExt = findViewById(R.id.btn_next);

        txtOtherUPS = findViewById(R.id.idTxtOtherUPSTwoo);
        txtCapacityUPS = findViewById(R.id.idTxtCapUPSTwoo);

        txtFreqPMUPS = findViewById(R.id.idTxtFreqUPSTwoo);
        txtNameOfMantUPS = findViewById(R.id.idTxtNameOfMantUPSTwoo);

        txtComentUPS = findViewById(R.id.idTxtComentUPSTwoo);
    }

    public void LimparCampos() {
        txtCapacityUPS.setText("");
        txtCapacityUPS.setText("");
        txtFreqPMUPS.setText("");
        txtComentUPS.setText("");
        txtNameOfMantUPS.setText("");
    }
}