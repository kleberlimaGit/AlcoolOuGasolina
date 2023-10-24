package br.gov.ba.pm.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputAlcool;
    private TextInputEditText editAlcool;
    private TextInputLayout inputGasolina;
    private TextInputEditText editGasolina;

    private Button btnCalcular;
    private TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentesInterface();
        btnCalcular.setOnClickListener(view -> {
            calcularMelhorPreco();
        });
    }

    private void calcularMelhorPreco() {
        txtResultado.setText("Resultado");
        boolean isvalid =  validarCampos(editAlcool.getText().toString(),editGasolina.getText().toString());
        if(isvalid){
            Double precoAlcool = Double.valueOf(editAlcool.getText().toString().replace(",","."));
            Double precoGasolina = Double.valueOf(editGasolina.getText().toString().replace(",","."));

            if(precoAlcool/precoGasolina < 0.7){
                txtResultado.setText("Álcool");
            }else {
                txtResultado.setText("Gasolina");
            }
        }


    }

    private boolean validarCampos(String pAlcool, String pGasolina) {
        inputAlcool.setError(null);
        inputGasolina.setError(null);

        if(pAlcool.isBlank() ) {
            inputAlcool.setError("Campo requerido.");
            return false;
        }else if (pGasolina.isBlank()){
            inputGasolina.setError("Campo requerido.");
            return false;
        }
        return true;
    }

    private void inicializarComponentesInterface() {
        inputAlcool = findViewById(R.id.input_alcool);
        editAlcool = findViewById(R.id.edit_alcool);

        inputGasolina = findViewById(R.id.input_gasolina);
        editGasolina = findViewById(R.id.edit_gasolina);

        btnCalcular = findViewById(R.id.btn_calcular);
        txtResultado = findViewById(R.id.txt_result);
    }
}