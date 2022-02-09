package com.app.material3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Importación de la clase para la inserción actualización de
    // datos del formulario en la BD

    Backend backend;

    // JSON con la información de la base de datos

    ObservableArrayMap<String, Object> InfoDatabase = new ObservableArrayMap<>();

    // Campos del formualrio

    EditText NameUser;
    EditText LastName;
    EditText NumberIdentification;

    TextView Info, Info2, Info3;

    // Botón para ejecutar la función de validación del formulario
    // y cambio de estado en las tablas vinculadas.

    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Información de la BD donde se almacenará la
        // información.

        InfoDatabase.put("database", "Occicafe"); // nombre de la base de datos
        InfoDatabase.put("table", "formulario_mipe"); // nombre de la tabla
        InfoDatabase.put("id_record", 1); // id del fila (ID del registro)

        // Clase que realizará el UPDATE

        backend = new Backend();

        // Obtención de los datos del formulario

        NameUser = (EditText)findViewById(R.id.names);
        LastName = (EditText)findViewById(R.id.last_name);
        NumberIdentification = (EditText)findViewById(R.id.number_identification);

        // Captura del evento TextCahnge de cada campo del formulario,
        // para irlo guardando.

        NameUser.addTextChangedListener(new addListenerOnTextChange(this, NameUser, InfoDatabase) );
        LastName.addTextChangedListener(new addListenerOnTextChange(this, LastName, InfoDatabase) );
        NumberIdentification.addTextChangedListener(new addListenerOnTextChange(this, NameUser, InfoDatabase) );

        // Para guardar oficialmente el registro se preciona el boton, el cual ejecuta
        // la función para verificar el formulario y cambiar el estado en la tabla del record
        // y la tabla de indexación de formularios.

        sendButton = (Button)findViewById(R.id.send);

        Info = (TextView)findViewById(R.id.info);
        Info2 = (TextView)findViewById(R.id.info2);
        Info3 = (TextView)findViewById(R.id.info3);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // A continuación enlace a función para la validación de campos de campos

                Integer validaciónForm = validacionDeCamposDelFormulario();

                // si es correcta la validación ejecuta la siguiente función
                // que cambiará el estado del formulario en la tabla de indexación.
                // Y procesará la tabla del formularo como terminada.

                System.out.println( NameUser.toString() );
                Info.setText("Hola " + NameUser.getText().toString() );

            }
        });
    }

    public Integer validacionDeCamposDelFormulario(){
        String var = null;
        var = backend.datos(var);
        System.out.println(var);

        Integer ResultadoValidacion = 12;
        return ResultadoValidacion;

    }

}