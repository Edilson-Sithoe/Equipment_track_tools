package projecto.jhpiego.equipment_track_tools.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.login.FormLogin;

public class FormCadastro extends AppCompatActivity {
    private TextView nameEdt, apelidoEdit, emailEdit, usernameEdt, passwordEdt, confirmPassEdt;
    private Spinner spinner;
    private Button btn_register;
    private ProgressBar progressBar;
    private TextView login;

    Database_connection DB;
    String[] mensagens = {"Prencha todos os campos", "As senhas não correspondem", "Usuário já existe", "Registado com sucesso", "Falha ao registar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
//        getSupportActionBar().hide();
        IniciarCompontes();


        DB = new Database_connection(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String apelido = apelidoEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String user = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                String confirm = confirmPassEdt.getText().toString();
                //   int funcao = (int) spinner.getSelectedItem();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(apelido) || TextUtils.isEmpty(email) || TextUtils.isEmpty(user) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    if (password.equals(confirm)) {
                        Boolean checkUSer = DB.checkUsername(user);
                        if (checkUSer == false) {
                            Boolean insertData = DB.users(name, apelido, email, user, password);
                            if (insertData == true) {
                                Snackbar snackbar = Snackbar.make(v, mensagens[3], Snackbar.LENGTH_SHORT);
                                snackbar.setBackgroundTint(Color.rgb(112, 128, 144));
                                snackbar.setTextColor(Color.WHITE);
                                snackbar.show();
                                Intent intent = new Intent(getApplicationContext(), FormLogin.class);
                                startActivity(intent);
                            } else {
                                Snackbar snackbar = Snackbar.make(v, mensagens[4], Snackbar.LENGTH_SHORT);
                                snackbar.setBackgroundTint(Color.rgb(210, 105, 30));
                                snackbar.setTextColor(Color.WHITE);
                                snackbar.show();
                            }
                        } else {
                            Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.rgb(210, 105, 30));
                            snackbar.setTextColor(Color.WHITE);
                            snackbar.show();
                        }
                    } else {
                        Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(210, 105, 30));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(i);
            }
        });
    }

    public void IniciarCompontes() {
        nameEdt = findViewById(R.id.idEditName);

        apelidoEdit = findViewById(R.id.idEditApelido);
        emailEdit = findViewById(R.id.idEditEmail);
        usernameEdt = findViewById(R.id.idEditUserName);
        passwordEdt = findViewById(R.id.idEditPassword);
        //   spinner = findViewById(R.id.spinner);
        confirmPassEdt = findViewById(R.id.idEditConfPassword);
        btn_register = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressbar);
        login = findViewById(R.id.idTVLogin);
    }

}