public class BackgroundImage implements Comparable<BackgroundImage> {
    //BackgroundImage Fields
    private String imageFileName;
    private String title;
    private String description;

    //BackgroundImage Default Constructor
    public BackgroundImage(){
        setImageFileName("");
        setTitle("");
        setDescription("");
    }

    //BackgroundImage Overloaded Constructor
    public BackgroundImage(String imageFileName, String title, String description){
        setImageFileName(imageFileName);
        setTitle(title);
        setDescription(description);
    }

    //Main Method
    public static void main(String[] args) {
    }

//OVERRIDDEN METHODS
    //toString
    @Override
    public String toString(){
        return (this.title + " <" + this.description + ">");
    }

    //equals
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (!(obj instanceof BackgroundImage)) {
            return false;
        }
        BackgroundImage b1 = (BackgroundImage) obj;
        return this.getImageFileName().equals(b1.getImageFileName()) &&
                this.getTitle().equals(b1.getTitle()) &&
                this.getDescription().equals(b1.getDescription());
    }
    //compareTo
    @Override
    public int compareTo(BackgroundImage o) {
        int returnVal = this.imageFileName.compareTo(o.imageFileName);
        if (returnVal !=0){
            return returnVal;
        }
        returnVal = this.title.compareTo(o.title);
        if (returnVal !=0){
            return returnVal;
        }
        return this.description.compareTo(o.description);
    }

    //GETTERS
    public String getImageFileName() {
        return imageFileName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //SETTERS
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
