package nspsolutions.net.dictianaryapp.entity;

public class NameMeaningDTO {

    private String name;
    private String meaning;

    public NameMeaningDTO(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
