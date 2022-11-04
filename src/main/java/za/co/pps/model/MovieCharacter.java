package za.co.pps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieCharacter {
    public int char_id;
    public String name;
    public String birthday;
    public ArrayList<String> occupation;
    public String img;
    public String status;
    public String nickname;
    public ArrayList<Integer> appearance;
    public String portrayed;
    public String category;
    public ArrayList<Object> better_call_saul_appearance;
}
