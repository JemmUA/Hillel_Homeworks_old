package HomeWorks.lesson17.interfaces;

@FunctionalInterface
public interface FiveDigits <N, R, T, P, V> {

   V getGasVolume (N n, R r, T t, P p);
    //  Where:
    //N - the number of gas moles
    //R - the universal gas constant
    //T - the gas temperature
    //P – gas pressure
    //V – volume of gas
}
