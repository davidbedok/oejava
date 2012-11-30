package hu.qwaevisz.athletics.model;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Student {
    
    private final String name;
    private final Sex sex;
    private final Date birthDate;
    private Map<Sport, Integer> results;
    
    public Student(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.results = new EnumMap<Sport, Integer>(Sport.class);
    }
    
    public void addResult( Sport sport, int result ) {
        this.results.put(sport, result);
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
    public Integer getResult( Sport sport ) {
        Integer result = null;
        if ( this.results.containsKey(sport) ) {
            result = this.results.get(sport);
        }
        return result;
    }
    
    public int resultCount() {
        return this.results.size();
    }
    
    public Set<Sport> sports() {
        return results.keySet();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(100);
        info.append(this.name).append(" Sex: ").append(this.sex).append(" Birthdate: ").append(this.birthDate).append("\n");
        for (Sport sport : this.results.keySet() ) {
            info.append(sport).append(" result: ").append(this.results.get(sport)).append("\n");
        }
        return info.toString();
    }
    
    
    
}
