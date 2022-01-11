package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormStabilizer;
import projecto.jhpiego.equipment_track_tools.generalForm.FormUPSOne;
import projecto.jhpiego.equipment_track_tools.generalForm.FormUPSTwoo;
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

public class Update_form_ups extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtOtherUPS, txtCapacityUPS, txtFreqPMUPS, txtNameOfMantUPS, txtComentUPS;
    private RadioButton idChkYesSTAB_editt, idChkNoSTAB_editt;
    private RadioButton rbWHosp, rbOpenT, rbEmerRoom, rbLabor;
    private RadioButton rbLess, rbBetwee, rbBetween, rbMore;
    private RadioButton rbYesGenWork, rbNoGenWork, rbParlGenWork, rbDontGenWork;
    private RadioButton idChkGIU_upd, idChkGBNU_upd, idChkIU_BNR_upd, idChkIUNNTR_upd, idchkOOSBR_upd, idChkOOSAndNR_upd, idChkStilInstPha_upd, idChkDontN_upd;
    private RadioButton idChkPMY_upd, idChkPMNUPS;
    private RadioButton idChkPMITPHF_upd, idChkPMPDI_upd, idChkSubcontracted_upd;
    private RadioButton idChkPMCMY_upd, idChkPMCMN_upd;
    private RadioButton idChkLoBY_upd, idChkLoBN_upd;
    private RadioButton idChkPMYUPS, radioButton;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW, cboMain_gen_pmcm, cboMain_gen_lb, cboMain_gene_pm;
    private String cboMain_supp, cboMain_gen_fuel;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form_ups);

        IniciarComponentes();

        getAndSetIntentData();


        setRBMain_supp();
        setRBMain_old();
        setRBMain_gen_work();
        setRBDuraPOut();
        setRBMain_gen_hfSTAB();
        setRBMain_gen_fuel();

        setRBMain_gen_pm();
        setRBMain_gen_pmcm();
        setRBMain_gen_lb();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sup_upss = cboMain_gen_hf;
                String prov_ups = cboMain_supp;
                String txtOther_ups = txtOtherUPS.getText().toString();
                String oldSys_ups = cboMain_old;
                String working_ups = cboMain_gen_work;
                String condEquip_ups = cboMain_gen_cond;
                String capacity_ups = txtCapacityUPS.getText().toString();
                String pmp_ups = cboMain_gene_pm;
                String carrie_by_ups = cboMain_gen_pm;
                String frequency_ups = txtFreqPMUPS.getText().toString();
                String nameOfMain_ups = txtNameOfMantUPS.getText().toString();
                String pmcm_ups = cboMain_gen_pmcm;
                String logbook_ups = cboMain_gen_lb;
                String comments_ups = txtComentUPS.getText().toString();

                if (idChkYesSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkSupUPSS("Yes");
                else if (idChkNoSTAB_editt.isChecked())
                    Variaveis.assessment_model.setChkSupUPSS("No");

                if (rbWHosp.isChecked())
                    Variaveis.assessment_model.setChkProvUPS("The whole hospital");
                else if (rbOpenT.isChecked())
                    Variaveis.assessment_model.setChkProvUPS("Operating theatre");
                else if (rbEmerRoom.isChecked())
                    Variaveis.assessment_model.setChkProvUPS("Emergency Room");
                else if (rbLabor.isChecked())
                    Variaveis.assessment_model.setChkProvUPS("Laboratory");

                if (rbLess.isChecked())
                    Variaveis.assessment_model.setChkOldSystemUPS("Less than 3 years");
                else if (rbBetwee.isChecked())
                    Variaveis.assessment_model.setChkOldSystemUPS("Between 3-10 years");
                else if (rbBetween.isChecked())
                    Variaveis.assessment_model.setChkOldSystemUPS("Between 11-20 years");
                else if (rbMore.isChecked())
                    Variaveis.assessment_model.setChkOldSystemUPS("More than 20 years");

                if (rbYesGenWork.isChecked())
                    Variaveis.assessment_model.setChkWorkingUPS("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setChkWorkingUPS("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setChkWorkingUPS("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setChkWorkingUPS("Don't know");

                if (idChkGIU_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Good and in use");
                else if (idChkGBNU_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Good, but not in use");
                else if (idChkIU_BNR_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("In use, but needs repair");
                else if (idChkIUNNTR_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("In use, but needs to be replaced");
                else if (idchkOOSBR_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Out of service, but repairable");
                else if (idChkOOSAndNR_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Out of service and needs to be replaced");
                else if (idChkStilInstPha_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Still in the installation phase");
                else if (idChkDontN_upd.isChecked())
                    Variaveis.assessment_model.setChkCondEquipmUPS("Don't know");

                if (idChkPMYUPS.isChecked())
                    Variaveis.assessment_model.setChkPMPUPS("Yes");
                else if (idChkPMNUPS.isChecked())
                    Variaveis.assessment_model.setChkPMPUPS("No");

                if (idChkPMITPHF_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByUPS("Internal Technical Personnel of the Health Facility");
                else if (idChkPMPDI_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByUPS("Personnel from the Department of Infrastructure");
                else if (idChkSubcontracted_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByUPS("Subcontracted");

                if (idChkPMCMY_upd.isChecked())
                    Variaveis.assessment_model.setChkPMCMUPS("Yes");
                else if (idChkPMCMN_upd.isChecked())
                    Variaveis.assessment_model.setChkPMCMUPS("No");

                if (idChkLoBY_upd.isChecked())
                    Variaveis.assessment_model.setChklogbBookUPS("Yes");
                else if (idChkLoBN_upd.isChecked())
                    Variaveis.assessment_model.setChklogbBookUPS("No");

                if (TextUtils.isEmpty(capacity_ups) || TextUtils.isEmpty(nameOfMain_ups) || TextUtils.isEmpty(frequency_ups)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkSupUPSS(sup_upss);
                    Assessment.assessment_model.setChkProvUPS(prov_ups);
                    Assessment.assessment_model.setTxtOtherUPS(txtOther_ups);
                    Assessment.assessment_model.setChkOldSystemUPS(oldSys_ups);
                    Assessment.assessment_model.setChkWorkingUPS(working_ups);
                    Assessment.assessment_model.setChkCondEquipmUPS(condEquip_ups);
                    Assessment.assessment_model.setTxtCapacityUPS(txtCapacityUPS.getText().toString());
                    Assessment.assessment_model.setChkPMPUPS(pmp_ups);
                    Assessment.assessment_model.setChkCarrByUPS(carrie_by_ups);
                    Assessment.assessment_model.setTxtFreqPMUPS(txtFreqPMUPS.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantUPS(txtNameOfMantUPS.getText().toString());
                    Assessment.assessment_model.setChkPMCMUPS(pmcm_ups);
                    Assessment.assessment_model.setChklogbBookUPS(logbook_ups);
                    Assessment.assessment_model.setTxtComentUPS(comments_ups);

                    Intent i = new Intent(Update_form_ups.this, Update_form_ups_twoo.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_form_ups.this, Update_stabilizer.class);
                startActivity(i);
            }
        });
    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtNameOfMantUPS")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOtherUPS.setText(Variaveis.assessment_model.getTxtOtherUPS());
            txtCapacityUPS.setText(Variaveis.assessment_model.getTxtCapacityUPS());
            txtFreqPMUPS.setText(Variaveis.assessment_model.getTxtFreqPMUPS());
            txtNameOfMantUPS.setText(Variaveis.assessment_model.getTxtNameOfMantUPS());
            txtComentUPS.setText(Variaveis.assessment_model.getTxtComentUPS());
        }
    }

    public void setRBMain_gen_hfSTAB() {
        idChkYesSTAB_editt = findViewById(R.id.idChkYesUPS);
        idChkNoSTAB_editt = findViewById(R.id.idChkNoUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkSupUPSS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkSupUPSS().equalsIgnoreCase("Yes")) {
                idChkYesSTAB_editt.setChecked(true);
            } else if (Variaveis.assessment_model.getChkSupUPSS().equalsIgnoreCase("No")) {
                idChkNoSTAB_editt.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesUPS:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoUPS:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
        }
    }

    public void setRBMain_supp() {
        rbWHosp = findViewById(R.id.idChkWhoHospUPS);
        rbOpenT = findViewById(R.id.idChkOpTheatreUPS);
        rbEmerRoom = findViewById(R.id.idChkEmergRoomUPS);
        rbLabor = findViewById(R.id.idChkLabUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkProvUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkProvUPS().equalsIgnoreCase("The whole hospital")) {
                rbWHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkProvUPS().equalsIgnoreCase("Operating theatre")) {
                rbOpenT.setChecked(true);
            } else if (Variaveis.assessment_model.getChkProvUPS().equalsIgnoreCase("Emergency Room")) {
                rbEmerRoom.setChecked(true);
            } else {
                rbLabor.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_two_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkWhoHospUPS:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatreUPS:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoomUPS:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLabUPS:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;
        }
    }

    public void setRBMain_old() {
        rbLess = findViewById(R.id.idChkLessUPS);
        rbBetwee = findViewById(R.id.idChkB3_10UPS);
        rbBetween = findViewById(R.id.idChkB11_20UPS);
        rbMore = findViewById(R.id.idChkMore20UPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkOldSystemUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkOldSystemUPS().equalsIgnoreCase("Less than 3 years")) {
                rbLess.setChecked(true);
            } else if (Variaveis.assessment_model.getChkOldSystemUPS().equalsIgnoreCase("Between 3-10 years")) {
                rbBetwee.setChecked(true);
            } else if (Variaveis.assessment_model.getChkOldSystemUPS().equalsIgnoreCase("Between 11-20 years")) {
                rbBetween.setChecked(true);
            } else if (Variaveis.assessment_model.getChkOldSystemUPS().equalsIgnoreCase("More than 20 years")) {
                rbMore.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_three_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessUPS:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10UPS:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20UPS:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20UPS:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void setRBMain_gen_work() {
        rbYesGenWork = findViewById(R.id.idChkUPSY);
        rbNoGenWork = findViewById(R.id.idChkUPSN);
        rbParlGenWork = findViewById(R.id.idChkUPSDontN);
        rbDontGenWork = findViewById(R.id.idChkUPSDontN);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkWorkingUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkWorkingUPS().equalsIgnoreCase("Yes")) {
                rbYesGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkWorkingUPS().equalsIgnoreCase("No")) {
                rbNoGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkWorkingUPS().equalsIgnoreCase("Partly")) {
                rbParlGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkWorkingUPS().equalsIgnoreCase("Don't know")) {
                rbDontGenWork.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_four_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkUPSY:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkUPSN:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkUPSPartly:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkUPSDontN:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void setRBDuraPOut() {
        idChkGIU_upd = findViewById(R.id.idChkGIUUPS);
        idChkGBNU_upd = findViewById(R.id.idChkGBNUUPS);
        idChkIU_BNR_upd = findViewById(R.id.idChkIU_BNRUPS);
        idChkIUNNTR_upd = findViewById(R.id.idChkIUNNTRUPS);
        idchkOOSBR_upd = findViewById(R.id.idchkOOSBRUPS);
        idChkOOSAndNR_upd = findViewById(R.id.idChkOOSAndNRUPS);
        idChkStilInstPha_upd = findViewById(R.id.idChkStilInstPhaUPS);
        idChkDontN_upd = findViewById(R.id.idChkDontNUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkCondEquipmUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Good and in use")) {
                idChkGIU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Good, but not in use")) {
                idChkGBNU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("In use, but needs repair")) {
                idChkIU_BNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("In use, but needs to be replaced")) {
                idChkIUNNTR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Out of service, but repairable")) {
                idchkOOSBR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Out of service and needs to be replaced")) {
                idChkOOSAndNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Still in the installation phase")) {
                idChkStilInstPha_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCondEquipmUPS().equalsIgnoreCase("Don't know")) {
                idChkDontN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_five_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGIUUPS:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUUPS:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRUPS:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRUPS:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRUPS:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRUPS:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaUPS:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNUPS:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void setRBMain_gen_fuel() {
        idChkPMYUPS = findViewById(R.id.idChkPMYUPS);
        idChkPMYUPS = findViewById(R.id.idChkPMNUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkPMPUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPMPUPS().equalsIgnoreCase("Yes")) {
                idChkPMYUPS.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPMPUPS().equalsIgnoreCase("No")) {
                idChkPMYUPS.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_six_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMYUPS:
                if (checked)
                    cboMain_gene_pm = "Yes";
                break;
            case R.id.idChkPMNUPS:
                if (checked)
                    cboMain_gene_pm = "No";
                break;
        }
    }

    public void setRBMain_gen_pm() {
        idChkPMITPHF_upd = findViewById(R.id.idChkPMITPHFUPS);
        idChkPMPDI_upd = findViewById(R.id.idChkPMPDIUPS);
        idChkSubcontracted_upd = findViewById(R.id.idChkSubcontractedUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkCarrByUPS())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkCarrByUPS().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPMITPHF_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrByUPS().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPMPDI_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrByUPS().equalsIgnoreCase("Subcontracted")) {
                idChkSubcontracted_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_seven_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMITPHFUPS:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDIUPS:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedUPS:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void setRBMain_gen_pmcm() {
        idChkPMCMY_upd = findViewById(R.id.idChkPMCMYUPS);
        idChkPMCMN_upd = findViewById(R.id.idChkPMCMNUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkPMCMUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPMCMUPS().equalsIgnoreCase("Yes")) {
                idChkPMCMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPMCMUPS().equalsIgnoreCase("No")) {
                idChkPMCMN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_eight_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMCMYUPS:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNUPS:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void setRBMain_gen_lb() {
        idChkLoBY_upd = findViewById(R.id.idChkLoBYUPS);
        idChkLoBN_upd = findViewById(R.id.idChkLoBNUPS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChklogbBookUPS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChklogbBookUPS().equalsIgnoreCase("Yes")) {
                idChkLoBY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChklogbBookUPS().equalsIgnoreCase("No")) {
                idChkLoBN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_nine_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLoBYUPS:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNUPS:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back);
        btnNExt = findViewById(R.id.btn_next);

        txtOtherUPS = findViewById(R.id.idTxtOtherUPS);
        txtCapacityUPS = findViewById(R.id.idTxtCapUPS);
        txtFreqPMUPS = findViewById(R.id.idTxtFreqUPS);
        txtNameOfMantUPS = findViewById(R.id.idTxtNameOfMantUPS);
        txtComentUPS = findViewById(R.id.idTxtComentUPS);
    }

}