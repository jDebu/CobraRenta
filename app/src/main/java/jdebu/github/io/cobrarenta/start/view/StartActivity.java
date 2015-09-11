package jdebu.github.io.cobrarenta.start.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import jdebu.github.io.cobrarenta.R;
import jdebu.github.io.cobrarenta.home.view.HomeActivity;
import jdebu.github.io.cobrarenta.start.presenter.ProgressBarPresenter;
import jdebu.github.io.cobrarenta.start.presenter.StartPresenter;


public class StartActivity extends Activity implements  IStartView, IProgressBarView {
    StartPresenter startPresenter;
    private ProgressBar progressBar;
    private ProgressBarPresenter progressBarPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_splash_allscreen);

        //find view
        progressBar = (ProgressBar) this.findViewById(R.id.startProgress);

        //init
        startPresenter = new StartPresenter(this);
        startPresenter.doStart();
        progressBarPresenter = new ProgressBarPresenter(this);
        progressBarPresenter.setProgressBarView(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void OnLoadResult(Boolean result) {
        progressBarPresenter.setProgressBarView(View.VISIBLE);
        if (result){
            startActivity(new Intent(this, HomeActivity.class));
        }
    }
}
