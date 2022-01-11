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

public class FormIdentiHeaFacil extends AppCompatActivity {

    private Button btnBack, btnNext;
    private EditText txtHealthID, txtNameHealth, txtLocation, txtDistrict, txtProvince, txtRegion, txtGpsCard, txtMaternity, txtCicov, txtIcu, txtTotal, txtOther;
    private String cboMain_level;
    private String cboMain_avail_fac;
    private String cboMain_outp;
    private String cboMain_typeHeaFac;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_identi_hea_facil);

        //  getSupportActionBar().hide();
        IniciarComponentes();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormIdentiHeaFacil.this, FormIdentiInterView.class);
                startActivity(i);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facilId = txtHealthID.getText().toString();
                String nome = txtNameHealth.getText().toString();
                String location = txtLocation.getText().toString();
                String district = txtDistrict.getText().toString();
                String province = txtProvince.getText().toString();
                String region = txtRegion.getText().toString();
                String gpsCard = txtGpsCard.getText().toString();
                String level = cboMain_level;
                //   String typeHeaFac = cboMain_typeHeaFac;
                String outpatient = cboMain_outp;
                String total = txtTotal.getText().toString();
                String maternity = txtMaternity.getText().toString();
                String cicov = txtCicov.getText().toString();
                String icu = txtIcu.getText().toString();
                String deptAva = cboMain_avail_fac;
                String other = txtOther.getText().toString();

                if (TextUtils.isEmpty(facilId) || TextUtils.isEmpty(nome) || TextUtils.isEmpty(location) || TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(province) || TextUtils.isEmpty(region) || TextUtils.isEmpty(gpsCard) ||
                        TextUtils.isEmpty(total) || TextUtils.isEmpty(maternity) ||
                        TextUtils.isEmpty(cicov) || TextUtils.isEmpty(icu)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTxtHealthFacID(facilId);
                    Assessment.assessment_model.setTxtName(nome);
                    Assessment.assessment_model.setTxtLocation(location);
                    Assessment.assessment_model.setTxtDistrict(district);
                    Assessment.assessment_model.setTxtProvince(province);
                    Assessment.assessment_model.setTxtRegion(region);
                    Assessment.assessment_model.setTxtGpsCardinates(gpsCard);
                    Assessment.assessment_model.setChkLevelHeath(level);
                    //   GeralDAdos.data.setChkTypeHealthFac(typeHeaFac); // chkTypeHealthFac
                    Assessment.assessment_model.setCboOupatient(outpatient);
                    Assessment.assessment_model.setTxtTotal(total);
                    Assessment.assessment_model.setTxtMaternity(maternity);
                    Assessment.assessment_model.setTxtCicov(cicov);
                    Assessment.assessment_model.setTxtIcu(icu);
                    Assessment.assessment_model.setChkDeptAvailable(deptAva);
                    Assessment.assessment_model.setTxtOther(other);

                    Intent iNext = new Intent(FormIdentiHeaFacil.this, FormElectricity.class);
                    startActivity(iNext);
                }
            }
        });
    }

    public void onRadioButtonClicked_fihf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_fl:
                if (checked)
                    cboMain_level = "First level";
                break;
            case R.id.radio_sl:
                if (checked)
                    cboMain_level = "Second Level";
                break;
            case R.id.radio_tl:
                if (checked)
                    cboMain_level = "Third level";
                break;
            case R.id.radio_fol:
                if (checked)
                    cboMain_level = "Fourth level";
                break;
        }
    }

    public void onRadioButtonClicked_two_fihf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkRuralHealthCenter:
                if (checked)
                    //    cboMain_avail_fac = "Rural  health center";
                    //  Toast.makeText(FormIdentiHeaFacil.this, "clicado", Toast.LENGTH_SHORT).show();
                    Assessment.assessment_model.setChkTypeHealthFac("Rural  health center");
                break;
            case R.id.chkUrbanoHealthCenter:
                if (checked)
                    //  cboMain_avail_fac = "Urbano health center";
                    Assessment.assessment_model.setChkTypeHealthFac("Urbano health center");
                break;
            case R.id.chkHealthPost:
                if (checked)
                    //  cboMain_avail_fac = "Health Post(HH)";
                    Assessment.assessment_model.setChkTypeHealthFac("Health Post(HH)");
                break;
            case R.id.chkCentralHospital:
                if (checked)
                    //  cboMain_avail_fac = "Central hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Central hospital(HF)");
                break;
            case R.id.chkSpecializedHospital:
                if (checked)
                    //   cboMain_avail_fac = "Specialized hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("Specialized hospital");
                break;
            case R.id.chkMilitaryHospital:
                if (checked)
                    //  cboMain_avail_fac = "Military hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("Military hospital");
                break;
            case R.id.chkDistrictHospital:
                if (checked)
                    //   cboMain_avail_fac = "District hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("District hospital");
                break;
            case R.id.chkGeneralHospital:
                if (checked)
                    //   cboMain_avail_fac = "General hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("General hospital");
                break;
            case R.id.chkRuralHospital:
                if (checked)
                    //    cboMain_avail_fac = "Rural hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Rural hospital(HF)");
                break;
            case R.id.chkProvincialHospital:
                if (checked)
                    // cboMain_avail_fac = "Provincial hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Provincial hospital(HF)");
                break;
        }
    }

    public void onRadioButtonClicked_three_fihf(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    cboMain_outp = "Yes";
                break;
            case R.id.radio_no:
                if (checked)
                    cboMain_outp = "No";
                break;
        }
    }

    public void onRadioButtonClicked_four_fihf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkOutpatientConsultationsr:
                if (checked)
                    cboMain_avail_fac = "Outpatient Consultations";
                break;
            case R.id.chkCasualtyWard:
                if (checked)
                    cboMain_avail_fac = "Casualty Ward";
                break;
            case R.id.chkMaternityWard:
                if (checked)
                    cboMain_avail_fac = "Maternity Ward";
                break;
            case R.id.chkNurseryWard:
                if (checked)
                    cboMain_avail_fac = "Nursery ward";
                break;
            case R.id.chkPaediatricWard:
                if (checked)
                    cboMain_avail_fac = "Paediatric Ward";
                break;
            case R.id.chkGeneralWard:
                if (checked)
                    cboMain_avail_fac = "General Ward";
                break;
            case R.id.chkSurgicalward:
                if (checked)
                    cboMain_avail_fac = "Surgical Ward";
                break;
            case R.id.chkOperatingTheatre:
                if (checked)
                    cboMain_avail_fac = "Operating Theatre";
                break;
            case R.id.chkIntensiveCare:
                if (checked)
                    cboMain_avail_fac = "Intensive Care(ICU)";
                break;
            case R.id.chkRadiology:
                if (checked)
                    cboMain_avail_fac = "Radiology";
                break;
            case R.id.chkOphthalmology:
                if (checked)
                    cboMain_avail_fac = "Ophthalmology";
                break;
            case R.id.chkCICOV:
                if (checked)
                    cboMain_avail_fac = "CICOV";
                break;
            case R.id.chkLaundry:
                if (checked)
                    cboMain_avail_fac = "Laundry";
                break;
            case R.id.chkKitchen:
                if (checked)
                    cboMain_avail_fac = "Kitchen";
                break;
            case R.id.chkWasteTreatment:
                if (checked)
                    cboMain_avail_fac = "Waste treatment";
                break;
            case R.id.chkMorgue:
                if (checked)
                    cboMain_avail_fac = "Morgue";
                break;
            case R.id.chkPharmacy:
                if (checked)
                    cboMain_avail_fac = "Pharmacy";
                break;
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_nextE);

        txtHealthID = findViewById(R.id.idHealtFacID);
        txtNameHealth = findViewById(R.id.idNameHealt);
        txtLocation = findViewById(R.id.idLocation);
        txtDistrict = findViewById(R.id.idDistrict);
        txtProvince = findViewById(R.id.idProvince);
        txtRegion = findViewById(R.id.idRegion);
        txtGpsCard = findViewById(R.id.idGPS);
        txtMaternity = findViewById(R.id.idMaternity);
        txtCicov = findViewById(R.id.idCICOV);
        txtTotal = findViewById(R.id.idTotal);
        txtIcu = findViewById(R.id.idICU);
        txtOther = findViewById(R.id.idOther);

        txtHealthID.setText(Assessment.assessment_model.getNome() != null ? Assessment.assessment_model.getTxtHealthFacID() : "");
        txtNameHealth.setText(Assessment.assessment_model.getEmail() != null ? Assessment.assessment_model.getEmail() : "");
     /*   txtLocation.setText(GeralDAdos.data.getTelephone()!= null?GeralDAdos.data.getTxtName():"");
        txtDistrict.setText(GeralDAdos.data.getPosition()!= null?GeralDAdos.data.getTxtName():"");
        txtProvince.setText(GeralDAdos.data.getOther()!= null?GeralDAdos.data.getTxtName():"");
        txtRegion.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtGpsCard.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtMaternity.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtCicov.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtTotal.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtIcu.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");
        txtOther.setText(GeralDAdos.data.getOtherTwo()!= null?GeralDAdos.data.getTxtName():"");*/
    }

    public void LimparCampos() {
        txtCicov.setText("");
        txtNameHealth.setText("");
        txtDistrict.setText("");
        txtGpsCard.setText("");
        txtHealthID.setText("");
        txtIcu.setText("");
        txtLocation.setText("");
        txtMaternity.setText("");
        txtProvince.setText("");
        txtRegion.setText("");
        txtTotal.setText("");
    }
}