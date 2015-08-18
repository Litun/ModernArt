package ru.litun.modernart;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        // rect 3 & 6 stable

        final ColorRectangleView rectangle1 = (ColorRectangleView) findViewById(R.id.rect1);
        rectangle1.setColors(getResources().getColor(R.color.from1),
                getResources().getColor(R.color.to1));

        final ColorRectangleView rectangle2 = (ColorRectangleView) findViewById(R.id.rect2);
        rectangle2.setColors(Color.LTGRAY, Color.GRAY);

        final ColorRectangleView rectangle4 = (ColorRectangleView) findViewById(R.id.rect4);
        rectangle4.setColors(getResources().getColor(R.color.from2),
                getResources().getColor(R.color.to2));

        final ColorRectangleView rectangle5 = (ColorRectangleView) findViewById(R.id.rect5);
        rectangle5.setColors(getResources().getColor(R.color.from3),
                getResources().getColor(R.color.to3));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rectangle1.updateColor(progress);
                rectangle2.updateColor(progress);
                rectangle4.updateColor(progress);
                rectangle5.updateColor(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            momaDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void momaDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("MoMA | Museum of Modern Art")
                .setMessage("Learn more")
                .setCancelable(false)
                .setNegativeButton("Not Now",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Visit MoMA",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                                startActivity(browserIntent);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
