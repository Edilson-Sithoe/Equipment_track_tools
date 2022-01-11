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

public class Update_electricity extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private EditText txtOther, txtComPoSrc, txtElectUsaLast, txtCostOrElect, txtCommSecPowrSrc;
    private RadioButton rbGrid, rbGene, rbSolar, rbOther;
    private RadioButton rbSixM, rbTwooH, rbProlTwooM, rbWeekOut, rbDaily_out;
    private RadioButton rbBetwAndYes, rbThWeek, rbThMonth, rbThisYear;
    private RadioButton rbLessMin, rbFewMin, rbLessHour, rbBOneEigtHour, rbDays;
    private RadioButton rbYes, rbNo, rbDonKnow;
    private RadioButton rbNoGen, rbGener, rbSolaPa,rbOtherGene;
    private RadioButton rbYesPoSource, rbNoPoSource;
    private RadioButton rbICU, rbOT, rbER;
    private RadioButton rbDang, rbPoor, rbAdequa, rbGood;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_cond_elect;
    private String cbo_power_source;
    private String cbo_sec_po_source;
    private String cbo_sec_src_elect;
    private String cbo_sched_po_out;
    private String cbo_duration;
    private String cbo_last_p_out;
    private String cbo_get_po_out;
    private String cbo_src_po_elecrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_electricity);

        IniciarComponentes_update();
        setRBPowerOut();
        getAndSetIntentData();
        setRBSrcPower();
        setRBLastPowerOut();
        setRBDuraPOut();
        setRBShePOut();
        setSec_src_elect();
        setSec_po_source();
        setRBPower_source();
        setCond_elect();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_electricity.this, Update_identi_health_facil.class);
                startActivity(i);
            }
        });

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String natioEDM = cbo_src_po_elecrt;
                String powerOut = cbo_get_po_out;
                String lat_po_out = cbo_last_p_out;
                String durationOut = cbo_duration;
                String shedule = cbo_sched_po_out;
                String secondSour = cbo_sec_src_elect;
                String powerSrcProv = cbo_sec_po_source;
                String recPowSrc = cbo_power_source;
                String other = txtOther.getText().toString();
                String comm = txtCommSecPowrSrc.getText().toString();
                String elect_usage = txtElectUsaLast.getText().toString();
                String cost = txtCostOrElect.getText().toString();
                String cond_ele = cbo_cond_elect;
                String comments = txtComPoSrc.getText().toString();

                if (rbGrid.isChecked())
                    Variaveis.assessment_model.setChk_main_src_power_electricity("National Grid (EDM)");
                else if (rbGene.isChecked())
                    Variaveis.assessment_model.setChk_main_src_power_electricity("Generator");
                else if (rbSolar.isChecked())
                    Variaveis.assessment_model.setChk_main_src_power_electricity("Solar System");
                else if (rbOther.isChecked())
                    Variaveis.assessment_model.setChk_main_src_power_electricity("Other");

                if (rbGrid.isChecked())
                    Variaveis.assessment_model.setChk_often_power_outage("National Grid (EDM)");
                else if (rbGene.isChecked())
                    Variaveis.assessment_model.setChk_often_power_outage("Generator");
                else if (rbSolar.isChecked())
                    Variaveis.assessment_model.setChk_often_power_outage("Solar System");
                else if (rbOther.isChecked())
                    Variaveis.assessment_model.setChk_often_power_outage("Other");

                if (rbBetwAndYes.isChecked())
                    Variaveis.assessment_model.setChk_last_power_outage("Between today and yesterday");
                else if (rbThWeek.isChecked())
                    Variaveis.assessment_model.setChk_last_power_outage("This week");
                else if (rbThMonth.isChecked())
                    Variaveis.assessment_model.setChk_last_power_outage("This month");
                else if (rbThisYear.isChecked())
                    Variaveis.assessment_model.setChk_last_power_outage("This year");

                if (rbLessMin.isChecked())
                    Variaveis.assessment_model.setChk_duration_typical_power_outage("Less than a minute");
                else if (rbFewMin.isChecked())
                    Variaveis.assessment_model.setChk_duration_typical_power_outage("Few minutes");
                else if (rbLessHour.isChecked())
                    Variaveis.assessment_model.setChk_duration_typical_power_outage("Less than an hour");
                else if (rbBOneEigtHour.isChecked())
                    Variaveis.assessment_model.setChk_duration_typical_power_outage("Between 1-8 hour");
                else if (rbDays.isChecked())
                    Variaveis.assessment_model.setChk_duration_typical_power_outage("Days");

                if (rbYes.isChecked())
                    Variaveis.assessment_model.setChk_schedule_power_outage("Yes");
                else if (rbNo.isChecked())
                    Variaveis.assessment_model.setChk_schedule_power_outage("No");
                else if (rbDonKnow.isChecked())
                    Variaveis.assessment_model.setChk_schedule_power_outage("Solar System");


                if (rbNoGen.isChecked())
                    Variaveis.assessment_model.setChk_secondary_src_electricty("No");
                else if (rbGener.isChecked())
                    Variaveis.assessment_model.setChk_secondary_src_electricty("Generator");
                else if (rbSolaPa.isChecked())
                    Variaveis.assessment_model.setChk_secondary_src_electricty("Solar Panel");
                else if (rbOtherGene.isChecked())
                    Variaveis.assessment_model.setChk_secondary_src_electricty("Other");

                if (rbYesPoSource.isChecked())
                    Variaveis.assessment_model.setChk_secondary_power_src_provide_Pow_entire("Yes");
                else if (rbNoPoSource.isChecked())
                    Variaveis.assessment_model.setChk_secondary_power_src_provide_Pow_entire("No");

                if (rbICU.isChecked())
                    Variaveis.assessment_model.setChk_areas_receive_power("ICU");
                else if (rbOT.isChecked())
                    Variaveis.assessment_model.setChk_areas_receive_power("Operating Theatre");
                else if (rbER.isChecked())
                    Variaveis.assessment_model.setChk_areas_receive_power("Emergency Room");

                if (rbDang.isChecked())
                    Variaveis.assessment_model.setChk_condition_electricity_system("Dangerous");
                else if (rbPoor.isChecked())
                    Variaveis.assessment_model.setChk_condition_electricity_system("Poor");
                else if (rbAdequa.isChecked())
                    Variaveis.assessment_model.setChk_condition_electricity_system("Adequate");
                else if (rbGood.isChecked())
                    Variaveis.assessment_model.setChk_condition_electricity_system("Good");

                if (TextUtils.isEmpty(elect_usage) || TextUtils.isEmpty(cost)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChk_main_src_power_electricity(natioEDM);
                    Assessment.assessment_model.setChk_often_power_outage(powerOut);
                    Assessment.assessment_model.setChk_last_power_outage(durationOut);
                    Assessment.assessment_model.setChk_duration_typical_power_outage(shedule);
                    Assessment.assessment_model.setChk_schedule_power_outage(secondSour);
                    Assessment.assessment_model.setChk_secondary_src_electricty(powerSrcProv);
                    Assessment.assessment_model.setChk_secondary_power_src_provide_Pow_entire(lat_po_out);
                    Assessment.assessment_model.setChk_areas_receive_power(recPowSrc);
                    Assessment.assessment_model.setTxt_other_area_receive_power(txtOther.getText().toString());
                    Assessment.assessment_model.setTxt_comment_power_src(txtCommSecPowrSrc.getText().toString());
                    Assessment.assessment_model.setTxt_electricity_usage_last_month(txtElectUsaLast.getText().toString());
                    Assessment.assessment_model.setTxt_cost_electricity_bill_last_month(txtCostOrElect.getText().toString());
                    Assessment.assessment_model.setChk_condition_electricity_system(cond_ele);
                    Assessment.assessment_model.setTxt_comment_electricity_system(txtComPoSrc.getText().toString());

                    Intent i = new Intent(Update_electricity.this, Update_generator_one.class);
                    startActivity(i);
                }
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtElectUsaLast") && getIntent().hasExtra("txtCostOrElect")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOther.setText(Variaveis.assessment_model.getTxt_other_area_receive_power());
            txtCommSecPowrSrc.setText(Variaveis.assessment_model.getTxt_comment_power_src());
            txtElectUsaLast.setText(Variaveis.assessment_model.getTxt_electricity_usage_last_month());
            txtCostOrElect.setText(Variaveis.assessment_model.getTxt_cost_electricity_bill_last_month());
            txtComPoSrc.setText(Variaveis.assessment_model.getTxt_comment_electricity_system());
        }
    }

    public void setRBSrcPower() {
        rbGrid = findViewById(R.id.chkEDM_upd);
        rbGene = findViewById(R.id.chkGenerator_upd);
        rbSolar = findViewById(R.id.chkSolar_upd);
        rbOther = findViewById(R.id.chkOther_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_main_src_power_electricity())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_main_src_power_electricity().equalsIgnoreCase("National Grid (EDM)")) {
                rbGrid.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_main_src_power_electricity().equalsIgnoreCase("Generator")) {
                rbGene.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_main_src_power_electricity().equalsIgnoreCase("Solar System")) {
                rbSolar.setChecked(true);
            } else {
                rbOther.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEDM_upd:
                if (checked)
                    cbo_src_po_elecrt = "National Grid (EDM)";
                break;
            case R.id.chkGenerator_upd:
                if (checked)
                    cbo_src_po_elecrt = "Generator";
                break;
            case R.id.chkSolar_upd:
                if (checked)
                    cbo_src_po_elecrt = "Solar System";
                break;
            case R.id.chkOther_upd:
                if (checked)
                    cbo_src_po_elecrt = "Other";
                break;
        }
    }

    public void setRBPowerOut() {
        rbSixM = findViewById(R.id.chkOutage_upd);
        rbTwooH = findViewById(R.id.chkOutLesHour_upd);
        rbProlTwooM = findViewById(R.id.chkFrquent_upd);
        rbWeekOut = findViewById(R.id.chkWeekly_upd);
        rbDaily_out = findViewById(R.id.chkDaily_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_often_power_outage())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_often_power_outage().equalsIgnoreCase("No outage in the last 6 months")) {
                rbSixM.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_often_power_outage().equalsIgnoreCase("Outage of less than 2 hours in the last month")) {
                rbTwooH.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_often_power_outage().equalsIgnoreCase("Frequent or prolonged outages of more than 2 hours in the last month")) {
                rbProlTwooM.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_often_power_outage().equalsIgnoreCase("Weekly outages")) {
                rbWeekOut.setChecked(true);
            } else {
                rbDaily_out.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_two_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkOutage_upd:
                if (checked)
                    cbo_get_po_out = "No outage in the last 6 months";
                break;
            case R.id.chkOutLesHour_upd:
                if (checked)
                    cbo_get_po_out = "Outage of less than 2 hours in the last month";
                break;
            case R.id.chkFrquent_upd:
                if (checked)
                    cbo_get_po_out = "Frequent or prolonged outages of more than 2 hours in the last month";
                break;
            case R.id.chkWeekly_upd:
                if (checked)
                    cbo_get_po_out = "Weekly outages";
                break;
            case R.id.chkDaily_upd:
                if (checked)
                    cbo_get_po_out = "Daily outage";
                break;
        }
    }

    public void setRBLastPowerOut() {
        rbBetwAndYes = findViewById(R.id.chkBToYes_upd);
        rbThWeek = findViewById(R.id.chkThWeek_upd);
        rbThMonth = findViewById(R.id.chkThMonth_upd);
        rbThisYear = findViewById(R.id.chkThYear_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_last_power_outage())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_last_power_outage().equalsIgnoreCase("Between today and yesterday")) {
                rbBetwAndYes.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_last_power_outage().equalsIgnoreCase("This week")) {
                rbThWeek.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_last_power_outage().equalsIgnoreCase("This month")) {
                rbThMonth.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_last_power_outage().equalsIgnoreCase("This year")) {
                rbThisYear.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_three_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkBToYes_upd:
                if (checked)
                    cbo_last_p_out = "Between today and yesterday";
                break;
            case R.id.chkThWeek_upd:
                if (checked)
                    cbo_last_p_out = "This week";
                break;
            case R.id.chkThMonth_upd:
                if (checked)
                    cbo_last_p_out = "This month";
                break;
            case R.id.chkThYear_upd:
                if (checked)
                    cbo_last_p_out = "This year";
                break;
        }
    }

    public void setRBDuraPOut() {
        rbLessMin = findViewById(R.id.chkLesThanMin_upd);
        rbFewMin = findViewById(R.id.chkFewMinute_upd);
        rbLessHour = findViewById(R.id.chkLessThanH_upd);
        rbBOneEigtHour = findViewById(R.id.chkBetweeOneEi_upd);
        rbDays = findViewById(R.id.chkDay_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_duration_typical_power_outage())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_duration_typical_power_outage().equalsIgnoreCase("Less than a minute")) {
                rbLessMin.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_duration_typical_power_outage().equalsIgnoreCase("Few minutes")) {
                rbFewMin.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_duration_typical_power_outage().equalsIgnoreCase("Less than an hour")) {
                rbLessHour.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_duration_typical_power_outage().equalsIgnoreCase("Between 1-8 hour")) {
                rbBOneEigtHour.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_duration_typical_power_outage().equalsIgnoreCase("Days")) {
                rbDays.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_four_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLesThanMin_upd:
                if (checked)
                    cbo_duration = "Less than a minute";
                break;
            case R.id.chkFewMinute_upd:
                if (checked)
                    cbo_duration = "Few minutes";
                break;
            case R.id.chkLessThanH_upd:
                if (checked)
                    cbo_duration = "Less than an hour";
                break;
            case R.id.chkBetweeOneEi_upd:
                if (checked)
                    cbo_duration = "Between 1-8 hour";
                break;
            case R.id.chkDay_upd:
                if (checked)
                    cbo_duration = "Days";
                break;
        }
    }

    public void setRBShePOut() {
        rbYes = findViewById(R.id.chkYesOR_upd);
        rbNo = findViewById(R.id.chkNOoR_upd);
        rbDonKnow = findViewById(R.id.chkDontKnow_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_schedule_power_outage())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_schedule_power_outage().equalsIgnoreCase("Yes")) {
                rbYes.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_schedule_power_outage().equalsIgnoreCase("No")) {
                rbNo.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_schedule_power_outage().equalsIgnoreCase("Don't know")) {
                rbDonKnow.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_five_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesOR_upd:
                if (checked)
                    cbo_sched_po_out = "Yes";
                break;
            case R.id.chkNOoR_upd:
                if (checked)
                    cbo_sched_po_out = "No";
                break;
            case R.id.chkDontKnow_upd:
                if (checked)
                    cbo_sched_po_out = "Don't know";
                break;
        }
    }

    public void setSec_src_elect() {
        rbNoGen = findViewById(R.id.chkNo_upd);
        rbGener = findViewById(R.id.chkGeneratorSec_upd);
        rbSolaPa = findViewById(R.id.chkSolPanels_upd);
        rbOtherGene = findViewById(R.id.chkOtherSec_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_secondary_src_electricty())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_secondary_src_electricty().equalsIgnoreCase("No")) {
                rbNoGen.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_secondary_src_electricty().equalsIgnoreCase("Generator")) {
                rbGener.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_secondary_src_electricty().equalsIgnoreCase("Solar Panel")) {
                rbSolaPa.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_secondary_src_electricty().equalsIgnoreCase("Other")) {
                rbOtherGene.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_six_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkNo_upd:
                if (checked)
                    cbo_sec_src_elect = "No";
                break;
            case R.id.chkGeneratorSec_upd:
                if (checked)
                    cbo_sec_src_elect = "Generator";
                break;
            case R.id.chkSolPanels_upd:
                if (checked)
                    cbo_sec_src_elect = "Solar Panel";
                break;
            case R.id.chkOtherSec_upd:
                if (checked)
                    cbo_sec_src_elect = "Other";
                break;
        }
    }

    public void setSec_po_source() {
        rbYesPoSource = findViewById(R.id.chkYesProvPO_upd);
        rbNoPoSource = findViewById(R.id.chkNoProvPO_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_secondary_power_src_provide_Pow_entire())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_secondary_power_src_provide_Pow_entire().equalsIgnoreCase("Yes")) {
                rbYesPoSource.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_secondary_power_src_provide_Pow_entire().equalsIgnoreCase("No")) {
                rbNoPoSource.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_seven_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesProvPO_upd:
                if (checked)
                    cbo_sec_po_source = "Yes";
                break;
            case R.id.chkNoProvPO_upd:
                if (checked)
                    cbo_sec_po_source = "No";
                break;
        }
    }

    public void setRBPower_source() {
        rbICU = findViewById(R.id.chkICU_upd);
        rbOT = findViewById(R.id.chkOpTheatre_upd);
        rbER = findViewById(R.id.chkByEmrgeRoom_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_areas_receive_power())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_areas_receive_power().equalsIgnoreCase("ICU")) {
                rbICU.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_areas_receive_power().equalsIgnoreCase("Operating Theatre")) {
                rbOT.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_areas_receive_power().equalsIgnoreCase("Emergency Room")) {
                rbER.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_eight_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkICU_upd:
                if (checked)
                    cbo_power_source = "ICU";
                break;
            case R.id.chkOpTheatre_upd:
                if (checked)
                    cbo_power_source = "Operating Theatre";
                break;
            case R.id.chkByEmrgeRoom_upd:
                if (checked)
                    cbo_power_source = "Emergency Room";
                break;
        }
    }

    public void setCond_elect() {
        rbDang = findViewById(R.id.chkDanger_upd);
        rbPoor = findViewById(R.id.chkPoor_upd);
        rbAdequa = findViewById(R.id.chkAdequate_upd);
        rbGood = findViewById(R.id.chkGood_upd);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_condition_electricity_system())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_condition_electricity_system().equalsIgnoreCase("Dangerous")) {
                rbDang.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_condition_electricity_system().equalsIgnoreCase("Poor")) {
                rbPoor.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_condition_electricity_system().equalsIgnoreCase("Adequate")) {
                rbAdequa.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_condition_electricity_system().equalsIgnoreCase("Good")) {
                rbGood.setChecked(true);
            }
        }
    }
    public void onRadioButtonClicked_nine_fe_upd(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDanger_upd:
                if (checked)
                    cbo_cond_elect = "Dangerous";
                break;
            case R.id.chkPoor_upd:
                if (checked)
                    cbo_cond_elect = "Poor";
                break;
            case R.id.chkAdequate_upd:
                if (checked)
                    cbo_cond_elect = "Adequate";
                break;
            case R.id.chkGood_upd:
                if (checked)
                    cbo_cond_elect = "Good";
                break;
        }
    }

    public void IniciarComponentes_update() {
        btnBack = findViewById(R.id.btn_back_upd);
        btnNExt = findViewById(R.id.btn_nextI_upd);

        txtCommSecPowrSrc = findViewById(R.id.idComPoSrc_upd);

        txtOther = findViewById(R.id.id_other_upd);
        txtComPoSrc = findViewById(R.id.idComPoSrc_upd);
        txtElectUsaLast = findViewById(R.id.idElectUsaLast_upd);
        txtCostOrElect = findViewById(R.id.idCostOrElect_upd);
    }


}