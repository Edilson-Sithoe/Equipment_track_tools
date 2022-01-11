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

public class FormElectricity extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtOther, txtComPoSrc, txtElectUsaLast, txtCostOrElect, txtCommSecPowrSrc;
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
        setContentView(R.layout.activity_form_electricity);

     //   getSupportActionBar().hide();
        IniciarComponentes();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormElectricity.this, FormIdentiHeaFacil.class);
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

                if (TextUtils.isEmpty(elect_usage) || TextUtils.isEmpty(cost)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChk_main_src_power_electricity(natioEDM);
                    Assessment.assessment_model.setChk_often_power_outage(powerOut);
                    Assessment.assessment_model.setChk_last_power_outage(lat_po_out);
                    Assessment.assessment_model.setChk_duration_typical_power_outage(durationOut);
                    Assessment.assessment_model.setChk_schedule_power_outage(shedule);
                    Assessment.assessment_model.setChk_secondary_src_electricty(secondSour);
                    Assessment.assessment_model.setChk_secondary_power_src_provide_Pow_entire(powerSrcProv);
                    Assessment.assessment_model.setChk_areas_receive_power(recPowSrc);
                    Assessment.assessment_model.setTxt_other_area_receive_power(txtOther.getText().toString());
                    Assessment.assessment_model.setTxt_comment_power_src(txtCommSecPowrSrc.getText().toString());
                    Assessment.assessment_model.setTxt_electricity_usage_last_month(txtElectUsaLast.getText().toString());
                    Assessment.assessment_model.setTxt_cost_electricity_bill_last_month(txtCostOrElect.getText().toString());
                    Assessment.assessment_model.setChk_condition_electricity_system(cond_ele);
                    Assessment.assessment_model.setTxt_comment_electricity_system(txtComPoSrc.getText().toString());

                    Intent i = new Intent(FormElectricity.this, FormGeneratorOne.class);
                    startActivity(i);
                }
            }
        });


    }


    public void onRadioButtonClicked_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEDM:
                if (checked)
                    cbo_src_po_elecrt = "National Grid (EDM)";
                break;
            case R.id.chkGenerator:
                if (checked)
                    cbo_src_po_elecrt = "Generator";
                break;
            case R.id.chkSolar:
                if (checked)
                    cbo_src_po_elecrt = "Solar System";
                break;
            case R.id.chkOther:
                if (checked)
                    cbo_src_po_elecrt = "Other";
                break;
        }
    }

    public void onRadioButtonClicked_two_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkOutage:
                if (checked)
                    cbo_get_po_out = "No outage in the last 6 months";
                break;
            case R.id.chkOutLesHour:
                if (checked)
                    cbo_get_po_out = "Outage of less than 2 hours in the last month";
                break;
            case R.id.chkFrquent:
                if (checked)
                    cbo_get_po_out = "Frequent or prolonged outages of more than 2 hours in the last month";
                break;
            case R.id.chkWeekly:
                if (checked)
                    cbo_get_po_out = "Weekly outages";
                break;
            case R.id.chkDaily:
                if (checked)
                    cbo_get_po_out = "Daily outage";
                break;
        }
    }

    public void onRadioButtonClicked_three_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkBToYes:
                if (checked)
                    cbo_last_p_out = "Between today and yesterday";
                break;
            case R.id.chkThWeek:
                if (checked)
                    cbo_last_p_out = "This week";
                break;
            case R.id.chkThMonth:
                if (checked)
                    cbo_last_p_out = "This month";
                break;
            case R.id.chkThYear:
                if (checked)
                    cbo_last_p_out = "This year";
                break;
        }
    }

    public void onRadioButtonClicked_four_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLesThanMin:
                if (checked)
                    cbo_duration = "Less than a minute";
                break;
            case R.id.chkFewMinute:
                if (checked)
                    cbo_duration = "Few minutes";
                break;
            case R.id.chkLessThanH:
                if (checked)
                    cbo_duration = "Less than an hour";
                break;
            case R.id.chkBetweeOneEi:
                if (checked)
                    cbo_duration = "Between 1-8 hour";
                break;
            case R.id.chkDay:
                if (checked)
                    cbo_duration = "Days";
                break;
        }
    }

    public void onRadioButtonClicked_five_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesOR:
                if (checked)
                    cbo_sched_po_out = "Yes";
                break;
            case R.id.chkNOoR:
                if (checked)
                    cbo_sched_po_out = "No";
                break;
            case R.id.chkDontKnow:
                if (checked)
                    cbo_sched_po_out = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_six_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkNo:
                if (checked)
                    cbo_sec_src_elect = "No";
                break;
            case R.id.chkGeneratorSec:
                if (checked)
                    cbo_sec_src_elect = "Generator";
                break;
            case R.id.chkSolPanels:
                if (checked)
                    cbo_sec_src_elect = "Solar Panel";
                break;
            case R.id.chkOtherSec:
                if (checked)
                    cbo_sec_src_elect = "Other";
                break;
        }
    }

    public void onRadioButtonClicked_seven_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesProvPO:
                if (checked)
                    cbo_sec_po_source = "Yes";
                break;
            case R.id.chkNoProvPO:
                if (checked)
                    cbo_sec_po_source = "No";
                break;
        }
    }

    public void onRadioButtonClicked_eight_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkICU:
                if (checked)
                    cbo_power_source = "ICU";
                break;
            case R.id.chkOpTheatre:
                if (checked)
                    cbo_power_source = "Operating Theatre";
                break;
            case R.id.chkByEmrgeRoom:
                if (checked)
                    cbo_power_source = "Emergency Room";
                break;
        }
    }

    public void onRadioButtonClicked_nine_fe(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDanger:
                if (checked)
                    cbo_cond_elect = "Dangerous";
                break;
            case R.id.chkPoor:
                if (checked)
                    cbo_cond_elect = "Poor";
                break;
            case R.id.chkAdequate:
                if (checked)
                    cbo_cond_elect = "Adequate";
                break;
            case R.id.chkGood:
                if (checked)
                    cbo_cond_elect = "Good";
                break;
        }
    }


    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back);
        btnNExt = findViewById(R.id.btn_nextI);

        txtCommSecPowrSrc = findViewById(R.id.idComPoSrc);

        txtOther = findViewById(R.id.id_other);
        txtComPoSrc = findViewById(R.id.idComPoSrc);
        txtElectUsaLast = findViewById(R.id.idElectUsaLast);
        txtCostOrElect = findViewById(R.id.idCostOrElect);
    }

    public void LimparCampos() {
        txtOther.setText("");
        txtComPoSrc.setText("");
        txtElectUsaLast.setText("");
        txtCostOrElect.setText("");
    }
}