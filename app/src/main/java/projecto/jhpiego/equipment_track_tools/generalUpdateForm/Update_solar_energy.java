package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormOxigenSystem;
import projecto.jhpiego.equipment_track_tools.generalForm.FormSolarEnergy;
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

public class Update_solar_energy extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private EditText txtOtherSE, txtCapacitySE, txtFreqPMSE, txtNameOfMantSE, txtComentSE;
    private RadioButton rbYesSolarP, rbNoSolarP, rbDontSolarP;
    private RadioButton rbWHosp, rbOpenT, rbEmerRoom, rbLabor, rbMatern;
    private RadioButton rbLess, rbBetwee, rbBetween, rbMore;
    private RadioButton rbYesGenWork, rbNoGenWork, rbParlGenWork, rbDontGenWork;
    private RadioButton idChkGIU_upd, idChkGBNU_upd, idChkIU_BNR_upd, idChkIUNNTR_upd, idchkOOSBR_upd, idChkOOSAndNR_upd, idChkStilInstPha_upd, idChkDontN_upd;
    private RadioButton rbYesSolarBact, rbNoSolarBact, rbDontSolarBact;
    private RadioButton idChkPMYSE, idChkPMNSE;
    private RadioButton idChkPMITPHF_upd, idChkPMPDI_upd, idChkSubcontracted_upd;
    private RadioButton idChkPMCMY_upd, idChkPMCMN_upd;
    private RadioButton idChkLoBY_upd, idChkLoBN_upd;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_pmcm, cboMain_gen_lb, cboMain_gene_pm, cboMain_bate_install;
    private String cboMain_supp;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_carrie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_solar_energy);

        IniciarComponentes();
        getAndSetItentData();
        setRBSolar();
        setRBMain_supp();
        setRBMain_old_solar();
        setRBMain_gen_work_solar();
        setRBDuraPOut_solar();
        setRBBact_solar();
        setRBMain_gen_hfSTAB_solar();
        setRBMain_gen_pm_solar();
        setRBMain_pm_solar();
        setRBMain_pmpps_solar();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String solar_power = cboMain_gen_hf;
                String area_provider = cboMain_supp;
                String area_provider_other = txtOtherSE.getText().toString().trim();
                String old_sys_solar = cboMain_old;
                String solar_psy_working = cboMain_gen_work;
                String condition_equipm = cboMain_gen_cond;
                String capacity_solar_power = txtCapacitySE.getText().toString();
                String batteries_installed = cboMain_bate_install;
                String active_pm_solar = cboMain_gen_pm;
                String carries_solar = cboMain_carrie;
                String frequency_pm = txtFreqPMSE.getText().toString();
                String name_main_solar = txtNameOfMantSE.getText().toString();
                String logbook_pm_solar = cboMain_gen_pmcm;
                String logbook_upd_solar = cboMain_gen_lb;
                String comments_solar = txtComentSE.getText().toString();

                if (rbYesSolarP.isChecked())
                    Variaveis.assessment_model.setCboSolarP("Yes");
                else if (rbNoSolarP.isChecked())
                    Variaveis.assessment_model.setCboSolarP("No");
                else if (rbDontSolarP.isChecked())
                    Variaveis.assessment_model.setCboSolarP("Don't know");

                if (rbWHosp.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("The whole hospital");
                else if (rbOpenT.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Operating theatre");
                else if (rbEmerRoom.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Emergency Room");
                else if (rbLabor.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Laboratory");
                else if (rbMatern.isChecked())
                    Variaveis.assessment_model.setCboAreaProv("Maternity");

                if (rbLess.isChecked())
                    Variaveis.assessment_model.setCboOldSysSolar("Less than 3 years");
                else if (rbBetwee.isChecked())
                    Variaveis.assessment_model.setCboOldSysSolar("Between 3-10 years");
                else if (rbBetween.isChecked())
                    Variaveis.assessment_model.setCboOldSysSolar("Between 11-20 years");
                else if (rbMore.isChecked())
                    Variaveis.assessment_model.setCboOldSysSolar("More than 20 years");

                if (rbYesGenWork.isChecked())
                    Variaveis.assessment_model.setCboSolarPSysWorking("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setCboSolarPSysWorking("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setCboSolarPSysWorking("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setCboSolarPSysWorking("Don't know");

                if (idChkGIU_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Good and in use");
                else if (idChkGBNU_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Good, but not in use");
                else if (idChkIU_BNR_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("In use, but needs repair");
                else if (idChkIUNNTR_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("In use, but needs to be replaced");
                else if (idchkOOSBR_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Out of service, but repairable");
                else if (idChkOOSAndNR_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Out of service and needs to be replaced");
                else if (idChkStilInstPha_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Still in the installation phase");
                else if (idChkDontN_upd.isChecked())
                    Variaveis.assessment_model.setCboConditionEquipmSolar("Don't know");

                if (rbYesSolarBact.isChecked())
                    Variaveis.assessment_model.setCbobatterieInstalled("Yes");
                else if (rbNoSolarBact.isChecked())
                    Variaveis.assessment_model.setCbobatterieInstalled("No");
                else if (rbDontSolarBact.isChecked())
                    Variaveis.assessment_model.setCbobatterieInstalled("Don't know");

                if (idChkPMYSE.isChecked())
                    Variaveis.assessment_model.setCboActivePM_solar("Yes");
                else if (idChkPMNSE.isChecked())
                    Variaveis.assessment_model.setCboActivePM_solar("No");

                if (idChkPMITPHF_upd.isChecked())
                    Variaveis.assessment_model.setCboCarriesSolarBy("Internal Technical Personnel of the Health Facility");
                else if (idChkPMPDI_upd.isChecked())
                    Variaveis.assessment_model.setCboCarriesSolarBy("Personnel from the Department of Infrastructure");
                else if (idChkSubcontracted_upd.isChecked())
                    Variaveis.assessment_model.setCboCarriesSolarBy("Subcontracted");

                if (idChkPMCMY_upd.isChecked())
                    Variaveis.assessment_model.setCboLogbbook_pmSolar("Yes");
                else if (idChkPMCMN_upd.isChecked())
                    Variaveis.assessment_model.setCboLogbbook_pmSolar("No");

                if (idChkLoBY_upd.isChecked())
                    Variaveis.assessment_model.setCboLogbbook_updateSolar("Yes");
                else if (idChkLoBN_upd.isChecked())
                    Variaveis.assessment_model.setCboLogbbook_updateSolar("No");

                if (TextUtils.isEmpty(frequency_pm) || TextUtils.isEmpty(name_main_solar)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setCboSolarP(solar_power);
                    Assessment.assessment_model.setCboAreaProv(area_provider);
                    Assessment.assessment_model.setTxtAreaProvOther(area_provider_other);
                    Assessment.assessment_model.setCboOldSysSolar(old_sys_solar);
                    Assessment.assessment_model.setCboSolarPSysWorking(solar_psy_working);
                    Assessment.assessment_model.setCboConditionEquipmSolar(condition_equipm);
                    Assessment.assessment_model.setTxtCapacitySolarPower(capacity_solar_power);
                    Assessment.assessment_model.setCbobatterieInstalled(batteries_installed);
                    Assessment.assessment_model.setCboActivePM_solar(active_pm_solar);
                    Assessment.assessment_model.setCboCarriesSolarBy(carries_solar);
                    Assessment.assessment_model.setTxtFrequencyPM(frequency_pm);
                    Assessment.assessment_model.setTxtNameMainSolar(name_main_solar);
                    Assessment.assessment_model.setCboLogbbook_pmSolar(logbook_pm_solar);
                    Assessment.assessment_model.setCboLogbbook_updateSolar(logbook_upd_solar);
                    Assessment.assessment_model.setTxtCommentsSolar(comments_solar);

                    Intent i = new Intent(Update_solar_energy.this, Update_oxigen_system.class);
                    //  Intent i = new Intent(FormSolarEnergy.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Update_solar_energy.this, Update_form_ups_twoo.class);
                startActivity(back);
            }
        });
    }


    private void getAndSetItentData() {
        if (getIntent().hasExtra("txtOtherSE")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOtherSE.setText(Variaveis.assessment_model.getTxtAreaProvOther());
            txtCapacitySE.setText(Variaveis.assessment_model.getTxtCapacitySolarPower());
            txtFreqPMSE.setText(Variaveis.assessment_model.getTxtFrequencyPM());
            txtNameOfMantSE.setText(Variaveis.assessment_model.getTxtNameMainSolar());
            txtComentSE.setText(Variaveis.assessment_model.getTxtCommentsSolar());
        }
    }

    public void setRBSolar() {
        rbYesSolarP = findViewById(R.id.idChkYesSE_sol_upd);
        rbNoSolarP = findViewById(R.id.idChkNoSE_sol_upd);
        rbDontSolarP = findViewById(R.id.IdChkDontKnowSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboSolarP())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboSolarP().equalsIgnoreCase("Yes")) {
                rbYesSolarP.setChecked(true);
            } else if (Variaveis.assessment_model.getCboSolarP().equalsIgnoreCase("No")) {
                rbNoSolarP.setChecked(true);
            } else if (Variaveis.assessment_model.getCboSolarP().equalsIgnoreCase("Don't know")) {
                rbDontSolarP.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesSE:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoSE:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
            case R.id.IdChkDontKnowSE:
                if (checked)
                    cboMain_gen_hf = "Don't know";
                break;
        }
    }

    public void setRBMain_supp() {
        rbWHosp = findViewById(R.id.idChkWhoHospSE_sol_upd);
        rbOpenT = findViewById(R.id.idChkOpTheatreSE_sol_upd);
        rbEmerRoom = findViewById(R.id.idChkEmergRoomSE_sol_upd);
        rbLabor = findViewById(R.id.idChkLabSE_sol_upd);
        rbMatern = findViewById(R.id.idChkMaternSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboAreaProv())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboAreaProv().equalsIgnoreCase("The whole hospital")) {
                rbWHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getCboAreaProv().equalsIgnoreCase("Operating theatre")) {
                rbOpenT.setChecked(true);
            } else if (Variaveis.assessment_model.getCboAreaProv().equalsIgnoreCase("Emergency Room")) {
                rbEmerRoom.setChecked(true);
            } else if (Variaveis.assessment_model.getCboAreaProv().equalsIgnoreCase("Laboratory")) {
                rbLabor.setChecked(true);
            } else {
                rbMatern.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_two_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkWhoHospSE_sol_upd:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatreSE_sol_upd:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoomSE_sol_upd:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLabSE_sol_upd:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;

            case R.id.idChkMaternSE_sol_upd:
                if (checked)
                    cboMain_supp = "Maternity";
                break;
        }
    }

    public void setRBMain_old_solar() {
        rbLess = findViewById(R.id.idChkLessSE_sol_upd);
        rbBetwee = findViewById(R.id.idChkB3_10SE_sol_upd);
        rbBetween = findViewById(R.id.idChkB11_20SE_sol_upd);
        rbMore = findViewById(R.id.idChkMore20SE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboOldSysSolar())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboOldSysSolar().equalsIgnoreCase("Less than 3 years")) {
                rbLess.setChecked(true);
            } else if (Variaveis.assessment_model.getCboOldSysSolar().equalsIgnoreCase("Between 3-10 years")) {
                rbBetwee.setChecked(true);
            } else if (Variaveis.assessment_model.getCboOldSysSolar().equalsIgnoreCase("Between 11-20 years")) {
                rbBetween.setChecked(true);
            } else if (Variaveis.assessment_model.getCboOldSysSolar().equalsIgnoreCase("More than 20 years")) {
                rbMore.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_three_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessSE_sol_upd:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10SE_sol_upd:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20SE_sol_upd:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20SE_sol_upd:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void setRBMain_gen_work_solar() {
        rbYesGenWork = findViewById(R.id.idChkSEY_sol_upd);
        rbNoGenWork = findViewById(R.id.idChkSEN_sol_upd);
        rbParlGenWork = findViewById(R.id.idChkSEPartly_sol_upd);
        rbDontGenWork = findViewById(R.id.idChkSEDontN_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboSolarPSysWorking())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboSolarPSysWorking().equalsIgnoreCase("Yes")) {
                rbYesGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getCboSolarPSysWorking().equalsIgnoreCase("No")) {
                rbNoGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getCboSolarPSysWorking().equalsIgnoreCase("Partly")) {
                rbParlGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getCboSolarPSysWorking().equalsIgnoreCase("Don't know")) {
                rbDontGenWork.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_four_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkSEY_sol_upd:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkSEN_sol_upd:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkSEPartly_sol_upd:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkSEDontN_sol_upd:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void setRBDuraPOut_solar() {
        idChkGIU_upd = findViewById(R.id.idChkGIUSE_sol_upd);
        idChkGBNU_upd = findViewById(R.id.idChkGBNUSE_sol_upd);
        idChkIU_BNR_upd = findViewById(R.id.idChkIU_BNRSE_sol_upd);
        idChkIUNNTR_upd = findViewById(R.id.idChkIUNNTRSE_sol_upd);
        idchkOOSBR_upd = findViewById(R.id.idchkOOSBRSE_sol_upd);
        idChkOOSAndNR_upd = findViewById(R.id.idChkOOSAndNRSE_sol_upd);
        idChkStilInstPha_upd = findViewById(R.id.idChkStilInstPhaSE_sol_upd);
        idChkDontN_upd = findViewById(R.id.idChkDontNSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboConditionEquipmSolar())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Good and in use")) {
                idChkGIU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Good, but not in use")) {
                idChkGBNU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("In use, but needs repair")) {
                idChkIU_BNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("In use, but needs to be replaced")) {
                idChkIUNNTR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Out of service, but repairable")) {
                idchkOOSBR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Out of service and needs to be replaced")) {
                idChkOOSAndNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Still in the installation phase")) {
                idChkStilInstPha_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboConditionEquipmSolar().equalsIgnoreCase("Don't know")) {
                idChkDontN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_five_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkGIUSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRSE:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNSE_sol_upd:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void setRBBact_solar() {
        rbYesSolarBact = findViewById(R.id.idChkYSE_sol_upd);
        rbNoSolarBact = findViewById(R.id.idChkNSE_sol_upd);
        rbDontSolarBact = findViewById(R.id.idchkDNSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCbobatterieInstalled())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCbobatterieInstalled().equalsIgnoreCase("Yes")) {
                rbYesSolarBact.setChecked(true);
            } else if (Variaveis.assessment_model.getCbobatterieInstalled().equalsIgnoreCase("No")) {
                rbNoSolarBact.setChecked(true);
            } else if (Variaveis.assessment_model.getCbobatterieInstalled().equalsIgnoreCase("Don't know")) {
                rbDontSolarBact.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_six_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYSE_sol_upd:
                if (checked)
                    cboMain_bate_install = "Yes";
                break;
            case R.id.idChkNSE_sol_upd:
                if (checked)
                    cboMain_bate_install = "No";
                break;
            case R.id.idchkDNSE_sol_upd:
                if (checked)
                    cboMain_bate_install = "Don't know";
                break;
        }
    }

    public void setRBMain_gen_hfSTAB_solar() {
        idChkPMYSE = findViewById(R.id.idChkPMYSE_sol_upd);
        idChkPMNSE = findViewById(R.id.idChkPMNSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboActivePM_solar())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboActivePM_solar().equalsIgnoreCase("Yes")) {
                idChkPMYSE.setChecked(true);
            } else if (Variaveis.assessment_model.getCboActivePM_solar().equalsIgnoreCase("No")) {
                idChkPMNSE.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_seven_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMYSE_sol_upd:
                if (checked)
                    cboMain_gen_pm = "Yes";
                break;
            case R.id.idChkPMNSE_sol_upd:
                if (checked)
                    cboMain_gen_pm = "No";
                break;
        }
    }

    public void setRBMain_gen_pm_solar() {
        idChkPMITPHF_upd = findViewById(R.id.idChkPMITPHFSE_sol_upd);
        idChkPMPDI_upd = findViewById(R.id.idChkPMPDISE_sol_upd);
        idChkSubcontracted_upd = findViewById(R.id.idChkSubcontractedSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboCarriesSolarBy())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboCarriesSolarBy().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPMITPHF_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboCarriesSolarBy().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPMPDI_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboCarriesSolarBy().equalsIgnoreCase("Subcontracted")) {
                idChkSubcontracted_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_eight_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMITPHFSE_sol_upd:
                if (checked)
                    cboMain_carrie = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDISE_sol_upd:
                if (checked)
                    cboMain_carrie = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedSE_sol_upd:
                if (checked)
                    cboMain_carrie = "Subcontracted";
                break;
        }
    }

    public void setRBMain_pm_solar() {
        idChkPMCMY_upd = findViewById(R.id.idChkPMCMYSE_sol_upd);
        idChkPMCMN_upd = findViewById(R.id.idChkPMCMNSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboLogbbook_pmSolar())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboLogbbook_pmSolar().equalsIgnoreCase("Yes")) {
                idChkPMCMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboLogbbook_pmSolar().equalsIgnoreCase("No")) {
                idChkPMCMN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_nine_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPMCMYSE_sol_upd:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNSE_sol_upd:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void setRBMain_pmpps_solar() {
        idChkLoBY_upd = findViewById(R.id.idChkLoBYSE_sol_upd);
        idChkLoBN_upd = findViewById(R.id.idChkLoBNSE_sol_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboLogbbook_updateSolar())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboLogbbook_updateSolar().equalsIgnoreCase("Yes")) {
                idChkLoBY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getCboLogbbook_updateSolar().equalsIgnoreCase("No")) {
                idChkLoBN_upd.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_ten_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLoBYSE_sol_upd:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNSE_sol_upd:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_backSE);
        btnNExt = findViewById(R.id.btn_next);

        txtOtherSE = findViewById(R.id.idTxtOtherSE_sol_upd);
        txtCapacitySE = findViewById(R.id.idTxtCapSE_sol_upd);
        txtFreqPMSE = findViewById(R.id.idTxtFreqSE_sol_upd);
        txtNameOfMantSE = findViewById(R.id.idTxtNameOfMantSE_sol_upd);
        txtComentSE = findViewById(R.id.idTxtComentSE_sol_upd);
    }

    public void LimparCampos() {
        txtCapacitySE.setText("");
        txtCapacitySE.setText("");
        txtFreqPMSE.setText("");
        txtComentSE.setText("");
        txtNameOfMantSE.setText("");
        txtOtherSE.setText("");
    }
}