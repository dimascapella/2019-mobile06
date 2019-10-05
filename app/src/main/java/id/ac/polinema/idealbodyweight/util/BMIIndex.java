package id.ac.polinema.idealbodyweight.util;

public class BMIIndex {
    private float weight;
    private float height;
    private float index;
    private String type;

    public BMIIndex(float weight, float height) {
        this.weight = weight;
        this.height = height/100;
        this.index = calculate();
    }

    public String getType() {
        return type;
    }

    public float getIndex() {
        return index;
    }

    public float calculate(){
        double count = weight / (Math.pow(height, 2));
        float f = (float) count;
        if(f < 18.50){
            type = "Underweight";
        }else if(f >= 18.50 && f <= 24.99){
            type = "Normal BMI Range";
        }else if(f >= 25.00 && f <= 29.99){
            type = "Pre-obese";
        }else if(f >= 30.00 && f <= 34.99){
            type = "Obese Class 1";
        }else if(f >= 35.00 && f <= 39.99){
            type = "Obese Class 2";
        }else if(f > 40.00){
            type = "Obese Class 3";
        }
        return f;
    }
}
