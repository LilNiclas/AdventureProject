public class Item {

    private String name;
    private String description;


    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String description ) {
        this.description = description;
        this.name = name;
    }

    //Getter
    public String getItemName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setter
    public void setItemName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //toString
    @Override
    public String toString() {
        return name + "\n" + description;
    }


}
