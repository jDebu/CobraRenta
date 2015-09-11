package jdebu.github.io.cobrarenta.home.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import jdebu.github.io.cobrarenta.R;
import jdebu.github.io.cobrarenta.home.presenter.HomePresenter;
import jdebu.github.io.cobrarenta.home.presenter.ProgressBarPresenter;
import jdebu.github.io.cobrarenta.room.view.RoomActivity;

/**
 * Created by jose on 16/08/15.
 */
public class HomeActivity extends Activity implements  IHomeView,IProgressBarView, View.OnClickListener{

    private TextInputLayout textInputLayout;
    private EditText editText;
    private Button button;
    private ProgressBar progressBar;
    private ProgressBarPresenter progressBarPresenter;
    HomePresenter homePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //find view
        textInputLayout=(TextInputLayout)this.findViewById(R.id.inputFloors);
        editText=(EditText)this.findViewById(R.id.editFloors);
        button=(Button)this.findViewById(R.id.btnNext);
        progressBar=(ProgressBar)this.findViewById(R.id.HomeProgress);

        //set listener
        button.setOnClickListener(this);

        //init
        homePresenter = new HomePresenter(this);
        progressBarPresenter= new ProgressBarPresenter(this);
        progressBarPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        progressBarPresenter.setProgressBarVisiblity(View.VISIBLE);
        button.setEnabled(false);
        homePresenter.doHome(editText.getText().toString());
    }

    @Override
    public void OnHomeResult(Boolean result,int errorType) {
        button.setEnabled(true);
        if (result && errorType==0){
            startActivity(new Intent(this, RoomActivity.class));
        }
        else
            setErrorType(errorType);
            progressBarPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void setErrorType(int tipo) {
        if (tipo==1)
            textInputLayout.setError("Ingrese la cantidad");
        else if(tipo==2)
            textInputLayout.setError("Fuera del rango entre 0 y 4");
        editText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }


}
