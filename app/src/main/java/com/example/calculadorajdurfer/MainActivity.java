package com.example.calculadorajdurfer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    //Declaracion de variables privadas para el funcionamiento del programa
    private boolean sum;
    private boolean res;
    private boolean div;
    private boolean prod;

    private int value1;
    private int value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Declaramos nuestras variables.

        Button buttonSum = findViewById(R.id.buttonSum);
        Button buttonRes = findViewById(R.id.buttonRes);
        Button buttonProduct = findViewById(R.id.buttonProduct);
        Button buttonDivision = findViewById(R.id.buttonDivision);
        Button buttonResset = findViewById(R.id.buttonResset);
        Button buttonEqual = findViewById(R.id.buttonEqual);

        Button button1 = findViewById(R.id.buttonNumber1);
        Button button2 = findViewById(R.id.buttonNumber2);
        Button button3 = findViewById(R.id.buttonNumber3);
        Button button4 = findViewById(R.id.buttonNumber4);
        Button button5 = findViewById(R.id.buttonNumber5);
        Button button6 = findViewById(R.id.buttonNumber6);
        Button button7 = findViewById(R.id.buttonNumber7);
        Button button8 = findViewById(R.id.buttonNumber8);
        Button button9 = findViewById(R.id.buttonNumber9);
        Button button0 = findViewById(R.id.buttonNumber0);

        TextView textViewResult = findViewById(R.id.textViewResult);


        // Clase listener para poner  el número dentro del botón y concatenarlo con el siguiente que pulses
        View.OnClickListener ObtainNumber = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                textViewResult.setText(textViewResult.getText().toString() + b.getText().toString());
            }
        };



        // Le damos la funcionalidad de obtener el numero a los botones numéricos
        button1.setOnClickListener(ObtainNumber);
        button2.setOnClickListener(ObtainNumber);
        button3.setOnClickListener(ObtainNumber);
        button4.setOnClickListener(ObtainNumber);
        button5.setOnClickListener(ObtainNumber);
        button6.setOnClickListener(ObtainNumber);
        button7.setOnClickListener(ObtainNumber);
        button8.setOnClickListener(ObtainNumber);
        button9.setOnClickListener(ObtainNumber);
        button0.setOnClickListener(ObtainNumber);

        // Creamos un listener para los botones de sumar, restar, multiplicar y dividir
        View.OnClickListener getSum = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewResult.getText().toString().isEmpty()) {
                    value1 = Integer.parseInt(textViewResult.getText().toString()); // Guardamos el valor de la pantalla
                    sum = true; // Indicamos que se va a sumar
                    textViewResult.setText(""); // Limpiamos el texto
                }
            }
        };
        buttonSum.setOnClickListener(getSum);


        View.OnClickListener getRes = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewResult.getText().toString().isEmpty()) {
                    value1 = Integer.parseInt(textViewResult.getText().toString()); // Guardamos el valor de la pantalla
                    res = true; // Indicamos que se va a restar
                    textViewResult.setText(""); // Limpiamos el texto
                }
            }
        };
        buttonRes.setOnClickListener(getRes);


        View.OnClickListener getProduct = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewResult.getText().toString().isEmpty()) {
                    value1 = Integer.parseInt(textViewResult.getText().toString()); // Guardamos el valor de la pantalla
                    prod = true; // Indicamos que se va a multiplicar
                    textViewResult.setText(""); // Limpiamos el texto
                }
            }
        };
        buttonProduct.setOnClickListener(getProduct);


        View.OnClickListener getDivision = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewResult.getText().toString().isEmpty()) {
                    value1 = Integer.parseInt(textViewResult.getText().toString()); // Guardamos el valor de la pantalla
                    div = true; // Indicamos que se va a dividir
                    textViewResult.setText(""); // Limpiamos el texto
                }
            }
        };

        buttonDivision.setOnClickListener(getDivision);




        // Damos un listener al botón limpiar que simplemente limpiará la pantalla y reseteará los valores
        View.OnClickListener Reset = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(""); // Limpiar el campo de texto
                sum = false;
                res = false;
                prod = false;
                div = false;// Reiniciar las banderas
            }
        };
        buttonResset.setOnClickListener(Reset);


        //Creamos un listener para el boton igual que dependiendo el valor de true del booleando
        //hara una operacion u otra.


        View.OnClickListener equal = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewResult.getText().toString().isEmpty()) {
                    value2 = Integer.parseInt(textViewResult.getText().toString());//Recojemos el segundo valor si el texto no esta vacio

                    if (sum) {
                        textViewResult.setText(String.valueOf(value1 + value2)); // Realiza la suma
                        sum = false; // Reiniciamos la bandera
                    } else if (res) {
                        textViewResult.setText(String.valueOf(value1 - value2)); // Realiza la resta
                        res = false; // Reiniciamos la bandera
                    } else if (prod) {
                        textViewResult.setText(String.valueOf(value1 * value2)); // Realiza la multiplicación
                        prod = false; // Reiniciamos la bandera
                    } else if (div) {
                        if (value2 != 0) {
                            textViewResult.setText(String.valueOf(value1 / value2)); // Realiza la división
                        } else {
                            textViewResult.setText("Error"); // Da error si tratamos de dividir entre 0
                        }
                        div = false; // Reiniciamos la bandera
                    }
                }
            }
        };
        buttonEqual.setOnClickListener(equal);
    }
}
