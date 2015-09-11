package jdebu.github.io.cobrarenta.room.model;

import java.util.Date;

/**
 * Created by jose on 19/08/15.
 */
public class Person {
    Integer idPerson;
    String name;
    Date dateInit;//ingreso
    Date dateFinish;
    int stateDate;//0-se cumplio el mes-1-esta debiendo
    int cantDaysDeude;
}
