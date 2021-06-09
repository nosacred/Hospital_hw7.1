import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float [] tempes = new float[patientsCount];

        for(int i = 0;i < patientsCount;i ++){
                tempes[i]= rnd();
            }
        return tempes;
    }
    public static float rnd(){
        float min = 32;
        float max = 40;
        return (float) Math.random()*((max-min)) + min;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float totalTemp=0;
        float middleTemp;
        int healthyCount=0;
        MathContext context2 = new MathContext(3, RoundingMode.HALF_UP);
        for (float i : temperatureData){
            if(i <=36.9f && i >=36.2f) healthyCount++;
            totalTemp += i;
        }
        for(int i=0; i <temperatureData.length; i++){
              float j = new BigDecimal(temperatureData[i],context2).floatValue();
              temperatureData[i]=j;
        }
        middleTemp =  totalTemp/temperatureData.length;
        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        String temperatures = String.join(" ",
                IntStream.range(0, temperatureData.length)
                        .mapToObj(i -> String.valueOf(temperatureData[i])).toArray(String[]::new));
        String report =
                        "Температуры пациентов: " + temperatures + System.lineSeparator()+
                        "Средняя температура: " + new BigDecimal(middleTemp,context)+ System.lineSeparator()+
                        "Количество здоровых: " + healthyCount;

        return report;
    }
}
