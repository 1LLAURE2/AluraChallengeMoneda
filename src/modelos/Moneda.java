package modelos;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;

public class Moneda {
    //private String descripcion;
    private String base_code;
    private double montoBase;
    private String target_code;
    private double conversion_rate;
    private double montoConversion;

    public Moneda(String base_code, String target_code,double montoBase) {
        this.base_code = base_code;
        this.target_code=target_code;
        this.montoBase = montoBase;
    }



    public String getAbreviatura() {
        return base_code;
    }

    public void setAbreviatura(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public void setTipoCambio(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getTipoCambio() {
        return conversion_rate;
    }

    public double getMontoConversion() {
        return montoConversion;
    }

    public double CalculaMontoConversion(){
        DecimalFormat df=new DecimalFormat("#.##");
        return  Double.parseDouble(df.format(conversion_rate * getMontoBase())) ;
    }

    @Override
    public String toString() {
        //"El valor "+MonedaBase+" "+MonedaBase+" corresponde al valor final de ==>>> "+monedita.CalculaMontoConversion() +"+MonedaConv"
        return "El valor "+montoBase+" "+base_code+" corresponde al valor final de ==>>> "+this.CalculaMontoConversion()+" "+target_code;
        /*return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", montoBase=" + montoBase +
                ", conversion_rate=" + conversion_rate +
                ", montoConversion=" + montoConversion +
                '}';

         */
    }
}
