package fr.video_game_tournament.webSite.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Event {


    private Integer id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String address;

    private List<Conference> conferences = new ArrayList<>();
    private List<Competition> competitions = new ArrayList<>();

   /* public Event(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
       // this.date = date;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
*/

}
