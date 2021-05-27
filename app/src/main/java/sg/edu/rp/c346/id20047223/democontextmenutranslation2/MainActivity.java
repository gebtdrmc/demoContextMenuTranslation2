package sg.edu.rp.c346.id20047223.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvTranslatedText) {
            wordClicked = "Hello";
        } else if(v== tvTranslatedText2){
            wordClicked = "Bye";
        }

        getMenuInflater().inflate(R.menu.menu_main,menu);



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (wordClicked.equalsIgnoreCase("hello")) {
            if (id == R.id.English) {
                tvTranslatedText.setText("Hello");

                return true;
            } else if (id == R.id.Italian) {
                tvTranslatedText.setText("Ciao");
                return true;
            }
        } else if(wordClicked.equalsIgnoreCase("bye")) {
            if(id == R.id.English){
                tvTranslatedText2.setText("Bye");
            } else if(id == R.id.Italian){
                tvTranslatedText2.setText("Addio");
            }
        }
        return super.onContextItemSelected(item);
    }

}