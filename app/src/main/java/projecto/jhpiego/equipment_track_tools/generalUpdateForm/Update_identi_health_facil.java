package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.app.ProgressDialog;
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

public class Update_identi_health_facil extends AppCompatActivity {
    private Button btnBack, btnNext;
    private EditText txtHealthFacID, txtName, txtLocation, txtDistrict, txtProvince, txtRegion, txtGpsCardinates;
    private EditText txtTotal, txtMaternity, txtCicov, txtIcu, txtOther;

    private RadioButton rbSim, rbNao, rbLevelOne, rbLevelT, rbLevelTh, rbLevelF;
    private RadioButton rbRCenter, rbUCenter, rbHPost, rbChospital, rbSpecHosp, rbMilitHosp, rbDisctHosp, rbGenHosp, rbRurHosp;
    private RadioButton rbProvHosp, rbOutCons, rbUCasWard, rbMaterWard, rbNursWard, rbPaediatric, rbGeneWard, rbSurgWard, rbOperaTheatre;
    private RadioButton rbInteCare, rbRadiol, rbOphthalm, rbCicov, rbLaundry, rbKitchen, rbWastTreat, rbMorgue, rbPharma;

    private String cboMain_level;
    private String cboMain_avail_fac;
    private String cboMain_outp;
    private String cboMain_typeHeaFac;

    private ProgressDialog load;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    int id;
    private String healthFacID, name, location, district, province, region, gpsCardinates, levelHeath;
    private String typeHealthFac, oupatient, total, maternity, cicov, icu, deptAvailable, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_identi_health_facil);
        IniciarComponentes();
        setRBLvel();
        setRBHCenter();
        setOutPati();
        serDeptAvaila();
        getAndSetItentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(healthFacID);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_identi_health_facil.this, Update_identi_inter_view.class);
                startActivity(i);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facilId = txtHealthFacID.getText().toString();
                String nome = txtName.getText().toString();
                String location = txtLocation.getText().toString();
                String district = txtDistrict.getText().toString();
                String province = txtProvince.getText().toString();
                String region = txtRegion.getText().toString();
                String gpsCard = txtGpsCardinates.getText().toString();
                String level = cboMain_level;
                String outpatient = cboMain_outp;
                String total = txtTotal.getText().toString();
                String maternity = txtMaternity.getText().toString();
                String cicov = txtCicov.getText().toString();
                String icu = txtIcu.getText().toString();
                String deptAva = cboMain_avail_fac;
                String other = txtOther.getText().toString();

                if (rbLevelOne.isChecked())
                    Variaveis.assessment_model.setChkLevelHeath("First level");
                else if (rbLevelT.isChecked())
                    Variaveis.assessment_model.setChkLevelHeath("Second level");
                else if (rbLevelTh.isChecked())
                    Variaveis.assessment_model.setChkLevelHeath("Third level");
                else
                    Variaveis.assessment_model.setChkLevelHeath("Fourth level");


                if (rbRCenter.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Rural  health center");
                else if (rbUCenter.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Urbano health center");
                else if (rbHPost.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Health Post(HH)");
                else if (rbChospital.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Central hospital(HF)");
                else if (rbSpecHosp.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Specialized hospital");
                else if (rbMilitHosp.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Military hospital");
                else if (rbDisctHosp.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("District hospital");
                else if (rbGenHosp.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("General hospital");
                else if (rbRurHosp.isChecked())
                    Variaveis.assessment_model.setChkTypeHealthFac("Rural hospital(HF)");
                else
                    Variaveis.assessment_model.setChkTypeHealthFac("Provincial hospital(HF)");


                if (rbSim.isChecked())
                    Variaveis.assessment_model.setCboOupatient("Yes");
                else
                    Variaveis.assessment_model.setCboOupatient("No");


                if (rbOutCons.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Outpatient Consultations");
                else if (rbUCasWard.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Casualty Wardr");
                else if (rbMaterWard.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Maternity Ward");
                else if (rbNursWard.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Nursery ward");
                else if (rbPaediatric.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Paediatric ward");
                else if (rbGeneWard.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("General Ward");
                else if (rbSurgWard.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Surgical Ward");
                else if (rbOperaTheatre.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Operating Theatre");
                else if (rbInteCare.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Intensive Care(ICU)");
                else if (rbRadiol.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Radiology");
                else if (rbOphthalm.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Ophthalmology");
                else if (rbCicov.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("CICOV");
                else if (rbLaundry.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Laundry");
                else if (rbKitchen.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Kitchen");
                else if (rbWastTreat.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Waste treatment");
                else if (rbMorgue.isChecked())
                    Variaveis.assessment_model.setChkDeptAvailable("Morgue");
                else
                    Variaveis.assessment_model.setChkDeptAvailable("Pharmacy");


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

                    Intent iNext = new Intent(Update_identi_health_facil.this, Update_electricity.class);
                    startActivity(iNext);
                }


            }
        });

    }

    public void setRBLvel() {
        rbLevelOne = findViewById(R.id.radio_fl_edit);
        rbLevelT = findViewById(R.id.radio_sl_edit);
        rbLevelTh = findViewById(R.id.radio_tl_edit);
        rbLevelF = findViewById(R.id.radio_fol_edit);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkLevelHeath())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkLevelHeath().equalsIgnoreCase("First level")) {
                rbLevelOne.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLevelHeath().equalsIgnoreCase("Second level")) {
                rbLevelT.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLevelHeath().equalsIgnoreCase("Third level")) {
                rbLevelTh.setChecked(true);
            } else if (Variaveis.assessment_model.getChkLevelHeath().equalsIgnoreCase("Fourth level")) {
                rbLevelF.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_fihf_edit(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_fl_edit:
                if (checked)
                    cboMain_level = "First level";
                break;
            case R.id.radio_sl_edit:
                if (checked)
                    cboMain_level = "Second Level";
                break;
            case R.id.radio_tl_edit:
                if (checked)
                    cboMain_level = "Third level";
                break;
            case R.id.radio_fol_edit:
                if (checked)
                    cboMain_level = "Fourth level";
                break;
        }
    }

    public void setRBHCenter() {
        rbRCenter = findViewById(R.id.chkRuralHealthCenter_edit);
        rbUCenter = findViewById(R.id.chkUrbanoHealthCenter_edit);
        rbHPost = findViewById(R.id.chkHealthPost_edit);
        rbChospital = findViewById(R.id.chkCentralHospital_edit);
        rbSpecHosp = findViewById(R.id.chkSpecializedHospital_edit);
        rbMilitHosp = findViewById(R.id.chkMilitaryHospital_edit);
        rbDisctHosp = findViewById(R.id.chkDistrictHospital_edit);
        rbGenHosp = findViewById(R.id.chkGeneralHospital_edit);
        rbRurHosp = findViewById(R.id.chkRuralHospital_edit);
        rbProvHosp = findViewById(R.id.chkProvincialHospital_edit);


        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkTypeHealthFac())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Rural health center")) {
                rbRCenter.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Urbano health center")) {
                rbUCenter.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Health Post(HH)")) {
                rbHPost.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Central hospital(HF)")) {
                rbChospital.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Specialized hospital")) {
                rbSpecHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Military hospital")) {
                rbMilitHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("District hospital")) {
                rbDisctHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("General hospital")) {
                rbGenHosp.setChecked(true);
            } else if (Variaveis.assessment_model.getChkTypeHealthFac().equalsIgnoreCase("Rural hospital(HF)")) {
                rbRurHosp.setChecked(true);
            } else {
                rbProvHosp.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_two_fihf_edit(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkRuralHealthCenter_edit:
                if (checked)
                    //    cboMain_avail_fac = "Rural  health center";
                    //  Toast.makeText(FormIdentiHeaFacil.this, "clicado", Toast.LENGTH_SHORT).show();
                    Assessment.assessment_model.setChkTypeHealthFac("Rural health center");
                break;
            case R.id.chkUrbanoHealthCenter_edit:
                if (checked)
                    //  cboMain_avail_fac = "Urbano health center";
                    Assessment.assessment_model.setChkTypeHealthFac("Urbano health center");
                break;
            case R.id.chkHealthPost_edit:
                if (checked)
                    //  cboMain_avail_fac = "Health Post(HH)";
                    Assessment.assessment_model.setChkTypeHealthFac("Health Post(HH)");
                break;
            case R.id.chkCentralHospital_edit:
                if (checked)
                    //  cboMain_avail_fac = "Central hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Central hospital(HF)");
                break;
            case R.id.chkSpecializedHospital_edit:
                if (checked)
                    //   cboMain_avail_fac = "Specialized hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("Specialized hospital");
                break;
            case R.id.chkMilitaryHospital_edit:
                if (checked)
                    //  cboMain_avail_fac = "Military hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("Military hospital");
                break;
            case R.id.chkDistrictHospital_edit:
                if (checked)
                    //   cboMain_avail_fac = "District hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("District hospital");
                break;
            case R.id.chkGeneralHospital_edit:
                if (checked)
                    //   cboMain_avail_fac = "General hospital";
                    Assessment.assessment_model.setChkTypeHealthFac("General hospital");
                break;
            case R.id.chkRuralHospital_edit:
                if (checked)
                    //    cboMain_avail_fac = "Rural hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Rural hospital(HF)");
                break;
            case R.id.chkProvincialHospital_edit:
                if (checked)
                    // cboMain_avail_fac = "Provincial hospital(HF)";
                    Assessment.assessment_model.setChkTypeHealthFac("Provincial hospital(HF)");
                break;
        }
    }

    public void setOutPati() {
        rbSim = findViewById(R.id.radio_yes_edit);
        rbNao = findViewById(R.id.radio_no_edit);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCboOupatient())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCboOupatient().equalsIgnoreCase("Yes")) {
                rbSim.setChecked(true);
            } else {
                rbNao.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_three_fihf_edit(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_yes_edit:
                if (checked)
                    cboMain_outp = "Yes";
                break;
            case R.id.radio_no_edit:
                if (checked)
                    cboMain_outp = "No";
                break;
        }
    }

    public void serDeptAvaila() {
        rbOutCons = findViewById(R.id.chkOutpatientConsultationsr_edit);
        rbUCasWard = findViewById(R.id.chkCasualtyWard_edit);
        rbMaterWard = findViewById(R.id.chkMaternityWard_edit);
        rbNursWard = findViewById(R.id.chkNurseryWard_edit);
        rbPaediatric = findViewById(R.id.chkPaediatricWard_edit);
        rbGeneWard = findViewById(R.id.chkGeneralWard_edit);
        rbSurgWard = findViewById(R.id.chkSurgicalward_edit);
        rbOperaTheatre = findViewById(R.id.chkOperatingTheatre_edit);
        rbInteCare = findViewById(R.id.chkIntensiveCare_edit);
        rbRadiol = findViewById(R.id.chkRadiology_edit);
        rbOphthalm = findViewById(R.id.chkOphthalmology_edit);
        rbCicov = findViewById(R.id.chkCICOV_edit);
        rbLaundry = findViewById(R.id.chkLaundry_edit);
        rbKitchen = findViewById(R.id.chkKitchen_edit);
        rbWastTreat = findViewById(R.id.chkWasteTreatment_edit);
        rbMorgue = findViewById(R.id.chkMorgue_edit);
        rbPharma = findViewById(R.id.chkPharmacy_edit);


        if (TextUtils.isEmpty(Variaveis.assessment_model.getChkDeptAvailable())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Outpatient Consultations")) {
                rbOutCons.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Casualty Ward")) {
                rbUCasWard.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Maternity Ward")) {
                rbMaterWard.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Nursery ward")) {
                rbNursWard.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Paediatric ward")) {
                rbPaediatric.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("General Ward")) {
                rbGeneWard.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Surgical Ward")) {
                rbSurgWard.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Operating Theatre")) {
                rbOperaTheatre.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Intensive Care(ICU)")) {
                rbInteCare.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Radiology")) {
                rbRadiol.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Ophthalmology")) {
                rbOphthalm.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("CICOV")) {
                rbCicov.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Laundry")) {
                rbLaundry.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Kitchen")) {
                rbKitchen.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Waste treatment")) {
                rbWastTreat.setChecked(true);
            } else if (Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Morgue")) {
                rbMorgue.setChecked(true);
            } else if(Variaveis.assessment_model.getChkDeptAvailable().equalsIgnoreCase("Pharmacy")) {
                rbPharma.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_four_fihf_edit(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkOutpatientConsultationsr_edit:
                if (checked)
                    cboMain_avail_fac = "Outpatient Consultations";
                break;
            case R.id.chkCasualtyWard_edit:
                if (checked)
                    cboMain_avail_fac = "Casualty Ward";
                break;
            case R.id.chkMaternityWard_edit:
                if (checked)
                    cboMain_avail_fac = "Maternity Ward";
                break;
            case R.id.chkNurseryWard_edit:
                if (checked)
                    cboMain_avail_fac = "Nursery ward";
                break;
            case R.id.chkPaediatricWard_edit:
                if (checked)
                    cboMain_avail_fac = "Paediatric Ward";
                break;
            case R.id.chkGeneralWard_edit:
                if (checked)
                    cboMain_avail_fac = "General Ward";
                break;
            case R.id.chkSurgicalward_edit:
                if (checked)
                    cboMain_avail_fac = "Surgical Ward";
                break;
            case R.id.chkOperatingTheatre_edit:
                if (checked)
                    cboMain_avail_fac = "Operating Theatre";
                break;
            case R.id.chkIntensiveCare_edit:
                if (checked)
                    cboMain_avail_fac = "Intensive Care(ICU)";
                break;
            case R.id.chkRadiology_edit:
                if (checked)
                    cboMain_avail_fac = "Radiology";
                break;
            case R.id.chkOphthalmology_edit:
                if (checked)
                    cboMain_avail_fac = "Ophthalmology";
                break;
            case R.id.chkCICOV_edit:
                if (checked)
                    cboMain_avail_fac = "CICOV";
                break;
            case R.id.chkLaundry_edit:
                if (checked)
                    cboMain_avail_fac = "Laundry";
                break;
            case R.id.chkKitchen_edit:
                if (checked)
                    cboMain_avail_fac = "Kitchen";
                break;
            case R.id.chkWasteTreatment_edit:
                if (checked)
                    cboMain_avail_fac = "Waste treatment";
                break;
            case R.id.chkMorgue_edit:
                if (checked)
                    cboMain_avail_fac = "Morgue";
                break;
            case R.id.chkPharmacy_edit:
                if (checked)
                    cboMain_avail_fac = "Pharmacy";
                break;
        }
    }

    private void getAndSetItentData() {
        if (getIntent().hasExtra("healthFacID") && getIntent().hasExtra("name") && getIntent().hasExtra("location")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtHealthFacID.setText(Variaveis.assessment_model.getTxtHealthFacID());
            txtName.setText(Variaveis.assessment_model.getTxtName());
            txtLocation.setText(Variaveis.assessment_model.getTxtLocation());
            txtDistrict.setText(Variaveis.assessment_model.getTxtDistrict());
            txtProvince.setText(Variaveis.assessment_model.getTxtProvince());
            txtRegion.setText(Variaveis.assessment_model.getTxtRegion());
            txtGpsCardinates.setText(Variaveis.assessment_model.getTxtGpsCardinates());
            //  chkLevelHeath.setText(Variaveis.assessment_model.getChkLevelHeath());
            //   chkTypeHealthFac.setText(Variaveis.assessment_model.getTxtHealthFacID());
            //   cboOupatient.setText(Variaveis.assessment_model.getTxtHealthFacID());
            txtTotal.setText(Variaveis.assessment_model.getTxtTotal());
            txtMaternity.setText(Variaveis.assessment_model.getTxtMaternity());
            txtCicov.setText(Variaveis.assessment_model.getTxtCicov());
            txtIcu.setText(Variaveis.assessment_model.getTxtIcu());
            //    chkDeptAvailable.setText(Variaveis.assessment_model.getTxtHealthFacID());
            txtOther.setText(Variaveis.assessment_model.getTxtOther());
        }
    }

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back_edit);
        btnNext = findViewById(R.id.btn_nextE_edit);

        txtHealthFacID = findViewById(R.id.idHealtFacID_edit);
        txtName = findViewById(R.id.idNameHealt_edit);
        txtLocation = findViewById(R.id.idLocation_edit);
        txtDistrict = findViewById(R.id.idDistrict_edit);
        txtProvince = findViewById(R.id.idProvince_edit);
        txtRegion = findViewById(R.id.idRegion_edit);
        txtGpsCardinates = findViewById(R.id.idGPS_edit);
        txtMaternity = findViewById(R.id.idMaternity_edit);
        txtCicov = findViewById(R.id.idCICOV_edit);
        txtTotal = findViewById(R.id.idTotal_edit);
        txtIcu = findViewById(R.id.idICU_edit);
        txtOther = findViewById(R.id.idOther_edit);

        txtHealthFacID.setText(Assessment.assessment_model.getNome() != null ? Assessment.assessment_model.getTxtHealthFacID() : "");
     /*   txtNameHealth.setText(GeralDAdos.data.getEmail()!= null?GeralDAdos.data.getTxtName():"");
        txtLocation.setText(GeralDAdos.data.getTelephone()!= null?GeralDAdos.data.getTxtName():"");
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

}