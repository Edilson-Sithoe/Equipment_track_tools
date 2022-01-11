package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.ActionBar;
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
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_identi_inter_view extends AppCompatActivity {

    private Button btnBack, btnNext;
    private EditText txtFullName, txtEmail,txtTelephone, txtPosition,txtOther, txtOtherTwo;

    int id;
    private String fullname, email, telephone, positions, other, otherTwo;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_identi_inter_view);
        IniciarComponentes();

        getAndSetIntentDate();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(fullname);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingData();
                String nome = txtFullName.getText().toString();
                String e_mail = txtEmail.getText().toString();
                String phone = txtTelephone.getText().toString();
                String pos = txtPosition.getText().toString();
                String other = txtOther.getText().toString();
                String other_two = txtOtherTwo.getText().toString();

                if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(e_mail) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(pos)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setNome(nome);
                    Assessment.assessment_model.setEmail(e_mail);
                    Assessment.assessment_model.setTelephone(phone);
                    Assessment.assessment_model.setPosition(pos);
                    Assessment.assessment_model.setOther(other);
                    Assessment.assessment_model.setOtherTwo(other_two);

                    Intent inext = new Intent(Update_identi_inter_view.this, Update_identi_health_facil.class);
                    startActivity(inext);
                }

            }
        });
    }

    private void settingData() {
        fullname = txtFullName.getText().toString().trim();
        email = txtEmail.getText().toString().trim();
        telephone = txtTelephone.getText().toString().trim();
        positions = txtPosition.getText().toString().trim();
        other = txtOther.getText().toString().trim();
        otherTwo = txtOtherTwo.getText().toString().trim();
    }

    private void getAndSetIntentDate() {
        if (getIntent().hasExtra("fullname") && getIntent().hasExtra("email") && getIntent().hasExtra("telephone") &&
        getIntent().hasExtra("positions") && getIntent().hasExtra("other") && getIntent().hasExtra("otherTwo")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();

        } else {
            txtFullName.setText(Variaveis.assessment_model.getNome());
            txtEmail.setText(Variaveis.assessment_model.getEmail());
            txtTelephone.setText(Variaveis.assessment_model.getTelephone());
            txtPosition.setText(Variaveis.assessment_model.getPosition());
            txtOther.setText(Variaveis.assessment_model.getOther());
            txtOtherTwo.setText(Variaveis.assessment_model.getOtherTwo());
        }
    }

    private void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_back_edit);
        btnNext = findViewById(R.id.btn_next_edit);

        txtFullName = findViewById(R.id.idName_edit);
        txtEmail = findViewById(R.id.idEmail_edit);
        txtTelephone = findViewById(R.id.idPhone_edit);
        txtPosition = findViewById(R.id.idPos_edit);

        txtOther = findViewById(R.id.idOther_edit);
        txtOtherTwo = findViewById(R.id.idOtherTwo_edit);
    }
}