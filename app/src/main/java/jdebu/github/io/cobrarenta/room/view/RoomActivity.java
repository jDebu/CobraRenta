package jdebu.github.io.cobrarenta.room.view;

import android.app.Activity;
import android.os.Bundle;

import jdebu.github.io.cobrarenta.R;

/**
 * Created by jose on 17/08/15.
 */
public class RoomActivity extends Activity {
    private RoomDrawView roomDrawView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.room_activity);
        roomDrawView = (RoomDrawView) this.findViewById(R.id.Room);
    }
}
