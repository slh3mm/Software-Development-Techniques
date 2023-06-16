public class BackgroundImage {
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
        //First BackgroundImage object
        BackgroundImage backIm = new BackgroundImage();
        backIm.setImageFileName("BIname");
        backIm.setTitle("BItitle");
        backIm.setDescription("BIdesc");

        //Second BackgroundImage object
        BackgroundImage backIm2 = new BackgroundImage();
        backIm2.setImageFileName("BIname2");
        backIm2.setTitle("BItitle2");
        backIm2.setDescription("BIdesc2");

        //toString test
        System.out.println(backIm);
        System.out.println(backIm2);

        //equals tests
        String eqTest = "this is a test";
        System.out.println(eqTest.equals(backIm));
        System.out.println(backIm2.equals(backIm));
    }

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
