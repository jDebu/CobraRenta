package jdebu.github.io.cobrarenta.room.model;



/**
 * Created by jose on 19/08/15.
 */
public class Room {
    Integer idRoom;
    int state;//0 disponible-1-ocupado
    String name;
    float buyMonth;
    int cantPersons;
    int stateMascot;//0:no permitido,1-permitido

    int positionX;
    int positionY;
    Person person;

    public Room(Integer idRoom, int state, String name, float buyMonth, int cantPersons, int stateMascot, int positionX, int positionY,Person person) {
        this.idRoom = idRoom;
        this.state = state;
        this.name = name;
        this.buyMonth = buyMonth;
        this.cantPersons = cantPersons;
        this.stateMascot = stateMascot;
        this.positionX = positionX;
        this.positionY = positionY;
        this.person= person;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBuyMonth() {
        return buyMonth;
    }

    public void setBuyMonth(float buyMonth) {
        this.buyMonth = buyMonth;
    }

    public int getCantPersons() {
        return cantPersons;
    }

    public void setCantPersons(int cantPersons) {
        this.cantPersons = cantPersons;
    }

    public int getStateMascot() {
        return stateMascot;
    }

    public void setStateMascot(int stateMascot) {
        this.stateMascot = stateMascot;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
