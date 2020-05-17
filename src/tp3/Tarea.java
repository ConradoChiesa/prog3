package tp3;

public class Tarea {

    private String name;
    private String description;
    private Integer duration;

    public Tarea(String name, String description, Integer duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Tarea(Integer duration) {
        this.name = "";
        this.description = "";
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
