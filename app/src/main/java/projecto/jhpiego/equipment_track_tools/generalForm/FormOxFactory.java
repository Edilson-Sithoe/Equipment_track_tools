package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;


public class FormOxFactory extends AppCompatActivity {
    private Button btn_next, btnBack;
    private String cbo_train_matter_related_fact,cbo_frequency_trainig_fact;
    private TextView txt_techi_trained_handling, txt_comments_factory;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ox_factory);

     //   getSupportActionBar().hide();
        InitComponents();


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String train_matter_related_fact = cbo_train_matter_related_fact;
                String frequency_trainig_fact = cbo_frequency_trainig_fact;
                String techi_trained_handling = txt_techi_trained_handling.getText().toString();
                String comments_factory = txt_comments_factory.getText().toString();

                if (TextUtils.isEmpty(techi_trained_handling)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTrain_matter_related_fact(train_matter_related_fact);
                    Assessment.assessment_model.setFrequency_trainig_fact(frequency_trainig_fact);
                    Assessment.assessment_model.setTechi_trained_handling(techi_trained_handling);
                    Assessment.assessment_model.setComments_factory(comments_factory);

                    Intent i = new Intent(FormOxFactory.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormOxFactory.this, FormDocTrainLiqOxTank.class);
                startActivity(i);
            }
        });


    }

    public void onRadioButtonClicked_ox_fact(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMS:
                if (checked)
                    cbo_train_matter_related_fact = "Yes";
                break;
            case R.id.chkNoMS:
                if (checked)
                    cbo_train_matter_related_fact = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_ox_fact(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6:
                if (checked)
                    cbo_frequency_trainig_fact = "Every 6 months";
                break;
            case R.id.chkEveryYear:
                if (checked)
                    cbo_frequency_trainig_fact = "Every yea";
                break;
            case R.id.chkEvery2Year:
                if (checked)
                    cbo_frequency_trainig_fact = "Every 2 years";
                break;
            case R.id.chkEvery5Year:
                if (checked)
                    cbo_frequency_trainig_fact = "Every 5 years";
                break;
            case R.id.chkOnRequest:
                if (checked)
                    cbo_frequency_trainig_fact = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backOxFac);
        btn_next = findViewById(R.id.btn_next);

        txt_techi_trained_handling = findViewById(R.id.txtMTTH);
        txt_comments_factory = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_techi_trained_handling.setText("");
        txt_comments_factory.setText("");
    }
}