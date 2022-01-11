package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
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

public class Update_generator_three extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private EditText txtComent, txtNameOfMant, txtFreqPM, txtOther, txtCapacity, txtOtherSupp;
    private RadioButton rbYes, rbNo, rbDK;
    private RadioButton rbWHosp, rbOpenT, rbEmerRoom, rbLabor;
    private RadioButton rbLess, rbBetwee, rbBetween, rbMore;
    private RadioButton rbYesGenWork, rbNoGenWork, rbParlGenWork, rbDontGenWork;
    private RadioButton idChkGIU_upd, idChkGBNU_upd, idChkIU_BNR_upd, idChkIUNNTR_upd, idchkOOSBR_upd, idChkOOSAndNR_upd, idChkStilInstPha_upd, idChkDontN_upd;
    private RadioButton rbYesidChkY_upd, rbNoidChkN_upd, rbDKidchkDN_upd;
    private RadioButton idChkATSY_upd, idChkATSN_upd, idChkATSPartly_upd, idChkATDontN_upd;
    private RadioButton idChkFuelY_upd, idChkFuelN_upd;
    private RadioButton idChkPMY_upd, idChkPMN_upd;
    private RadioButton idChkPMITPHF_upd, idChkPMPDI_upd, idChkSubcontracted_upd;
    private RadioButton idChkPMCMY_upd, idChkPMCMN_upd;
    private RadioButton idChkLoBY_upd, idChkLoBN_upd;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW, cboMain_gen_pmcm, cboMain_gen_lb, cboMain_gene_pm;
    private String cboMain_supp, cboMain_gen_fuel;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_generator_three);
        IniciarComponentes_update();
        getAndSetIntentData();

        setRBMain_gen_hf();
        setRBMain_supp();
        setRBMain_old();
        setRBMain_gen_work();
        setRBDuraPOut();
        setRBMain_gen_ats();
        setRBMain_gen_atsW();
        setRBMain_gen_fuel();
        setRBMain_gene_pm();
        setRBMain_gen_pm();
        setRBMain_gen_pmcm();
        setRBMain_gen_lb();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gene = cboMain_gen_hf;
                String suppEl = cboMain_supp;
                String othSuppEl = txtOtherSupp.getText().toString();
                String hold_sys = cboMain_old;
                String genWork = cboMain_gen_work;
                String condEquip = cboMain_gen_cond;
                String ats = cboMain_gen_ats;
                String atsWor = cboMain_gen_atsW;
                String fuelToday = cboMain_gen_fuel;
                String capacity = txtCapacity.getText().toString();
                String pmp_rogram = cboMain_gene_pm;
                String carry_by = cboMain_gen_pm;
                String frequ_pm = txtFreqPM.getText().toString();
                String name = txtNameOfMant.getText().toString();
                String logbook = cboMain_gen_pmcm;
                String logbookupd = cboMain_gen_lb;
                String comments = txtComent.getText().toString();

                if (rbYes.isChecked())
                    Variaveis.assessment_model.setChkGeneThree("Yes");
                else if (rbNo.isChecked())
                    Variaveis.assessment_model.setChkGeneThree("No");
                else if (rbDK.isChecked())
                    Variaveis.assessment_model.setChkGeneThree("I Don't Know");

                if (rbWHosp.isChecked())
                    Variaveis.assessment_model.setChkSuppElectThree("The whole hospital");
                else if (rbOpenT.isChecked())
                    Variaveis.assessment_model.setChkSuppElectThree("Operating theatre");
                else if (rbEmerRoom.isChecked())
                    Variaveis.assessment_model.setChkSuppElectThree("Emergency Room");
                else if (rbLabor.isChecked())
                    Variaveis.assessment_model.setChkSuppElectThree("Laboratory");

                if (rbLess.isChecked())
                    Variaveis.assessment_model.setChkHoldSysteThree("Less than 3 years");
                else if (rbBetwee.isChecked())
                    Variaveis.assessment_model.setChkHoldSysteThree("Between 3-10 years");
                else if (rbBetween.isChecked())
                    Variaveis.assessment_model.setChkHoldSysteThree("Between 11-20 years");
                else if (rbMore.isChecked())
                    Variaveis.assessment_model.setChkHoldSysteThree("More than 20 years");

                if (rbYesGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWorkThree("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWorkThree("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWorkThree("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWorkThree("Don't know");

                if (idChkGIU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Good and in use");
                else if (idChkGBNU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Good, but not in use");
                else if (idChkIU_BNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("In use, but needs repair");
                else if (idChkIUNNTR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("In use, but needs to be replaced");
                else if (idchkOOSBR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Out of service, but repairable");
                else if (idChkOOSAndNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Out of service and needs to be replaced");
                else if (idChkStilInstPha_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Still in the installation phase");
                else if (idChkDontN_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquipThree("Don't know");

                if (rbYesidChkY_upd.isChecked())
                    Variaveis.assessment_model.setChkATSThree("Yes");
                else if (rbNoidChkN_upd.isChecked())
                    Variaveis.assessment_model.setChkATSThree("No");
                else if (rbDKidchkDN_upd.isChecked())
                    Variaveis.assessment_model.setChkATSThree("I Don't Know");

                if (idChkATSY_upd.isChecked())
                    Variaveis.assessment_model.setChkATSWorkinThree("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkinThree("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkinThree("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkinThree("Don't know");

                if (idChkFuelY_upd.isChecked())
                    Variaveis.assessment_model.setChkFuelTodayThree("Yes");
                else if (idChkFuelN_upd.isChecked())
                    Variaveis.assessment_model.setChkFuelTodayThree("No");

                if (idChkPMY_upd.isChecked())
                    Variaveis.assessment_model.setChkPMProgramThree("Yes");
                else if (idChkPMN_upd.isChecked())
                    Variaveis.assessment_model.setChkPMProgramThree("No");

                if (idChkPMITPHF_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByThree("Internal Technical Personnel of the Health Facility");
                else if (idChkPMPDI_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByThree("Personnel from the Department of Infrastructure");
                else if (idChkSubcontracted_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrByThree("Subcontracted");

                if (idChkPMCMY_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBookv("Yes");
                else if (idChkPMCMN_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBookv("No");

                if (idChkLoBY_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBoobUpdThree("Yes");
                else if (idChkLoBN_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBoobUpdThree("No");

                if (TextUtils.isEmpty(capacity) || TextUtils.isEmpty(frequ_pm) || TextUtils.isEmpty(name)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkGeneThree(gene);
                    Assessment.assessment_model.setChkSuppElectThree(suppEl);
                    Assessment.assessment_model.setTxtOtherSuppEleThree(othSuppEl);
                    Assessment.assessment_model.setChkHoldSysteThree(hold_sys);
                    Assessment.assessment_model.setChkGenWorkThree(genWork);
                    Assessment.assessment_model.setChkConditionEquipThree(condEquip);
                    Assessment.assessment_model.setChkATSThree(ats);
                    Assessment.assessment_model.setChkATSWorkinThree(atsWor);
                    Assessment.assessment_model.setChkFuelTodayThree(fuelToday);
                    Assessment.assessment_model.setTxtCapacityThree(txtCapacity.getText().toString());
                    Assessment.assessment_model.setChkPMProgramThree(pmp_rogram);
                    Assessment.assessment_model.setChkCarrByThree(carry_by);
                    Assessment.assessment_model.setTxtFreqPMThree(txtFreqPM.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantThree(txtNameOfMant.getText().toString());
                    Assessment.assessment_model.setChkLogBookv(logbook);
                    Assessment.assessment_model.setChkLogBoobUpdThree(logbookupd);
                    Assessment.assessment_model.setTxtComent(txtComent.getText().toString());

                    Intent i = new Intent(Update_generator_three.this, Update_generator_four.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_generator_three.this, Update_generator_twoo.class);
                startActivity(i);
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtComment")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOtherSupp.setText(Variaveis.assessment_model.getTxtOtherSuppEleThree());
            txtCapacity.setText(Variaveis.assessment_model.getTxtCapacityThree());
            txtFreqPM.setText(Variaveis.assessment_model.getTxtFreqPMThree());
            txtNameOfMant.setText(Variaveis.assessment_model.getTxtNameOfMantThree());
            txtComent.setText(Variaveis.assessment_model.getTxtComentThree());
        }
    }

    public void setRBMain_gen_hf() {
        rbYes = findViewById(R.id.idChkYes_upd);
        rbNo = findViewById(R.id.idChkNo_upd);
        rbDK = findViewById(R.id.IdChkDontKnow_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkGeneThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkGeneThree().equalsIgnoreCase("Yes")) {
                rbYes.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGeneThree().equalsIgnoreCase("No")) {
                rbNo.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGeneThree().equalsIgnoreCase("I Don't Know")) {
                rbDK.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYes_upd:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNo_upd:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
            case R.id.IdChkDontKnow_upd:
                if (checked)
                    cboMain_gen_hf = "I Don't Know";
                break;
        }
    }

    public void setRBMain_supp() {
        rbWHosp = findViewById(R.id.idChkWhoHosp_upd);
        rbOpenT = findViewById(R.id.idChkOpTheatre_upd);
        rbEmerRoom = findViewById(R.id.idChkEmergRoom_upd);
        rbLabor = findViewById(R.id.idChkLab_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkSuppElectThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkSuppElectThree().equalsIgnoreCase("The whole hospital")) {
                rbWHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkSuppElectThree().equalsIgnoreCase("Operating theatre")) {
                rbOpenT.setChecked(true);
            } else if (Variaveis.assessment_model.getChkSuppElectThree().equalsIgnoreCase("Emergency Room")) {
                rbEmerRoom.setChecked(true);
            } else {
                rbLabor.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_two_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkWhoHosp_upd:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatre_upd:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoom_upd:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLab_upd:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;
        }
    }

    public void setRBMain_old() {
        rbLess = findViewById(R.id.idChkLess_upd);
        rbBetwee = findViewById(R.id.idChkB3_10_upd);
        rbBetween = findViewById(R.id.idChkB11_20_upd);
        rbMore = findViewById(R.id.idChkMore20_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkHoldSysteThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkHoldSysteThree().equalsIgnoreCase("Less than 3 years")) {
                rbLess.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSysteThree().equalsIgnoreCase("Between 3-10 years")) {
                rbBetwee.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSysteThree().equalsIgnoreCase("Between 11-20 years")) {
                rbBetween.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSysteThree().equalsIgnoreCase("More than 20 years")) {
                rbMore.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_three_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLess_upd:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10_upd:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20_upd:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20_upd:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void setRBMain_gen_work() {
        rbYesGenWork = findViewById(R.id.idChkGENY_upd);
        rbNoGenWork = findViewById(R.id.idChkGENN_upd);
        rbParlGenWork = findViewById(R.id.idChkGENPartly_upd);
        rbDontGenWork = findViewById(R.id.idChkGENDontN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkGenWorkThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkGenWorkThree().equalsIgnoreCase("Yes")) {
                rbYesGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWorkThree().equalsIgnoreCase("No")) {
                rbNoGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWorkThree().equalsIgnoreCase("Partly")) {
                rbParlGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWorkThree().equalsIgnoreCase("Don't know")) {
                rbDontGenWork.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_four_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGENY_upd:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkGENN_upd:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkGENPartly_upd:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkGENDontN_upd:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void setRBDuraPOut() {
        idChkGIU_upd = findViewById(R.id.idChkGIU_upd);
        idChkGBNU_upd = findViewById(R.id.idChkGBNU_upd);
        idChkIU_BNR_upd = findViewById(R.id.idChkIU_BNR_upd);
        idChkIUNNTR_upd = findViewById(R.id.idChkIUNNTR_upd);
        idchkOOSBR_upd = findViewById(R.id.idchkOOSBR_upd);
        idChkOOSAndNR_upd = findViewById(R.id.idChkOOSAndNR_upd);
        idChkStilInstPha_upd = findViewById(R.id.idChkStilInstPha_upd);
        idChkDontN_upd = findViewById(R.id.idChkDontN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkConditionEquipThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Good and in use")) {
                idChkGIU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Good, but not in use")) {
                idChkGBNU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("In use, but needs repair")) {
                idChkIU_BNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("In use, but needs to be replaced")) {
                idChkIUNNTR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Out of service, but repairable")) {
                idchkOOSBR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Out of service and needs to be replaced")) {
                idChkOOSAndNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Still in the installation phase")) {
                idChkStilInstPha_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquipThree().equalsIgnoreCase("Don't know")) {
                idChkDontN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_five_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGIU_upd:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNU_upd:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNR_upd:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTR_upd:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBR_upd:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNR_upd:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPha_upd:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontN_upd:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void setRBMain_gen_ats() {
        rbYesidChkY_upd = findViewById(R.id.idChkY_upd);
        rbNoidChkN_upd = findViewById(R.id.idChkN_upd);
        rbDKidchkDN_upd = findViewById(R.id.idchkDN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkATSThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkATSThree().equalsIgnoreCase("Yes")) {
                rbYesidChkY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSThree().equalsIgnoreCase("No")) {
                rbNoidChkN_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSThree().equalsIgnoreCase("I Don't Know")) {
                rbDKidchkDN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_six_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkY_upd:
                if (checked)
                    cboMain_gen_ats = "Yes";
                break;
            case R.id.idChkN_upd:
                if (checked)
                    cboMain_gen_ats = "No";
                break;
            case R.id.idchkDN_upd:
                if (checked)
                    cboMain_gen_ats = "I Don't Know";
                break;
        }
    }

    public void setRBMain_gen_atsW() {
        idChkATSY_upd = findViewById(R.id.idChkATSY_upd);
        idChkATSN_upd = findViewById(R.id.idChkATSN_upd);
        idChkATSPartly_upd = findViewById(R.id.idChkATSPartly_upd);
        idChkATDontN_upd = findViewById(R.id.idChkATDontN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkATSWorkinThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkATSWorkinThree().equalsIgnoreCase("Yes")) {
                idChkATSY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkinThree().equalsIgnoreCase("No")) {
                idChkATSN_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkinThree().equalsIgnoreCase("Partly")) {
                idChkATSPartly_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkinThree().equalsIgnoreCase("Don't know")) {
                idChkATDontN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_seven_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkATSY_upd:
                if (checked)
                    cboMain_gen_atsW = "Yes";
                break;
            case R.id.idChkATSN_upd:
                if (checked)
                    cboMain_gen_atsW = "No";
                break;
            case R.id.idChkATSPartly_upd:
                if (checked)
                    cboMain_gen_atsW = "Partly";
                break;
            case R.id.idChkATDontN_upd:
                if (checked)
                    cboMain_gen_atsW = "I Don't Know";
                break;
        }
    }

    public void setRBMain_gen_fuel() {
        idChkFuelY_upd = findViewById(R.id.idChkFuelY_upd);
        idChkFuelN_upd = findViewById(R.id.idChkFuelN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkFuelTodayThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkFuelTodayThree().equalsIgnoreCase("Yes")) {
                idChkFuelY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkFuelTodayThree().equalsIgnoreCase("No")) {
                idChkFuelN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_eight_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkFuelY_upd:
                if (checked)
                    cboMain_gen_fuel = "Yes";
                break;
            case R.id.idChkFuelN_upd:
                if (checked)
                    cboMain_gen_fuel = "No";
                break;
        }
    }

    public void setRBMain_gene_pm() {
        idChkPMY_upd = findViewById(R.id.idChkPMY_upd);
        idChkPMN_upd = findViewById(R.id.idChkPMN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkPMProgramThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPMProgramThree().equalsIgnoreCase("Yes")) {
                idChkPMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPMProgramThree().equalsIgnoreCase("No")) {
                idChkPMN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_nine_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMY_upd:
                if (checked)
                    cboMain_gene_pm = "Yes";
                break;
            case R.id.idChkPMN_upd:
                if (checked)
                    cboMain_gene_pm = "No";
                break;
        }
    }

    public void setRBMain_gen_pm() {
        idChkPMITPHF_upd = findViewById(R.id.idChkPMITPHF_upd);
        idChkPMPDI_upd = findViewById(R.id.idChkPMPDI_upd);
        idChkSubcontracted_upd = findViewById(R.id.idChkSubcontracted_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkCarrByThree())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkCarrByThree().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPMITPHF_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrByThree().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPMPDI_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrByThree().equalsIgnoreCase("Subcontracted")) {
                idChkSubcontracted_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_ten_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMITPHF_upd:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDI_upd:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontracted_upd:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void setRBMain_gen_pmcm() {
        idChkPMCMY_upd = findViewById(R.id.idChkPMCMY_upd);
        idChkPMCMN_upd = findViewById(R.id.idChkPMCMN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkLogBookv())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkLogBookv().equalsIgnoreCase("Yes")) {
                idChkPMCMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLogBookv().equalsIgnoreCase("No")) {
                idChkPMCMN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_eleven_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMCMY_upd:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMN_upd:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void setRBMain_gen_lb() {
        idChkLoBY_upd = findViewById(R.id.idChkLoBY_upd);
        idChkLoBN_upd = findViewById(R.id.idChkLoBN_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkFuelTodayThree())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkFuelTodayThree().equalsIgnoreCase("Yes")) {
                idChkLoBY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkFuelTodayThree().equalsIgnoreCase("No")) {
                idChkLoBN_upd.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_twelve_go_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLoBY_upd:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBN_upd:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes_update() {
        btnBack = findViewById(R.id.btn_back_upd);
        btnNExt = findViewById(R.id.btn_next_upd);

        txtComent = findViewById(R.id.idTxtComent_upd);
        txtNameOfMant = findViewById(R.id.idTxtNameOfMant_upd);
        txtFreqPM = findViewById(R.id.idTxtFreq_upd);
        txtOther = findViewById(R.id.idTxtOther_upd);
        txtOtherSupp = findViewById(R.id.idTxtOther_upd);
        txtCapacity = findViewById(R.id.idTxtCapGen_upd);
    }
}