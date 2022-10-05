public class Item {

    public String name;
    public String description;


    /* //Ikke i brug
    public Item(String name) {
        this.name = name;
    }*/

    public Item(String name, String description ) {
        this.description = description;
        this.name = name;
    }

    //Getter
    public String getItemName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "\n" + description;
    }


   /* //Ikke i brug
   public String getDescription() {
        return description;
    }
    //Setter
    public void setItemName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }*/





}
