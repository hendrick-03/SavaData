package ac.mz.savedatearray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText nome, pass, data_ed;
    private Date data;
    private Spinner spinner;
    private TextView entrar_tv;
    private Button gravar;

    private String novoNome, novaPass, novaData;

    ArrayList<FormData> formData = new ArrayList<>();

    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String formattedDate = formatter.format(currentDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.nome_ed);
        pass = findViewById(R.id.pass_ed);
        data_ed = findViewById(R.id.data_ed);
        spinner = findViewById(R.id.spinner);
        entrar_tv = findViewById(R.id.entra_tv);
        gravar = findViewById(R.id.gravar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoNome = nome.getText().toString();
                novaPass = pass.getText().toString();
                novaData = data_ed.getText().toString();
                saveData();
            }
        });

        entrar_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    public void saveData() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String inputdata = data_ed.getText().toString();
            Date userDate = formatter.parse(inputdata);
            long ageInMills = currentDate.getTime() - userDate.getTime();
            long ageInYears = ageInMills / (365L * 24 * 60 * 60 * 1000);
            if (ageInYears >= 18) {
                FormData data = new FormData(novoNome, novaPass, novaData);
                formData.add(data);
                Toast.makeText(MainActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Volte quando fores maior de idade", Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            Toast.makeText(MainActivity.this, "Erro ao analisar a data", Toast.LENGTH_SHORT).show();
        }
    }

    public void logar() {
        Intent i = new Intent(this, Login.class);
        i.putExtra("dados", formData);
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selecionou " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}