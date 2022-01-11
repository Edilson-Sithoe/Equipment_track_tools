package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormElectricity;
import projecto.jhpiego.equipment_track_tools.generalForm.FormGeneratorOne;
import projecto.jhpiego.equipment_track_tools.generalForm.FormGeneratorTwo;
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

public class Update_generator_one extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtComent, txtNameOfMant, txtFreqPM, txtOther, txtCapacity, txtOtherSupp;
    private RadioButton rbYes,rbNo,rbDK;
    private RadioButton rbWHosp,rbOpenT,rbEmerRoom,rbLabor;
    private RadioButton rbLess,rbBetwee,rbBetween,rbMore;
    private RadioButton rbYesGenWork,rbNoGenWork,rbParlGenWork,rbDontGenWork;
    private RadioButton idChkGIU_upd,idChkGBNU_upd,idChkIU_BNR_upd,idChkIUNNTR_upd,idchkOOSBR_upd,idChkOOSAndNR_upd,idChkStilInstPha_upd,idChkDontN_upd;
    private RadioButton rbYesidChkY_upd,rbNoidChkN_upd,rbDKidchkDN_upd;
    private RadioButton idChkATSY_upd,idChkATSN_upd,idChkATSPartly_upd,idChkATDontN_upd;
    private RadioButton idChkFuelY_upd,idChkFuelN_upd;
    private RadioButton idChkPMY_upd,idChkPMN_upd;
    private RadioButton idChkPMITPHF_upd,idChkPMPDI_upd,idChkSubcontracted_upd;
    private RadioButton idChkPMCMY_upd,idChkPMCMN_upd;
    private RadioButton idChkLoBY_upd,idChkLoBN_upd;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW, cboMain_gen_pmcm, cboMain_gen_lb, cboMain_gene_pm;
    private String cboMain_supp, cboMain_gen_fuel;
    private String cboMain_old, cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_generator_one);

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
                    Variaveis.assessment_model.setChkGene("Yes");
                else if (rbNo.isChecked())
                    Variaveis.assessment_model.setChkGene("No");
                else if (rbDK.isChecked())
                    Variaveis.assessment_model.setChkGene("I Don't Know");

                if (rbWHosp.isChecked())
                    Variaveis.assessment_model.setChkSuppElect("The whole hospital");
                else if (rbOpenT.isChecked())
                    Variaveis.assessment_model.setChkSuppElect("Operating theatre");
                else if (rbEmerRoom.isChecked())
                    Variaveis.assessment_model.setChkSuppElect("Emergency Room");
                else if (rbLabor.isChecked())
                    Variaveis.assessment_model.setChkSuppElect("Laboratory");

                if (rbLess.isChecked())
                    Variaveis.assessment_model.setChkHoldSyste("Less than 3 years");
                else if (rbBetwee.isChecked())
                    Variaveis.assessment_model.setChkHoldSyste("Between 3-10 years");
                else if (rbBetween.isChecked())
                    Variaveis.assessment_model.setChkHoldSyste("Between 11-20 years");
                else if (rbMore.isChecked())
                    Variaveis.assessment_model.setChkHoldSyste("More than 20 years");

                if (rbYesGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWork("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWork("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWork("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setChkGenWork("Don't know");

                if (idChkGIU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Good and in use");
                else if (idChkGBNU_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Good, but not in use");
                else if (idChkIU_BNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("In use, but needs repair");
                else if (idChkIUNNTR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("In use, but needs to be replaced");
                else if (idchkOOSBR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Out of service, but repairable");
                else if (idChkOOSAndNR_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Out of service and needs to be replaced");
                else if (idChkStilInstPha_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Still in the installation phase");
                else if (idChkDontN_upd.isChecked())
                    Variaveis.assessment_model.setChkConditionEquip("Don't know");

                if (rbYesidChkY_upd.isChecked())
                    Variaveis.assessment_model.setChkATS("Yes");
                else if (rbNoidChkN_upd.isChecked())
                    Variaveis.assessment_model.setChkATS("No");
                else if (rbDKidchkDN_upd.isChecked())
                    Variaveis.assessment_model.setChkATS("I Don't Know");

                if (idChkATSY_upd.isChecked())
                    Variaveis.assessment_model.setChkATSWorkin("Yes");
                else if (rbNoGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkin("No");
                else if (rbParlGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkin("Partly");
                else if (rbDontGenWork.isChecked())
                    Variaveis.assessment_model.setChkATSWorkin("Don't know");

                if (idChkFuelY_upd.isChecked())
                    Variaveis.assessment_model.setChkFuelToday("Yes");
                else if (idChkFuelN_upd.isChecked())
                    Variaveis.assessment_model.setChkFuelToday("No");

                if (idChkPMY_upd.isChecked())
                    Variaveis.assessment_model.setChkPMProgram("Yes");
                else if (idChkPMN_upd.isChecked())
                    Variaveis.assessment_model.setChkPMProgram("No");

                if (idChkPMITPHF_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrBy("Internal Technical Personnel of the Health Facility");
                else if (idChkPMPDI_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrBy("Personnel from the Department of Infrastructure");
                else if (idChkSubcontracted_upd.isChecked())
                    Variaveis.assessment_model.setChkCarrBy("Subcontracted");

                if (idChkPMCMY_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBook("Yes");
                else if (idChkPMCMN_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBook("No");

                if (idChkLoBY_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBoobUpd("Yes");
                else if (idChkLoBN_upd.isChecked())
                    Variaveis.assessment_model.setChkLogBoobUpd("No");

                if (TextUtils.isEmpty(capacity) || TextUtils.isEmpty(frequ_pm) || TextUtils.isEmpty(name)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkGene(gene);
                    Assessment.assessment_model.setChkSuppElect(suppEl);
                    Assessment.assessment_model.setTxtOtherSuppEle(othSuppEl);
                    Assessment.assessment_model.setChkHoldSyste(hold_sys);
                    Assessment.assessment_model.setChkGenWork(genWork);
                    Assessment.assessment_model.setChkConditionEquip(condEquip);
                    Assessment.assessment_model.setChkATS(ats);
                    Assessment.assessment_model.setChkATSWorkin(atsWor);
                    Assessment.assessment_model.setChkFuelToday(fuelToday);
                    Assessment.assessment_model.setTxtCapacity(txtCapacity.getText().toString());
                    Assessment.assessment_model.setChkPMProgram(pmp_rogram);
                    Assessment.assessment_model.setChkCarrBy(carry_by);
                    Assessment.assessment_model.setTxtFreqPM(txtFreqPM.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMant(txtNameOfMant.getText().toString());
                    Assessment.assessment_model.setChkLogBook(logbook);
                    Assessment.assessment_model.setChkLogBoobUpd(logbookupd);
                    Assessment.assessment_model.setTxtComent(txtComent.getText().toString());

                    Intent i = new Intent(Update_generator_one.this, Update_generator_twoo.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_generator_one.this, Update_electricity.class);
                startActivity(i);
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtCapacity") && getIntent().hasExtra("txtFreqPM")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOtherSupp.setText(Variaveis.assessment_model.getTxtOtherSuppEle());
            txtCapacity.setText(Variaveis.assessment_model.getTxtCapacity());
            txtFreqPM.setText(Variaveis.assessment_model.getTxtFreqPM());
            txtNameOfMant.setText(Variaveis.assessment_model.getTxtNameOfMant());
            txtComent.setText(Variaveis.assessment_model.getTxtComent());
        }
    }

    public void setRBMain_gen_hf() {
        rbYes = findViewById(R.id.idChkYes_upd);
        rbNo = findViewById(R.id.idChkNo_upd);
        rbDK = findViewById(R.id.IdChkDontKnow_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkGene())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkGene().equalsIgnoreCase("Yes")) {
                rbYes.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGene().equalsIgnoreCase("No")) {
                rbNo.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGene().equalsIgnoreCase("I Don't Know")) {
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
        rbOpenT= findViewById(R.id.idChkOpTheatre_upd);
        rbEmerRoom = findViewById(R.id.idChkEmergRoom_upd);
        rbLabor = findViewById(R.id.idChkLab_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkSuppElect())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkSuppElect().equalsIgnoreCase("The whole hospital")) {
                rbWHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkSuppElect().equalsIgnoreCase("Operating theatre")) {
                rbOpenT.setChecked(true);
            } else if (Variaveis.assessment_model.getChkSuppElect().equalsIgnoreCase("Emergency Room")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkHoldSyste())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkHoldSyste().equalsIgnoreCase("Less than 3 years")) {
                rbLess.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSyste().equalsIgnoreCase("Between 3-10 years")) {
                rbBetwee.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSyste().equalsIgnoreCase("Between 11-20 years")) {
                rbBetween.setChecked(true);
            } else if (Variaveis.assessment_model.getChkHoldSyste().equalsIgnoreCase("More than 20 years")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkGenWork())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkGenWork().equalsIgnoreCase("Yes")) {
                rbYesGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWork().equalsIgnoreCase("No")) {
                rbNoGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWork().equalsIgnoreCase("Partly")) {
                rbParlGenWork.setChecked(true);
            } else if (Variaveis.assessment_model.getChkGenWork().equalsIgnoreCase("Don't know")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkConditionEquip())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Good and in use")) {
                idChkGIU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Good, but not in use")) {
                idChkGBNU_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("In use, but needs repair")) {
                idChkIU_BNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("In use, but needs to be replaced")) {
                idChkIUNNTR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Out of service, but repairable")) {
                idchkOOSBR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Out of service and needs to be replaced")) {
                idChkOOSAndNR_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Still in the installation phase")) {
                idChkStilInstPha_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkConditionEquip().equalsIgnoreCase("Don't know")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkATS())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkATS().equalsIgnoreCase("Yes")) {
                rbYesidChkY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATS().equalsIgnoreCase("No")) {
                rbNoidChkN_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATS().equalsIgnoreCase("I Don't Know")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkATSWorkin())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkATSWorkin().equalsIgnoreCase("Yes")) {
                idChkATSY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkin().equalsIgnoreCase("No")) {
                idChkATSN_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkin().equalsIgnoreCase("Partly")) {
                idChkATSPartly_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkATSWorkin().equalsIgnoreCase("Don't know")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkFuelToday())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkFuelToday().equalsIgnoreCase("Yes")) {
                idChkFuelY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkFuelToday().equalsIgnoreCase("No")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkPMProgram())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPMProgram().equalsIgnoreCase("Yes")) {
                idChkPMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPMProgram().equalsIgnoreCase("No")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkCarrBy())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkCarrBy().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                idChkPMITPHF_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrBy().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                idChkPMPDI_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkCarrBy().equalsIgnoreCase("Subcontracted")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkLogBook())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkLogBook().equalsIgnoreCase("Yes")) {
                idChkPMCMY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLogBook().equalsIgnoreCase("No")) {
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

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkFuelToday())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkPMProgram().equalsIgnoreCase("Yes")) {
                idChkLoBY_upd.setChecked(true);
            } else if (Variaveis.assessment_model.getChkPMProgram().equalsIgnoreCase("No")) {
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